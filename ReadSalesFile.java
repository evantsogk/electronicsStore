import java.io.*; 
import java.util.*;

public class ReadSalesFile {
	private Sales_List sale_list= new Sales_List();
	public void loadFile(String data) {
		File f = null;
        BufferedReader reader = null;
        TV item1 = new TV();
		BlueRay_DVD_player item2 = new BlueRay_DVD_player();
		Camera item3 = new Camera();
		Gaming item4 = new Gaming();
		Refrigerator item5 = new Refrigerator();
		Washing_Machine item6 = new Washing_Machine();
		Sale sale=new Sale();
		boolean f1=false;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		boolean f5=false;
		boolean f6=false;
        String line;
		
        try {
            f = new File(data);
        } 
	    catch (NullPointerException e) { 
	        System.err.println("File not found.");
        }    

        try {
            reader = new BufferedReader(new FileReader(f));
        } 
	    catch (FileNotFoundException e) { 
	        System.err.println("Error opening file!");
        }
        try {
			line = reader.readLine();
			if (line!=null) {
                if (line.trim().equalsIgnoreCase("SALES_LIST")) {
				    line = reader.readLine();

                    if (line != null) {
                        if (line.trim().equals("{")) { 
						    line = reader.readLine();

						    while (line != null && !line.startsWith("}")) {
				              

                                
                                    if (line.trim().toUpperCase().startsWith("SALE")) {
                                        line = reader.readLine();
                                    
                                        if (line !=null) {
										    if (line.trim().equals("{")) {
											    reader.mark(100000);
                                                while(true) { //NAME
												    line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("NAME")) {
															((Device) item1).setName(line.trim().substring(5).trim());
															((Device) item2).setName(line.trim().substring(5).trim());
															((Device) item3).setName(line.trim().substring(5).trim());
															((Device) item4).setName(line.trim().substring(5).trim());
															((Device) item5).setName(line.trim().substring(5).trim());
															((Device) item6).setName(line.trim().substring(5).trim());
															break;
														}
													}
												}
												reader.reset();
													
												while (true) { //CODE
												    line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("CODE")) { 
															((Device) item1).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item2).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item3).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item4).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item5).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item6).setCode(Integer.parseInt(line.trim().substring(5).trim()));
															break;
														}
													}
												}
											    reader.reset();
												while (true) { //YEAR
													line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("YEAR")) {
															((Device) item1).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item2).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item3).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item4).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item5).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															((Device) item6).setYear(Integer.parseInt(line.trim().substring(5).trim()));
															break;
														}
					                                }
												}
												reader.reset();
												while (true) { //CONSTRUCTOR
													line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
															((Device) item1).setConstructor(line.trim().substring(12).trim());
															((Device) item2).setConstructor(line.trim().substring(12).trim());
															((Device) item3).setConstructor(line.trim().substring(12).trim());
															((Device) item4).setConstructor(line.trim().substring(12).trim());
															((Device) item5).setConstructor(line.trim().substring(12).trim());
															((Device) item6).setConstructor(line.trim().substring(12).trim());
															break;
														}
                                                    }
												}
												
												reader.reset();
												while (true) { //PRICE
													line = reader.readLine();
													if (line!=null) {
													    if (line.trim().toUpperCase().startsWith("PRICE")) {
															((Device) item1).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															((Device) item2).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															((Device) item3).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															((Device) item4).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															((Device) item5).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															((Device) item6).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
															break;
														}
	                                                }
												}
												reader.reset();
												while (true) { //STOCK
												    line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("STOCK")) {
															((Device) item1).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															((Device) item2).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															((Device) item3).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															((Device) item4).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															((Device) item5).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															((Device) item6).setStock(Integer.parseInt(line.trim().substring(6).trim()));
															break;
														}
			                                        }
												}
												reader.reset();
												while (true) { //SALE_NUMBER
												    line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("SALE_NUMBER")) {
															sale.setCodeOfSale(Integer.parseInt(line.trim().substring(12).trim()));
															break;
														}
			                                        }
												}
												reader.reset();
												while (true) { //CUSTOMER
													line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("CUSTOMER")) {
															((Orders_and_Sales) sale).setCustomer(line.trim().substring(9).trim());
															break;
														}
                                                    }
												}
												reader.reset();
												while (true) { //PHONE
													line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("PHONE")) {
															((Orders_and_Sales) sale).setPhone(line.trim().substring(6).trim());
															break;
														}
                                                    }
												}
												reader.reset();
												while (true) { //DATE
													line = reader.readLine();
													if (line!=null) {
														if (line.trim().toUpperCase().startsWith("DATE")) {
															((Orders_and_Sales) sale).setDate(line.trim().substring(5).trim());
															break;
														}
                                                    }
												}
												reader.reset();
												while (true) { //FINAL_PRICE
													line = reader.readLine();
													if (line!=null) {
													    if (line.trim().toUpperCase().startsWith("FINAL_PRICE")) {
															((Orders_and_Sales) sale).setFinal_Price(Double.parseDouble(line.trim().substring(12).trim()));
															break;
														}
	                                                }
												}
												reader.reset();
											    while (true) {
												    line = reader.readLine();
												    if (line.trim().toUpperCase().startsWith("ITEM_TYPE")) {
													    if (line.trim().substring(10).trim().equalsIgnoreCase("tv")) {
														    f1=true;
															reader.reset();
															while (true) { //TYPE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("TYPE")) {
																		((Image_and_Sound) item1).setType(line.trim().substring(5).trim());
																		break;
																	}
                                                                }
															}
															reader.reset();
															while (true) { //SCREEN
																line = reader.readLine();
																if (line!=null) {
																    if (line.trim().toUpperCase().startsWith("SCREEN")) {
																		item1.setScreen(Integer.parseInt(line.trim().substring(7).trim()));
																		break;
																	}
                                                                }
															}
															reader.reset();
															while (true) { //RESOLUTION
												                line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("RESOLUTION")) {
																		item1.setResolution(line.trim().substring(11).trim());
																		break;
																	}
                                                                }
															}	
															reader.reset();
															while (true) { //PORTS
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("PORTS")) {
																		item1.setPorts(line.trim().substring(6).trim());
																		break;
																	}
                                                                }
															}
														
													    } //tv
												        else if (line.trim().substring(10).trim().equalsIgnoreCase("BlueRay_DVD_player")) {
															f2=true;
															reader.reset();
															while (true) { //TYPE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("TYPE")) {
																		((Image_and_Sound) item2).setType(line.trim().substring(5).trim());
																		break;
																	}
			                                                    }
															}					

															reader.reset();
															while (true) { //RESOLUTION
															    line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("RESOLUTION")) {
																		item2.setResolution(line.trim().substring(11).trim());
																		break;
																	}
	                                                            }
															}
															reader.reset();
															while (true) { //FORMAT
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("FORMAT")) {
																		item2.setFormat(line.trim().substring(7).trim());
																		break;
																	}
	                                                            }
                                                            }
														}// BlueRay_DVD_player
														else if (line.trim().substring(10).trim().equalsIgnoreCase("CAMERA")) {
														    f3=true;
														    reader.reset();
															while (true) { //TYPE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("TYPE")) {
																		((Image_and_Sound) item3).setType(line.trim().substring(5).trim());
																		break;
																	}
	                                                            }
															}
															reader.reset();
															while (true) { //MEGAPIXEL
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("MEGAPIXEL")) {
																		item3.setMegapixel(Double.parseDouble(line.trim().substring(10).trim()));
																		break;
																	}
                                                                }
															}	
															reader.reset();
															while (true) { //SCREEN_SIZE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("SCREEN_SIZE")) {
																		item3.setScreen_Size(Double.parseDouble(line.trim().substring(12).trim()));
																		break;
																	}
                                                                }
															}
															reader.reset();
														    while (true) { //OPTICAL_ZOOM
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("OPTICAL_ZOOM")) {
																		item3.setOptical_Zoom(line.trim().substring(13).trim());
																		break;
																	}
		                                                        }
															}
															reader.reset();
															while (true) { //DIGITAL_ZOOM
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("DIGITAL_ZOOM")) {
																		item3.setDigital_Zoom(line.trim().substring(13).trim());
																		break;
																	}
		                                                        }
															}					
																				
														}// Camera
														else if (line.trim().substring(10).trim().equalsIgnoreCase("GAMING")) {
															f4=true;												
														    reader.reset();
															while (true) { //TYPE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("TYPE")) {
																		item4.setType(line.trim().substring(5).trim());
																		break;
																	}
                                                                }
															}
															reader.reset();
															while (true) { //GRAPHICS
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("GRAPHICS")) {
																		item4.setGraphics(line.trim().substring(9).trim());
																		break;
																	}
																}							
		                                                    }
															reader.reset();
															while (true) { //PROCCESOR
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("PROCCESOR")) {
																		item4.setProccesor(line.trim().substring(10).trim());
																		break;
																	}
			                                                    }
															}
															reader.reset();
															while (true) { //SOUND
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("SOUND")) {
																		item4.setSound(line.trim().substring(6).trim());
																		break;
																	}
		                                                        }
															}
															reader.reset();
															while (true) { //HARD_DISC
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("HARD_DISC")) {
																		item4.setHard_Disc(line.trim().substring(10).trim());
																		break;
																	}
                                                                }
															}

														}// Gaming
														else if (line.trim().substring(10).trim().equalsIgnoreCase("REFRIGERATOR")) {
															f5=true;
															reader.reset();
															while (true) { //TYPE
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("TYPE")) {
																		item5.setType(line.trim().substring(5).trim());
																		break;
																	}
	                                                            }
															}
														    reader.reset();
															while (true) { //ENERGY_RATING
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("ENERGY_RATING")) {
																		((Household_Machine) item5).setEnergy_Rating(line.trim().substring(14).trim());
																		break;
																	}
																}
															}
															reader.reset();
															while (true) { //COOLER_CAPACITY
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("COOLER_CAPACITY")) {
																		item5.setCooler_Capacity(line.trim().substring(16).trim());
																		break;
																	}
                                                                }
															}
															reader.reset();
															while (true) { //FREEZER_CAPACITY
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("FREEZER_CAPACITY")) {
																		item5.setFreezer_Capacity(line.trim().substring(17).trim());
																		break;
																	}
		                                                        }
															}						

														}// Refrigerator
														else if (line.trim().substring(10).trim().equalsIgnoreCase("WASHING_MACHINE")) {
															reader.reset();																					
															f6=true;					    
															while (true) { //ENERGY_RATING
																line = reader.readLine();
																if (line!=null) {
														     		if (line.trim().toUpperCase().startsWith("ENERGY_RATING")) {
																		((Household_Machine) item6).setEnergy_Rating(line.trim().substring(14).trim());
																		break;
																	}
                                                                }
															}
															reader.reset();
															while (true) { //CAPACITY
															    line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CAPACITY")) {
																		item6.setCapacity(line.trim().substring(9).trim());
																		break;
																	}
	                                                            }
															}
															reader.reset();
															while (true) { //SPINS
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("SPINS")) {
																		item6.setSpins(line.trim().substring(6).trim());
																		break;
																	}
                                                                }
                                                            }      
														}// Washing_Machine
                                                        break;
												    }
												}
												if (f1)
												    sale.setDevice(item1);
												else if (f2)
												    sale.setDevice(item2);
												else if (f3)
													sale.setDevice(item3);
												else if (f4)
													sale.setDevice(item4);
												else if (f5)
													sale.setDevice(item5);
												else if (f6) 
													sale.setDevice(item6);
												
												
												
												line=reader.readLine();
												while (line !=null && !line.trim().startsWith("}")) {
													line=reader.readLine();
												}
												sale_list.storeSale(sale);
													
												f1=false;
		                                        f2=false;
		                                        f3=false;
		                                        f4=false;
		                                        f5=false;
		                                        f6=false;
												item1 = new TV();
		                                        item2 = new BlueRay_DVD_player();
		                                        item3 = new Camera();
		                                        item4 = new Gaming();
		                                        item5 = new Refrigerator();
		                                        item6 = new Washing_Machine();
		                                        sale=new Sale();
											    

													
										    }
									    }
                                    }										
                                    line=reader.readLine();   
                                
                            }
                        }
                    }
                }
			    
            }

        }
        catch (IOException e) {
            System.out.println("Error reading line.");
		}		
	    try {
			reader.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
	public Sales_List getSale_List() {
		return sale_list;
	}
}





