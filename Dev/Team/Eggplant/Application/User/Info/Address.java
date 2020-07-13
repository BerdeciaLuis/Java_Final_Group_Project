package Dev.Team.Eggplant.Application.User.Info;

import java.util.regex.Pattern;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Address Class will take care of the following information
 *  -- Street Number of the Address
 *  -- Street Name of the Address
 *  -- Street Type of the Address
 *  -- City of the Address
 *  -- State Code of the Address
 *  -- Zip Code of the Address
 *  
 */

public class Address {

	
	//FIELDS//
	
	private String streetNumber;
	private String streetName;
	private String streetType;
	private String city; 
	private States stateCode;
	private String zipCode;	
   
    
    
    //Default Constructor
    public Address(){
    	
    	setStreetNumber("12345a");
    //No-Args Constructor
    	
    }//Constructor
    
    
    //Constructor 
    public Address(String streetNumber, String streetName, String streetType, String city,
    			   States stateCode, String zipCode ){
    	
    	setStreetNumber(streetNumber);
    	setStreetName(streetName);
    	setStreetType(streetType);
    	setCity(city);
    	setStateCode(stateCode);
    	setZipCode(zipCode);
    	
    }//Constructor
    
   
    
    //GETTERS AND SETTERS//
    
    
    /**
     * @return The Street Number of the User
     */
    
    public String getStreetNumber(){
    	
    	return streetNumber;
    	
    }//getStreetNumber
    
    
    /**
     * @param streetNumber - The streetNumber to set
     */
    
    public void setStreetNumber(String streetNumber){
    	
    	if(!(streetNumber.isEmpty())){
    		
    		if(Pattern.matches("[0-9]+", streetNumber)){
    			
    			this.streetNumber = streetNumber;
    			
    		}//if
    		
    	 	else{
        		
        		ErrorManager.addErrorMessage("- Error Found on Street Number Info!");
        		
        	}//else
    		

    	}//if
    	
    	else{
    		
    		ErrorManager.addErrorMessage("- No Street Number Info Found!");
    		
    	}//else
    	
    	
    }//setStreetName
    
    
    /**
     * @return The Street Name of the User
     */
    
    public String getStreetName(){
    	
    	return streetName;
    	
    }//getStreetName
    
    
    /**
     * @param streetName - The streetName to set
     */
    
    public void setStreetName(String streetName){
    	
    	if(!(streetName.isEmpty())){
    		
    		if(Pattern.matches("[a-zA-Z]+", streetName)){
    			
    			this.streetName =  streetName;
    			
    		}//if
    		
    		else{
    			
    			ErrorManager.addErrorMessage("- Error Found on Street Name Info!");
    			
    		}//else
    		
    		
    	}//if
    	
    	else{
    		
    		ErrorManager.addErrorMessage("- No Street Name Found!");
    		
    	}//else
    	
    	
    }//setStreetName
    
    
    /**
     * @return The Street Type of the User
     */
    
    public String getStreetType(){
    	
    	return streetType;
    	
    }//getStreetType
    
    
    /** 
     * @param streetType - The streetType to set
     */
    
    public void setStreetType(String streetType){
    	
    	if(!(streetType.isEmpty())){
    		
    			if(Pattern.matches("[a-zA-Z]+", streetType)){
    			
    				this.streetType =  streetType;
    			
    			}//if
    		
    			else{
    			
    				ErrorManager.addErrorMessage("- Error Found on Street Type Info!");
    			
    			}//else
    		
    		
    		}//if
    	
    		else{
    		
    			ErrorManager.addErrorMessage("- No Street Type Found!");
    		
    		}//else
    	
    }//setStreetType
    
    
    /**
     * @return The City of the User
     */
    
    public String getCity(){
    	
    	return city;
    	
    }//getCity
    
    
    /**
     * @param city -  The city to set
     */
    
    public void setCity(String city){
    	
    	if(!(city.isEmpty())){
    		
    			if(Pattern.matches("[a-zA-Z]+", city)){
    			
    				this.city =  city;
    			
    			}//if
    		
    			else{
    			
    				ErrorManager.addErrorMessage("- Error Found on City Info!");
    			
    			}//else
    		
    		
    		}//if
    	
    		else{
    		
    			ErrorManager.addErrorMessage("- No City Found!");
    		
    		}//else
    	
    }//setCity
    	
    
    /** 
     * @return The State Code of the User
     */
    
    public String getStateCode(){
    	
    	return stateCode.getStateDescription();
    	
    }//getStateCode
    
    
    /**
     * @param stateCode - The stateCode to set
     */
    
    public void setStateCode(States stateCode){
    	
    	this.stateCode = stateCode;
    	
    }//setStateCode
    
    
    /**
     * @return The Zip Code of the User
     */
    
    public String getZipCode(){
    	
    	return zipCode;
    	
    }//getZipCode
    
    
    /**
     * @param zipCode - The zipCode to set 
     */
    
    public void setZipCode(String zipCode){
    	
    	if(!(zipCode.isEmpty())){
    		
    			if(Pattern.matches("[0-9]+", zipCode)){
    			
    				this.zipCode =  zipCode;
    			
    			}//if
    		
    			else{
    			
    				ErrorManager.addErrorMessage("- Error Found on Zip Code Info!");
    			
    			}//else
    		
    		
    		}//if
    	
    		else{
    		
    			ErrorManager.addErrorMessage("- No Zip Code Found!");
    		
    		}//else
    	
    }//setZipCode
    
    
    //OTHER METHODS//
	
  	/**
  	 * @see java.lang.Object#toString()
  	 */
  	
  	@Override
  	public String toString() {
  		
  		return getStreetNumber()+" "+getStreetName()+" "+getStreetType()+"\n"+getCity()+", "+getStateCode()+" "+getZipCode();
  		
  	}//toString
  	

  	/** 
  	 * @param obj An object
  	 * @return True if the Address of one person equals the Address of another person 
  	 * @return False if the Address of one person doesn't equal another
  	 * @see java.lang.Object#equals(java.lang.Object)
  	 */
  	
  	@Override
  	public boolean equals(Object obj) {
  		
  		boolean flag = false;
  		
  		if(obj instanceof Address)
  		{
  			
  			if(getStreetNumber() == ((Address)obj).getStreetNumber() 
  					&& getStreetName() == ((Address)obj).getStreetName()
  					&& getStreetType() == ((Address)obj).getStreetType()
  				    && getCity() == ((Address)obj).getCity()
  				    && getStateCode() == ((Address)obj).getStateCode()
  				    && getZipCode() == ((Address)obj).getZipCode()){
  					
  					flag = true;
  				
  			}//if
  			
  			
  		}//if
  		
  		return flag;
  		
  	}//equals 
    
	
}//end of Address Class
