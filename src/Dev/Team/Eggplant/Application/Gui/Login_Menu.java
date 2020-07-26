package Dev.Team.Eggplant.Application.Gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on June 2020
 * 
 * @deprecated Not Used for this Program
 * @category This class will create a LogIn Menu for the Program
 *
 */

public class Login_Menu extends Application{
	
	
	//FIELDS//
	
	private Stage window =  new Stage();
	private BorderPane layout =  new BorderPane();
	private GridPane grid = new GridPane(); 
	private Label openingLabel =  new Label("\t\tWelcome to our Final Project");

	
	//Default Constructor
	public Login_Menu() throws Exception{
		
		start(window);
		
	}//Gui Constructor
	

	public void start(Stage stage) throws Exception{
		
		window = stage;
		CloseProgram.closeRequest(window);
		setUserAgentStylesheet(STYLESHEET_MODENA);
		
		grid.setPadding(new Insets(10,10,10,10)); //sets the space form the window on each side by pixel
		grid.setHgap(10); //spacing between cells horizontally
		grid.setVgap(8); //spacing between cells vertically
		
		//Intro
		VBox topMenu = new VBox();
		topMenu.getChildren().addAll(openingLabel);
		topMenu.setAlignment(Pos.CENTER);
		
		//Name Label
		Label nameLabel = new Label("Username");
		GridPane.setConstraints(nameLabel, 0, 1); 
		
		//Name Input
		TextField nameInput =  new  TextField();
		GridPane.setConstraints(nameInput, 1, 1); 
		
		
		//Pass Label
		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel, 0, 2); 
		
		//Pass Input
		PasswordField passInput =  new  PasswordField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 2);
		
		
		HBox bottomMenu = new HBox();
		bottomMenu.setAlignment(Pos.CENTER);
		bottomMenu.setSpacing(5);
		
		//Buttons
		Button signUp =  new Button("Sign Up");
		signUp.setOnAction( e ->{
			
			//New_Account.createNewAccount();
			window.close();
			
		});
		
		
		Button login =  new Button("Log In");
		login.setOnAction( e ->{
			
			
		});
		
		
		bottomMenu.getChildren().addAll(login,signUp);
		GridPane.setConstraints(bottomMenu, 1, 3);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,bottomMenu);
		
		
		
		layout.setCenter(grid);
		layout.setTop(topMenu);	
		
		window.setTitle("Final Project");
		Scene openingScene =  new Scene(layout,400,200);
		window.setScene(openingScene);
		window.show();
		
	}//start 
		
		
	}//end of Gui Class
