public class TV extends Image_and_Sound {
	private int screen;
	private String ports, resolution;
	
	//type values
	public static final String LCD="LCD";
	public static final String LED="LED";
	public static final String Plasma="Plasma";
	
	//ports values
	public static final String HDMI="HDMI";
	public static final String DVI="DVI";
	public static final String Composite="Composite";
	
	
	public TV() {
		
	}
	
	public TV(int code, String name, int year, String constructor, double price, int stock, String type, int screen, String ports, String resolution) {
		super(code, name, year, constructor, price, stock, type);
		this.resolution=resolution;
		this.screen=screen;
		this.ports=ports;
	}

	public String getResolution() {
		return resolution;
	}
	
	public void setResolution(String str) {
		resolution=str;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int n) {
		screen=n;
	}
	public String getPorts() {
		return ports;
	}
	public void setPorts(String str) {
		ports=str;
	}
	public String toString() {
		return super.toString()+"Screen: "+screen+"\n"+"Ports: "+ports+"\n"+"Resolution: "+resolution;
	}
}

