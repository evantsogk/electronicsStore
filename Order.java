public class Order extends Orders_and_Sales{
	private String arrival_date, status;
	private int codeOfOrder;
	
	//Status values
	public static String awaiting="Awaiting";
	public static String completed="Completed";
	
	public Order() {
		super();
	}
	
	public Order(int codeOfOrder, Device device, String customer, String phone, String date, double final_price, String arrival_date, String status) {
		super(device, customer, phone, date, final_price);
		this.arrival_date=arrival_date;
		this.status=status;
		this.codeOfOrder=codeOfOrder;
	}
	public void setCodeOfOrder(int n) {
		codeOfOrder=n;
	}
	public int getCodeOfOrder() {
		return codeOfOrder;
	}
	
	public Device getDevice() {
		return device;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public String getPhone() {
		return phone;
	}
    public String getDate() {
		return date;
	}
	public String getArrival_Date() {
		return arrival_date;
	}
	public void setArrival_Date(String str) {
		arrival_date=str;
	}
	public double getFinal_Price() {
		return final_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String str) {
		status=str;
	}
	

	public String toString() {
		return super.toString()+" Code of order: "+codeOfOrder+" Arrival date: "+arrival_date+" Status: "+status;
	}
}

