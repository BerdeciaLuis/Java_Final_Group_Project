package Dev.Team.Eggplant.Application.Gui;

import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on June 2020
 * 
 * @category This program will handle the closing of the program when the user selects the X on the GUI
 *
 */
public class CloseProgram {

	
	//FIELDS//
	private static boolean answer;
	
	
	/**
	 * This method will throw a confirm dialog box to make sure the user actually want to close the program
	 * @param stage - stage to be closed
	 */
	
	
	public static void closeProgram(Stage stage){
		
		answer =  AlertBox.confirmMessage("Are you sure you would like to close this program?");
		
		if(answer){ 
			
			stage.close();
			
		}
		
		
	}//closeProgram
	
	/**
	 * This method will throw a confirm dialog box when the user clicks the X on the window
	 * 
	 * @param stage - stage to be closed
	 */
	
	public static void closeRequest(Stage stage){
		
		stage.setOnCloseRequest(e ->{
			
			e.consume();
			closeProgram(stage);
			
		});
		
		
	}//closeRequest
	
}//end of CloseProgram Class
