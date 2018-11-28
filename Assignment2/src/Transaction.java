import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {

	private int ID;
    private String nameOnCard;
	private String cardNumber;
	private float UnitPrice;
	private int Quantity;
	private float TotalPrice;
	private String ExpDate; 
	private Date CreatedOn;
	private String CreatedBy;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
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
	
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public String getExpDate() {
		return ExpDate;
	}
	public void setExpDate(String ExpDate) {
		this.ExpDate = ExpDate;
	}
	public Date getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(Date CreatedOn) {
		this.CreatedOn = CreatedOn;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = System.getProperty("user.name");
	}
	public String toString(){
		
		String results = new String();
		
		results = "[ID: "+ID+ " NameOnCard: " + nameOnCard +",CardNumber: " + cardNumber+  ",UnitPrice: " + UnitPrice + ",Quantity: " + Quantity + ",TotalPrice: " +TotalPrice+ ",ExpDate: " +ExpDate+ ",CreatedOn: " + CreatedOn + ",CreatedBy: " + CreatedBy + "]";
		return results;

	}
	
	
}
