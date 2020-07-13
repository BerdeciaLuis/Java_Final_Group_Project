package Dev.Team.Eggplant.Application.User;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Students Class will take care of the following information
 *  -- Major of the Student
 *  -- The GPA of the Student
 *  -- The Credits of the Student
 *  -- If the Student is a smoker or not
 *  
 */

public class Student extends Person {
	
	
	//FIELDS//
	
	private String major;
	private double gpa;
	private int credits;
	
	
	//Default Constructor
	public Student(){
		
		setMajor("Undeclared");
		setGPA(0.0);
		setCredits(0);
		isSmoker("");
		
		
	}//Constructor
	
	
	public Student(String major, double gpa, int credits, String isSmoker){
		
		setMajor(major);
		setGPA(gpa);
		setCredits(credits);
		isSmoker(isSmoker);
		
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
		
		this.major = major;
		
	}//setMajor
	
	
	/**
	 * @return The GPA of the Student
	 */
	
	public double getGPA(){
		
		return gpa;
		
	}//getGPA
	
	
	/**
	 * @param gpa -  gpa of the student to set
	 * If the gpa of the Student is not between 0.0 and 5.0 then the gpa will be set to 0.0
	 */
	
	public void setGPA(double gpa){
		
		if(gpa >= 0.0 && gpa <= 5.0){
			
			this.gpa = gpa;
			
		}//if
		
		else{
			
			this.gpa = 0.0;
			
		}//else
		
		
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
	
	public void setCredits(int credits){
		
		if(credits >= 0 && credits <= 130){
			
			this.credits = credits;
		
		}//if
		
		else{
			
			this.credits = 0;
			
		}//else
		
	}//setCredits
	
	
	/**
	 * @param smoker - sets true or false the Person smokes
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
				   +"               Student Info \n"
				   +"--------------------------------------\n"
				   +"Major: "+ getMajor() +"\n"
				   +"GPA: "+getGPA() + "\n"
				   +"Credits: "+ getCredits() +"\n"
				   +"--------------------------------------";
		
	}//toString
	

	/** 
	 * @param obj An object
	 * @return True if the SSN of a student equals another student or False if the SSN of one student doesn't equal another
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag = false;
		
		if(obj instanceof Student)
		{
			
			if(getSSN() == ((Student)obj).getSSN())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 

	
	

}//ends of Student Class
