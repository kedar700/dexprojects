import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
public class InsertLogs2 {
	private static final String COMMA_DELIMITER = ","; 
	private static final String NEW_LINE_SEPARATOR = "\n"; 
	 public void PassToDatabase()  throws IOException{
		 String date1, URL, quality,method,date2;
try{
			FileWriter fw = null;
			String lin = "";
			fw = new FileWriter("data2.csv");
			InputStream fileStream = new FileInputStream("comb2.log");
			Reader decoder = new InputStreamReader (fileStream);
			BufferedReader bf = new BufferedReader(decoder);
			while ((lin = bf.readLine()) != null){
				try{
					String[] myline=lin.split("\\s+");
					
				URL=myline[4];
				quality=myline[10];
				date1=myline[0];
				date2=myline[0].substring(0,7);
				method=myline[3];
				}
				catch(StringIndexOutOfBoundsException ex){
					 date1= " ";
					 URL =" ";
					 quality = " ";
					 method=" ";
					 date2= " ";
				}catch(ArrayIndexOutOfBoundsException e){
					date1= " ";
					 URL =" ";
					 quality = " ";
					 method=" ";
					 date2 = " ";
				}
				if (quality.matches("200")){
					fw.append(String.valueOf(date1));
					fw.append(COMMA_DELIMITER);
					fw.append(String.valueOf(date2));
					fw.append(COMMA_DELIMITER);
					fw.append(String.valueOf(URL));
					fw.append(COMMA_DELIMITER);
					fw.append(String.valueOf(method));
					fw.append(NEW_LINE_SEPARATOR);
				}
				
			
			}
			System.out.println("----File written successfully----");
}
catch (FileNotFoundException e) {

	System.out.println("----No files present in the given location----");
} catch (IOException e) {
	System.out.println(e);
}

	 }
public void insertdata() throws SQLException, ClassNotFoundException{
	String myDriver = "com.mysql.jdbc.Driver";
	String myUrl = "jdbc:mysql://localhost:3306/weblog";
    Class.forName(myDriver);
    Connection connect = DriverManager.getConnection(myUrl, "root", "safestsystemever");
	Statement statement = connect.createStatement();
	
	String loadQuery = "LOAD DATA LOCAL INFILE '" + "../src/data2.csv"
			+ "' INTO TABLE largelog FIELDS TERMINATED BY ','"
			+ " LINES TERMINATED BY '\n' (date1,date2,URL,method) ";
	statement.execute(loadQuery);
	System.out.println("----The values are entered into the tables----");	
}
public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
	InsertLogs2 um = new InsertLogs2();
	um.PassToDatabase();
	um.insertdata();
	
}
}
