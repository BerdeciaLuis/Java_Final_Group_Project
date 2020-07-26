package Dev.Team.Eggplant.Application.Gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import Dev.Team.Eggplant.Application.Data.UserList;
import Dev.Team.Eggplant.Application.Database.Database;
import Dev.Team.Eggplant.Application.Reports.Charts;
import Dev.Team.Eggplant.Application.Reports.Reports;
import Dev.Team.Eggplant.Application.User.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will handle the Main Menu of the Program
 *
 */
public class Main_Menu extends Application{
	
	
	//FIELDS//
	private static final long serialVersionUID = 2L;
	private Stage window =  new Stage();
	private BorderPane layout =  new BorderPane();
	private New_Account newAccount =  new New_Account();
	private Edit_Account edit = new Edit_Account();
	private View_Info view = new View_Info();
	
	private TextField searchBar;
	private ChoiceBox<String> searchByOption,filterByType;
	
	private TableView<Person> table;
	TableColumn<Person,String> majorColumn, subjectColumn, hourlyRateColumn;
	TableColumn<Person,Double> gpaColumn;
	TableColumn<Person,Integer> creditsColumn, numOfClassesColumn, officeNumberColumn, yearsOfServiceColumn;
	private FilteredList<Person> filteredPerson;
	public UserList Users = new UserList();
	private Label fromServerMessage;
	private Button reportButton;
	
	private ImageView addUserImage, deleteUserImage;
	private Image addImage, deleteImage;
	private boolean searched = false, deleteUserAnswer;
	private Socket socket;
	private DataOutputStream toServer;
	private DataInputStream fromServer;

	
	//Default Constructor
	public Main_Menu() throws Exception{
		
		new Database().getUsers(Users);
		start(window);
		
		try
		{
			
			socket = new Socket("localhost",8000);
			toServer = new DataOutputStream(socket.getOutputStream());
			fromServer = new DataInputStream(socket.getInputStream());
			
		}//try
		
		catch(Exception e)
		{
			
			AlertBox.errorMessage("- Program was Unable to Connect to Server!");
			fromServerMessage.setText("Could Not Connect to Server!");
			
		}//catch
			
	}//Main_Menu Constructor


	public void start(Stage stage){
		
		try{
			
			stage =  new Stage();
			CloseProgram.closeRequest(stage);
		    setUserAgentStylesheet(STYLESHEET_MODENA);
		    stage.setResizable(false);
			
		    
		    //Top Menu 
		    HBox topMenu =  new HBox();
		    topMenu.setAlignment(Pos.CENTER);
		    Label title =  new Label("School Database");
		    title.setFont(Font.font("Arial Black", FontWeight.BOLD, 18));
			topMenu.setPadding(new Insets(10,10,5,10));
		    topMenu.getChildren().addAll(title);
		    
		    
		    
		    //Center Menu
		    
		    //Name Column
			TableColumn<Person,String> nameColumn = new TableColumn<>("Name");
			nameColumn.setMinWidth(150);
			nameColumn.setEditable(false);
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //has to be the exact name as the property
			
			//Date Of Birth Column
			TableColumn<Person,String> dobColumn = new TableColumn<>("Date Of Birth");
			dobColumn.setMinWidth(100);
			dobColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth")); //has to be the exact name as the property
			
			//Address Column
			TableColumn<Person,String> addressColumn = new TableColumn<>("Address");
			addressColumn.setMinWidth(175);
			addressColumn.setCellValueFactory(new PropertyValueFactory<>("address")); //has to be the exact name as the property
			
			//Gender Column
			TableColumn<Person,String> genderColumn = new TableColumn<>("Gender");
			genderColumn.setMinWidth(50);
			genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender")); //has to be the exact name as the property
			
			//Smoker Info Column
			TableColumn<Person,String> smokerColumn = new TableColumn<>("Smoker");
			smokerColumn.setMinWidth(50);
			smokerColumn.setCellValueFactory(new PropertyValueFactory<>("smokerInfo")); //has to be the exact name as the property
			
			//Occupation Column
			TableColumn<Person,String> typeColumn = new TableColumn<>("Occupation");
			typeColumn.setMinWidth(50);
			typeColumn.setCellValueFactory(new PropertyValueFactory<>("occupation")); //has to be the exact name as the property
		
		
			//Setting up the Table
			table = new TableView<>();
			table.setEditable(false);
			table.setMinHeight(80);
			filteredPerson = new FilteredList<Person>(FXCollections.observableArrayList(Users.getUserList()), p -> true);//Pass the data to a filtered list
		    table.setItems(filteredPerson);
			table.getColumns().addAll(nameColumn,dobColumn,addressColumn,genderColumn,smokerColumn,typeColumn);
			


			//Layout of the Center 
			Label filterLabel = new Label("Filter by:");
			filterByType = new ChoiceBox<>();
		    filterByType.getItems().addAll("All", "Students", "Teachers", "Janitors");
		    filterByType.setValue("All");
		    filterByType.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> filterByType());
		    
		    Button refreshButton =  new Button();
		    refreshButton.setOnAction(e -> refreshButtonClicked());
		    refreshButton.setGraphic(new ImageView(new Image("refresh.png")));
			
		    HBox filterLayout = new HBox();
			filterLayout.setAlignment(Pos.CENTER);
			filterLayout.setSpacing(10);
			filterLayout.getChildren().addAll(filterLabel,filterByType,refreshButton);
		    
			VBox tableLayout = new VBox(10);
			tableLayout.setAlignment(Pos.CENTER);
			tableLayout.getChildren().addAll(filterLayout,table);
			
			
			//Bottom Menu
			
		    searchBar = new TextField();
			searchBar.setPromptText("Search");
			searchBar.setMaxWidth(100);
			searchBar.setOnKeyPressed(e ->{ //Allows the User to Search when they hit the ENTER Key
			
				if(e.getCode().equals(KeyCode.ENTER)){
					
					searchButtonClicked();
					
					}});
					
					
			searchByOption = new ChoiceBox<>();
		    searchByOption.getItems().addAll("Name", "Gender", "Address");
		    searchByOption.setValue("Name");
		    
		    searchByOption.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->{ //resets table and searchBar when new choice is selected
		    	
	            if (newVal != null){
	            	
	                searchBar.setText("");
	                filteredPerson.setPredicate(null);
	                
	            }//if
	            
	            
	        });
		    
			addImage =  new Image("addUser.png");
			addUserImage = new ImageView(addImage);
			
			deleteImage =  new Image("deleteUser.png");
			deleteUserImage = new ImageView(deleteImage);
			
			Button searchButton =  new Button("Search");
			searchButton.setOnAction(e -> {
				
				searchButtonClicked();
				
			});
					
			Button addUserButton =  new Button();
			addUserButton.setGraphic(addUserImage);
			addUserButton.setOnAction(e -> addButtonClicked());

			Button deleteUserButton =  new Button();
			deleteUserButton.setGraphic(deleteUserImage);
			deleteUserButton.setOnAction(e -> deleteButtonClicked());
			
			Button editUserButton = new Button("Edit User");
			editUserButton.setOnAction(e -> editButtonClicked());
			
			Button viewUserButton = new Button("View User");
			viewUserButton.setOnAction(e -> viewButtonClicked());
			
			reportButton = new Button("Generate Users Report");
			reportButton.setOnAction(e -> new Reports().writeAllUsersReport(Users,filterByType.getValue()));
			reportButton.setAlignment(Pos.CENTER_RIGHT);
			
			Button chartButton = new Button();
			chartButton.setOnAction(e -> new Charts().createChart(Users));
			chartButton.setGraphic(new ImageView(new Image("pieChart.png")));
			
			fromServerMessage =  new Label();
			fromServerMessage.setMinWidth(100);
			fromServerMessage.setText("Connecting to Server...");
			
			HBox bottomMenu = new HBox();
			bottomMenu.setPadding(new Insets(10,0,10,10));
			bottomMenu.setSpacing(10);
			bottomMenu.getChildren().addAll(searchByOption,searchBar,searchButton,addUserButton,deleteUserButton,editUserButton,viewUserButton,reportButton,chartButton,fromServerMessage);
		
		
			
			//Border Pane Setup
			layout.setTop(topMenu);
			layout.setCenter(tableLayout);	
			layout.setBottom(bottomMenu);
			
			stage.setTitle("Final Project by Luis Berdecia");
			Scene openingScene =  new Scene(layout,900,500);
			//window.setResizable(false);
			stage.setScene(openingScene);
			stage.show();
			
			
		}//try 
		catch(Exception e){
			
			AlertBox.exceptionMessage(e);
			
		}//catch

		
	}//start 
	
	
	//BUTTON AND CHOICEBOX METHODS//
	
	/**
	 * This method will handle the action of the filterByType ChoiceBox.
	 * It will filter the table based on the occupation the user has selected
	 */
	
	public void filterByType(){
		
		if(filterByType.getValue().equals("All")){
			
			searched = false;
			
		}//if
		
		else{
			
			searched = true;
			
		}//else
		
		
		switch (filterByType.getValue()){
		
			case "Students":
				filteredPerson.setPredicate(p -> p.getOccupation().equals("Student"));
				reportButton.setText("Generate Students Report");
				
				//Major Column
				majorColumn = new TableColumn<>("Major");
				majorColumn.setMinWidth(75);
				majorColumn.setCellValueFactory(new PropertyValueFactory<>("major")); //has to be the exact name as the property
				
				//GPA Column
				gpaColumn = new TableColumn<>("GPA");
				gpaColumn.setMinWidth(60);
				gpaColumn.setCellValueFactory(new PropertyValueFactory<>("gpa")); //has to be the exact name as the property
				
				//Credits Column
				creditsColumn = new TableColumn<>("Credits");
				creditsColumn.setMinWidth(50);
				creditsColumn.setCellValueFactory(new PropertyValueFactory<>("credits")); //has to be the exact name as the property
				table.getColumns().addAll(majorColumn,gpaColumn,creditsColumn);
				table.getColumns().removeAll(subjectColumn,numOfClassesColumn,officeNumberColumn,hourlyRateColumn,yearsOfServiceColumn);
				break;
				
			case "Teachers":
				filteredPerson.setPredicate(p -> p.getOccupation().equals("Teacher"));
				reportButton.setText("Generate Teachers Report");
				
				//Subject Taught Column
				subjectColumn = new TableColumn<>("Subject");
				subjectColumn.setMinWidth(125);
				subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject")); //has to be the exact name as the property
				
				//Number Of Classes Column
				numOfClassesColumn = new TableColumn<>("# of Classes");
				numOfClassesColumn.setMinWidth(50);
				numOfClassesColumn.setCellValueFactory(new PropertyValueFactory<>("numOfClasses")); //has to be the exact name as the property
				
				//Office Number Column
				officeNumberColumn = new TableColumn<>("Office #");
				officeNumberColumn.setMinWidth(50);
				officeNumberColumn.setCellValueFactory(new PropertyValueFactory<>("officeNumber")); //has to be the exact name as the property
				table.getColumns().addAll(subjectColumn,numOfClassesColumn,officeNumberColumn);
				table.getColumns().removeAll(majorColumn,gpaColumn,creditsColumn,hourlyRateColumn,yearsOfServiceColumn);
				
				break;
			case "Janitors":
				filteredPerson.setPredicate(p -> p.getOccupation().equals("Janitor"));
				reportButton.setText("Generate Janitors Report");
				
				//Hourly Rate Column
				hourlyRateColumn = new TableColumn<>("Hourly Rate ($)");
				hourlyRateColumn.setMinWidth(60);
				hourlyRateColumn.setCellValueFactory(new PropertyValueFactory<>("hourlyRate")); //has to be the exact name as the property
				
				//Years of Service Column
				yearsOfServiceColumn = new TableColumn<>("Years of Service");
				yearsOfServiceColumn.setMinWidth(50);
				yearsOfServiceColumn.setCellValueFactory(new PropertyValueFactory<>("yearsOfService")); //has to be the exact name as the property
				table.getColumns().addAll(hourlyRateColumn,yearsOfServiceColumn);
				table.getColumns().removeAll(majorColumn,gpaColumn,creditsColumn,subjectColumn,numOfClassesColumn,officeNumberColumn);
				
				break;
			default: 
				filteredPerson.setPredicate(null); 
				reportButton.setText("Generate Users Report");
				table.getColumns().removeAll(majorColumn,gpaColumn,creditsColumn,subjectColumn,numOfClassesColumn,officeNumberColumn,hourlyRateColumn,yearsOfServiceColumn);
			    break;

		}//switch

		
	}//filterByType
	
	
	/**
	 * This method will handle the action of the refresh button.
	 * It will refresh the table after the user has added a new account
	 */
	
	public void refreshButtonClicked(){
		
		table.getColumns().removeAll(majorColumn,gpaColumn,creditsColumn,subjectColumn,numOfClassesColumn,officeNumberColumn,hourlyRateColumn,yearsOfServiceColumn);
		searchBar.setText("");
		searched = false;
		filteredPerson = new FilteredList<Person>(FXCollections.observableArrayList(Users.getUserList()), p -> true);
		table.setItems(filteredPerson);
		table.refresh();
		
		
	}//refreshedButtonClicked
	
	
	/**
	 * This method will handle the action of the view button.
	 * It will view the info of the selected user in the Table
	 */
	
	public void viewButtonClicked(){
		
		try{
			
				if(searched){
					
					Person selectedPerson = table.getSelectionModel().getSelectedItem();
					
					for(int index = 0; index < filteredPerson.getSource().size(); index++){
						
						if(filteredPerson.getSource().get(index).getName().equals(selectedPerson.getName()) && 
							filteredPerson.getSource().get(index).getAddress().equals(selectedPerson.getAddress())){
							
								
							view.viewAccountInfo(Users.getUserList().get(index));
							break;

						}//if
							
						
						}//for loop
						

				}//if 
				
				else{
						
					view.viewAccountInfo(Users.getUserList().get(table.getSelectionModel().getSelectedIndex()));
					
				}//else
		
			
		}catch(Exception ex){
			
			AlertBox.errorMessage("No User was Selected!!!!!");
			
			}//catch
		
	
	}//viewButtonClicked
	
	
	/**
	 * This method will handle the action of the search button.
	 * It will search depending on what is on the Textfiled searchBar
	 * also depending on the option as well using a FilteredList
	 */
	
	public void searchButtonClicked(){
		
		if(searchBar.getText().equals("")){
			
			searched = false;
			
		}//if
		
		else{
			
			searched = true;
			
		}//else
		
		
		switch (searchByOption.getValue()){
		
			case "Name":
				filteredPerson.setPredicate(p -> p.getName().toString().toLowerCase().contains(searchBar.getText().toLowerCase().trim()));//filter table by name
				break;
			case "Gender":
				filteredPerson.setPredicate(p -> p.getGender().toLowerCase().contains(searchBar.getText().toLowerCase().trim()));//filter table by gender
				break;
			case "Address":
				filteredPerson.setPredicate(p -> p.getAddress().toString().toLowerCase().contains(searchBar.getText().toLowerCase().trim()));//filter table by address
				break;

		}//switch

	
	}//searchButtonClicked

	
	/**
	 * This method will handle the action of the add button.
	 * It will open a new window to create a new account
	 */
	
	public void addButtonClicked(){
	
		newAccount.createNewAccount(Users);

	}//addButtonClicked

	
	/**
	 * This method will handle the action of the edit button.
	 * It will edit the info of the selected user in the Table
	 */
	
	public void editButtonClicked(){
	
		try{
			
		
			if(searched){
			
				Person selectedPerson = table.getSelectionModel().getSelectedItem();
		
				for(int index = 0; index < filteredPerson.getSource().size(); index++){
			
					if(filteredPerson.getSource().get(index).getName().equals(selectedPerson.getName()) && 
							filteredPerson.getSource().get(index).getAddress().equals(selectedPerson.getAddress())){
	

						//toServer.writeUTF(Users.getUserList().get(index)+" Info was Edited!");
						//toServer.flush();
						edit.editAccount(Users, index,table);
						table.refresh();
						//fromServerMessage.setText(fromServer.readUTF());
					

					}//if
				
				}//for loop

			}//if 
	
			
			else{
		
				if(table.getSelectionModel().getSelectedIndex() != -1){
					
					//toServer.writeUTF(Users.getUserList().get(table.getSelectionModel().getSelectedIndex()).getName()+" Info was Edited!");
					//toServer.flush();
					edit.editAccount(Users, table.getSelectionModel().getSelectedIndex(),table);
					table.refresh();
					//fromServerMessage.setText(fromServer.readUTF());

					
				}//if
				
				else{
					
					AlertBox.warningMessage("No User was Selected!!!!!");
					
				}	
				
			}//else
		
			
		}catch(Exception e){
			
			AlertBox.errorMessage("No User was Selected!!!!!");
			
		}//catch

		
		
	}//editButtonClicked
	
	
	/**
	 * This method will handle the action of the delete button.
	 * It will delete the selected user in the Table from the Program
	 */
	
	public void deleteButtonClicked(){
		
		try{
		
			deleteUserAnswer = AlertBox.confirmMessage("Are you sure you want to delete "+table.getSelectionModel().getSelectedItem().getName()+" from the system?");
		
			if(deleteUserAnswer){

				if(searched){
				
					Person selectedPerson = table.getSelectionModel().getSelectedItem();
				
					for(int index = 0; index < filteredPerson.getSource().size(); index++){
					
						if(filteredPerson.getSource().get(index).getName().equals(selectedPerson.getName()) && 
							filteredPerson.getSource().get(index).getAddress().equals(selectedPerson.getAddress())){
						
							//new Database().removeUserFromDatabase(Users, index);
							//toServer.writeUTF(Users.getUserList().get(index).getName()+" was removed from the Program!");
							//toServer.flush();
							Users.getUserList().remove(index);
							filteredPerson.getSource().remove(index);
							fromServerMessage.setText(fromServer.readUTF());
							break;

						}//if
						
					
					}//for loop
						

				}//if 
			
				else{
					
					
					//toServer.writeUTF(Users.getUserList().get(table.getSelectionModel().getSelectedIndex()).getName()+" was removed from the Program!");
					//toServer.flush();
					//new Database().removeUserFromDatabase(Users, table.getSelectionModel().getSelectedIndex());
					Users.getUserList().remove(table.getSelectionModel().getSelectedIndex());
					filteredPerson.getSource().remove(table.getSelectionModel().getSelectedIndex());
					//fromServerMessage.setText(fromServer.readUTF());		
				
				}//else
				
			}//if
	
		
		}catch(Exception ex){
		
			AlertBox.errorMessage("No User was Selected!!!!!");
		
			}//catch
		
			
	}//deleteButtonClicked
	
	

}//end of Main_Menu Class
