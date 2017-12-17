// Created by Kedar Naik
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxURLMapper
  extends Mapper<LongWritable, Text, Text, Text> {

	
  public void map(LongWritable key,Text value, Context context)
      throws IOException, InterruptedException {
String[] myline= null;
String line = value.toString();
myline=line.split("\\s+");

String month, quality;
String URL="";
try{
	      month=myline[0];
	     quality=myline[10];
		
    if (quality.matches("200") && URL!="/index.*") {
    	
		 URL= myline[4];
   context.write(new Text(month), new Text(URL));  
}
}
catch(StringIndexOutOfBoundsException ex){
	 month = " ";
	 URL =" ";
	 quality = " ";
}
catch(ArrayIndexOutOfBoundsException Ex){
	month = " ";
	URL =" ";
	quality = " ";
}

}
}
