import java.sql.Connection;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Assignment2 {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog"); 
		FileHandler fh;
        MySQLAccess dao = new MySQLAccess();
        try {
        	fh = new FileHandler("./ahuja.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter); 
        	 
        	//Here is connection establishment
			Connection connection = dao.setupConnection();
			
			
			Collection<Transaction> trxns = dao.getAllTransactions(connection);
			
			for (Transaction trxn:trxns ){
				System.out.println(trxn.toString());
			}
			
			if (connection != null) {
				connection.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
			//logger.info("My first log");
		}
	}	
	
}
