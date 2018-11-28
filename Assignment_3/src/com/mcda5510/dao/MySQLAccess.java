package com.mcda5510.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.mcda5510.connect.Connection_Mysql;
import com.webservice.transaction.Transaction;

public class MySQLAccess {
	public static Logger logger;
	public MySQLAccess() throws SecurityException, IOException {
		logger = Logger.getLogger("Main");  
	    FileHandler fh;  
	    
	    fh = new FileHandler("C:/Users/bhavy/OneDrive/Desktop/log.log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
	}
	
	public boolean insert_ID(Transaction trs) throws InstantiationException, IllegalAccessException
	{
			Connection_Mysql my_Conn;
			try {
				my_Conn = Connection_Mysql.getInstance();
				Connection con=Connection_Mysql.getDBConnection();
				
				String query = "INSERT INTO Transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreatedBy) values (?,?,?,?,?,?,?,NOW(),?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, String.valueOf(trs.getID()));
				stmt.setString(2, trs.getNameOnCard());
				stmt.setString(3, trs.getCardNumber());
				stmt.setString(4, String.valueOf(trs.getUnitPrice()));
				stmt.setString(5, String.valueOf(trs.getQuantity()));
				stmt.setDouble(6, (trs.getUnitPrice()*trs.getQuantity()));
				stmt.setString(7, trs.getExpDate());
				stmt.setString(8, System.getProperty("user.name"));
				
//				stmt.setString(9, String.valueOf(trs.getCardType()));

				int result = stmt.executeUpdate();
				logger.info("insert successfully");
			return true;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
				
	}
	
	public boolean Update_ID(Transaction trxnn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			int update = 0;
			PreparedStatement st = null;
			st = con.prepareStatement("UPDATE Transaction set NameOnCard=?, CardNumber=?, Quantity=?, UnitPrice=?, ExpDate=? WHERE ID=?");
		
			
			st.setString(1, trxnn.getNameOnCard());
			st.setString(2, trxnn.getCardNumber());
			st.setString(3, String.valueOf(trxnn.getUnitPrice()));
			st.setString(4, String.valueOf(trxnn.getQuantity()));
			st.setString(5, trxnn.getExpDate());
			st.setString(6, String.valueOf(trxnn.getID()));
			System.out.println(st.toString());
			update =st.executeUpdate();
			logger.info("updated");

			if (update>0) {
				System.out.println("updated");
			}else {
				System.out.println("update failed");
			}
			
				return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
			

	}

	

	public boolean Delete_Transaction(Transaction trxnn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			PreparedStatement st=null;
			st = con.prepareStatement("Delete from Transaction where ID="+trxnn.getID());
	

			int rowsDeleted = st.executeUpdate();
			
			
			if (rowsDeleted > 0) {
				System.out.println("Transaction Deleted");
				logger.info("Transaction Deleted");
				return true;
				}
			

		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		
		return false;
	}
	
	public Transaction get_Transaction(Transaction trxnn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet res = stmt1.executeQuery("Select * from Transaction where ID =" +trxnn.getID());
	

			while (res.next()) {
				trxnn = new Transaction();
				trxnn.setID(res.getInt(1));
				trxnn.setNameOnCard(res.getString(2));
				trxnn.setCardNumber(res.getString(3));
				trxnn.setUnitPrice(res.getDouble(4));
				trxnn.setQuantity(res.getInt(5));
				trxnn.setTotalPrice(res.getDouble(6));
				trxnn.setExpDate(res.getString(7));
				trxnn.setCreatedOn(res.getDate(8));
				trxnn.setCreatedBy(res.getString(9));
				//trxnn.setCardType(res.getString(10));
				System.out.println(trxnn.toString());
				logger.info(trxnn.toString());
				return trxnn;
				
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}

		return trxnn;
}
}