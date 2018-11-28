
/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MySQLAccess {

	public Connection setupConnection() throws Exception {

		Connection connection = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB

			connection = DriverManager.getConnection("jdbc:mysql://dev.cs.smu.ca/b_ahuja?" // DTP
					+ "user=b_ahuja&password=A00428499" // Creds
					+ "&useSSL=false&AllowPublicKeyRetrieval=True" // b/c localhost
					+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone

		} catch (Exception e) {
			throw e;
		} finally {

		}
		return connection;
	}

	public Collection<Transaction> getAllTransactions(Connection connection) throws  Exception {
		Statement st = null;
		ResultSet rs = null;
		
		Collection<Transaction> results = null;
		Logger logger = Logger.getLogger("MyLog");
		//FileHandler fh; 
		// Result set get the result of the SQL query
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(0);
	        //SimpleFormatter formatter = new SimpleFormatter();  
			st = connection.createStatement();
			
			String exp_date = new SimpleDateFormat("MM/YYYY").format(date);
			System.out.println(exp_date);
			
			System.out.println("Enter number\n '1' for Display row\n '2' for updatation of row\n '3' for deletion of row\n '4' for creation of row");
			Scanner reader = new Scanner(System.in);
			int n = reader.nextInt();
			switch(n) {
			case 1:
			
		     System.out.println("Enter the ID number");
		     int a = reader.nextInt();			 
			 rs = st.executeQuery("Select * from b_ahuja.transaction where ID="+a);
			 
			break;
			case 2:
			 System.out.println("Enter the ID to be updated");
			 int b = reader.nextInt();
			 System.out.println("Enter the feild to be updated. Please choose and type - nameOnCard, cardNumber, UnitPrice, Quantity, TotalPrice, ExpDate");
			 String feild = reader.next();
			 System.out.println("Enter the value");
			 String val = reader.next();
			 st.executeUpdate("UPDATE Transaction SET "+feild+" = "+val+" where ID = "+b);
			 rs = st.executeQuery("Select * from b_ahuja.transaction where ID="+b);
			 System.out.println(st.toString());			  
			 logger.info("Updated" + rs );
			 
			
			 break;
			case 3:
				 System.out.println("Enter the ID to be deleted");
				 String c = reader.next();
				
				 st.executeUpdate("Delete from b_ahuja.transaction where ID ="+c);
				 logger.info("Deleted");
				 break;
			case 4:
				 System.out.println("Enter the ID to be entered");
				 int ID = reader.nextInt();
				 if (checkWhetherIdExists(ID)) {
						//  fails if ID exists in DB and prompts user to use update 
						System.out.println("you should not use create but to use update transaction instead,id already exists");
						throw new Exception("ID Exists");	
					}
				 System.out.println("Enter the name on the card");
				 String cardName = reader.next();
				 System.out.println("Enter Card Number");
				 String cardNum = reader.next();
				 System.out.println("Enter UnitPrice");
				 float UnPr = reader.nextFloat();
				 System.out.println("Enter Quantity");
				 int quantity = reader.nextInt();
				 System.out.println("Enter Total Price");
				 float tprice = reader.nextFloat();
				 System.out.println("Enter expiry date, put it in MM/YYYY format");
				 String expDate = reader.next();
				 //System.out.println("Enter the date yyyy-mm-dd format" + new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime()));
				 //String datestring = reader.next();
				 //System.out.println("Enter CreatedBy");
				 //String Createdby = reader.next();
				
				 st.executeUpdate("INSERT INTO Transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreatedBy) VALUES (" + ID +",'" + cardName +"','" + cardNum+ "',"+ UnPr+ "," +quantity+ "," +tprice+ ",'" +exp_date+ "','" +dateFormat.format(date)+ "','" +System.getProperty("user.name") +"') ");
				 //System.out.println(st.toString());
				 rs = st.executeQuery("Select * from b_ahuja.transaction where ID="+ID);
				 logger.info("Row Inserted" + rs);
				 break;
			}
			results = createTrxns(rs);
			logger.finest("results" + results);
			
//			
//			if (rs != null) {
//				rs.close();
//			}
//
//			if (st1 != null) {
//				st1.close();
//			}
			reader.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   
			
		} finally {
			
			st = null;
			rs = null;
		}
		return results;

	}
	
	

	private boolean checkWhetherIdExists(int iD) {
		// TODO Auto-generated method stub
		return false;
	}

	private Collection<Transaction> createTrxns(ResultSet rs) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();
 
		// ResultSet is initially before the first data set
		while (rs.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			Transaction trxn = new Transaction();
			trxn.setNameOnCard(rs.getString("nameOnCard"));
			trxn.setCardNumber(rs.getString("cardNumber"));
			trxn.setID(rs.getInt("ID"));
			trxn.setUnitPrice(rs.getFloat("UnitPrice"));
			trxn.setQuantity(rs.getInt("Quantity"));
			trxn.setTotalPrice(rs.getFloat("TotalPrice"));
			trxn.setExpDate(rs.getString("ExpDate"));
			trxn.setCreatedOn(rs.getDate("CreatedOn"));
			trxn.setCreatedBy(rs.getString("CreatedBy"));
			
			
			
			String cardnumber = trxn.getCardNumber();
			results.add(trxn);
			

			// TODO
			/*
			 * String ID = resultSet.getString("ID"); String ExpDate =
			 * resultSet.getString("ExpDate"); String UnitPrice =
			 * resultSet.getString("UnitPrice"); Integer qty =
			 * resultSet.getInt("Quantity"); String totalPrice =
			 * resultSet.getString("TotalPrice"); Date createdOn =
			 * resultSet.getDate("CreatedOn"); String createdBy =
			 * resultSet.getString("CreatedBy");
			 */

		}

		return results;

	}
	
	

}
