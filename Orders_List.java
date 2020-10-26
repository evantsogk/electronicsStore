import java.util.ArrayList;
public class Orders_List {
	private ArrayList<Order>  orders= new ArrayList<Order>();
	
	public void storeOrder(Order order) {
		orders.add(order);
	}
	
	public void showCodesOfOrders() {
		for (int i=0; i<orders.size(); i++) {
			System.out.println(i+1);
		}
	}
	
	public void showOrder(int i) {
		System.out.println(orders.get(i));
	}
	
	public int Entries(){
		return orders.size();
	}
	
	public Order Dev(int i) {
		return orders.get(i);
	}
	public int getSize() {
		return orders.size();
	}
}
	
	