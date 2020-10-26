public class Device {
	private String name, constructor;
	private int year, code, stock;
	private double price;
	public Device() {
		
	}
	    
	
	public Device(int code, String name, int year, String constructor, double price, int stock) {
        this.code=code;
        this.name=name;
        this.year=year;
        this.constructor=constructor;
        this.price=price;
		this.stock=stock;
		
    }
	public int getYear() {
		return year;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String str) {
		name=str;
	}
	
    public int getCode() {
		return code;
	}
	public void setCode(int n) {
		code=n;
	}

	public void setYear(int n) {
		year=n;
	}
	public String getConstructor() {
		return constructor;
	}
	public void setConstructor(String str) {
		constructor=str;
	}
	
	public int getStock() {
		return stock;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double d) {
		price=d;
	}
	public void setStock(int n) {
		stock=n;
	}
	public String toString() {
	    return "Code: "+code+"\n"+ "Name: "+name+"\n"+"Year: "+year+"\n"+"Constructor: "+constructor+"\n"+"Price: "+price+"\n"+"Available: "+stock+"\n";
	}

}


	
	