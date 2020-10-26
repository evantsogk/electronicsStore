import java.io.*; 
import java.util.*;

public class ReadDevicesFile {
	private static final int n=0;
	private static final double d=0.0;
	private static final String str=" ";

    private Device_List dev_list= new Device_List();

    
    public void loadFile(String data) {
        int counter = 1;

        File f = null;
        BufferedReader reader = null; 
	    TV item1 = null;
		BlueRay_DVD_player item2 = null;
		Camera item3 = null;
		Gaming item4 = null;
		Refrigerator item5 = null;
		Washing_Machine item6 = null;
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
			if (!line.trim().equals(" ")) {
                if (line.trim().equalsIgnoreCase("ITEM_LIST")) {
				    line = reader.readLine();

                    if (line != null) {
                        if (line.trim().equals("{")) { 
						    line = reader.readLine();

						    while (line != null && !line.startsWith("}")) {
				              

                                
                                    if (line.trim().toUpperCase().startsWith("ITEM")) {
                                        line = reader.readLine();
                                    
                                        if (line !=null) {
										    if (line.trim().equals("{")) {
											    reader.mark(100000);

											    while (true) {
												    line = reader.readLine();
												    if (line.trim().toUpperCase().startsWith("ITEM_TYPE")) {
													    if (line.trim().substring(10).trim().equalsIgnoreCase("tv")) {
														   item1=new TV();
														   
														    reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item1).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item1).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item1).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item1).setYear(n);
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
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item1).setConstructor(str);
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
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item1).setPrice(d);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //TYPE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("TYPE")) {
																								((Image_and_Sound) item1).setType(line.trim().substring(5).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Image_and_Sound) item1).setType(str);
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
																							if (line.trim().startsWith("}")) {
																								item1.setScreen(n);
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
																							if (line.trim().startsWith("}")) {
																								item1.setResolution(str);
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
																							if (line.trim().startsWith("}")) {
																								item1.setPorts(str);
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
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item1).setStock(n);
																							    break;
																							}
																					    }	
																					}
																				    line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) { 
																							dev_list.storeDevice(item1);
																						    break;
																						}
												                                    }
                                                                                    break;
																				
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														
													    } //tv
												        else if (line.trim().substring(10).trim().equalsIgnoreCase("BlueRay_DVD_player")) {
															item2=new BlueRay_DVD_player();
														    reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item2).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item2).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item2).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item2).setYear(n);
																							    break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //CONSTRUCTOR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
																								((Device) item2).setConstructor(line.trim().substring(12).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item2).setConstructor(str);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //PRICE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("PRICE")) {
																								((Device) item2).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item2).setPrice(d);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //TYPE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("TYPE")) {
																								((Image_and_Sound) item2).setType(line.trim().substring(5).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Image_and_Sound) item2).setType(str);
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
																							if (line.trim().startsWith("}")) {
																								item2.setResolution(str);
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
																							if (line.trim().startsWith("}")) {
																								item2.setFormat(str);
																								break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //STOCK
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("STOCK")) {
																								((Device) item2).setStock(Integer.parseInt(line.trim().substring(6).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item2).setStock(n);
																							    break;
																							}
																					    }	
																					}
																					line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) 
																							dev_list.storeDevice(item2);
																						    break;
												                                    }
																					break;
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														}// BlueRay_DVD_player
														else if (line.trim().substring(10).trim().equalsIgnoreCase("CAMERA")) {
															item3= new Camera();
															reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item3).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item3).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item3).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item3).setYear(n);
																							    break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //CONSTRUCTOR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
																								((Device) item3).setConstructor(line.trim().substring(12).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item3).setConstructor(str);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //PRICE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("PRICE")) {
																								((Device) item3).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item3).setPrice(d);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //TYPE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("TYPE")) {
																								((Image_and_Sound) item3).setType(line.trim().substring(5).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Image_and_Sound) item3).setType(str);
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
																							if (line.trim().startsWith("}")) {
																								item3.setMegapixel(d);
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
																							if (line.trim().startsWith("}")) {
																								item3.setScreen_Size(d);
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
																							if (line.trim().startsWith("}")) {
																								item3.setOptical_Zoom(str);
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
																							if (line.trim().startsWith("}")) {
																								item3.setDigital_Zoom(str);
																								break;
																							}
																						}	
																					}
																					
																					reader.reset();
																					while (true) { //STOCK
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("STOCK")) {
																								((Device) item3).setStock(Integer.parseInt(line.trim().substring(6).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item3).setStock(n);
																							    break;
																							}
																					    }	
																					}
																					line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) 
																							dev_list.storeDevice(item3);
																						    break;
												                                    }
																					break;
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														}// Camera
														else if (line.trim().substring(10).trim().equalsIgnoreCase("GAMING")) {
															item4= new Gaming();
															reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item4).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item4).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item4).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item4).setYear(n);
																							    break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //CONSTRUCTOR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
																								((Device) item4).setConstructor(line.trim().substring(12).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item4).setConstructor(str);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //PRICE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("PRICE")) {
																								((Device) item4).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item4).setPrice(d);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //TYPE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("TYPE")) {
																								item4.setType(line.trim().substring(5).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								item4.setType(str);
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
																							if (line.trim().startsWith("}")) {
																								item4.setGraphics(str);
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
																							if (line.trim().startsWith("}")) {
																								item4.setProccesor(str);
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
																							if (line.trim().startsWith("}")) {
																								item4.setSound(str);
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
																							if (line.trim().startsWith("}")) {
																								item4.setHard_Disc(str);
																								break;
																							}
																						}	
																					}
																					
																					reader.reset();
																					while (true) { //STOCK
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("STOCK")) {
																								((Device) item4).setStock(Integer.parseInt(line.trim().substring(6).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item4).setStock(n);
																							    break;
																							}
																					    }	
																					}
																					line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) 
																							dev_list.storeDevice(item4);
																						    break;
												                                    }
																					break;
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														}// Gaming
														else if (line.trim().substring(10).trim().equalsIgnoreCase("REFRIGERATOR")) {
															item5= new Refrigerator();
															reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item5).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item5).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item5).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item5).setYear(n);
																							    break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //CONSTRUCTOR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
																								((Device) item5).setConstructor(line.trim().substring(12).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item5).setConstructor(str);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //PRICE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("PRICE")) {
																								((Device) item5).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item5).setPrice(d);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //TYPE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("TYPE")) {
																								item5.setType(line.trim().substring(5).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								item5.setType(str);
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
																							if (line.trim().startsWith("}")) {
																								((Household_Machine) item5).setEnergy_Rating(str);
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
																							if (line.trim().startsWith("}")) {
																								item5.setCooler_Capacity(str);
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
																							if (line.trim().startsWith("}")) {
																								item5.setFreezer_Capacity(str);
																								break;
																							}
																						}	
																					}
																					
																					reader.reset();
																					while (true) { //STOCK
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("STOCK")) {
																								((Device) item5).setStock(Integer.parseInt(line.trim().substring(6).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item5).setStock(n);
																							    break;
																							}
																					    }	
																					}
																					line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) 
																							dev_list.storeDevice(item5);
																						    break;
												                                    }
																					break;
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														}// Refrigerator
															else if (line.trim().substring(10).trim().equalsIgnoreCase("WASHING_MACHINE")) {
															item6= new Washing_Machine();
															reader.reset();
														    while (true) {
																line = reader.readLine();
																if (line!=null) {
																	if (line.trim().toUpperCase().startsWith("CODE")) { 
																		((Device) item6).setCode(Integer.parseInt(line.trim().substring(5).trim()));
																	    reader.reset();
																		while(true) {
																			line = reader.readLine();
																			if (line!=null) {
																				if (line.trim().toUpperCase().startsWith("NAME")) {
																					((Device) item6).setName(line.trim().substring(5).trim());
																					reader.reset();
																					while (true) { //YEAR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("YEAR")) {
																								((Device) item6).setYear(Integer.parseInt(line.trim().substring(5).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item6).setYear(n);
																							    break;
																							}
																						}
																					}
																					reader.reset();
																					while (true) { //CONSTRUCTOR
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("CONSTRUCTOR")) {
																								((Device) item6).setConstructor(line.trim().substring(12).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item6).setConstructor(str);
																								break;
																							}
																						}	
																					}
																					reader.reset();
																					while (true) { //PRICE
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("PRICE")) {
																								((Device) item6).setPrice(Double.parseDouble(line.trim().substring(6).trim()));
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item6).setPrice(d);
																								break;
																							}
																						}	
																					}

																					


																				    reader.reset();
																					while (true) { //ENERGY_RATING
																						line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("ENERGY_RATING")) {
																								((Household_Machine) item6).setEnergy_Rating(line.trim().substring(14).trim());
																								break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Household_Machine) item6).setEnergy_Rating(str);
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
																							if (line.trim().startsWith("}")) {
																								item6.setCapacity(str);
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
																							if (line.trim().startsWith("}")) {
																								item6.setSpins(str);
																								break;
																							}
																						}	
																					}
																					
																					reader.reset();
																					while (true) { //STOCK
																					    line = reader.readLine();
																						if (line!=null) {
																							if (line.trim().toUpperCase().startsWith("STOCK")) {
																								((Device) item6).setStock(Integer.parseInt(line.trim().substring(6).trim()));
																							    break;
																							}
																							if (line.trim().startsWith("}")) {
																								((Device) item6).setStock(n);
																							    break;
																							}
																					    }	
																					}
																					line = reader.readLine();
                                                                                    if (line != null) {
                                                                                        if (line.trim().equals("}")) 
																							dev_list.storeDevice(item6);
																						    break;
												                                    }
																					break;
																				}
																			    if (line.trim().startsWith("}")) {
																					System.out.println("Name of device unknown! It will not be taken into account!");
																					
																					break;
																				}
																			}
																		}
																		break;
																	}
																    if (line.trim().startsWith("}")) {
																		System.out.println("Code of device unknown! It will not be taken into account!");
																		
																		break;
																	}
																		
																	
																}
															}
														}// Washing_Machine
														else {
															System.out.println("Invalid type!");
														    line = reader.readLine();
														    while (!line.trim().startsWith("}")) {
																line = reader.readLine();
															}
															break;
														}
														break;
												    }
													if (line.trim().startsWith("}")) {
													    System.out.println("Type of device unknown! It will not be taken into account!");
														
														break;
													}
												
											    }

													
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
            System.out.println("Error reading line"+counter+".");
		}
		
		try {
			reader.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}

    public Device_List getDev_List() {
		return dev_list;
	}

}
	
