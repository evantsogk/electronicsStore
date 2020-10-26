public class Washing_Machine extends Household_Machine {
	private String capacity, spins;
	
	public Washing_Machine() {
		
	}
	
	public Washing_Machine(int code, String name, int year, String constructor, double price, int stock, String energy_rating, String capacity, String spins) {
	    super(code, name, year, constructor, price, stock, energy_rating);
		this.capacity=capacity;
		this.spins=spins;
    }
	public String getCapacity() {
		return capacity;
	}
	public String getSpins() {
		return spins;
	}
	public void setCapacity(String str) {
		capacity=str;
	}
	
	public void setSpins(String str) {
		spins=str;
	}
	public String toString() {
		return super.toString()+"Capacity: "+capacity+"\n"+"Spins: "+spins;
	}
	
}

	