package Dev.Team.Eggplant.Application;

import Dev.Team.Eggplant.Application.Gui.Login_Menu;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on June 2020
 * 
 * @category This class is going to handle launching the program.
 *
 */
public class Launch extends Application{
	
	
	
	public void start(Stage stage) throws Exception{
		
		new Login_Menu();
		
	}//start
	
	
	public static void main(String [] args){
		
		
		/*
		 * Method: main()
		 * 
		 * Parameters: args - Array of values entered on the command line
		 * 
		 * Processes:  Launches the application.
		 * 
		 * Returns : nothing
		 */
		
	     launch(args);
		
	}//main
	

}//end of Launch Class
