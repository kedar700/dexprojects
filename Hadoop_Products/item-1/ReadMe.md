# **ITEM 1 Analysis**
## Steps to run the code

concatincate the multiple log files inside both the datsets into single ones and name them as **comb.log** for the files in small-log and **comb2.log** for the files in the large-log and upload them to hdfs.

1. Clone the repo on the cluster where you want to test the code.
2. Navigate to the appropriate directory from there and here i will assume that java is already installed as well as hadoop. 
3. Compile the code making use of the command **hadoop com.sun.tools.javac.Main *.java**. 
6. Create a jar making use of the command **jar cf mxc.jar *.class** . The name for the jar selected here is mxc.jar. Select the name as per your convinience.
7. Next run the code as **hadoop jar mxc.jar  /ip /op** where input path will be the path to the input file at HDFS and give a output path of your choice in hdfs.
8. Verify the output after going to the output folder in hdfs.
9. The analysis is given below.

## Analysis
1. In this item we run the MapReduce for finding the highest occuring URL's per day and month.
2. The conditions that were applied for the same was that the status code should be **200** and there should be no 
   **"index.*"*** files like either **index.html** or **index.php**.
3. The given weblog data was parsed and the the mapper emitted the key as the date and the value as the URL.
4. In the reducer side the map outputs were sorted to get the highest occuring URL. This was performed 4 times in total twice for 
   two different datasets.
5. For the dataset **smalllogs** there were **19** splits generated and for the **largelogs** dataset there were **11** splits 
   that were generated.
6. The highest occuring URL can be seen below in the screenshots and then later screenshots are for the proof that the code was run
   successfully.
7. The splits were genrated according to the HDFS block size which by default and for our system is 128MB. Hence **19** splits for the      small logs file and **11** for the large log files[1].
8. The screenshots below depict the values of the required highest occuring URL's per day and per month.
9. Time taken for small logs data sets to find the maximum URL's per day and per month was **3 minutes and 33 seconds**.
10. Time taken for large logs data sets to find the maximum URL's per day and per month was **2 minutes and 5 seconds**.


## **References**
* [1] White T. (2015). Hadoop: The Definitive guide. Beijing: O’Reilly. *pg 119-126 of pdf*.

## Screen Shots
### Highest Occuring URL per day on small logs
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/smallday.JPG)
### Highest Occuring URL per month on small logs
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/smallmonth.JPG)
### Highest Occuring URL per day on large logs
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/largeday.JPG)
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/largeday2.JPG)
### Highest Occuring URL per month on large logs
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/largemonth.JPG)

### Verification for MapReduce code completion
![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/mrsmall.JPG)

![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/mrsmallmonth.JPG)

![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/mrlarge.JPG)

![mr1](https://github.com/illinoistech-itm/knaik3/blob/master/images/Screenshots/Week13/item1/mrlargemonth.JPG)
