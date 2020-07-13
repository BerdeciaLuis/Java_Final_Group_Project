package Dev.Team.Eggplant.Application.Gui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;

/**
 * 
 * @author Luis Berdecia
 * @version Created on June 2020
 * 
 * @category This class will be in charge of handling the Alert Boxes for the program
 *
 */
public class AlertBox{

	
	//FIELDS//
	private static Alert alert;
	private static boolean answer;

	
	/**
	 * This method will display an Error Alert Box
	 * @param message - error message that will be diplayed
	 */
	
	public static void errorMessage(String message){
		
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("The Following Errors have Occurred!");
		alert.setContentText(message);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();
		
	}//ErrorMessage
	
	
	/**
	 * This method will display a Confirm Message Alert Box
	 * @param message -  confirm message that will be displayed
	 * @return the answer for the confirm message
	 */
	
	public static boolean confirmMessage(String message){
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initModality(Modality.APPLICATION_MODAL);
		
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.get() == ButtonType.OK){
			
			answer = true;
			
			
		}//if
		
		else{
			
			answer = false;
			
		}
		
		return answer;
		
	}//confirmMessage
	
	
	
	/**
	 * This method will display a Warning Message Alert Box
	 * @param message -  warning message that will be displayed
	 */
	
	public static void warningMessage(String message){
			
		alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();
		
		
	}//warningMessage
	
	
	/**
	 * This method will display an Info Message Alert Box
	 * @param message -  info message that will be displayed
	 */
	
	public static void infoMessage(String message){
		
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();
		
		
	}//infoMessage
	
	
	/**
	 * This method will display a Exception Error Message Alert Box
	 * @param message -  Exception message that will be displayed
	 */
	
	public static void exceptionMessage(Exception e){
		
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText(null);
		alert.setContentText("");

		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
		
		
	}//exceptionMessage
	
	

}//end of AlertBox Class
