# Description about the files

### The scripts are in the scripts folder navigate there and run the scripts as directed below

* Change the permissions of the shell script using __chmod +x [filename]__.
* The file to run is __*create-env.sh*__ and it takes 4 parameters in the specific order and should be run as given below:
### ./create-env.sh ami-81ef39f9 _[KEY-NAME]_ _[SECURITY-GROUPS]_ _[IAMINSTANCEPROFILE]_

* __All four are required__ and are as follows :
- ami-81ef39f9 is the AMI which has all the infrastructure already set up.
- _KEY-NAME_ : Private key file you have generated.
- _SECURITY-GROUPS_ : Security group you want to assign it to.
- _IAMINSTANCEPROFILE_ : THis profile will have POWERUERACCESS also IAMFULLACCESS,SNSFULLACCESS, SQSFULLAccess & RDSFULLACCESS. The last two are optional.

### Usage Directive
* This is is what you will use to generate the instance and then you can use the DNS of the load balancer to view the web application that is run.
* For destroying run the __destroy-env.sh__ file which will delete the instances, created load-balancers, rds, sqs, sns. 
* Upload the image through the add image button and then navigate to the gallery for viewing the images.
* The crontab is set to refresh every 30 seconds so please wait for the same and then refresh the page.
* All the different dashboards refresh every 15 seconds automatically and you can see the change in values.
* The gallery also refreshes every 15 seconds.
* For viewing the dashboard go to the public URL of the instance which contains the processing and this will usually be the file with a        different availability zone than the main one.

## Assumptions
* Zone used in the configurations is __us-west-2a__.
* Security group has ports open for mysqli that is 3306.

