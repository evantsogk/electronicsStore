public class Camera extends Image_and_Sound {
	private double megapixel, screen_size;
	private String optical_zoom, digital_zoom;
	
	//type values
	public static final String compact="compact";
	public static final String DSLR="DSLR";
	public static final String Action_camera="Action camera";
	
	public Camera() {
		
	}
	
	public Camera(int code, String name, int year, String constructor, double price, int stock, String type, double megapixel, double screen_size, String optical_zoom, String digital_zoom){
	    super(code, name, year, constructor, price, stock, type);
		this.megapixel=megapixel;
		this.screen_size=screen_size;
		this.optical_zoom=optical_zoom;
		this.digital_zoom=digital_zoom;
    }
	public double getMegapixel() {
		return megapixel;
	}
	public double getScreen_Size() {
		return screen_size;
	}
	public String getOptical_Zoom() {
		return optical_zoom;
	}
	public String getDigital_Zoom() {
		return digital_zoom;
	}
	public void setMegapixel(double d) {
		megapixel=d;
	}
	
	public void setScreen_Size(double d) {
		screen_size=d;
	}
	
	public void setOptical_Zoom(String str) {
		optical_zoom=str;
	}
	
	public void setDigital_Zoom(String str) {
		digital_zoom=str;
	}
	
	public String toString() {
		return super.toString()+"Megapixel: "+megapixel+"\n"+"Screen size: "+screen_size+"\n"+"Optical zoom: "+optical_zoom+"\n"+"Digital zoom: "+digital_zoom;
	}
}
