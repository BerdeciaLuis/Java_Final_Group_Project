package Dev.Team.Eggplant.Application.Gui;

import Dev.Team.Eggplant.Application.Reports.Reports;
import Dev.Team.Eggplant.Application.User.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.*;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will handle the Gui that will display the info of the selected
 * person and it will also allow the user to create a txt file containing the Users Info
 *
 */

public class View_Info {
	
	
	//FIELDS//
	private Stage window;	
	private Label infoLabel;

	
	//Default Constructor
	public View_Info(){
		
		//No-Args Constructor	
		
	}//Constructor
	
	
	/**
	 * This method will show the user the information
	 * of the selected user and it also has an option to
	 * create a text file containing the users info
	 * 
	 * @param person - The selected person that the user wants to see
	 */
	
	public void viewAccountInfo(Person person){
		
		window =  new Stage();
		window.setTitle("View Account");
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		BorderPane layout =  new BorderPane();
		Scene scene = new Scene(layout,600,400);
		window.setScene(scene);
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		window.show();
		
		VBox topMenu = new VBox();
		Label newAccountLabel =  new Label("View Account");
		newAccountLabel.setFont(Font.font("Arial Black", FontWeight.BOLD, 18));
		topMenu.getChildren().addAll(newAccountLabel);
		topMenu.setPadding(new Insets(10,10,5,10));
		topMenu.setAlignment(Pos.CENTER);
	
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5,10,10,10));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setAlignment(Pos.TOP_CENTER);
	
		
		//Information Label
		infoLabel = new Label(person.toString());
		GridPane.setConstraints(infoLabel, 0, 0); 
		
		//Buttons
	  	HBox buttonMenu =  new HBox();
	  	buttonMenu.setAlignment(Pos.CENTER);
	    buttonMenu.setSpacing(10);
	    Button reportButton =  new Button("Generate Report");
	    reportButton.setOnAction(e -> new Reports().writeUserReport(person));
	  	Button backButton = new Button("Back");
	  	backButton.setOnAction(e -> window.close());//backButton
	  	buttonMenu.getChildren().addAll(reportButton,backButton);
	  	GridPane.setConstraints(buttonMenu, 0, 1);
		
	  	grid.getChildren().addAll(infoLabel,buttonMenu);
	  	
	  	layout.setCenter(grid);
		layout.setTop(topMenu);
		
	}//viewAccountInfo

	
}//end of View_Info Class
