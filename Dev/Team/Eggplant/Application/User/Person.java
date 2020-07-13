package Dev.Team.Eggplant.Application.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;
import Dev.Team.Eggplant.Application.Gui.AlertBox;
import Dev.Team.Eggplant.Application.User.Info.Address;
import Dev.Team.Eggplant.Application.User.Info.Name;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Person Class will take care of the following information
 *  -- Name of the Person
 *  -- SSN or Social Security Number of the Person (to make each Person object created unique)
 *  -- DOB of the Person
 *  -- Address of the Person
 *  -- Gender of the Person 
 *  -- Is the Person a Smoker
 *  
 */

public abstract class Person {
	
	//FIELDS//
	
	private Name name;
	private String SSN;
	private String dateOfBirth;
	private Address address;
	private String gender;
	public boolean smoker;

	
	//Default Constructor
	public Person(){
		
		//No-Args Constructor
		
	}//Constructor
	
	
	//Constructor
	public Person(Name name, String SSN, String dateOfBirth, Address address, String gender){
		
		setName(name);
		setSSN(SSN);
		setDateOfBirth(dateOfBirth);
		setAddress(address);
		setGender(gender);
		
	}//constructor
	 
	
	//GETTER AND SETTERS//
	
	
	/**
	 * @return The Full Name of the Person
	 */
	
	public String getName(){
		
		return name.toString();
		
	}//getName
	
	
	/** 
	 * @param name -  The full name of the user to set
	 */
	public void setName(Name name){
		
		this.name = name;
		
	}//setName
	
	
	/**
	 * @return SSN(Social Security Number) in a XXX-XX-XXXX format
	 */
	
	public String getSSN(){
		
		return SSN;
		
	}//getSSN
	
	
	/**
	 * @param SSN is the SSN(Social Security Number) to set
	 * If the SSN is empty the method will send an Error message 
	 * Else if SSN is not empty it will check if the length is = 9 and
	 * it will also make sure it follows the correct pattern:
	 * 
	 * ^ - Start of string
	 *(?!000|666) -fail the match if the string starts with 000 or 666
     *[0-8] - Then match and consume the next digit if it is in range 0 to 8
	 *[0-9]{2} - Then match and consume the next any two digits where [0-9] means any digit which you can also compactly write as /d
	 *(?!00) - rejects the match if the next two digits are 00
	 *[0-9]{2} - Then next it matches and consumes any two digits
	 *(?!0000) - rejects the match if the next four digits are 0000
	 *[0-9]{4} - Then next it matches and consumes any four digits
	 * $ - End of string
	 * 
	 */
	
	public void setSSN(String SSN){
				
		if(!(SSN.isEmpty())){
			

		
			if(SSN.length() == 9 && Pattern.matches("^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$", SSN)){
				
				this.SSN = SSN.substring(0, 3)+"-"+SSN.substring(3, 5)+"-"+SSN.substring(5,9);
				
			}//if
			
			else{
				
				ErrorManager.addErrorMessage("- Incorrect Format for Social Security Number");
				
			}//else
			
		}//if
		
		else{
			
			 ErrorManager.addErrorMessage("- No Social Security Found!");
			
		}//else
		
		
	}//setSSN
	
	
	/**
	 * @return The Date of Birth of the Person
	 */
	
	public String getDateOfBirth(){
		
		return dateOfBirth;
		
	}//getDateOfBirth
	
	
	/**
	 * 
	 * @param dateOfBirth - The Date Of Birth of the user to set
	 */
	
	public void setDateOfBirth(String dateOfBirth){
		
		if(!(dateOfBirth.equals(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))){
			
				this.dateOfBirth = dateOfBirth;
			
		}//if
		
		else{
			
			 ErrorManager.addErrorMessage("- No Date Of Birth Found!");
			
		}//else
			

		
	}//setDateOfBirth
	
	
	/**
	 * @return The address of the person
	 */
	
	public String getAddress(){
	
		return address.toString();
		
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
	 * @return Yes if the Person smokes/ No if the Person does not smokes
	 */
	
	public String getIsSmokerInfo(){
		
		if(smoker = true){
			
			return "Yes";
			
		}//if
		
		else if(smoker = false){
			
			return "No";
			
		}//else if
		
		else{
			
			return "No Info Found!";
			
		}//else
		
	}//getIsSmoker
	
	
	//OTHER METHODS//
	
	
	public abstract void isSmoker(String smoker);
	
	
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				    "--------------------------------------\n"
				   +"               Personal Info \n"
				   +"--------------------------------------\n"
				   +"Name: "+ getName() +"\n"
				   +"SSN: "+getSSN() + "\n"
				   +"Gender: "+ getGender() +"\n"
				   +"DOB (yyyy-mm-dd): "+ getDateOfBirth() +"\n\n"
				   + getAddress() +"\n\n" 
				   +"Smoker (Yes or No): "+ "No" +"\n"
				   +"--------------------------------------";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the SSN of a person equals another person 
	 * @return False if the SSN of one person doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Person)
		{
			
			if(getSSN() == ((Person)obj).getSSN())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	

}//end of Person class
