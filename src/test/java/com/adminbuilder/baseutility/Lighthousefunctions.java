package com.adminbuilder.baseutility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

public class Lighthousefunctions {

	private static Lighthousefunctions InstanceReader = new Lighthousefunctions();
	
	public static Lighthousefunctions getInstance(){
		return InstanceReader;
	}
	WebAction webaction;
		private static String samplefile = new File("./log/ExecutionLog/ExecutionLog.csv").getAbsolutePath();
		static String path = "./log/ExecutionLog/ExecutionLog"+ getcurrentdate("MM-dd-yyyy HH-mm-ss") +".csv";
		private static String fileToUpdate = new File(path.trim().replace("-", "")).getAbsolutePath();
		private static File inputFile = new File(fileToUpdate);
		public static List<String[]> csvBody;
		public void loadCSV() throws IOException {
			copyFile(samplefile, fileToUpdate);
			CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
			csvBody = reader.readAll();
			reader.close();


			
	}
		
		public static String getcurrentdate(String dateFormat){ 

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);  
			LocalDateTime now = LocalDateTime.now();
			return dtf.format(now);

		}
		
		public void updateCSV(String replace,
				String Testcasename, String Columnname) throws IOException {

			csvBody.get(getrownumber(csvBody, Testcasename))[getcolumnnumber(csvBody, Columnname)] = replace;
			


			
	}
		
		
		public int getcolumnnumber(List<String[]> csvBody,String elementToFind) {
			if(csvBody != null && csvBody.size() > 0) {
				for(String[] row: csvBody) {
					for(int i=0; i< row.length; i++) {
						if(elementToFind.equalsIgnoreCase(row[i])) {
							return i;
						}
					}
				}
			}
			return -1;
		}
		
		public int getrownumber(List<String[]> csvBody,String elementToFind) {
			int j=0;
			if(csvBody != null && csvBody.size() > 0) {
				for(String[] row: csvBody) {
					
					for(int i=0; i< row.length; i++) {
						if(elementToFind.equalsIgnoreCase(row[i])) {
							return j;
						}
						
					}
					j++;
				}
			}
			return -1;
		}

		public void writecsvData() throws IOException{
			CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
		}
		
		 public String getcurrentdatetime()  {
				

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:ss");  
				LocalDateTime now1 = LocalDateTime.now();
				return dtf.format(now1);
				
		}
		 
		 public String getcurrentdate()  {
				

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
				LocalDateTime now1 = LocalDateTime.now();
				return dtf.format(now1);
				
		}
		 
		 public String getelapsedtime(String start, String end)  {		
				
			    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
				 Date d1 = null;
				    Date d2 = null;
				    try {
				        d1 = format.parse(start);
				        d2 = format.parse(end);
				    } catch (ParseException e) {
				        e.printStackTrace();
				    }

				   long diff = d2.getTime() - d1.getTime();
				    long diffSeconds = diff / 1000 % 60;
				    long diffMinutes = diff / (60 * 1000) % 60;
				    long diffHours = diff / (60 * 60 * 1000);
				    
				   return diffHours + ":" + diffMinutes + ":" + diffSeconds;
		}
		 
		 public static void copyFile(String origin, String destination) throws IOException {
		        Path FROM = Paths.get(origin);
		        Path TO = Paths.get(destination);
		        //overwrite the destination file if it exists, and copy
		        // the file attributes, including the rwx permissions
		        CopyOption[] options = new CopyOption[]{
		          StandardCopyOption.REPLACE_EXISTING,
		          StandardCopyOption.COPY_ATTRIBUTES
		        }; 
		        Files.copy(FROM, TO, options);
		    }
}
