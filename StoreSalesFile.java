import java.io.*;
import java.util.*;

public class StoreSalesFile {
	
	public void createFile  (String fn, Sales_List list) {
		Sales_List sale_list=list;
		File f = null;
		BufferedWriter writer = null;
		Device dev=null;
		try	{
			f = new File(fn);
		}
		catch (NullPointerException e) {
			System.err.println ("File not found.");
		}

		try	{
			writer = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(f)));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}

		try	{
			writer.write("SALES_LIST"+"\n"+"{");
		    for (int i=0; i<sale_list.Entries(); i++) {
				dev=sale_list.Dev(i).getDevice();
				writer.write("\n"+"\t"+"SALE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t");
                if (dev instanceof TV) 
					writer.write("ITEM_TYPE TV"
				    +"\n"+"\t"+"\t"+"TYPE "+((TV) dev).getType()
					+"\n"+"\t"+"\t"+"SCREEN "+((TV) dev).getScreen()
					+"\n"+"\t"+"\t"+"PORTS "+((TV) dev).getPorts()
					+"\n"+"\t"+"\t"+"RESOLUTION "+((TV) dev).getResolution());
				   
				else if (dev instanceof BlueRay_DVD_player)
					writer.write("ITEM_TYPE BlueRay_DVD_player"
				    +"\n"+"\t"+"\t"+"TYPE "+((BlueRay_DVD_player) dev).getType()
					+"\n"+"\t"+"\t"+"RESOLUTION "+((BlueRay_DVD_player) dev).getResolution()
					+"\n"+"\t"+"\t"+"FORMAT "+((BlueRay_DVD_player) dev).getFormat());
				else if (dev instanceof Camera)
					writer.write("ITEM_TYPE Camera"
				    +"\n"+"\t"+"\t"+"TYPE "+((Camera) dev).getType()
					+"\n"+"\t"+"\t"+"MEGAPIXEL "+((Camera) dev).getMegapixel()
					+"\n"+"\t"+"\t"+"SCREEN_SIZE "+ ((Camera) dev).getScreen_Size()
					+"\n"+"\t"+"\t"+"OPTICAL_ZOOM "+((Camera) dev).getOptical_Zoom()
					+"\n"+"\t"+"\t"+"DIGITAL_ZOOM "+((Camera) dev).getDigital_Zoom());
				else if (dev instanceof Gaming)
					writer.write("ITEM_TYPE Gaming"
				    +"\n"+"\t"+"\t"+"TYPE "+((Gaming) dev).getType()
					+"\n"+"\t"+"\t"+"GRAPHICS "+((Gaming) dev).getGraphics()
					+"\n"+"\t"+"\t"+"PROCCESOR "+((Gaming) dev).getProccesor()
					+"\n"+"\t"+"\t"+"SOUND "+((Gaming) dev).getSound()
					+"\n"+"\t"+"\t"+"HARD_DISC "+((Gaming) dev).getHard_Disc());
				else if (dev instanceof Refrigerator)
					writer.write("ITEM_TYPE Refrigerator"
				    +"\n"+"\t"+"\t"+"TYPE "+((Refrigerator) dev).getType()
					+"\n"+"\t"+"\t"+"ENERGY_RATING "+((Refrigerator) dev).getEnergy_Rating()
					+"\n"+"\t"+"\t"+"COOLER_CAPACITY "+((Refrigerator) dev).getCooler_Capacity()
					+"\n"+"\t"+"\t"+"FREEZER_CAPACITY "+((Refrigerator) dev).getFreezer_Capacity());
				else if (dev instanceof Washing_Machine)
					writer.write("ITEM_TYPE Washing_Machine"
				    +"\n"+"\t"+"\t"+"ENERGY_RATING "+((Washing_Machine) dev).getEnergy_Rating()
					+"\n"+"\t"+"\t"+"CAPACITY "+((Washing_Machine) dev).getCapacity()
					+"\n"+"\t"+"\t"+"SPINS "+((Washing_Machine) dev).getSpins());
				writer.write("\n"+"\t"+"\t"+"NAME "+dev.getName()
				+"\n"+"\t"+"\t"+"CODE "+dev.getCode()
				+"\n"+"\t"+"\t"+"YEAR "+dev.getYear()
				+"\n"+"\t"+"\t"+"PRICE "+dev.getPrice()
				+"\n"+"\t"+"\t"+"STOCK "+dev.getStock()
				+"\n"+"\t"+"\t"+"CONSTRUCTOR "+dev.getConstructor()
				+"\n"+"\t"+"\t"+"SALE_NUMBER "+sale_list.Dev(i).getCodeOfSale()
				+"\n"+"\t"+"\t"+"CUSTOMER "+sale_list.Dev(i).getCustomer()
				+"\n"+"\t"+"\t"+"PHONE "+sale_list.Dev(i).getPhone()
				+"\n"+"\t"+"\t"+"DATE "+sale_list.Dev(i).getDate()
				+"\n"+"\t"+"\t"+"FINAL_PRICE "+sale_list.Dev(i).getFinal_Price()
				+"\n"+"\t"+"}");
		    }
			writer.write("\n"+"}");
        }
		catch (IOException e) {
			System.err.println("Write error!");
		}
		
		try {
			writer.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
}

