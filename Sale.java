public class Sale extends Orders_and_Sales {
	private int codeOfSale;
	public Sale() {
		
	}
	public Sale(int codeOfSale, Device device, String customer, String phone, String date, double final_price) {
		super(device, customer, phone, date, final_price);
		this.codeOfSale=codeOfSale;
	}
	public void setCodeOfSale(int n) {
		codeOfSale=n;
	}
	public Device getDevice() {
		return device;
	}
	public int getCodeOfSale () {
		return codeOfSale;
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
	public String toString() {
		return super.toString()+" Code of Sale: "+codeOfSale;
	}
	public double getFinal_Price() {
		return final_price;
	}
}


