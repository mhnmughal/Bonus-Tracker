package program.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import program.model.User;

import program.model.*;

public class Controller {
	private List<SalesData> salesData = new ArrayList<>();
    private List<BonusCampaign> bonusCampaign = new ArrayList<>();
    private List<BonusTracker> tracker =new ArrayList<>();
    private List<User> user=new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


  
    
    
    public List<BonusTracker> generateBonusTrackerList(List<SalesData> salesData, List<BonusCampaign> bonusCampaign) {
        List<BonusTracker> bonusTrackerList = new ArrayList<>();
        
        for (SalesData sale : salesData ) {
        	
            BonusTracker bonusTracker = new BonusTracker();
            bonusTracker.setPRODUCT_NAME(sale.getPRODUCT_NAME());
            bonusTracker.setBARCODE(sale.getBARCODE());
            bonusTracker.setPHARMACY_GLN_NUMBER(sale.getPHARMACY_GLN_NUMBER());
            bonusTracker.setPHARMACY_NAME(sale.getPHARMACY_NAME());
            bonusTracker.setDATE(sale.getDATE());
            bonusTracker.setORDER_NO(sale.getORDER_NO());
            bonusTracker.setTOWN(sale.getTOWN());
            bonusTracker.setPROVINCE(sale.getPROVINCE());
            bonusTracker.setQUANTITY(sale.getQUANTITY());
            bonusTracker.setBONUS(sale.getBONUS());
            bonusTracker.setPRICE(sale.getPRICE());
            bonusTracker.setWAREHOUSE(sale.getWAREHOUSE());
            bonusTracker.setManualApprove(" ");
 
            for (BonusCampaign campaign : bonusCampaign) {
            	if (sale.getPRODUCT_NAME().equals(campaign.getPRODUCT_1_NAME()) && 
                        sale.getBARCODE().equals(campaign.getPRODUCT_1_BARCODE()) ) {
                        int product1MF = Integer.parseInt(campaign.getPRODUCT_1_MF());
                        int bonus = Integer.parseInt(sale.getBONUS());
                        int autoApproved = bonus - product1MF;
                        bonusTracker.setAUTO_APPROVED(String.valueOf(product1MF)); // Set AUTO_APPROVED to PRODUCT_1_MF
                        if (autoApproved > 0) {
                            bonusTracker.setAUTO_CUT(String.valueOf(autoApproved));
                            bonusTracker.setHIGHLIGHT("!");
                            bonusTracker.setNote("Max MF Value is " + product1MF + " and bonus value is " + bonus + "(!)");
                        } else if (autoApproved < 0) {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Bonus is Zero");
                        } else {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Max MF Value is " + product1MF + " and bonus value is " + bonus);
                        }
                        break; // Exit the loop once AUTO_APPROVED is set
                    }
            	else if (sale.getPRODUCT_NAME().equals(campaign.getPRODUCT_2_NAME()) && 
                        sale.getBARCODE().equals(campaign.getPRODUCT_2_BARCODE()) ) {
                        int product2MF = Integer.parseInt(campaign.getPRODUCT_2_MF());
                        int bonus = Integer.parseInt(sale.getBONUS());
                        int autoApproved = bonus - product2MF;
                        bonusTracker.setAUTO_APPROVED(String.valueOf(product2MF)); // Set AUTO_APPROVED to PRODUCT_1_MF
                        if (autoApproved > 0) {
                            bonusTracker.setAUTO_CUT(String.valueOf(autoApproved));
                            bonusTracker.setHIGHLIGHT("!");
                            bonusTracker.setNote("Max MF Value is " + product2MF + " and bonus value is " + bonus + "(!)");
                        } else if (autoApproved < 0) {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Bonus is Zero");
                        } else {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Max MF Value is " + product2MF + " and bonus value is " + bonus);
                        }
                        break; // Exit the loop once AUTO_APPROVED is set
                    }
            	else if (sale.getPRODUCT_NAME().equals(campaign.getPRODUCT_3_NAME()) && 
                        sale.getBARCODE().equals(campaign.getPRODUCT_3_BARCODE()) ) {
                        int product3MF = Integer.parseInt(campaign.getPRODUCT_3_MF());
                        int bonus = Integer.parseInt(sale.getBONUS());
                        int autoApproved = bonus - product3MF;
                        bonusTracker.setAUTO_APPROVED(String.valueOf(product3MF)); // Set AUTO_APPROVED to PRODUCT_1_MF
                        if (autoApproved > 0) {
                            bonusTracker.setAUTO_CUT(String.valueOf(autoApproved));
                            bonusTracker.setHIGHLIGHT("!");
                            bonusTracker.setNote("Max MF Value is " + product3MF + " and bonus value is " + bonus + "(!)");
                        } else if (autoApproved < 0) {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Bonus is Zero");
                        } else {
                            bonusTracker.setAUTO_CUT(" ");
                            bonusTracker.setHIGHLIGHT(" ");
                            bonusTracker.setNote("Max MF Value is " + product3MF + " and bonus value is " + bonus);
                        }
                        break; // Exit the loop once AUTO_APPROVED is set
                    }
            	else
            	{
            		bonusTracker.setAUTO_CUT(" ");
            		bonusTracker.setAUTO_APPROVED(" ");
            		bonusTracker.setHIGHLIGHT("!!");
            		bonusTracker.setNote(" (!!) (two exclamation marks) added to HIGHLIGHT field; as there's no campaign for this *price* for product A");
            	}
            	
            }

            bonusTrackerList.add(bonusTracker);
        }

        return bonusTrackerList;
    }
    // Functionality to get customer data
    public List<User> getUser() {
        return user;
    }
    public List<SalesData> getSalesData() {
		return salesData;
	}

	public List<BonusCampaign> getBonusCampaign() { 
		return bonusCampaign;
	}
	
	public List<BonusTracker> getBonusTracker() {
		return tracker;
	}
	 public void getSalesDetails(String FilePath) 
	    {
	    	
		 readSalesFromFile(FilePath);  
	    }
	 public void getbonusDetail(String FilePath)
	 {
		 readBonusFromFile(FilePath);
	 }
	 public void getUserDetails() 
	    {
	        readUserFromFile("user.csv");
	    }
	 public void addUser(int id,String name,String username,String password) {
	     User u=new User();
	     u.setId(id);
	     u.setName(name);
	     u.setUsername(username);
	     u.setPassword(password);
	     user.add(u);
	     writeUserToFile("user.csv");
	    }
	 
	 private void writeUserToFile(String filePath)
	   {
		   FileWriter fileWriter=null;
	       try  {
	    	   fileWriter = new FileWriter(filePath, true); // append mode set to true

	           File file = new File(filePath);

	           if (file.length() == 0) {
	               // If the file is empty, write the header
	               fileWriter.append("Id, Username, Password\n");
	           }
	           for (User u : user) {
	        	   fileWriter.append(String.valueOf(u.getId())).append(",");
	               fileWriter.append(u.getUsername()).append(",");
	               fileWriter.append(u.getPassword());
	               
	               fileWriter.append("\n");
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       finally
	       {
	       	closeWriter(fileWriter);
	       }
	   }
	 private void readUserFromFile(String filePath)
	   {
		   user.clear();
	       BufferedReader reader = null;
	       try {
	           reader = new BufferedReader(new FileReader(filePath));
	           // Skip the header line
	           reader.readLine();
	           
	           String line;
	           while ((line = reader.readLine()) != null) {
	               String[] fields = line.split(",");
	               if (fields.length > 0) {
	                   User u=new User();
	                  u.setId(Integer.parseInt(fields[0]));
	                  u.setUsername(fields[1]);
	                  u.setPassword(fields[2]);
	                   user.add(u);
	               }
	           }
	       } catch (IOException | NumberFormatException e) {
	           e.printStackTrace();
	       } finally {
	           try {
	               if (reader != null) {
	                   reader.close();
	               }
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	       }
	   }
	  
	   private void readSalesFromFile(String filePath) {
		   salesData.clear();
		    BufferedReader reader = null;
		    try {
		        reader = new BufferedReader(new FileReader(filePath));
		        // Skip the header line
		        reader.readLine();
		        
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] fields = line.split(",");
		            if (fields.length > 0) {
		                SalesData sales = new SalesData();
		              sales.setPRODUCT_NAME(fields[0]);
		              sales.setBARCODE(fields[1]);
		              sales.setPHARMACY_GLN_NUMBER(fields[2]);
		              sales.setPHARMACY_NAME(fields[3]);
		              
						sales.setDATE(fields[4]);
					
						
						
		              sales.setORDER_NO(fields[5]);
		              sales.setTOWN(fields[6]);
		              sales.setPROVINCE(fields[7]);
		              sales.setQUANTITY(fields[8]);
		              sales.setBONUS(fields[9]);
		              sales.setPRICE(fields[10]);
		              sales.setWAREHOUSE(fields[11]);
		                
		              salesData.add(sales);
		            }
		        }
		    } catch (IOException | NumberFormatException e) {
		        e.printStackTrace();
		    } finally 
		    {
		    	closeReader(reader);
		    }
		    
		    System.out.println("Inside Sale reader");
		}
	
	   private void readBonusFromFile(String filePath) {
		   bonusCampaign.clear();
		    BufferedReader reader = null;
		    try {
		        reader = new BufferedReader(new FileReader(filePath));
		        // Skip the header line
		        reader.readLine();
		        
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] fields = line.split(",");
		            if (fields.length > 0) {
		            	BonusCampaign bonus = new BonusCampaign();
		              bonus.setPRODUCT_1_NAME(fields[0]);
		              bonus.setPRODUCT_1_BARCODE(fields[1]);
		              bonus.setPRODUCT_1_MINIMUM_QUANTITY(fields[2]);
		              bonus.setPRODUCT_1_MF(fields[3]);
		              bonus.setPRODUCT_1_PRICE(fields[4]);
		              bonus.setPRODUCT_2_NAME(fields[5]);
		              bonus.setPRODUCT_2_BARCODE(fields[6]);
		              bonus.setPRODUCT_2_MINIMUM_QUANTITY(fields[7]);
		              bonus.setPRODUCT_2_MF(fields[8]);
		              bonus.setPRODUCT_2_PRICE(fields[9]);
		              bonus.setPRODUCT_3_NAME(fields[10]);
		              bonus.setPRODUCT_3_BARCODE(fields[11]);
		              bonus.setPRODUCT_3_MINIMUM_QUANTITY(fields[12]);
		              bonus.setPRODUCT_3_MF(fields[13]);
		              bonus.setPRODUCT_3_PRICE(fields[14]);
		             
						bonus.setValidFrom(fields[15]);
						bonus.setValidFrom(fields[16]);
					
		              
		              
		              bonusCampaign.add(bonus);
		            }
		        }
		    } catch (IOException | NumberFormatException e) {
		        e.printStackTrace();
		    } finally 
		    {
		    	closeReader(reader);
		    }
		System.out.println("Inside bonus reader");
	   }
	
	   public void writeBonusTrackerCSVFile(String filePath, List<BonusTracker> bonusTrackerList) {
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(filePath);
	            fileWriter.append("ProductName,Barcode,PharmacyGLNNumber,PharmacyName,Date,OrderNo,Town,Province,Quantity,Bonus,Price,Warehouse,AutoApprove,ManualApprove,AutoCut,Highlight,Note\n");
	            for (BonusTracker t : bonusTrackerList) {
	                fileWriter.append(t.getPRODUCT_NAME()).append(",");
	                fileWriter.append(t.getBARCODE()).append(",");
	                fileWriter.append(t.getPHARMACY_GLN_NUMBER()).append(",");
	                fileWriter.append(t.getPHARMACY_NAME()).append(",");
	                fileWriter.append(t.getDATE()).append(",");
	                fileWriter.append(t.getORDER_NO()).append(",");
	                fileWriter.append(t.getTOWN()).append(",");
	                fileWriter.append(t.getPROVINCE()).append(",");
	                fileWriter.append(t.getQUANTITY()).append(",");
	                fileWriter.append(t.getBONUS()).append(",");
	                fileWriter.append(t.getPRICE()).append(",");
	                fileWriter.append(t.getWAREHOUSE()).append(",");
	                fileWriter.append(t.getAUTO_APPROVED()).append(",");
	                fileWriter.append(t.getManualApprove()).append(",");
	                fileWriter.append(t.getAUTO_CUT()).append(",");
	                
	                fileWriter.append(t.getHIGHLIGHT()).append(",");
	                fileWriter.append(t.getNote()).append("\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            closeWriter(fileWriter);
	        }
	    }

	// Helper method to close FileWriter
	    private void closeWriter(FileWriter writer) {
	        try {
	            if (writer != null) {
	                writer.flush();
	                writer.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Helper method to close BufferedReader
	    private void closeReader(BufferedReader reader) {
	        try {
	            if (reader != null) {
	                reader.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	  
	}
	


