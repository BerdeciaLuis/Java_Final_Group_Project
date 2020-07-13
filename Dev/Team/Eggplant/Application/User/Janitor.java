package Dev.Team.Eggplant.Application.User;


/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Janitor Class will take care of the following information
 *  -- The Years of Service of the Janitor
 *  -- The Hourly Rate of the Janitor
 *  -- If the Janitor is a smoker or not
 *  
 */

public class Janitor extends Person{

	//FIELDS//
	
	private int yearsOfService;
	private double hourlyRate;
	
	
	//Default Constructor
	public Janitor(){
		
		
		
	}//Constructor
	
	public Janitor(int yearsOfService, double hourlyRate){
		
		
		
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
	
	public void setYearsOfService(int yearsOfService){
		
		this.yearsOfService =  yearsOfService;
	
	}//setYearsOfService
	
	
	/**
	 * @return the Hourly Rate of the Janitor
	 */
	
	public double getHourlyRate(){
		
		return hourlyRate;
		
	}//getHourlyRate
	
	
	/**
	 * @param hourlyRate - hourlyRate of the Janitor to set
	 * If the hourlyRate is between $10.00 and $25.00 else hourlyRate will = $0.00
	 */
	
	public void setHourlyRate(double hourlyRate){
		
		if(hourlyRate >= 10.00 && hourlyRate <= 25.00){
			
			String.format("%.2f",hourlyRate);
			this.hourlyRate =  hourlyRate;
			
		}//if
		
		else{
			
			this.hourlyRate = 0.0;
			
		}//else
		
		
	}//setHourlyRate
	
	
	/**
	 * @param smoker - sets true or false if Person smokes
	 */
	
	public void isSmoker(String smoker){
		
		if(smoker.equals("Yes")){
			
			this.smoker = true;
			
		}//if
		
		else if(smoker.equals("No")){
			 
			this.smoker = false;
			
		}//else
		
		
	}//isSmoker
	
	
	//OTHER METHODS//
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				    "--------------------------------------\n"
				   +"               Janitor Info \n"
				   +"--------------------------------------\n"
				   +"Years Worked: "+ getYearsOfService() +"\n"
				   +"Hourly Rate: "+getHourlyRate() + "\n"
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
			
			if(getSSN() == ((Janitor)obj).getSSN())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	
	
}//end of Janitor Clsss
