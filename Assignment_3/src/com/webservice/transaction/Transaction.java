package com.webservice.transaction;

import java.util.Date;

public class Transaction {
	

	private int ID;
	private String cardNumber;
	private String nameOnCard;
	private double unitPrice;
	private int quantity;
	private double TotalPrice;
	private String ExpDate;
	private Date CreatedOn;
	private String CreatedBy;
    //private String CardType;
	
    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}



	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getTotalPrice() {
		
		return TotalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		
		TotalPrice = totalPrice;
	}



	public String getExpDate() {
		return ExpDate;
	}



	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}



	public Date getCreatedOn() {
		return CreatedOn;
	}



	public void setCreatedOn(Date createdOn2) {
		
		CreatedOn = createdOn2;
	}



	public String getCreatedBy() {
		
		return CreatedBy;
	}



	public void setCreatedBy(String createdBy) {
		
		CreatedBy = createdBy;
	}



//	public String getCardType() {
//		return CardType;
//	}



//	public void setCardType(String cardType) {
//		CardType = cardType;
//	}




	public String toString() {
		return "Transaction [ID=" + ID + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", unitPrice="
				+ unitPrice + ", quantity=" + quantity + ", TotalPrice=" + TotalPrice + ", ExpDate=" + ExpDate
				+ ", CreatedOn=" + CreatedOn + ", CreatedBy=" + CreatedBy + "]";
	}
	
	
}