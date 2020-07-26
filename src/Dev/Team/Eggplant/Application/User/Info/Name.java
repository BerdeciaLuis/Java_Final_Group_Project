package Dev.Team.Eggplant.Application.User.Info;

import java.util.regex.Pattern;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Name Class will take care of the following information
 *  -- First Name of the Person
 *  -- Middle Initial of the Person
 *  -- Last Name of the Person
 *  
 */

public class Name 
{
	
	//FIELDS//
	
	private String firstName;
	private String midInitial;
	private String lastName;
	private char firstLetter; //It will be used to capitalize the first char in the First Name and Last Name
	
	
	//Default Constructor
	public Name(){
		
		//No-Args Constructor
		
	}//Name Constructor
	
	
	//Constructor with First Name and Last Name
	
	public Name(String firstName, String lastName){
		
		setFirstName(firstName);
		setMiddleInitial("");
		setLastName(lastName);	
		
	}//Name Constructor
	
	//Constructor with First Name, Middle Initial, and Last Name
	
	public Name(String firstName, String midInitial, String lastName){
		
		setFirstName(firstName);
		setMiddleInitial(midInitial);
		setLastName(lastName);
		
	}//Name Construtor
	
	
	//GETTER AND SETTERS//
	
	
	/** 
	 * @return firstName; 
	 */
	
	public String getFirstName(){
		
		return firstName;
		
	}//getFirstName
	
	
	/**
	 * @param firstName the First Name of the User to set
	 * The method will also capitalize the first char of the String
	 */
	
	public void setFirstName(String firstName){
		
		if(firstName.equals("")){
			 
			ErrorManager.addErrorMessage("- No First Name Info Found!");
			
		}//if
		
		else{
			
			 if(Pattern.matches("[a-zA-z]+", firstName)){
			 
				 firstName = firstName.toLowerCase(); //This just makes sure that all the characters in the String are lower case to avoid mistakes like(saMantHa or lUIs)
				 firstLetter = Character.toUpperCase(firstName.charAt(0));
				 this.firstName = firstLetter+firstName.substring(1);
				 
			 }//if	
			 
			 else{
				 
				 ErrorManager.addErrorMessage("- Error Found on First Name Info!");
				 
			 }
			 
		}//else
		
	}//setFirstName
	
	/**
	 * @return midInitial in this format (midInitial+". ")
	 */
	
	public String getMiddleInitial(){
		
		if(!midInitial.equals("")){
			
			return midInitial+".";
			
		}
		
		return midInitial;
		
	}//getMiddleInitial
	
	/** 
	 * @param midInitial - the middle Initial to set
	 * The method will also capitalize the middle initial String
	 */
	
	public void setMiddleInitial(String midInitial){
		
		if(midInitial.equals("")){
			
			this.midInitial = "";
			
		}//if
		
		else{
			 
			 midInitial = midInitial.substring(0, 1);
			 this.midInitial = midInitial.toUpperCase();
	
		}//else
		
	}//setMiddleInitial
	
	/**
	 * @return lastName
	 */
	
	public String getLastName(){
		
		return lastName;
		
	}//getLastName
	
	/**
	 * @param lastName lastName to set
	 * The method will also capitalize the first char in the lastName String
	 */
	
	public void setLastName(String lastName){
		
		if(lastName.equals("")){
			
			ErrorManager.addErrorMessage("- No Last Name Info Found!");
			
		}//if
		
		else{
			
			if(Pattern.matches("[a-zA-Z]+", lastName)){
				
				 lastName = lastName.toLowerCase(); //This just makes sure that all the characters in the String are lower case to avoid mistakes like(saMantHa or lUIs)
				 firstLetter = Character.toUpperCase(lastName.charAt(0));
				 this.lastName = firstLetter+lastName.substring(1);
			
			}//if
			
			
			else{
				
				ErrorManager.addErrorMessage("- Error Found on Last Name Info!");
				
			}//else
			
		}//else
		
		
	}//setLastName

	
	
	//OTHER METHODS//
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return getFirstName()+" "+getMiddleInitial()+" "+getLastName();
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the firstName and lastName of a person equals another person 
	 * @return False if firstName and lastName of one person doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Name)
		{
			
			if(getFirstName() == ((Name)obj).getFirstName() && getLastName() == ((Name)obj).getLastName())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	
	

}//end of Name Class
