# **ITEM 2 Analysis**

## Steps to Run the script and code

On MySQL Server in the vagrant box create a database making use of the sql commands in the proj.sql file. Run the **create database ** and **create table ** queries.It its imperative that you run these commands in the mysql server in vagrant box before moving forward.

The username & password combo has to be username-root and password-safestsystemever.


1. Clone the repo onto the local machine or directly into the vagrantbox. If cloned direclty into the vagrant box skip step 2 and 3.
2. Copy the src folder into the shared folder with vagrant. This folder being /data in my case but same can be configured after going through the professors video on 1/12/2017.
2. This will get the src folder in the vagrant_data folder in the vagrantbox.
3. concatincate the multiple log files inside both the datsets into single ones and name them as **comb.log** for the files in small-log and **comb2.log** for the files in the large-log.
3. Copy the dataset files in our case being the log files into the src folder and move the folder to the directory you want to work with.
4. Compile the three java files making use of command javac **filename.java**.
5. Run the files through the command **java filename**.
6. This will get the data into the mysql tables and after doinf this run the queries provided in the proj.sql file.
## Analysis
1. In this item we used SQL command for finding the highest occuring URL's per day and month.
2. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
3. The SQL commands used to create the table in the mysql database and command used for finding the result 
   are mentioned in the **proj.sql** file.
4. In the *src* folder we can find two files which are used to insert the data into the database.
5. The java code for inserting the records into the database was used to filter only the fields whose **status code is 200**.
6. This reduces the data that is to be inserted and at the same time simplifies the query that is to be performed.
7. The same data is used for sqoop, pig and hive later on so that only the data to that is needed for processing is available.
8. The main assumption made here is that i have inserted only those records who have status code as **200**. I have done this filtering in    the java code which is present in the src folder.
9. For highest occuring URL's per day in smalllog we have 27 rows and for per month we have 2 rows since the small log contains data of 2 months.
10.  For highest occuring URL's per day in smalllog we have 235 rows and for per month we have 9 rows since the large log contains data of about a year.
9. This assumption is hence carried out throughout the project for the next parts of the project.
10. The screenshots provide understanding about the output obtained.


## **Screen Shots**
### Highest Occuring URL per day on small logs

![sql1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item2/sql1.JPG)

### Highest Occuring URL per month on small logs

![sql2](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item2/sql1month.JPG)

### Highest Occuring URL per day on large logs
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item2/sql2.JPG)
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item2/sql22.JPG)

### Highest Occuring URL per month on large logs

![sql4](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item2/sql2month.JPG)
