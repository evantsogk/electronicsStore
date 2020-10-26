public class Refrigerator extends Household_Machine {
	private String type, cooler_capacity, freezer_capacity;
	
	//type values
	public static final String Single_door="Single door";
	public static final String Double_door="Double door";
	public static final String French_door="French door"; //ntoulapa
	
	public Refrigerator() {
		
	}
	
	public Refrigerator(int code, String name, int year, String constructor, double price, int stock, String energy_rating, String type, String cooler_capacity, String freezer_capacity) {
		super(code, name, year, constructor, price, stock, energy_rating);
		this.type=type;
		this.cooler_capacity=cooler_capacity;
		this.freezer_capacity=freezer_capacity;
	}
	public String getType() {
		return type;
	}
	public String getCooler_Capacity() {
		return cooler_capacity;
	}
	public String getFreezer_Capacity() {
		return freezer_capacity;
	}
	public void setType(String str) {
		type=str;
	}
	
	public void setCooler_Capacity(String str) {
		cooler_capacity=str;
	}
	
	public void setFreezer_Capacity(String str) {
		freezer_capacity=str;
	}
	public String toString() {
		return super.toString()+"Type: "+type+"\n"+"Cooler capacity: "+cooler_capacity+"\n"+"Freezer capacity: "+freezer_capacity;
	}
	
}
