package com.webservice.webserviceCall;

import java.io.IOException;
import java.util.Scanner;

import com.mcda5510.dao.MySQLAccess;
import com.webservice.transaction.Transaction;

public class Webservice_Call {
	
	public String createTransaction(int ID, String NameOnCard,String CardNumber,double UnitPrice,int Quantity, String ExpDate) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
				
		Transaction trxnn = new Transaction();
	
		trxnn.setID(ID);
		  if (NameOnCard.contains(";") || NameOnCard.contains(":") ||NameOnCard.contains("!") || NameOnCard.contains("@") || NameOnCard.contains("#") 
			        || NameOnCard.contains("$") || NameOnCard.contains("%") || NameOnCard.contains("^") || NameOnCard.contains("*") || NameOnCard.contains("+") ||NameOnCard.contains("?") || NameOnCard.contains("<") || NameOnCard.contains(">"))
			        {
			        	return "Contains Special Character";
			        }
		trxnn.setNameOnCard(NameOnCard);
		if (CardNumber.contains(";") || CardNumber.contains(":") ||CardNumber.contains("!") || CardNumber.contains("@") || CardNumber.contains("#") 
		        || CardNumber.contains("$") || CardNumber.contains("%") || CardNumber.contains("^") || CardNumber.contains("*") || CardNumber.contains("+") ||CardNumber.contains("?") || CardNumber.contains("<") || CardNumber.contains(">"))
		        {
		        	return "Contains Special Character";
		        }
		trxnn.setCardNumber(CardNumber);
		trxnn.setUnitPrice(UnitPrice);
		trxnn.setQuantity(Quantity);
		if (ExpDate.contains(";") || ExpDate.contains(":") ||ExpDate.contains("!") || ExpDate.contains("@") || ExpDate.contains("#") 
		        || ExpDate.contains("$") || ExpDate.contains("%") || ExpDate.contains("^") || ExpDate.contains("*") || ExpDate.contains("+") ||ExpDate.contains("?") || ExpDate.contains("<") || ExpDate.contains(">"))
		        {
		        	return "Contains Special Character";
		        }
		trxnn.setExpDate(ExpDate);
			
		MySQLAccess insert=new MySQLAccess();
		boolean temp=insert.insert_ID(trxnn);
		if (temp==true)
		{

			return "ID Inserted";
		}else
			return "ID not Inserted";
	}
	
	public String updateTransaction(int ID, String NameOnCard,String CardNumber,double UnitPrice,int Quantity, String ExpDate) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
		
		Transaction trxnn = new Transaction();
    
               
				trxnn.setID(ID);
				 if (NameOnCard.contains(";") || NameOnCard.contains(":") ||NameOnCard.contains("!") || NameOnCard.contains("@") || NameOnCard.contains("#") 
					        || NameOnCard.contains("$") || NameOnCard.contains("%") || NameOnCard.contains("^") || NameOnCard.contains("*") || NameOnCard.contains("+") ||NameOnCard.contains("?") || NameOnCard.contains("<") || NameOnCard.contains(">"))
					        {
					        	return "Contains Special Character";
					        }
         		trxnn.setNameOnCard(NameOnCard);
         		if (CardNumber.contains(";") || CardNumber.contains(":") ||CardNumber.contains("!") || CardNumber.contains("@") || CardNumber.contains("#") 
        		        || CardNumber.contains("$") || CardNumber.contains("%") || CardNumber.contains("^") || CardNumber.contains("*") || CardNumber.contains("+") ||CardNumber.contains("?") || CardNumber.contains("<") || CardNumber.contains(">"))
        		        {
        		        	return "Contains Special Character";
        		        }
         		trxnn.setCardNumber(CardNumber);
         		trxnn.setUnitPrice(UnitPrice);
         		trxnn.setQuantity(Quantity);
         		if (ExpDate.contains(";") || ExpDate.contains(":") ||ExpDate.contains("!") || ExpDate.contains("@") || ExpDate.contains("#") 
        		        || ExpDate.contains("$") || ExpDate.contains("%") || ExpDate.contains("^") || ExpDate.contains("*") || ExpDate.contains("+") ||ExpDate.contains("?") || ExpDate.contains("<") || ExpDate.contains(">"))
        		        {
        		        	return "Contains Special Character";
        		        }
         		trxnn.setExpDate(ExpDate);
         		MySQLAccess update=new MySQLAccess();
         		boolean temp=update.Update_ID(trxnn);
         			
         			if (temp==true)
         			{

         				return "ID Updated Successfully";
         			}else
         				return "Update Failed";
         		}
         		
         
public String deleteTransaction(int ID) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
	
	Transaction trxnn = new Transaction();
          
			trxnn.setID(ID);
     		
     		MySQLAccess delete=new MySQLAccess();
     		boolean temp = delete.Delete_Transaction(trxnn);
     		if (temp==true)
 			{

 				return "ID Deleted Successfully";
 			}else
 				return "Delete Failed";
 		}
 		
public String get_Transaction(int ID) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
	
	Transaction trxnn = new Transaction();
          
			trxnn.setID(ID);   		
     		MySQLAccess get=new MySQLAccess();
     		Transaction temp = get.get_Transaction(trxnn);
     		return temp.toString();
     }
	}