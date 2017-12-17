# **ITEM 4 Analysis**

## Steps to Run the script and code
1.The first prerequisite is to import the tables to HDFS through **Sqoop** without this next steps wont work.
2. Run the command **sqoop create-hive-table --connect jdbc:mysql://localhost/weblog --table smalllog --fields-terminated-by ','**
3. IT is assumed that u have performed the steps fro item 2 and 3 successfully.
4. Do the same for the largelog table which was generated i in **[ITEM 2 Anaysis](https://github.com/illinoistech-itm/knaik3/blob/master/itmd521/Week%2013/item-2/ReadMe.md)**. 
5. Next run hive prompt and run the command **LOAD DATA INPATH "smalllog" INTO TABLE smalllog;** and do the same for largelog.
6. Next run the scripts in the HiveQl.txt to get the desired results.
## Analysis
1. In this item we used HiveQL for finding the highest occuring URL's per day and month for the two different datasets.
2. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
3. The HiveQl commands used to create the databasae in Hive and interact with the data are present in the **HiveQL.txt**
4. In the *src* folder we can find two files which are used to insert the data into the database.
5. Hive provides the necessary SQL abstraction to integrate SQL-like queries (HiveQL) into the underlying Java without the need to implement queries in the low-level Java API.
6. The HiveQL queries are converted to MapReduce and the same is run as a MapReduce Job.
7. The advantage behind using hive is that data to be analyzed is stored in HDFS which provides all features like scalability,redundancy etc and SQL like query over data in Hadoop  which makes achieveing results faster.
8. For highest occuring URL's per day in smalllog we have 27 rows and for per month we have 2 rows since the small log contains data of    2 months.
9.  For highest occuring URL's per day in smalllog we have 235 rows and for per month we have 9 rows since the large log contains data of about a year.
10. The queries written in HiveQL** do not contain the part about status code since filtering by status was performed in [ITEM 2 Anaysis](https://github.com/illinoistech-itm/knaik3/blob/master/itmd521/Week%2013/item-2/ReadMe.md)** and also mentioned in the **ReadMe.md** file in the Week-13 folder.
10. The screenshots provide understanding about the output obtained.

## **References**
* [1] White T. (2015). Hadoop: The Definitive guide. Beijing: O’Reilly. *pg 464-467 of pdf*.

## **Screen Shots**
### Highest Occuring URL per day on small logs

![sql1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item4/smallperday.JPG)

### Highest Occuring URL per month on small logs

![sql2](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item4/smallpermonthf.JPG)

### Highest Occuring URL per day on large logs
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item4/largeperday.JPG)
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item4/largeperday2.JPG)

### Highest Occuring URL per month on large logs

![sql4](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item4/largepermonth.JPG)

