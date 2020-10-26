import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;

public class mainApp extends JFrame {
	private JMenuItem j1, j2;
	private JButton sale, order_arrival, search;
	private JPanel jdevices, jsales, jorders;
	private ReadDevicesFile dev_file = new ReadDevicesFile();
	private ReadOrdersFile ord_file = new ReadOrdersFile();
	private ReadSalesFile sales_file = new ReadSalesFile();
	private StoreOrdersFile write_orders=new StoreOrdersFile();
	private StoreSalesFile write_sales = new StoreSalesFile();
	private Device_List dev_list=new Device_List();
	private Sales_List sales=new Sales_List();
	private Orders_List orders=new Orders_List();
	private File file;
	private JList jdev_list, jdev_info, jsales_list, jord_list;
    private DefaultListModel dev_listModel, dev_infoModel, salesModel, ordModel;
	Sale sale1;
	Order ord1;
	private boolean isSale, isOrder, found;
    private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	private Calendar c = Calendar.getInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	String date2;
	private int ans;
	private String in=null;
    private String in1=null;
	private String in2=null;
	private Object in3=null;
	private Object in4=null;
	private double discount1;
	private double price;
	private String strPrice;
	private ImageIcon img = new ImageIcon("Logo/logo.png");
	public mainApp () {
		setResizable(false);
		c.setTime(new Date());
		c.add(Calendar.DATE, 14);
		String date2=sdf.format(c.getTime());
		DevListListener listen1 = new DevListListener();
		DevInfoListener listen2 = new DevInfoListener();
		setLayout(new BorderLayout());
		setBounds(500, 300, 700, 400);
		setTitle("Electronics Store by 3150185 3150104 3150258");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(img.getImage());
		//menu bar
		j1 = new JMenuItem("Load File");
		j2 = new JMenuItem("Save File");
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Files");
		menu.add(j1);
        menu.addSeparator();
		menu.add(j2);
		menubar.add(menu);
		setJMenuBar(menubar);
		//tool bar
		ImageIcon saleIcon = new ImageIcon("toolbar images/sale.jpg");
        ImageIcon order_arrivalIcon = new ImageIcon("toolbar images/order arrival.jpg");
        ImageIcon searchIcon = new ImageIcon("toolbar images/search.jpg");
		sale = new JButton("Sell", saleIcon);
		sale.setFocusPainted(false);
		order_arrival = new JButton("Order Arrival", order_arrivalIcon);
		order_arrival.setFocusPainted(false);
		search = new JButton("Search", searchIcon);
		search.setFocusPainted(false);
		JToolBar bar = new JToolBar();
		bar.add(sale);
		bar.add(order_arrival);
		bar.add(search);
		add("North", bar);
        sale.setEnabled(false);
		order_arrival.setEnabled(false);
		search.setEnabled(false);

		//jdev_list 
		jdevices = new JPanel();
        dev_listModel=new DefaultListModel();
        dev_listModel.addElement("TVs");
        dev_listModel.addElement("Blue Ray/DVD players");
        dev_listModel.addElement("Cameras");
        dev_listModel.addElement("Gaming Consoles");
        dev_listModel.addElement("Refrigerators");
        dev_listModel.addElement("Washing Machines");
        jdev_list = new JList(dev_listModel);
		jdevices.setLayout(new FlowLayout());
		JScrollPane listScroller1 = new JScrollPane(jdev_list);
		listScroller1.setPreferredSize(new Dimension(500, 250));
		jdevices.add(listScroller1);
		jdev_list.addMouseListener(listen1);
		//jdev_info
		dev_infoModel=new DefaultListModel();
		jdev_info = new JList(dev_infoModel);
		JScrollPane listScroller2 = new JScrollPane(jdev_info);
		listScroller2.setPreferredSize(new Dimension(500, 250));
		jdevices.add(listScroller2);
		jdev_info.addMouseListener(listen2);
		
		jsales = new JPanel();
		jorders = new JPanel();
		
		//jsales_list
			
		salesModel=new DefaultListModel();

		jsales_list = new JList(salesModel);
		
		jsales.setLayout(new FlowLayout());
		JScrollPane listScroller3 = new JScrollPane(jsales_list);
		listScroller3.setPreferredSize(new Dimension(500, 250));
		jsales.add(listScroller3);
		
		//jord_list
		ordModel=new DefaultListModel();
		jord_list = new JList(ordModel);
		
		jorders.setLayout(new FlowLayout());
		JScrollPane listScroller4 = new JScrollPane(jord_list);
		listScroller4.setPreferredSize(new Dimension(500, 250));
		jorders.add(listScroller4);
		

		//tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Devices", jdevices);
		tabs.addTab("Sales", jsales);
		tabs.addTab("Orders", jorders);
		add(tabs);
		ChangeListener changeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
			search.setEnabled(false);
			order_arrival.setEnabled(false);
            if (tabs.getSelectedIndex()==0 && jdev_info.getSelectedIndex()!=-1) {
				sale.setEnabled(true);

			}
            if (tabs.getSelectedIndex()==1) {
				sale.setEnabled(false);
				search.setEnabled(true);
				order_arrival.setEnabled(false);

			}
			if (tabs.getSelectedIndex()==2) {
				jord_list.setSelectedIndex(0);
				sale.setEnabled(false);
				if (jord_list.getSelectedIndex()!=-1)
					order_arrival.setEnabled(true);
				
				
				search.setEnabled(true);
			}
        }
        };
        tabs.addChangeListener(changeListener);
		add(tabs);

		
        //sale listener
        sale.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				sale1=new Sale();
				ord1=new Order();
				isSale=false;
				isOrder=false;
			    if (jdev_list.getSelectedIndex()==0) {
					discount1=Image_and_Sound.discount;
                    if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(0).getPrice();						
                        if (dev_list.Dev(0).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(0));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(0));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						
						price=dev_list.Dev(1).getPrice();
                        if (dev_list.Dev(1).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(1));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(1));
						    isOrder=true;
						}
					}	
				}
				else if (jdev_list.getSelectedIndex()==1) {
					discount1=Image_and_Sound.discount;
					if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(2).getPrice();						
                        if (dev_list.Dev(2).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(2));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(2));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						price=dev_list.Dev(3).getPrice();
                        if (dev_list.Dev(3).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(3));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(3));
						    isOrder=true;
						}
					}	
				}
                else if (jdev_list.getSelectedIndex()==2) {	
				    discount1=Image_and_Sound.discount;
                    if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(4).getPrice();						
                        if (dev_list.Dev(4).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(4));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(4));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						price=dev_list.Dev(5).getPrice();
                        if (dev_list.Dev(5).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(5));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(5));
						    isOrder=true;
						}
					}
                }
                else if (jdev_list.getSelectedIndex()==3) {	
				    discount1=Gaming.discount;
                    if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(6).getPrice();						
                        if (dev_list.Dev(6).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(6));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(6));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						price=dev_list.Dev(7).getPrice();
                        if (dev_list.Dev(7).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(7));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(7));
						    isOrder=true;
						}
					}
                }
                else if (jdev_list.getSelectedIndex()==4) {	
				    discount1=Household_Machine.discount;
                    if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(8).getPrice();						
                        if (dev_list.Dev(8).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(8));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(8));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						price=dev_list.Dev(9).getPrice();
                        if (dev_list.Dev(9).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(9));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(9));
						    isOrder=true;
						}
					}
                }
                else if (jdev_list.getSelectedIndex()==5) {	
				    discount1=Household_Machine.discount;
                    if (jdev_info.getSelectedIndex()==0) {
                        price=dev_list.Dev(10).getPrice();						
                        if (dev_list.Dev(10).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(10));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(10));
						    isOrder=true;
						}
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						price=dev_list.Dev(11).getPrice();
                        if (dev_list.Dev(11).getStock()!=0) {
							((Orders_and_Sales) sale1).setDevice(dev_list.Dev(11));
							isSale=true;
						}
						else {
							((Orders_and_Sales) ord1).setDevice(dev_list.Dev(11));
						    isOrder=true;
						}
					}
                }
                if (isSale) {		
      				
                    in1= JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);

					while ((in1!=null && in1.length() == 0))  {
						JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						in1 = JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);
						
					}
                    if (in1!=null) {
						((Orders_and_Sales) sale1).setCustomer(in1);
						in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);

					    while (in2!=null && in2.length() ==0) {
							JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						    in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);
						    
					    }
					}
					if (in1!=null && in2!=null) {
						((Orders_and_Sales) sale1).setPhone(in2);
						in3 = JOptionPane.showInputDialog(null, "Enter date of sale:", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);

						while (in3!=null && ((String) in3).length() == 0) {
							JOptionPane.showMessageDialog( null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
						    in3 = JOptionPane.showInputDialog(null, "Enter date of sale:", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);
						    
					    }
					}
                    if (in1!=null && in2!=null && in3!=null) {
						((Orders_and_Sales) sale1).setDate((String) in3);
						sale1.setCodeOfSale(sales.Entries()+1);
						((Orders_and_Sales) sale1).setFinal_Price(price-price*discount1);
						sale1.getDevice().setStock( sale1.getDevice().getStock()-1);
						strPrice="Final price: "+ sale1.getFinal_Price();
						JOptionPane.showMessageDialog(mainApp.this, strPrice);
						sales.storeSale(sale1);
						salesModel.addElement("Sale number: "+(sales.Entries())+", Model: "+sales.Dev(sales.Entries()-1).getDevice().getName()+", Customer: "+sales.Dev(sales.Entries()-1).getCustomer()
						+", Phone: "+sales.Dev(sales.Entries()-1).getPhone()+", Date: "+sales.Dev(sales.Entries()-1).getDate()+", Final price: "+sales.Dev(sales.Entries()-1).getFinal_Price());
					}					
                }
                if (isOrder) {		
      				int ans =JOptionPane.showConfirmDialog(null,"There is no available piece! Do you want to order it?", "Order", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
					if (ans== JOptionPane.YES_OPTION) {
                    in1= JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);

					while ((in1!=null && in1.length() == 0))  {
						JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						in1 = JOptionPane.showInputDialog(null, "Enter customer's name:", "Customer", JOptionPane.PLAIN_MESSAGE);
						
					}
                    if (in1!=null) {
						((Orders_and_Sales) ord1).setCustomer(in1);
						in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);

					    while (in2!=null && in2.length() ==0) {
							JOptionPane.showMessageDialog(null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE );
						    in2 = JOptionPane.showInputDialog(null, "Enter customer's phone:", "Phone", JOptionPane.PLAIN_MESSAGE);
						    
					    }
					}
					if (in1!=null && in2!=null) {
						((Orders_and_Sales) ord1).setPhone(in2);
						in3 = JOptionPane.showInputDialog(null, "Enter date of order:", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);

						while (in3!=null && ((String) in3).length() == 0) {
							JOptionPane.showMessageDialog( null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
						    in3 = JOptionPane.showInputDialog(null, "Enter date of order:", "Date", JOptionPane.PLAIN_MESSAGE, null, null, date);
						    
					    }
					}
					if (in1!=null && in2!=null && in3!=null) {
						((Orders_and_Sales) ord1).setDate((String) in3);
						in4 = JOptionPane.showInputDialog(null, "Enter date of arrival:", "Arrival date", JOptionPane.PLAIN_MESSAGE, null, null, date2);
						while (in4!=null && ((String) in4).length() == 0) {
							JOptionPane.showMessageDialog( null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
						    in4 = JOptionPane.showInputDialog(null, "Enter date of arrival:", "Arrival date", JOptionPane.PLAIN_MESSAGE, null, null, date2);
						    
					    }
					}
                    if (in1!=null && in2!=null && in3!=null && in4!=null) {
						ord1.setArrival_Date((String) in4);
						ord1.setCodeOfOrder(orders.Entries()+1);
						((Orders_and_Sales) ord1).setFinal_Price(price-price*discount1);
						ord1.setStatus(Order.awaiting);
						strPrice="Final price: "+ ord1.getFinal_Price();
						JOptionPane.showMessageDialog(mainApp.this, strPrice);
						orders.storeOrder(ord1);
						ordModel.addElement("Order number: "+orders.Entries()+", Model: "+orders.Dev(orders.Entries()-1).getDevice().getName()+", Customer: "+orders.Dev(orders.Entries()-1).getCustomer()
						+", Phone: "+orders.Dev(orders.Entries()-1).getPhone()+", Order date: "+orders.Dev(orders.Entries()-1).getDate()+"Date of arrival: "+orders.Dev(orders.Entries()-1).getArrival_Date()
						+", Status: "+orders.Dev(orders.Entries()-1).getStatus()
						+", Final price: "+orders.Dev(orders.Entries()-1).getFinal_Price());
						
					}
                    }					
                }				
			}
		}); 
		//order_arrival listener
        order_arrival.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
    			in4 = JOptionPane.showInputDialog(null, "Enter date of arrival:", "Arrival date", JOptionPane.PLAIN_MESSAGE, null, null, date);
				while (in4!=null && ((String) in4).length() == 0) {
					JOptionPane.showMessageDialog( null, "The text field can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
					in4 = JOptionPane.showInputDialog(null, "Enter date of arrival:", "Arrival date", JOptionPane.PLAIN_MESSAGE, null, null, date);
						    
				}
				if (in4!=null) {
					orders.Dev(jord_list.getSelectedIndex()).setArrival_Date((String) in4);
					orders.Dev(jord_list.getSelectedIndex()).setStatus(Order.completed);
					sale1=new Sale(sales.Entries()+1, orders.Dev(jord_list.getSelectedIndex()).getDevice(), orders.Dev(jord_list.getSelectedIndex()).getCustomer(), orders.Dev(jord_list.getSelectedIndex()).getPhone(),
					orders.Dev(jord_list.getSelectedIndex()).getArrival_Date(),
					orders.Dev(jord_list.getSelectedIndex()).getFinal_Price());
					sales.storeSale(sale1);
					salesModel.addElement("Sale number: "+sales.Entries()+", Model: "+sales.Dev(sales.Entries()-1).getDevice().getName()+", Customer: "+sales.Dev(sales.Entries()-1).getCustomer()
					+", Phone: "+sales.Dev(sales.Entries()-1).getPhone()+", Date: "+sales.Dev(sales.Entries()-1).getDate()+", Final price: "+sales.Dev(sales.Entries()-1).getFinal_Price());
				}
			}
		});
		//search listener
        search.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				found=false;
			    in=JOptionPane.showInputDialog(null, "Enter customer's name:", "Search", JOptionPane.PLAIN_MESSAGE);
                if (in!=null && in.length()>0){
					if (tabs.getSelectedIndex()==1) {
						
				        for (int i=0; i<sales.Entries(); i++) {
							if (in.equalsIgnoreCase(sales.Dev(i).getCustomer())) {
								jsales_list.setSelectedIndex(i);
								
								found=true;
							}
						}
						if (found) {
							JOptionPane.showMessageDialog(mainApp.this, "Sale was found and selected!");
						}
						else {
							JOptionPane.showMessageDialog(mainApp.this, "Sale not found!");
						}
					}
					else if (tabs.getSelectedIndex()==2) {
						
						for (int i=0; i<orders.Entries(); i++) {
							if (in.equalsIgnoreCase(orders.Dev(i).getCustomer())) {
								jord_list.setSelectedIndex(i);
								
								found=true;

							}
						}
						if (found) {
							JOptionPane.showMessageDialog(mainApp.this, "Order was found and selected!");
						}
						else {
							JOptionPane.showMessageDialog(mainApp.this, "Order not found!");
						}
					}
				}
            }
		});
		//menu listener
		j1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(mainApp.this, "Choose files to load (Devices.txt, Sales.txt, Orders.txt).");
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    file = fileChooser.getSelectedFile();
					if (file.getName().equals("Devices.txt")) {
					    dev_file.loadFile("Devices.txt");
						JOptionPane.showMessageDialog(mainApp.this, "Devices file loaded.");
						dev_list =dev_file.getDev_List();
						
				    }
					else if (file.getName().equals("Sales.txt")) {

					    sales_file.loadFile("Sales.txt");
						JOptionPane.showMessageDialog(mainApp.this, "Sales file loaded.");
						sales=sales_file.getSale_List();
					
						
                        for (int i=0; i<sales.Entries(); i++) {
			                salesModel.addElement("Sale number: "+sales.Dev(i).getCodeOfSale()+", Model: "+sales.Dev(i).getDevice().getName()+", Customer: "+sales.Dev(i).getCustomer()
			                +", Phone: "+sales.Dev(i).getPhone()+", Date: "+sales.Dev(i).getDate()+", Final price: "+sales.Dev(i).getFinal_Price());
                        }
						
					}
					else if (file.getName().equals("Orders.txt")) {

					    ord_file.loadFile("Orders.txt");
						JOptionPane.showMessageDialog(mainApp.this, "Orders file loaded.");
						orders=ord_file.getOrd_List();
						
						for (int i=0; i<orders.Entries(); i++) {
			                ordModel.addElement("Order number: "+orders.Dev(i).getCodeOfOrder()+", Model: "+orders.Dev(i).getDevice().getName()+", Customer: "+orders.Dev(i).getCustomer()
			                +", Phone: "+orders.Dev(i).getPhone()+", Orders date: "+orders.Dev(i).getDate()+"Date of arrival: "+orders.Dev(i).getArrival_Date()+"Staus: "+orders.Dev(i).getStatus()
							+", Final price: "+orders.Dev(i).getFinal_Price());
                        }
						jord_list.setSelectedIndex(0);
					}
					else 
					    JOptionPane.showMessageDialog(mainApp.this, "Invalid file!");	
					
				}
		            
			}
        });
        j2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(mainApp.this, "Choose files to save (Device.txt, Sales.txt, Orders.txt).");
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    file = fileChooser.getSelectedFile();
					if (file.getName().equals("Sales.txt")) {
					    write_sales.createFile("Sales.txt", sales);
						JOptionPane.showMessageDialog(mainApp.this, "Sales file saved.");
						
					}
					else if (file.getName().equals("Orders.txt")) {
					    write_orders.createFile("Orders.txt", orders);
						JOptionPane.showMessageDialog(mainApp.this, "Orders file saved.");
						
					}

					else 
					    JOptionPane.showMessageDialog(mainApp.this, "Choose a valid file!");	
					
				}
		            
			}
        });		

		
        pack();
		setVisible(true);
		
	}
	//jdev_list listener
    private class DevListListener implements MouseListener {
	public void mouseClicked(MouseEvent event) {
 			
		if (event.getClickCount() ==2) {
			sale.setEnabled(false);
		    if (jdev_list.getSelectedIndex() != -1) {
                dev_infoModel.removeAllElements();	
                if (jdev_list.getSelectedIndex()==0) {
                    for (int i=0; i<dev_list.Entries(); i++) {
			            if (dev_list.Dev(i) instanceof TV) {
				            dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
					    }
					}

				}
			

		        
				else if (jdev_list.getSelectedIndex()==1) {
					for (int i=0; i<dev_list.Entries(); i++) {
						if (dev_list.Dev(i) instanceof BlueRay_DVD_player) {
							dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
						}
					}
				}
				else if (jdev_list.getSelectedIndex()==2) {
					for (int i=0; i<dev_list.Entries(); i++) {
						if (dev_list.Dev(i) instanceof Camera) {
							dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
						}
					}
				}
				else if (jdev_list.getSelectedIndex()==3) {
					for (int i=0; i<dev_list.Entries(); i++) {
						if (dev_list.Dev(i) instanceof Gaming) {
							dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
						}
					}
				}
				else if (jdev_list.getSelectedIndex()==4) {
					for (int i=0; i<dev_list.Entries(); i++) {
						if (dev_list.Dev(i) instanceof Refrigerator) {
							dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
						}
					}
				}
				else if (jdev_list.getSelectedIndex()==5) {
					for (int i=0; i<dev_list.Entries(); i++) {
						if (dev_list.Dev(i) instanceof Washing_Machine) {
							dev_infoModel.addElement("Model: "+dev_list.Dev(i).getName()+", Constructor: "+dev_list.Dev(i).getConstructor()+", Price: "+dev_list.Dev(i).getPrice());
						}
					}
				}
		    }			
	    }
	
    }
	public void mouseExited(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
    public void mousePressed(MouseEvent event){}
    }


    //jdev_info listener
	private class DevInfoListener implements MouseListener {
	public void mouseClicked(MouseEvent event) {
		if (jdev_info.getSelectedIndex() != -1) 
			sale.setEnabled(true);
        if (event.getClickCount() ==2) {
		    if (jdev_info.getSelectedIndex() != -1) {
				if (jdev_list.getSelectedIndex()==0) {
                    if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon1 = new ImageIcon("Images/tv1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(0).toString(), dev_list.Dev(0).getName(), JOptionPane.INFORMATION_MESSAGE, icon1);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon2 = new ImageIcon("Images/tv2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(1).toString(), dev_list.Dev(1).getName(), JOptionPane.INFORMATION_MESSAGE, icon2);
					}	
				}
				else if (jdev_list.getSelectedIndex()==1) {
					if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon3 = new ImageIcon("Images/bd1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(2).toString(), dev_list.Dev(2).getName(), JOptionPane.INFORMATION_MESSAGE, icon3);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon4 = new ImageIcon("Images/bd2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(3).toString(), dev_list.Dev(3).getName(), JOptionPane.INFORMATION_MESSAGE, icon4);
					}	
				}
                else if (jdev_list.getSelectedIndex()==2) {	
                    if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon5 = new ImageIcon("Images/c1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(4).toString(), dev_list.Dev(4).getName(), JOptionPane.INFORMATION_MESSAGE, icon5);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon6 = new ImageIcon("Images/c2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(5).toString(), dev_list.Dev(5).getName(), JOptionPane.INFORMATION_MESSAGE, icon6);
					}
                }
                else if (jdev_list.getSelectedIndex()==3) {	
                    if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon7 = new ImageIcon("Images/g1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(6).toString(), dev_list.Dev(6).getName(), JOptionPane.INFORMATION_MESSAGE, icon7);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon8 = new ImageIcon("Images/g2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(7).toString(), dev_list.Dev(7).getName(), JOptionPane.INFORMATION_MESSAGE, icon8);
					}
                }
                else if (jdev_list.getSelectedIndex()==4) {	
                    if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon9 = new ImageIcon("Images/r1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(8).toString(), dev_list.Dev(8).getName(), JOptionPane.INFORMATION_MESSAGE, icon9);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon10 = new ImageIcon("Images/r2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(9).toString(), dev_list.Dev(9).getName(), JOptionPane.INFORMATION_MESSAGE, icon10);
					}
                }
                else if (jdev_list.getSelectedIndex()==5) {	
                    if (jdev_info.getSelectedIndex()==0) {				
                        ImageIcon icon11 = new ImageIcon("Images/w1.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(10).toString(), dev_list.Dev(10).getName(), JOptionPane.INFORMATION_MESSAGE, icon11);
			        }
					else if (jdev_info.getSelectedIndex()==1) {
						ImageIcon icon12 = new ImageIcon("Images/w2.jpg");
					    JOptionPane.showMessageDialog(mainApp.this, dev_list.Dev(11).toString(), dev_list.Dev(11).getName(), JOptionPane.INFORMATION_MESSAGE, icon12);
					}
                }				
			}
		}
	}
    public void mouseExited(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
    public void mousePressed(MouseEvent event){}
	}

	
	public static void main(String[] args) {
        new mainApp(); 
    }
}







