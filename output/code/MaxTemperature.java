// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
// Edited by Kedar Naresh Naik
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.compress.CompressionCodec;

public class MaxTemperature {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: MaxTemperature <input path> <output path>");
      System.exit(-1);
    }
    Configuration config = new Configuration();
    config.setBoolean(Job.MAP_OUTPUT_COMPRESS, true);
    config.setClass(Job.MAP_OUTPUT_COMPRESS_CODEC, GzipCodec.class,CompressionCodec.class);
    Job job = new Job(config);
    job.setJarByClass(MaxTemperature.class);
    job.setJobName("Max temperature");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
	job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
	
	FileOutputFormat.setCompressOutput(job, true);
    FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
    
    job.setMapperClass(MaxTemperatureMapper.class);
    job.setReducerClass(MaxTemperatureReducer.class);


    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
// ^^ MaxTemperature
