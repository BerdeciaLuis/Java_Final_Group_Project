package Dev.Team.Eggplant.Application.Reports;

import Dev.Team.Eggplant.Application.Data.UserList;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will handle the statistics for the reports and charts in the program
 *
 */

public class Statistics {
	
	
	//ALL USERS FIELDS//
	private int amountStudents, amountTeachers, amountJanitors;
	private int amountM, amountF, amountU, amountO;
	private int amountYesSmoker, amountNoSmoker;
		
	
	//Default Constructor
	public Statistics(UserList users){
		
		setGenderAmount(users);
		setOccupationAmount(users);
		setSmokerAmount(users);
		
	}//Constructor
	
	
	//GETTERS AND SETTERS
	
	/**
	 * This method will take all the users from the ArrayList and
	 * it will count how many of the different type of Gender are in the Program
	 * 
	 * @param users -  The ArrayList the contains all the users in the program
	 */
	
	public void setGenderAmount(UserList users){
		
		for(int x = 0; x < users.getUserList().size(); x++){
			
			
			switch(users.getUserList().get(x).getGender()){
			
			case "M": amountM++;
				break;
			case "F": amountF++;
				break;
			case "U": amountU++;
				break;
			case "O": amountO++;
				break;
			
			}//switch
			
		}//for loop
	
	}//setGenderAmount
	
	
	/**
	 * @param gender Type of Gender the User will return
	 * @return amount of users with the selected gender in the program
	 */

	public int getGenderAmount(String gender){
		
		switch(gender){
		
		case "M": return amountM;
		case "F": return amountF;
		case "U": return amountU;
		case "O": return amountO;
			
		}//swtich
		
		return 0;

	}//getGenderAmount
	
	
	/**
	 * This method will take all the users from the ArrayList and
	 * it will count how many of the different type of occupations are in the Program
	 * 
	 * @param users -  The ArrayList the contains all the users in the program
	 */
	
	public void setOccupationAmount(UserList users){
		
		for(int x = 0; x < users.getUserList().size(); x++){
			
			
			switch(users.getUserList().get(x).getOccupation()){
			
			case "Student": amountStudents++;
				break;
			case "Teacher": amountTeachers++;
				break;
			case "Janitor": amountJanitors++;
				break;
			
			}//switch
			
		}//for loop
	
	}//setOccupationAmount
	
	
	/**
	 * @param occuaption -  Type of occuaption the User will return
	 * @return amount of users with the selected occupation in the program
	 */
	
	public int getOccupationAmount(String occupation){
		
		switch(occupation){
		
		case "Student": return amountStudents;
		case "Teacher": return amountTeachers;
		case "Janitor": return amountJanitors;
			
		}//swtich
		
		return 0;

	}//getOccupationAmount
	
	
	/**
	 * This method will take all the users from the ArrayList and
	 * it will count how many people smoke and how many don't smoke are in the Program
	 * 
	 * @param users -  The ArrayList the contains all the users in the program
	 */
	
	public void setSmokerAmount(UserList users){
		
		for(int x = 0; x < users.getUserList().size(); x++){
			
			
			switch(users.getUserList().get(x).getSmokerInfo()){
			
			case "Yes": amountYesSmoker++;
				break;
			case "No": amountNoSmoker++;
				break;
			
			}//switch
			
		}//for loop
	
	}//setSmokerAmount
	
	
	/**
	 * @param smoker - Type of smoker the User will return
	 * @return amount of users that smoke or don't smoke that are in the program
	 */
	
	public int getSmokerAmount(String smoker){
		
		switch(smoker){
		
		case "Yes": return amountYesSmoker;
		case "No": return amountNoSmoker;
			
		}//swtich
		
		return 0;

	}//getSmokerAmount
	
	

	
}