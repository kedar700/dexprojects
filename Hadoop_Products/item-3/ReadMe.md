# **ITEM 3 Analysis**

## Steps to Run the script and code


1. Clone the repo onto the local machine or directly into the vagrantbox. If cloned direclty into the vagrant box skip step 2 and 3.
2. Copy the src folder into the shared folder with vagrant. This folder being /data in my case but same can be configured after going through the professors video on 1/12/2017.
3. This will get the src folder in the vagrant_data folder in the vagrantbox.
4. run the first two commands from the sqoop table to import the data to HDFS.
5. Run the next commands following the same to get the results you want from Sqoop.txt.

## Analysis
1. In this item we used Sqoop command for finding the highest occuring URL's per day and month.
2. Sqoop supports incremental loads of a single table or a free form SQL query as well as saved jobs which can be run multiple times to import updates made to a database since the last import. 
   Imports can also be used to populate tables in Hive or HBase
3. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
4. For highest occuring URL's per day in smalllog we have 27 rows and for per month we have 2 rows since the small log contains data of 2 months.
5.  For highest occuring URL's per day in smalllog we have 235 rows and for per month we have 9 rows since the large log contains data of about a year.
6. The queries written in HiveQL** do not contain the part about status code since filtering by status was performed in [ITEM 2 Anaysis](https://github.com/illinoistech-itm/knaik3/blob/master/itmd521/Week%2013/item-2/ReadMe.md)** and also mentioned in the **ReadMe.md** file in the Week-13 folder.
7. The screenshots provide understanding about the output obtained.



## **Screen Shots**
### Highest Occuring URL per day on small logs

![sql1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item3/sq1.JPG)

### Highest Occuring URL per month on small logs

![sql2](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item3/sq2.JPG)

### Highest Occuring URL per day on large logs
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item3/sq3.JPG)
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item3/sq4.JPG)

### Highest Occuring URL per month on large logs

![sql4](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item3/sq5.JPG)




