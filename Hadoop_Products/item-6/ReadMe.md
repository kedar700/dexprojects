# **ITEM 6 Analysis**
![sql1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item6/1.JPG)
## Part 1
1. In the earlier items we have used all the different hadoop tools finding the highest occuring URL's per day and month for the two different datasets.
2. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
3. In MapReduce we wrote java like code for parsing the data and at the same time achieving the desired results which was achieved through map and reduce the concepts on which mapreduce was based on.
4. The MapReduce job works by breaking down the input data into small chunks of blocks of default block size 128 MB which can be changed and makes triplicates of this input files and stores the same on HDFS.
5. When the job is submitted the Resource manager will allocate the resources accordingly. The job is then run in parallel across different nodes so as to achieve parallel processing effect. In our case the same happened and there were 6 nodes to achieve the same.
6. If we compare the time required to run these scripts then MapReduce then it lies somewhere in the middle. For ease of use MapReduce will not be my first choice in programming such a problem.
7. This is faster than SQL since the insertion of records in SQL took longer time than the processing time of MapReduce and it was a bit easier to query the data later on since sql makes it easy to query the database and get the result.
8. Sqoop supports incremental loads of a single table or a free form SQL query as well as saved jobs which can be run multiple times to import updates made to a database since the last import. Imports can also be used to populate tables in Hive or HBase.
9. Sqoop was a bit difficult to use and it may be because i lack familarity with it but given an option i would choose this as the the last unless i dont have any other choice.
10. Hive provides the necessary SQL abstraction to integrate SQL-like queries (HiveQL) into the underlying Java without the need to implement queries in the low-level Java API.
11. Improting the data and querying the data in hive was easy but it was dependant on Sqoop output. Writing the queries in hive was also easy and interactive.
12. Pig provided an optimal solution for the problem with easy to understand and it was easy to code in pig.

## Part 2
1. Based on part 1 i would say that pig was one of the most easy and simplest one of them all and i would prefer it if  a similar problem was presented to me since i could work more efficiently.
2. My second choice would be SQL and Hive and the choice between them would depend on which type of data i would like to analyze whether one in HDFS or on smaller data.
3. My third choice would be MapReduce if i have to perform this type of operation and Sqoop comes the last since MapReduce will always be an option and i would not use sqoop unless absolutely needed.

