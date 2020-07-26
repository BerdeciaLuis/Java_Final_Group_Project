package Dev.Team.Eggplant.Application.User;

import java.util.regex.Pattern;
import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Teacher Class will take care of the following information
 *  -- The Subject taught by the Teacher
 *  -- The Number of Classes being taught by the Teacher
 *  -- The Office Number of the Teacher
 *  
 */

public class Teacher extends Person{
	

	//FIELDS//
	
	private String subject;
	private int numOfClasses;
	private String officeNumber;
	
	
	//Default Constructor
	public Teacher(){
		
		setOccupation();
		
	}//constructor
	
	public Teacher(String subject, String numOfClasses, String officeNumber){
		
		setSubject(subject);
		setNumOfClasses(numOfClasses);
		setOfficeNumber(officeNumber);
		setOccupation();
		
	}//constructor
	
	
	//GETTERS AND SETTERS//
	
	
	/**
	 * @return The subject taught by the Teacher
	 */
	
	public String getSubject(){
		
		return subject;
	
	}//getSubjectTaught
	
	
	/**
	 * @param subject -  subject taught by the Teacher to set
	 */
	
	public void setSubject(String subject){
		
		if(!(subject.isEmpty())){
			
			this.subject = subject; 
			
		}
		
		else{
			
			ErrorManager.addErrorMessage("- No Subject was selected!");
			
		}
		
	}//setSubjectTaught
	
	
	/** 
	 * @return The Number of Classes being taught by the Teacher
	 */
	
	public int getNumOfClasses(){
		
		return numOfClasses;
		
	}//getNumOfClasses
	
	
	/**
	 * @param numOfClasses -  numOfClasses taught by the Teacher to set
	 */
	
	public void setNumOfClasses(String numOfClasses){
		
		if(!(numOfClasses.isEmpty())){
			
			if(Pattern.matches("[0-9]+", numOfClasses)){
				
				this.numOfClasses = Integer.parseInt(numOfClasses);
			}
			
			else{
				
				ErrorManager.addErrorMessage("- Incorrect Format for # of Classes was Placed!");
				
			}
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- Number Of Classes Amount was Not Found!");
			
		}
		
	}//setNumOfClasses
	
	
	/**
	 * @return The Office Number of the Teacher
	 */
	
	public String getOfficeNumber(){
		
		return officeNumber;
		
	}//getOfficeNumber
	
	
	/**
	 * @param officeNumber -  officeNumber of the Teacher to set
	 */
	
	public void setOfficeNumber(String officeNumber){
		
		if(!(officeNumber.isEmpty())){
			
			if(Pattern.matches("[0-9]+", officeNumber)){
				
				this.officeNumber = officeNumber;
			}
			
			else{
				
				ErrorManager.addErrorMessage("- Incorrect Office Number was Placed!");
				
			}
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- Office Number was Not Found!");
			
		}
		
		
	}//setOfficeNumber
	
	
	//OTHER METHODS//
	

	public void setOccupation(){
		
		this.occupation = "Teacher";
		
	}//setOccupation
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				    super.toString()
				   +"Subject: "+ getSubject() +"\n"
				   +"Number of Classes: "+getNumOfClasses() + "\n"
				   +"Officer Number: "+ getOfficeNumber() +"\n"
				   +"--------------------------------------";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the SSN of a teacher equals another teacher or False if the SSN of one student doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Teacher)
		{
			
			if(getName() == ((Teacher)obj).getName())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	
	
}//end of Teacher Class
