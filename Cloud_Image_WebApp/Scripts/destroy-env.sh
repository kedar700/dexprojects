#!/bin/bash

echo "Destroy Script will destroy everything hence be warned"

Instance=`aws ec2 describe-instances --filters "Name=instance-state-code,Values=16" --query 'Reservations[*].Instances[*].InstanceId'`

scaling=`aws autoscaling describe-auto-scaling-groups --output json | grep AutoScalingGroupName | sed "s/[\"\:\, ]//g" | sed "s/AutoScalingGroupName//g"`


echo "Updating auto scaling groups"


aws autoscaling update-auto-scaling-group --auto-scaling-group-name $scaling --min-size 0 --max-size 0 --desired-capacity 0


echo "Deleting Instances"

aws ec2 wait instance-terminated --instance-ids $Instance


echo "Detaching Load Balancer"
loadbalancer=`aws elb describe-load-balancers --output json | grep LoadBalancerName | sed "s/[\"\:\, ]//g" | sed "s/LoadBalancerName//g"`

aws autoscaling detach-load-balancers --load-balancer-names $loadbalancer --auto-scaling-group-name $scaling

echo "Deleting AutoScaling Groups"
aws autoscaling delete-auto-scaling-group --auto-scaling-group-name $scaling --force-delete

echo "lDeleting Launch Configuration"
config=`aws autoscaling describe-launch-configurations --output json | grep LaunchConfigurationName | sed "s/[\"\:\, ]//g" | sed "s/LaunchConfigurationName//g"`
aws autoscaling delete-launch-configuration --launch-configuration-name $config


echo "Deleting Load Balancers"
aws elb delete-load-balancer --load-balancer-name $loadbalancer

rds=`aws rds describe-db-instances --output json | grep "\"DBInstanceIdentifier" | sed "s/[\"\:\, ]//g" | sed "s/DBInstanceIdentifier//g"`

#echo "Deleting S3 buckets"
#s3bucket=`aws s3api list-buckets --query 'Buckets[].Name'`
#aws s3 rb s3://$s3bucket --force  

echo "Cleaning up SNS"
#Delete SNS
snstopic=`aws sns list-topics --output text | awk '{print $2}' | grep 'arn'`

aws sns delete-topic --topic-arn "$snstopic"
# aws sns unsubscribe --subscription-arn $snstopic

echo "deleting sqs queue"
sqs=`aws sqs get-queue-url --queue-name knaik-sqs`
aws sqs delete-queue --queue-url $sqs

echo "Deleting RDS"
aws rds delete-db-instance --db-instance-identifier $rds  --skip-final-snapshot --output text
aws rds wait db-instance-deleted --db-instance-identifier $rds  --output text


