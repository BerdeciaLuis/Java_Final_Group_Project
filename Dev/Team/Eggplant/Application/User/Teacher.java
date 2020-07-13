package Dev.Team.Eggplant.Application.User;


/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category Teacher Class will take care of the following information
 *  -- The Subject taught by the Teacher
 *  -- The Number of Classes being taught by the Teacher
 *  -- The Office Number of the Teacher
 *  -- If the Teacher is a smoker or not
 *  
 */

public class Teacher extends Person{
	

	//FIELDS//
	
	private String subject;
	private int numOfClasses;
	private int officeNumber;
	
	
	//Default Constructor
	public Teacher(){
		
		setSubjectTaught("");
		setNumOfClasses(0);
		setOfficeNumber(0);
		isSmoker("");
		
	}//constructor
	
	public Teacher(String subject, int numOfClasses, int officeNumber, String isSmoker){
		
		setSubjectTaught(subject);
		setNumOfClasses(numOfClasses);
		setOfficeNumber(officeNumber);
		isSmoker(isSmoker);
		
	}//constructor
	
	
	//GETTERS AND SETTERS//
	
	
	/**
	 * @return The subject taught by the Teacher
	 */
	
	public String getSubjectTaught(){
		
		return subject;
	
	}//getSubjectTaught
	
	
	/**
	 * @param subject -  subject taught by the Teacher to set
	 */
	
	public void setSubjectTaught(String subject){
		
		this.subject = subject;
		
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
	
	public void setNumOfClasses(int numOfClasses){
		
		this.numOfClasses = numOfClasses;
		
	}//setNumOfClasses
	
	
	/**
	 * @return The Office Number of the Teacher
	 */
	
	public int getOfficeNumber(){
		
		return officeNumber;
		
	}//getOfficeNumber
	
	
	/**
	 * @param officeNumber -  officeNumber of the Teacher to set
	 */
	
	public void setOfficeNumber(int officeNumber){
		
		this.officeNumber = officeNumber;
		
		
	}//setOfficeNumber
	

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
				   +"               Teacher Info \n"
				   +"--------------------------------------\n"
				   +"Subject: "+ getSubjectTaught() +"\n"
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
			
			if(getSSN() == ((Teacher)obj).getSSN())
			{
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}//equals 
	
	
}//end of Teacher Class
