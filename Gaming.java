public class Gaming extends Device {
	private String graphics, type, sound, hard_disc, proccesor;
	public static final double discount=10.0/100;
	
	//type values
	public static final String PS4="PS4";
	public static final String PS3="PS3";
	public static final String Xbox="Xbox";
	public static final String Wii="Wii";
	
	public Gaming() {
		
	}
	
	
	public Gaming(int code, String name, int year, String constructor, double price, int stock, String type, String graphics, String proccesor, String sound, String hard_disc) {
		super(code, name, year, constructor, price, stock);
		this.graphics=graphics;
		this.proccesor=proccesor;
		this.sound=sound;
		this.hard_disc=hard_disc;
		this.type=type;
	}
	public String getType() {
		return type;
	}
	public String getGraphics() {
		return graphics;
	}
	public String getProccesor() {
		return proccesor;
	}
	public String getSound() {
		return sound;
	}
	public String getHard_Disc() {
		return hard_disc;
	}
	public void setGraphics(String str) {
		graphics=str;
	}
	
	public void setProccesor(String str) {
		proccesor=str;
	}
	
	public void setSound(String str) {
		sound=str;
	}
	
	public void setHard_Disc(String str) {
		hard_disc=str;
	}
	
	public void setType(String str) {
		type=str;
	}
	public String toString() {
		return super.toString()+"Type: "+type+"\n"+"Graphics: "+graphics+"\n"+"Proccesor: "+proccesor+"\n"+"Sound: "+sound+"\n"+"Hard Disc: "+hard_disc;
	}
}
