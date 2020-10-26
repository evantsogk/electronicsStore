public class Orders_and_Sales {
	protected Device device;
	protected String customer, phone;
	protected String date;
	protected double final_price;
	
	public Orders_and_Sales() {
		
	}
	
	public Orders_and_Sales(Device device, String customer, String phone, String date, double final_price) {
		
		this.device=device;
		this.customer=customer;
		this.phone=phone;
		this.date=date;
		this.final_price=final_price;
	}
    public void setDevice(Device dev) {
		device=dev;
	}
	public void setCustomer(String str) {
		customer=str;
	}
	public void setPhone(String str) {
		phone=str;
	}
	public void setDate(String str) {
		date=str;
	}
	public void setFinal_Price(double d) {
		final_price=d;
	}
	public String toString() {
		return  " Device: "+device+" Costumer: "+customer+" Phone: "+phone+" Date: "+date+" Final price: "+final_price;
	}

}

