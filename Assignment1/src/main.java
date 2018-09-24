import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.PrintWriter;
import java.io.LineNumberReader;

public class main {
	public static int i = 0;
	public static int x = 0;
	public static long startTime;
	public static long endTime;
	private static CSVPrinter csvPrinter;

	public void walk(String path) {

		ArrayList<String[]> getFiles = new ArrayList<>();

		File root = new File(path);
		File[] list = root.listFiles();
		if (list == null)
			return;
		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				
			} else {
				Reader in;
				try {
					if (f.getAbsolutePath().endsWith(".csv")) {
						in = new FileReader(f.getAbsoluteFile());
						
						Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
						
						
						for (CSVRecord record : records) {
							if(record.getRecordNumber() == 1) continue;
							try {
								String First_Name = record.get(0);
								String Last_Name = record.get(1);
								String Street_Number = record.get(2);
								String Street = record.get(3);
								String City = record.get(4);
								String Province = record.get(5);
								String Postal_Code = record.get(6);
								String Country = record.get(7);
								String Phone_Number = record.get(8);
								String email_Address = record.get(9);
								if (First_Name.equals ("") || Last_Name.equals("") || Postal_Code.equals("")
										|| Postal_Code.equals("") || email_Address.equals("")
										|| email_Address.equals("")) {
									Logger.getAnonymousLogger().log(Level.INFO,
											"This record is incomplete, so it is skipped." + ++i);
								} else {
									String[] sourceArray = { First_Name , Last_Name , 
											  Street_Number , Street , City , Province ,
												 Postal_Code , Country , Phone_Number , email_Address };
									csvPrinter.printRecord( Arrays.asList(sourceArray));
									Logger.getAnonymousLogger().log(Level.INFO,
											"This record is complete." + ++x);

										
								}
									} catch (Exception e) {
										throw e; 
									}
						}
					}
			}catch(IOException e) {
				
			}catch (ArrayIndexOutOfBoundsException e) {
				
			}
			catch (Exception e) {
				throw e; 
			}
			}
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh; 
		final long startTime = System.currentTimeMillis();
		try {
			fh = new FileHandler("/home/student_2018_fall/b_ahuja/Assignment1/Assignment1/ahuja.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter); 
	        
	        
			PrintWriter pw = new PrintWriter("/home/student_2018_fall/b_ahuja/Assignment1/Assignment1/Bhavya.csv");
			
		    
			

			csvPrinter = new CSVPrinter(pw, CSVFormat.EXCEL.withHeader("First_Name", "Last_Name","Street_Number","Street","City","Province","Postal_Code","Country","Phone_Number" ,"email_Address"));
			//csvPrinter = new CSVPrinter(p, CSVFormat.EXCEL.withHeader("total_time","skipped","valid"));
			
		} catch (Exception e) {  
	        e.printStackTrace();  
	        logger.info(e.getMessage());
	    }  
	     

	main fw = new main();
		fw.walk("/home/student_2018_fall/b_ahuja/Sample_Data");
		csvPrinter.flush();
		csvPrinter.close();
		final long endTime = System.currentTimeMillis();
		//System.out.println("Total execution time: " + (endTime - startTime)+ " ms " +  " " + i + " " + x);
		logger.info("Total execution time: " + (endTime - startTime)+ " ms " + "\n" + "Total invalid rows: " + i + "\n" + "Total valid rows: " + x);
		
	}
	
	    

	    
}