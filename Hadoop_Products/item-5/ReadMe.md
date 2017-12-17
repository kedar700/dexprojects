# **ITEM 5 Analysis**

# **ITEM 4 Analysis**

## Steps to Run the script and code
1. The first prerequisite is to import the tables to HDFS through **Sqoop** without this next steps wont work.
2. Once that is completed rename the table which contains records from large-logs to **large.txt** and the one which contains records from small-logs to **small.txt** and reupload it to the HDFS in this directory **/user/$USER/pig/log/**. Use **-copyToLocal** and **-copyFromLocal** like **hadoop fs -copyToLocal /input /user/$USER/pig/log/** where input path is the path on the local machine.
3. Ensure that step 2 is done perfectly.
4. Another assumption that pig is installed and is working fully if not then download and install it otherwise proceed to step 5.
5. copy the scripts from the **/PIG** directory to the working directory and run pig using the command **pig filename.pig**

## Analysis
1. In this item we used Pig Latin for finding the highest occuring URL's per day and month for the two different datasets.
2. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
3. Pig Latin abstracts the programming from the Java MapReduce idiom into a notation which makes MapReduce programming high level, similar to that of SQL for relational database management systems. 
8. For highest occuring URL's per day in smalllog we have 27 rows and for per month we have 2 rows since the small log contains data of    2 months.
9.  For highest occuring URL's per day in smalllog we have 235 rows and for per month we have 9 rows since the large log contains data of about a year.
10. The script written in PIG** do not contain the part about status code since filtering by status was performed in [ITEM 2 Anaysis](https://github.com/illinoistech-itm/knaik3/blob/master/itmd521/Week%2013/item-2/ReadMe.md)** and also mentioned in the **ReadMe.md** file in the Week-13 folder.
10. The screenshots provide understanding about the output obtained.

## **References**
* [1] White T. (2015). Hadoop: The Definitive guide. Beijing: O’Reilly. *pg 421-424 of pdf*.

## **Screen Shots**
### Highest Occuring URL per day on small logs

![sql1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item5/smallperday.JPG)

### Highest Occuring URL per month on small logs

![sql2](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item5/smallpermonth.JPG)

### Highest Occuring URL per day on large logs
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item5/largeperday.JPG)
![sql3](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item5/largeperday2.JPG)

### Highest Occuring URL per month on large logs

![sql4](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item5/largepermonth.JPG)



