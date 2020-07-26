package Dev.Team.Eggplant.Application.User;

import java.util.regex.Pattern;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Janitor Class will take care of the following information
 *  -- The Years of Service of the Janitor
 *  -- The Hourly Rate of the Janitor
 *  
 */

public class Janitor extends Person{

	//FIELDS//
	
	private int yearsOfService;
	private String hourlyRate;
	
	
	//Default Constructor
	public Janitor(){
		
		setOccupation();
		
	}//Constructor
	
	public Janitor(String yearsOfService, String hourlyRate){
		
		setYearsOfService(yearsOfService);
		setHourlyRate(hourlyRate);
		setOccupation();
		
	}//constructor
	
	
	//GETTERS AND SETTERS//

	
	/**
	 * @return The Years of Service of the Janitor
	 */
	
	public int getYearsOfService(){
		
		return yearsOfService;
		
	}//getYearsOfService
	
	
	/**
	 * @param yearsOfService -  yearsOfService of the Janitor to set
	 */
	
	public void setYearsOfService(String yearsOfService){
		
		if(!(yearsOfService.isEmpty())){
			
			if(Pattern.matches("[0-9]+", yearsOfService)){
				
				this.yearsOfService = Integer.parseInt(yearsOfService);
			}
			
			else{
				
				ErrorManager.addErrorMessage("- Incorrect Format For Years Of Service was Placed!");
				
			}
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- Years Of Service Amount was Not Found!");
			
		}
	
	}//setYearsOfService
	
	
	/**
	 * @return the Hourly Rate of the Janitor
	 */
	
	public String getHourlyRate(){
		
		return "$"+hourlyRate;
		
	}//getHourlyRate
	
	
	/**
	 * @param hourlyRate - hourlyRate of the Janitor to set
	 * If the hourlyRate is between $10.00 and $25.00 else hourlyRate will = $0.00
	 */
	
	public void setHourlyRate(String hourlyRate){
		
		if(Pattern.matches("[0-9]+(.){0,1}[0-9]*", hourlyRate)){
			
			
			if(Double.parseDouble(hourlyRate) >= 10.00 && Double.parseDouble(hourlyRate) <= 25){
				
				this.hourlyRate = hourlyRate;
			}
			
			else{
				
				ErrorManager.addErrorMessage("- Hourly Rate must be between $10.00 and $25.00!");
				
			}
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- Hourly Rate Amount Not Found!");
			
		}//else
		
		
	}//setHourlyRate
	
	//OTHER METHODS//
	
	
	public void setOccupation(){
		
		this.occupation = "Janitor";
		
	}//setOccupation
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				   super.toString()
				   +"Years Worked: "+ getYearsOfService() +"\n"
				   +"Hourly Rate: $"+ getHourlyRate()+"\n"
				   +"--------------------------------------";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the SSN of a Janitor equals another Janitor or False if the SSN of one Janitor doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Janitor)
		{
			
			if(getName() == ((Janitor)obj).getName())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	
	
}//end of Janitor Clsss
