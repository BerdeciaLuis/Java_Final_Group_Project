package Dev.Team.Eggplant.Application.Gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;
import Dev.Team.Eggplant.Application.User.*;
import Dev.Team.Eggplant.Application.User.Info.Address;
import Dev.Team.Eggplant.Application.User.Info.Name;
import Dev.Team.Eggplant.Application.User.Info.States;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will handle the create new account of the program
 *
 */

public class New_Account{


	//FIELDS//
	private static Stage window = new Stage();	
	private static States states = new States();
	private static String [] StatesList = new String[57];
	private static Person person;
	private static String[] splitAddress;
	
	
	public static void createNewAccount(){
		
		window.setTitle("Create New Account");
		CloseProgram.closeRequest(window);
		BorderPane layout =  new BorderPane();
		Scene scene2 = new Scene(layout,600,400);
		window.setScene(scene2);
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		window.show();
		
	
		VBox topMenu = new VBox();
		Label newAccountLabel =  new Label("New Account");
		newAccountLabel.setFont(Font.font("Arial Black", FontWeight.BOLD, 18));
		topMenu.getChildren().addAll(newAccountLabel);
		topMenu.setPadding(new Insets(10,10,5,10));
		topMenu.setAlignment(Pos.CENTER);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5,10,10,10));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setAlignment(Pos.TOP_CENTER);
	
		
		//First Name Label
		Label firstNameLabel = new Label("*First Name:");
		firstNameLabel.setMaxWidth(75);
		GridPane.setConstraints(firstNameLabel, 0, 0); 
				
		//First Name Input
		TextField firstNameInput =  new  TextField();
		firstNameInput.setPromptText("First Name");
		GridPane.setConstraints(firstNameInput, 1, 0);
		
		//Middle Name Label
		Label middleNameLabel = new Label("Initial:");
		middleNameLabel.setMaxWidth(45);
		GridPane.setConstraints(middleNameLabel, 2, 0); 
						
		//Middle Name Input
		TextField middleNameInput =  new  TextField();
		middleNameInput.setMaxWidth(30);
		GridPane.setConstraints(middleNameInput, 3, 0);
		
		//Last Name Label
		Label lastNameLabel = new Label("*Last Name:");
		lastNameLabel.setMaxWidth(75);
		GridPane.setConstraints(lastNameLabel, 0, 1); 
								
		//Last Name Input
		TextField lastNameInput =  new  TextField();
		lastNameInput.setPromptText("Last Name");
		GridPane.setConstraints(lastNameInput, 1, 1);
		
		//SSN Label
		Label SSNLabel = new Label("*SSN:");
		GridPane.setConstraints(SSNLabel, 2, 1); 
										
		//SSN Input
		TextField SSNInput =  new  TextField();
		SSNInput.setPromptText("123456789");
		SSNInput.setMaxWidth(75);
		GridPane.setConstraints(SSNInput, 3, 1);
		
		//Gender Label
		Label genderLabel = new Label("Gender:");
		GridPane.setConstraints(genderLabel, 0, 2); 
										
		//Gender Input
		ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();                
		genderChoiceBox.getItems().addAll("M","F","O","U");        
		genderChoiceBox.setValue("U");         
		GridPane.setConstraints(genderChoiceBox, 1, 2);  
		 
		//Date Of Birth Label
		Label dateOfBirthLabel = new Label("*DOB:");
		GridPane.setConstraints(dateOfBirthLabel, 0, 3); 
											
		//Date of Birth Input
		DatePicker date =  new DatePicker();
		date.setValue(LocalDate.now());
		date.setPromptText("Date of Birth");
		GridPane.setConstraints(date, 1, 3);
		
		
		//Type of Person
		HBox radioMenu =  new HBox();
		Label typeLabel = new Label("Choose Occupation:");
		typeLabel.setMaxWidth(115);
		typeLabel.setAlignment(Pos.CENTER);
		GridPane.setConstraints(typeLabel, 0, 4);
		
		
		//Radio Buttons
	    ToggleGroup group = new ToggleGroup();  
	    RadioButton student = new RadioButton("Student");        
	    student.setToggleGroup(group);         
	    student.setSelected(true);
	    student.setMinWidth(50);
	    
	    RadioButton teacher = new RadioButton("Teacher");        
	    teacher.setToggleGroup(group);   
	    teacher.setMinWidth(50);
	   
	    RadioButton janitor = new RadioButton("Janitor");
	    janitor.setToggleGroup(group);
	    janitor.setMinWidth(50);

	    
	    radioMenu.setAlignment(Pos.CENTER);
	    radioMenu.setSpacing(10);
	    radioMenu.getChildren().addAll(student,teacher,janitor);
	    GridPane.setConstraints(radioMenu, 1, 4);
	    
	    
	    //Address Label
	  	Label addressLabel = new Label("*Address:");
	  	GridPane.setConstraints(addressLabel, 0, 6); 
	  										
	  	//Address Input
	  	TextField addressInput =  new  TextField();
	  	addressInput.setPromptText("1234 Imaginary Drive");
	  	GridPane.setConstraints(addressInput, 1, 6);
	  	
	  	//State Label
	  	Label stateLabel = new Label("*State:");
	  	GridPane.setConstraints(stateLabel, 2, 6); 
	  										
	  	//State Input
	  	ChoiceBox<String> stateInput = new ChoiceBox<String>();
	  	states.getStatesCodes(StatesList);
	  	for(int s = 0; s < StatesList.length; s++){
	  		
	  		stateInput.getItems().add(StatesList[s]);
	  		
	  	}//for  
	  	
	
		stateInput.setValue(stateInput.getItems().get(56));       
	  	GridPane.setConstraints(stateInput, 3, 6);
	  	
	    //City Label
	  	Label cityLabel = new Label("*City:");
	  	GridPane.setConstraints(cityLabel, 0, 7); 
	  	
	  	//City Input
	  	TextField cityInput =  new  TextField();
	  	cityInput.setPromptText("Name of the City");
	  	GridPane.setConstraints(cityInput, 1, 7);
	  	
	    //Zip Code Label
	  	Label zipCodeLabel = new Label("*Zip Code:");
	  	GridPane.setConstraints(zipCodeLabel, 2, 7); 
	  	
	  	//Zip Code Input
	  	TextField zipCodeInput =  new  TextField();
	  	zipCodeInput.setPromptText("Zip Code");
	  	zipCodeInput.setMaxWidth(60);
	  	GridPane.setConstraints(zipCodeInput, 3, 7);
	  	
	  	
	  	//Buttons
	  	HBox buttonMenu =  new HBox();
	  	buttonMenu.setAlignment(Pos.CENTER);
	    buttonMenu.setSpacing(10);
	

	    
	  	Button nextButton = new Button("Next");
	  	
	  	nextButton.setOnAction(e ->{
	  		
	  		
	  		
	  		
	  		if(teacher.isSelected()){
	  				
	  			person = new Teacher();
	  				
	  				
	  		}//if
	  			
	  		else if(janitor.isSelected()){
	  			
	  			person = new Janitor();
	  			
	  			
	  		}//else if
	  		
	  		
	  		else{
	  			
	  			person = new Student();
	  			person.setName(new Name(firstNameInput.getText(),middleNameInput.getText(),lastNameInput.getText()));
	  			person.setDateOfBirth(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	  			person.setSSN(SSNInput.getText().trim());
	  			person.setGender(genderChoiceBox.getValue());
	  			
	  			if(!addressInput.getText().equals("")){
	  			splitAddress = addressInput.getText().split(" ");
	  			person.setAddress(new Address(splitAddress[0],splitAddress[1],splitAddress[2],cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));
	  			
	  			}//if
	  			
	  			else{person.setAddress(new Address("","","",cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));}
	  			
	  			if(!(ErrorManager.infoNotCompleted())){
	  				
	  				System.out.println("Everything was completed!!");
	  				
	  			}//if
	  			
	  		}//else
	  		  		
	  		
	  	});//nextButton
	  			
	  			
	  	Button backButton = new Button("Back");
	  	
	  	 backButton.setOnAction(e ->{
	  		
	  		window.close();
	  	
	  		try{
	  			
				new Login_Menu();
				
			}catch (Exception ex){
				
				AlertBox.exceptionMessage(ex);
				
			}//try
	  		
	  	});//backButton
	  	
	  	
	  	buttonMenu.getChildren().addAll(nextButton,backButton);
	  	GridPane.setConstraints(buttonMenu, 1, 8);
	  
		grid.getChildren().addAll(firstNameLabel,firstNameInput,middleNameLabel,middleNameInput,lastNameLabel,lastNameInput,SSNLabel,SSNInput,genderLabel,genderChoiceBox);
		grid.getChildren().addAll(dateOfBirthLabel,date,typeLabel,radioMenu,addressLabel,addressInput,cityLabel,cityInput,stateLabel,stateInput,zipCodeLabel,zipCodeInput,buttonMenu);
	
		layout.setTop(topMenu);
		layout.setCenter(grid);
		
		
		
	}//createNewAccount
	
	
	
}
