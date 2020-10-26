import java.util.ArrayList;
public class Device_List {
	private ArrayList<Device>  list= new ArrayList<Device>();

	
    public void storeDevice(Device device) {
	    list.add(device);
	}
	
	

	
	public boolean isTV(int i) {
	   
			if (list.get(i) instanceof TV)
				return true;
				
		    else
		        return false;
		
	}
	

	
	public boolean isBlueRay_DVD_player(int i) {
	    
		
			if ((list.get(i) instanceof BlueRay_DVD_player) && (list.get(i).getCode()==i))
				return true;
				
		    else
		        return false;
		
	}
	

	
	public boolean isCamera(int i) {
	    
		
			if ((list.get(i) instanceof Camera) && (list.get(i).getCode()==i))
				return true;
				
		    else
		        return false;
		
	}
	

	
	public boolean isGaming(int i) {
	    
		
			if ((list.get(i) instanceof Gaming) && (list.get(i).getCode()==i))
				return true;
				
            else
		        return false;
		
	}
	

	
	public boolean isRefrigerator(int i) {
	    
		
			if ((list.get(i) instanceof Refrigerator) && (list.get(i).getCode()==i))
				return true;
				
		    else
		        return false;
		
	}

	
	public boolean isWashing_Machine(int i) {
	    
		
		if ((list.get(i) instanceof Washing_Machine) && (list.get(i).getCode()==i))
			return true;
				
		else
		    return false;
		
	}

	public int Entries(){
		return list.size();
	}
	
	public Device Dev(int i) {
		return list.get(i);
	}

}
	