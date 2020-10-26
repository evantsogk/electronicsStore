public class Image_and_Sound extends Device {
	private String type;
	public static final double discount=25.0/100;
	
	public Image_and_Sound() {
		
	}
	public Image_and_Sound (int code, String name, int year, String constructor, double price, int stock, String type) {
		super(code, name, year, constructor, price, stock);
		this.type=type;
		
	
		
	}
    public String getType() {
		return type;
	}
	public void setType(String str) {
		type=str;
	}
	public String toString() {
		return super.toString()+"Type: "+type+"\n";
	}
	
}

		