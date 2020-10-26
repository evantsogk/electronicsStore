import java.util.ArrayList;
public class Sales_List {
	private ArrayList<Sale>  sales= new ArrayList<Sale>();
	
    public void storeSale(Sale sale) {
		sales.add(sale);
	}
	
	public void showSales() {
		for (int i=0; i<sales.size(); i++) {
			System.out.println(sales.get(i));
		}
	}
	
	public int Entries(){
		return sales.size();
	}
	
	public Sale Dev(int i) {
		return sales.get(i);
	}
	
}