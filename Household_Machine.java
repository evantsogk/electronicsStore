public class Household_Machine extends Device {
	private String energy_rating;
	public static final double discount=20.0/100;
	
	public Household_Machine() {
		
	}
	public Household_Machine(int code, String name, int year, String constructor, double price, int stock, String energy_rating) {
	    super(code, name, year, constructor, price, stock);
		this.energy_rating=energy_rating;
	}
	public String getEnergy_Rating() {
		return energy_rating;
	}
	public void setEnergy_Rating(String str) {
		energy_rating=str;
	}
	public String toString() {
		return super.toString()+"Energy rating: "+energy_rating+"\n";
	}
}

