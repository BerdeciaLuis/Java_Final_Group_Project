package Dev.Team.Eggplant.Application.User;
import java.time.LocalDate;
import java.time.Period;
import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;
import Dev.Team.Eggplant.Application.User.Info.Address;
import Dev.Team.Eggplant.Application.User.Info.Name;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Person Class will take care of the following information
 *  -- Name of the Person
 *  -- DOB of the Person
 *  -- Address of the Person
 *  -- Gender of the Person 
 *  -- Is the Person a Smoker
 *  
 */

public abstract class Person {
	
	//FIELDS//
	private Name name;
	private String dateOfBirth;
	private Address address;
	private String gender;
	public String smokerInfo;
	protected String occupation;

	
	//Default Constructor
	public Person(){
		
		//No-Args Constructor
		
	}//Constructor
	
	
	//Constructor
	public Person(Name name, String dateOfBirth, Address address, String gender, String smokerInfo){
		
		setName(name);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setGender(gender);
		setSmokerInfo(smokerInfo);
		
	}//constructor
	

	//GETTER AND SETTERS//
	
	
	/**
	 * @return The Full Name of the Person
	 */
	
	public Name getName(){
		
		return name;
		
	}//getName
	
	
	/** 
	 * @param name -  The full name of the user to set
	 */
	public void setName(Name name){
		
		this.name = name;
		
	}//setName
	
	
	/**
	 * @return The Date of Birth of the Person
	 */
	
	public String getDateOfBirth(){
		
		return dateOfBirth;
		
	}//getDateOfBirth

	
	/**
	 * @param dateOfBirth - The Date Of Birth of the user to set
	 */
	
	public void setDateOfBirth(String dateOfBirth){
		
		if(!(Period.between(LocalDate.of(Integer.parseInt(dateOfBirth.substring(6, 10)), Integer.parseInt(dateOfBirth.substring(0, 2)), 
				Integer.parseInt(dateOfBirth.substring(3, 5))),LocalDate.now()).getYears() < 18)){  //makes sure the user is 18 years or older
			
				this.dateOfBirth = dateOfBirth;
			
		}//if
		
		else{
			
			 ErrorManager.addErrorMessage("- Date of Birth has to 18 or Older!");
			
		}//else
			

		
	}//setDateOfBirth
	
	
	/**
	 * @return The address of the person
	 */
	
	public Address getAddress(){
	
		return address;
		
	}//getAddress
	
	
	/**
	 * @param address - The address of the user to set
	 */
	
	public void setAddress(Address address)
	{
		
		this.address = address;
		
	}//setAddress
	
	/** 
	 * @return The gender of the person
	 */
	
	public String getGender(){
		
		return gender;
		
	}//getGender
	
	
	/**
	 * @param gender - The gender of the user to set
	 */
	public void setGender(String gender){
		
		
		this.gender = gender;
		
	}//setGender
	
	
	/**
	 * @return  The smoking info of the person
	 */
	
	public String getSmokerInfo()
	{
		
		return smokerInfo;
		
	}//getSmokerInfo
	
	
	/**
	 * @param smoker - sets Yes or No if the Person smokes
	 */
	
	public void setSmokerInfo(String smokerInfo){
		
		this.smokerInfo = smokerInfo;
		
	}//setSmokerInfo
	
	
	public String getOccupation(){
		
		return occupation;
		
	}//getOccupation
	
	
	//OTHER METHODS//
	
	
	public abstract void setOccupation();
	

	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				    "--------------------------------------\n"
				   +"Name: "+ getName() +"\n"
				   +"Gender: "+ getGender() +"\n"
				   +"DOB (mm/dd/yyyy): "+ getDateOfBirth() +"\n\n"
				   + getAddress() +"\n\n" 
				   +"Smoker: "+ getSmokerInfo() +"\n"
				   +"Occupation: "+getOccupation()+"\n"
				   +"--------------------------------------\n";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the Name and Address of a person equals another person 
	 * @return False if the Name and Address of one person doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Person)
		{
			
			if(getName() == ((Person)obj).getName() && getAddress() == ((Person)obj).getAddress())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	

}//end of Person class
