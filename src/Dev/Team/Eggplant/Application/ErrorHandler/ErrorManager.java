package Dev.Team.Eggplant.Application.ErrorHandler;

import Dev.Team.Eggplant.Application.Gui.AlertBox;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will be in charge of handling all the errors of the program
 *
 */

public class ErrorManager{

	//FIELDS//
	private static String errorMessage = "";
	private static boolean errorFound = false;

	
	//Default Constructor
	public ErrorManager()
	{
		
		//No-Args Constructor
		
	}//constructor
	
	
	/**
	 * The following method will set the error message for the error
	 * 
	 * @param message -  message that the error will display
	 */
	
	public static void addErrorMessage(String message ){
		
			errorMessage += message+"\n";
			errorFound = true;
		
	}//addErrorMessage
	
	
	/**
	 * This method will make sure that all fields in the New Account area are completely filled before 
	 * allowing the user to move on
	 * 
	 * @return true or false if the info for New Account Class was completed correctly 
	 */
	
	public static boolean infoNotCompleted(){
		
			boolean notCompleted = false;
			
			if(!errorFound){
				
				notCompleted = false;
						
			}//if
			
			else if(errorFound){
				
			    notCompleted = true;
				AlertBox.errorMessage(errorMessage);
				errorMessage = "";
				errorFound = false;
						
			}//else if
			
			return notCompleted;
		
	}//infoNotCompleted
	
	
	
}//end of ErrorManager Class
