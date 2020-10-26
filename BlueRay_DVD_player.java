public class BlueRay_DVD_player extends Image_and_Sound {
	private String format, resolution;
	
	//type values
	public static final String Blue_ray="Blue ray";
	public static final String DVD="DVD";
	
	//format values
    public static final String BDR="BD-R";
	public static final String BDRD="BD-RD";
	public static final String DVDRW="DVD-RW";
	public static final String DVDplusRW="DVD+RW";
	
	public BlueRay_DVD_player() {
		
	}
	
	public BlueRay_DVD_player(int code, String name, int year, String constructor, double price, int stock, String type, String resolution, String format) {
		super(code, name, year, constructor, price, stock, type);
		this.format=format;
		this.resolution=resolution;
	}
	public String getResolution() {
		return resolution;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String str) {
		format=str;
	}
	public void setResolution(String str) {
		resolution=str;
	}
	public String toString() {
		return super.toString()+"Resolution: "+resolution+"\n"+"Format: "+format;
    }
}
	
