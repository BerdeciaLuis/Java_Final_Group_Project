package Dev.Team.Eggplant.Application;

import Dev.Team.Eggplant.Application.Gui.*;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on June 2020
 * 
 * @category This class is going to handle launching the program.
 * 
 * Design Tool in the File Name Read_ME
 *
 */
public class Launch extends Application{
	
	
	
	public void start(Stage stage) throws Exception{
		
		new Main_Menu();	
		
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
