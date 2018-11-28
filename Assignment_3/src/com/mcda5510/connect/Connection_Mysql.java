package com.mcda5510.connect;


import java.sql.*;


public class Connection_Mysql {

	public static Connection_Mysql my_Conn=new Connection_Mysql();
	static Connection conn;

	private Connection_Mysql()  {
		
	}
	public static Connection_Mysql getInstance() throws ClassNotFoundException, SQLException
	{
		return my_Conn;
	}
	
		public static Connection getDBConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","mysqlpass");
			return conn;			
		} 
	}