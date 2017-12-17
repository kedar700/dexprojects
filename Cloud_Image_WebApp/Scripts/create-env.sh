#!/bin/bash

## 1- imageID ##2 keyname ##3 security group 
aws ec2 run-instances --image-id $1 --key-name $2 --security-groups $3 --instance-type t2.micro  --iam-instance-profile Name=$4 --monitoring Enabled=true --user-data file://install-app2-env.sh 
##To get Security group id
SG=`aws ec2 describe-security-groups | grep $3  | awk '{print $3}'`
##Create Load Balancer
aws elb create-load-balancer --load-balancer-name miniproject1 --listeners "Protocol=HTTP,LoadBalancerPort=80,InstanceProtocol=HTTP,InstancePort=80" --security-groups $SG --availability-zones us-west-2a

## describe load balancer
LB=`aws elb describe-load-balancers | awk 'NR==1{print $6}'`

# Create sticky bits
aws elb create-lb-cookie-stickiness-policy --load-balancer-name miniproject1 --policy-name policy1 --cookie-expiration-period 60

## wait command for load blancers
##aws elb wait any-instance-in-service --load-balancer-name $4

##create Launcg configuration
aws autoscaling create-launch-configuration --launch-configuration-name LC1 --image-id $1 --instance-type t2.micro --key-name $2 --security-groups $3 --user-data file://install-app-env.sh --iam-instance-profile $4 


# create auto scaling group
aws autoscaling create-auto-scaling-group --auto-scaling-group-name AC1 --launch-configuration-name LC1 --min-size 3 --max-size 3 --load-balancer-name miniproject1 --availability-zones us-west-2a

# create s3
aws s3api create-bucket --bucket kedarbktbefore --region us-west-2 --acl public-read-write --create-bucket-configuration LocationConstraint=us-west-2
aws s3api create-bucket --bucket kedarbktafter --region us-west-2 --acl public-read-write --create-bucket-configuration LocationConstraint=us-west-2

#create sns topic
#CREATE A TOPIC
ARN=(`aws sns create-topic --name kedar-mp2`)
echo "This is the ARN: $ARN"

echo "Creating a SQS topic"
aws sqs create-queue --queue-name knaik-sqs 

#DISPLAY NAME ATTRIBUTE
aws sns set-topic-attributes --topic-arn $ARN --attribute-name DisplayName --attribute-value kedar-mp2


#Create Database
aws rds create-db-instance --db-name miniproject --db-instance-identifier mp1-sb --db-instance-class db.t2.micro --engine mysql --master-username muser --master-user-password 544miniproject --allocated-storage 5 --vpc-security-group-ids $SG --publicly-accessible --availability-zone us-west-2a

#Wait Untill Database is created
aws rds wait db-instance-available --db-instance-identifier mp1-sb

#Create an EndPoint
DBEndpoint=(`aws rds describe-db-instances --output text | grep ENDPOINT | sed -e "s/3306//g" -e "s/ //g" -e "s/ENDPOINT//g"`);
echo ${DBEndpoint[0]}

#Create table if not created by setup.php
	# Connect to DB instance
		# Connect to database
			# Create a table
				# Show Schema 

mysql -h ${DBEndpoint[0]} -P 3306 -u muser -p544miniproject  << EOF

use miniproject;

CREATE TABLE IF NOT EXISTS records (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, uname VARCHAR(32) NOT NULL, email VARCHAR(32) NOT NULL, phone VARCHAR(32) NOT NULL, s3rawurl VARCHAR(255) NOT NULL, s3finishedurl VARCHAR(255) NOT NULL, status INT(1), receipt BIGINT, date DATETIME DEFAULT CURRENT_TIMESTAMP);

show tables;

EOF

##Creating replica
aws rds create-db-instance-read-replica --db-instance-identifier mp1-replica-db --source-db-instance-identifier mp1-sb

aws rds wait db-instance-available --db-instance-identifier mp1-replica-db

echo "==============================================";
echo "Create-env.sh successfully completed";
echo "==============================================";

