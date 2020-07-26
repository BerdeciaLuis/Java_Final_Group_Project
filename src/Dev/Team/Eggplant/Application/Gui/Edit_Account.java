package Dev.Team.Eggplant.Application.Gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Dev.Team.Eggplant.Application.Data.UserList;
import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;
import Dev.Team.Eggplant.Application.User.*;
import Dev.Team.Eggplant.Application.User.Info.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will be creating the Gui and Editing the Selected
 * Users Information.
 *
 */

public class Edit_Account {
	

	//FIELDS//
	private Stage window;	
	private States states = new States();
	private String [] StatesList = new String[56];
	private DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private String[] splitAddress;
	private boolean updateInfo;
	private Subjects subjects = new Subjects();
	private Majors majors = new Majors();
	
	//Person Info
	private Label firstNameLabel,middleNameLabel,lastNameLabel,smokerInfoLabel,genderLabel,dateOfBirthLabel,addressLabel,cityLabel,zipCodeLabel,stateLabel;
	private TextField firstNameInput,middleNameInput,lastNameInput,addressInput,cityInput,zipCodeInput;
	private DatePicker date;
	private ChoiceBox<String> genderChoiceBox,stateInput;
	private ComboBox<String> smokerInfoInput;
	
	//Student Info
	private Label majorLabel,creditsLabel,gpaLabel;
	private TextField creditsInput,gpaInput;
	private ChoiceBox<String> majorInput;
	
	//Teacher Info
	private Label subjectLabel, numOfClassesLabel, officeNumberLabel;
	private TextField numOfClassesInput, officeNumberInput;
	private ChoiceBox<String> subjectInput;
	
	//Janitor Info
	private Label hourlyRateLabel, yearsOfServiceLabel;
	private TextField hourlyRateInput, yearsOfServiceInput;
	
	
	//Default Constructor
	public Edit_Account(){
		
		//No-Args Constructor
		
	}//Constructor
	

	/**
	 * The method will create the GUI for the Edit Account Class
	 * @param user -  The ArrayList that holds the Users of the Program
	 * @param index - The location of the targeted User in the ArrayList
	 * @param table - The TableView that will be refreshed after Editing an Account
	 */
	
	public void editAccount(UserList user, int index, TableView<Person> table){
		
		window =  new Stage();
		window.setTitle("Edit Account");
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		BorderPane layout =  new BorderPane();
		Scene scene = new Scene(layout,600,400);
		window.setScene(scene);
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		window.show();
		
	
		//Layout for the Top Menu
		VBox topMenu = new VBox();
		Label newAccountLabel =  new Label("Edit Account");
		newAccountLabel.setFont(Font.font("Arial Black", FontWeight.BOLD, 18));
		topMenu.getChildren().addAll(newAccountLabel);
		topMenu.setPadding(new Insets(10,10,5,10));
		topMenu.setAlignment(Pos.CENTER);
		
		//Layout for the Center Menu
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5,10,10,10));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setAlignment(Pos.TOP_CENTER);
	
		
		//First Name Label
		firstNameLabel = new Label("*First Name:");
		firstNameLabel.setMaxWidth(75);
		GridPane.setConstraints(firstNameLabel, 0, 0); 
				
		//First Name Input
		firstNameInput =  new  TextField();
		firstNameInput.setPromptText("First Name");
		firstNameInput.setText(user.getUserList().get(index).getName().getFirstName());
		GridPane.setConstraints(firstNameInput, 1, 0);
		
		//Middle Name Label
		middleNameLabel = new Label("Initial:");
		middleNameLabel.setMaxWidth(45);
		GridPane.setConstraints(middleNameLabel, 2, 0); 
						
		//Middle Name Input
		middleNameInput =  new  TextField();
		middleNameInput.setMaxWidth(30);
		middleNameInput.setText(user.getUserList().get(index).getName().getMiddleInitial());
		GridPane.setConstraints(middleNameInput, 3, 0);
		
		//Last Name Label
		lastNameLabel = new Label("*Last Name:");
		lastNameLabel.setMaxWidth(75);
		GridPane.setConstraints(lastNameLabel, 0, 1); 
								
		//Last Name Input
		lastNameInput =  new  TextField();
		lastNameInput.setPromptText("Last Name");
		lastNameInput.setText(user.getUserList().get(index).getName().getLastName());
		GridPane.setConstraints(lastNameInput, 1, 1);
		
		//SmokerInfo Label
		smokerInfoLabel = new Label("Smoker:");
		GridPane.setConstraints(smokerInfoLabel, 2, 1); 
										
		//SmokerInfo Input
		smokerInfoInput = new ComboBox<>();
		smokerInfoInput.setValue(user.getUserList().get(index).getSmokerInfo());
		smokerInfoInput.getItems().addAll("Yes","No");
		smokerInfoInput.setMaxWidth(75);
		GridPane.setConstraints(smokerInfoInput, 3, 1);
		
		//Gender Label
		genderLabel = new Label("Gender:");
		GridPane.setConstraints(genderLabel, 0, 2); 
										
		//Gender Input
		genderChoiceBox = new ChoiceBox<String>();                
		genderChoiceBox.getItems().addAll("M","F","O","U");        
		genderChoiceBox.setValue(user.getUserList().get(index).getGender());         
		GridPane.setConstraints(genderChoiceBox, 1, 2);  
		 
		//Date Of Birth Label
		dateOfBirthLabel = new Label("*DOB:");
		GridPane.setConstraints(dateOfBirthLabel, 0, 3); 
											
		//Date of Birth Input
		date =  new DatePicker();
		date.setValue(LocalDate.parse(user.getUserList().get(index).getDateOfBirth(), dtf));
		date.setPromptText("Date of Birth");
		GridPane.setConstraints(date, 1, 3);
	 
		
	    //Address Label
	  	addressLabel = new Label("*Address:");
	  	GridPane.setConstraints(addressLabel, 0,4); 
	  										
	  	//Address Input
	  	addressInput =  new  TextField();
	  	addressInput.setPromptText("1234 Imaginary Drive");
	  	addressInput.setText(user.getUserList().get(index).getAddress().getStreetNumber()+" "+user.getUserList().get(index).getAddress().getStreetName()+" "
	  	+user.getUserList().get(index).getAddress().getStreetType());
	  	GridPane.setConstraints(addressInput, 1, 4);
	  	
	  	//State Label
	  	stateLabel = new Label("*State:");
	  	GridPane.setConstraints(stateLabel, 2, 4); 
	  										
	  	//State Input
	  	stateInput = new ChoiceBox<String>();
	  	states.getStatesCodesList(StatesList);
	  	for(int s = 0; s < StatesList.length; s++){
	  		
	  		stateInput.getItems().add(StatesList[s]);
	  		
	  	}//for  
	  	
	    stateInput.setValue(user.getUserList().get(index).getAddress().getStateCode().getStatesCode());
	  	GridPane.setConstraints(stateInput, 3, 4);
	  	
	    //City Label
	  	cityLabel = new Label("*City:");
	  	GridPane.setConstraints(cityLabel, 0,5); 
	  	
	  	//City Input
	  	cityInput =  new  TextField();
	  	cityInput.setPromptText("Name of the City");
	  	cityInput.setText(user.getUserList().get(index).getAddress().getCity());
	  	GridPane.setConstraints(cityInput, 1, 5);
	  	
	    //Zip Code Label
	  	zipCodeLabel = new Label("*Zip Code:");
	  	GridPane.setConstraints(zipCodeLabel, 2, 5); 
	  	
	  	//Zip Code Input
	  	zipCodeInput =  new  TextField();
	  	zipCodeInput.setPromptText("Zip Code");
	  	zipCodeInput.setMaxWidth(60);
	  	zipCodeInput.setText(user.getUserList().get(index).getAddress().getZipCode());
	  	GridPane.setConstraints(zipCodeInput, 3, 5);
	  	
	  	if(user.getUserList().get(index).getOccupation().equals("Student")){
	  		
	  		//Major Label
			majorLabel = new Label("*Major:");
			GridPane.setConstraints(majorLabel, 0, 6); 
							
			//Major Input
		  	majorInput = new ChoiceBox<String>();
		  	for(int m = 0; m < majors.getListOfMajors().size(); m++){
		  		
		  		majorInput.getItems().add(majors.getListOfMajors().get(m));
		  		
		  	}//for  
		    majorInput.setValue(((Student) user.getUserList().get(index)).getMajor());
			GridPane.setConstraints(majorInput, 1, 6);
				

			//GPA Label
			gpaLabel = new Label("*GPA:");
			GridPane.setConstraints(gpaLabel, 0, 7); 
									
			//GPA Input
			gpaInput =  new  TextField();
			gpaInput.setMaxWidth(50);
			gpaInput.setPromptText("GPA");
			gpaInput.setText(String.valueOf(((Student)user.getUserList().get(index)).getGpa()));
			GridPane.setConstraints(gpaInput, 1, 7);
					
			//Credits Label
			creditsLabel = new Label("*Credits:");
			GridPane.setConstraints(creditsLabel, 2, 7); 
											
			//Credits Input
			creditsInput =  new  TextField();
			creditsInput.setMaxWidth(60);
			creditsInput.setPromptText("Credits");
			creditsInput.setText(String.valueOf(((Student)user.getUserList().get(index)).getCredits()));
			GridPane.setConstraints(creditsInput, 3, 7);
			
			grid.getChildren().addAll(majorLabel,majorInput,gpaLabel,gpaInput,creditsLabel,creditsInput);
	  		
	  	}//if 
	  	
	  	else if(user.getUserList().get(index).getOccupation().equals("Teacher")){
	  		
	  		
	  		//Subject Taught Label
			subjectLabel = new Label("*Subject:");
			GridPane.setConstraints(subjectLabel, 0, 6); 
							
			//Subject Teaching Input
		  	subjectInput = new ChoiceBox<String>();
		  	for(int s = 0; s < subjects.getListOfSubjects().size(); s++){
		  		
		  		subjectInput.getItems().add(subjects.getListOfSubjects().get(s));
		  		
		  	}//for  
		    subjectInput.setValue(((Teacher) user.getUserList().get(index)).getSubject());
			GridPane.setConstraints(subjectInput, 1, 6);
				
			
			//Number Of Classes Teaching Label
			numOfClassesLabel = new Label("*# of Classes:");
			GridPane.setConstraints(numOfClassesLabel, 0, 7); 
									
			//Number Of Classes Input
			numOfClassesInput =  new  TextField();
			numOfClassesInput.setMaxWidth(50);
			numOfClassesInput.setText(String.valueOf(((Teacher)user.getUserList().get(index)).getNumOfClasses()));
			GridPane.setConstraints(numOfClassesInput, 1, 7);
					
			//Office Number Label
			officeNumberLabel = new Label("*Office #:");
			GridPane.setConstraints(officeNumberLabel, 2, 7); 
											
			//Office Number Input
			officeNumberInput =  new  TextField();
			officeNumberInput.setMaxWidth(50);
			officeNumberInput.setText(((Teacher)user.getUserList().get(index)).getOfficeNumber());
			GridPane.setConstraints(officeNumberInput, 3, 7);
			
			grid.getChildren().addAll(subjectLabel,subjectInput,numOfClassesLabel,numOfClassesInput,officeNumberLabel,officeNumberInput);
	  		
	  		
	  	}//else if
	  	
	  	
	  	else if (user.getUserList().get(index).getOccupation().equals("Janitor")){
	  		
	  		//Hourly Rate Label
			hourlyRateLabel = new Label("*Hourly Rate:");
			GridPane.setConstraints(hourlyRateLabel, 0, 6); 
							
			//Hourly Rate Input
		  	hourlyRateInput =  new TextField();
		  	hourlyRateInput.setMaxWidth(50);
		  	hourlyRateInput.setText(((Janitor)user.getUserList().get(index)).getHourlyRate().substring(1));
			GridPane.setConstraints(hourlyRateInput, 1, 6);
			
			//Years Of Service Label
			yearsOfServiceLabel = new Label("*Years of Service:");
			GridPane.setConstraints(yearsOfServiceLabel, 2, 6); 
									
			//Years Of Service Input
			yearsOfServiceInput =  new  TextField();
			yearsOfServiceInput.setMaxWidth(50);
			yearsOfServiceInput.setText(String.valueOf(((Janitor)user.getUserList().get(index)).getYearsOfService()));
			GridPane.setConstraints(yearsOfServiceInput, 3, 6);
	  		
			grid.getChildren().addAll(hourlyRateLabel,hourlyRateInput,yearsOfServiceLabel,yearsOfServiceInput);
			
	  		
	  	}//else if

	  	
	  	//Buttons and Layout for the Bottom Menu
	  	HBox buttonMenu =  new HBox();
	  	buttonMenu.setAlignment(Pos.CENTER);
	    buttonMenu.setSpacing(10);
	  	Button updateButton = new Button("Update");
	  	updateButton.setOnAction(e -> handleUpdateAccount(user, index, table));		
	  	Button backButton = new Button("Back");
	  	backButton.setOnAction(e -> window.close());//backButton
	  	buttonMenu.getChildren().addAll(updateButton,backButton);
	  	GridPane.setConstraints(buttonMenu, 1, 8);
	  	
	  
		grid.getChildren().addAll(firstNameLabel,firstNameInput,middleNameLabel,middleNameInput,lastNameLabel,lastNameInput,smokerInfoLabel,smokerInfoInput,genderLabel,genderChoiceBox);
		grid.getChildren().addAll(dateOfBirthLabel,date,addressLabel,addressInput,cityLabel,cityInput,stateLabel,stateInput,zipCodeLabel,zipCodeInput,buttonMenu);
	
		layout.setTop(topMenu);
		layout.setCenter(grid);
		
		
	}//editAccount
	
	
	
	/**
	 * This method will handle updating the info of the User
	 * 
	 * @param user - The ArrayList that contains the users for the Program
	 * @param index - The index where the targeted user is located in the ArrayList
	 * @param table - The TableView that will be updated after editing the User
	 */
	
	public void handleUpdateAccount(UserList user,int index, TableView<Person> table){
		
		
			if(user.getUserList().get(index).getOccupation().equals("Student")){
			
						Student student = new Student();
						student = (Student)user.getUserList().get(index);
						student.setName(new Name(firstNameInput.getText(),middleNameInput.getText(),lastNameInput.getText()));
  						student.setDateOfBirth(date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
  						student.setGender(genderChoiceBox.getValue());
  						student.setSmokerInfo(smokerInfoInput.getValue());
  						splitAddress = addressInput.getText().split(" ");
  			
  				if(!(addressInput.getText().equals("")) && splitAddress.length == 3){
  			
  						student.setAddress(new Address(splitAddress[0],splitAddress[1],splitAddress[2],cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));
  			
  				}//if
  			
  				else{student.setAddress(new Address("","","",cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));} //else
  				
  						student.setMajor(majorInput.getValue());
  						student.setGPA(gpaInput.getText());
  						student.setCredits(creditsInput.getText());
  			
  				if(!(ErrorManager.infoNotCompleted())){
  				
  					updateInfo = AlertBox.confirmMessage("Would you like to update "+student.getName()+"'s information to the following:\n\n"+student.toString());
  				
  					if(updateInfo){
  						
  						user.getUserList().remove(index);
  						user.getUserList().add(index, student);
  						window.close();
  						table.refresh();
  
  					}//if
  				
  				}//if
			
			
			}//if
		
			
			if(user.getUserList().get(index).getOccupation().equals("Teacher")){
			
						Teacher teacher = new Teacher();
						teacher = (Teacher)user.getUserList().get(index);
						teacher.setName(new Name(firstNameInput.getText(),middleNameInput.getText(),lastNameInput.getText()));
						teacher.setDateOfBirth(date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
						teacher.setGender(genderChoiceBox.getValue());
						teacher.setSmokerInfo(smokerInfoInput.getValue());
						splitAddress = addressInput.getText().split(" ");
  			
				if(!(addressInput.getText().equals("")) && splitAddress.length == 3){
  			
  						teacher.setAddress(new Address(splitAddress[0],splitAddress[1],splitAddress[2],cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));
  			
  				}//if
  			
  				else{teacher.setAddress(new Address("","","",cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));} //else
  			
  						teacher.setSubject(subjectInput.getValue());
  						teacher.setNumOfClasses(numOfClassesInput.getText());
  						teacher.setOfficeNumber(officeNumberInput.getText());
  			
  				if(!(ErrorManager.infoNotCompleted())){
  				
  						updateInfo = AlertBox.confirmMessage("Would you like to update "+teacher.getName()+"'s information to the following:\n\n"+teacher.toString());
  				
  				if(updateInfo){
  					
  					user.getUserList().remove(index);
  					user.getUserList().add(index, teacher);
  					window.close();
  					table.refresh();
  					
  				}//if
  				
  			}//if
			
			
		}//if
		

			if(user.getUserList().get(index).getOccupation().equals("Janitor")){
	
					Janitor janitor = new Janitor();
					janitor = (Janitor)user.getUserList().get(index);
					janitor.setName(new Name(firstNameInput.getText(),middleNameInput.getText(),lastNameInput.getText()));
					janitor.setDateOfBirth(date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
					janitor.setGender(genderChoiceBox.getValue());
					janitor.setSmokerInfo(smokerInfoInput.getValue());
					splitAddress = addressInput.getText().split(" ");
		
				if(!(addressInput.getText().equals("")) && splitAddress.length == 3){
		
					janitor.setAddress(new Address(splitAddress[0],splitAddress[1],splitAddress[2],cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));
		
				}//if
		
				else{janitor.setAddress(new Address("","","",cityInput.getText(),new States(stateInput.getValue()),zipCodeInput.getText()));} //else
		
					janitor.setHourlyRate(hourlyRateInput.getText());
					janitor.setYearsOfService(yearsOfServiceInput.getText());
		
				if(!(ErrorManager.infoNotCompleted())){
			
					updateInfo = AlertBox.confirmMessage("Would you like to update "+janitor.getName()+"'s information to the following:\n\n"+janitor.toString());
			
				if(updateInfo){
				
					user.getUserList().remove(index);
					user.getUserList().add(index, janitor);
					window.close();
					table.refresh();
					
					}//if
			
				}//if
	
	
			}//if
		
			
	}//handleUpdateAccount
	

}//end of Edit_Account
