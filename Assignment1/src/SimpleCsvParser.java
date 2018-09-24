import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SimpleCsvParser {

	public static void main(String[] args) {

		Reader in;
		try {
			in = new FileReader("/Users/mcda5550/Desktop/Java/https-github.com-DanielPenny-MCDA5510_Assignments-master/Sample Data/2018/12/21/CustomerData11.csv");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			for (CSVRecord record : records) {
			    String id = record.get(0);
			    String refID = record.get(1);
			    System.out.println("Data: "+ id+" : "+refID);
			}			
			
		} catch ( IOException e) {
			e.printStackTrace();
		}

		
		
	}

}
