package Dev.Team.Eggplant.Application.User;


import java.util.regex.Pattern;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Students Class will take care of the following information
 *  -- Major of the Student
 *  -- The GPA of the Student
 *  -- The Credits of the Student
 *  
 */

public class Student extends Person {
	
	
	//FIELDS//
	
	private String major;
	private double gpa;
	private int credits;
	
	
	//Default Constructor
	public Student(){
		
		setOccupation();
		
	}//Constructor
	
	
	public Student(String major, String gpa, String credits){
		
		setMajor(major);
		setGPA(gpa);
		setCredits(credits);
		setOccupation();
		
		
	}//Constructor
	
	
	//GETTERS AND SETTERS//
	
	
	/**
	 * @return The Major of the Student
	 */
	
	public String getMajor(){
		
		return major;
		
	}//getMajor
	
	
	/** 
	 * @param major - major of the student to set
	 */
	
	public void setMajor(String major){
		
		if(!(major.isEmpty())){
			
			this.major = major; 
			
		}
		
		else{
			
			ErrorManager.addErrorMessage("- No Major was selected!");
			
		}
		
		
	}//setMajor
	
	
	/**
	 * @return The GPA of the Student
	 */
	
	public double getGpa(){
		
		return gpa;
		
	}//getGPA
	
	
	/**
	 * @param gpa -  gpa of the student to set
	 * If the gpa of the Student is not between 0.0 and 5.0 then the gpa will be set to 0.0
	 */
	
	public void setGPA(String gpa){
		
		
		if((!(gpa.isEmpty())) && Pattern.matches("[0-9]+(.){0,1}[0-9]*", gpa)){
			
				
			if(Double.parseDouble(gpa) >= 0.0 && Double.parseDouble(gpa) <= 5.0){
				
				this.gpa = Double.parseDouble(gpa);
			
			}//if
		
			else{
			
				ErrorManager.addErrorMessage("- GPA must be between 0.0 and 5.0!");
			
			}//else
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- GPA Amount was Not Found!");
			
		}
		
		
	}//setGPA
	
	
	/**
	 * @return The Credits of the Student
	 */
	
	public int getCredits(){
	
		return credits;
		
	}//getCredits
	
	
	/**
	 * @param credits - credits of the student to set
	 * If the credits of the student are not between 0 and 130 the credits will be set to 0
	 */
	
	public void setCredits(String credits){
		
		if((!(credits.isEmpty())) && Pattern.matches("[0-9]+", credits)){
			
			if(Integer.parseInt(credits) >= 0 && Integer.parseInt(credits) <= 130){
				
				this.credits = Integer.parseInt(credits);
			}
			
			else{
				
				ErrorManager.addErrorMessage("- Credits must be between 0 and 130!");
				
			}
			
		}//if
		
		else{
			
			ErrorManager.addErrorMessage("- Credits Amount was Not Found!");
			
		}
		
	}//setCredits
	
	
	//OTHER METHODS//
	
	
	public void setOccupation(){
		
		this.occupation = "Student";
		
	}//setOccupation
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		return 
				    
				   super.toString()
				   +"Major: "+ getMajor() +"\n"
				   +"GPA: "+String.format("%.2f",getGpa())+ "\n"
				   +"Credits: "+ getCredits() +"\n"
				   +"--------------------------------------";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the name of a student equals another student or False if the name of one student doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Student)
		{
			
			if(getName() == ((Student)obj).getName())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 

	
	

}//ends of Student Class
