package Dev.Team.Eggplant.Application.Reports;

import Dev.Team.Eggplant.Application.Data.UserList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will be in charge of creating charts to display the statistics
 *
 */

public class Charts {

	
	//FIELDS//
	private Stage window;
	private Statistics stats;
	private ChoiceBox<String> filterByType;
	private PieChart chart;
	private ObservableList<PieChart.Data> pieChartData;
	
	
	//Default Constructor
	public Charts(){
		
		//No-Args Constructor
		
	}//Constructor
	
	
	/**
	 * This method will create a PieChart that will display
	 * the statistics of the following type
	 * - Ocupation
	 * - Gender
	 * - Smoker Info
	 * 
	 * @param users - The ArrayList that holds all the Users of the Program
	 */
	
	public void createChart(UserList users){
		
		window =  new Stage();
		window.setTitle("Statistics Report");
		window.getIcons().add(new Image("pieChart.png"));
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		BorderPane layout = new BorderPane();
		VBox root = new VBox();
		Scene scene = new Scene(layout,500,500);
		window.setScene(scene);
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		window.show();
			
		stats =  new Statistics(users);
		chart = new PieChart();
		pieChartData =FXCollections.observableArrayList(new PieChart.Data("", 100));
		chart.setData(pieChartData);
		chart.setTitle("Select Type");
		
		
		//Layout of the Center 
		Label filterLabel = new Label("Filter by:");
		filterByType = new ChoiceBox<>();
	    filterByType.getItems().addAll("Occupation", "Gender", "Smoker Info");
	    filterByType.setValue("");
		
	    HBox filterLayout = new HBox();
		filterLayout.setAlignment(Pos.BOTTOM_CENTER);
		filterLayout.setSpacing(10);
		filterLayout.getChildren().addAll(filterLabel,filterByType);
		
		filterByType.setOnAction(e ->{
			
			if(filterByType.getValue().equals("Gender")){
				
					pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("M ("+(stats.getGenderAmount("M")*100)/users.getUserList().size()+"%)", stats.getGenderAmount("M")),
	                new PieChart.Data("F ("+(stats.getGenderAmount("F")*100)/users.getUserList().size()+"%)", stats.getGenderAmount("F")),
	                new PieChart.Data("U ("+(stats.getGenderAmount("U")*100)/users.getUserList().size()+"%)", stats.getGenderAmount("U")),
	                new PieChart.Data("O ("+(stats.getGenderAmount("O")*100)/users.getUserList().size()+"%)", stats.getGenderAmount("O")));
	   
					chart.setData(pieChartData);
					chart.setTitle(filterByType.getValue());
					chart.setLayoutX(-50);
					
					
			}//if
			
			else if(filterByType.getValue().equals("Smoker Info")){
				
					pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Yes ("+(stats.getSmokerAmount("Yes")*100)/users.getUserList().size()+"%)", stats.getSmokerAmount("Yes")),
	                new PieChart.Data("No ("+(stats.getSmokerAmount("No")*100)/users.getUserList().size()+"%)", stats.getSmokerAmount("No")));
	   
					chart.setData(pieChartData);
					chart.setTitle(filterByType.getValue());
					chart.setLayoutX(-50);
					
					
			}//else if

			else if(filterByType.getValue().equals("Occupation")){
	
					pieChartData =
					FXCollections.observableArrayList(
					new PieChart.Data("Student ("+(stats.getOccupationAmount("Student")*100)/users.getUserList().size()+"%)", stats.getOccupationAmount("Student")),
					new PieChart.Data("Teacher ("+(stats.getOccupationAmount("Teacher")*100)/users.getUserList().size()+"%)", stats.getOccupationAmount("Teacher")),
					new PieChart.Data("Janitor ("+(stats.getOccupationAmount("Janitor")*100)/users.getUserList().size()+"%)", stats.getOccupationAmount("Janitor")));

					chart.setData(pieChartData);
					chart.setTitle(filterByType.getValue());
					chart.setLayoutX(-50);
		
		
			}//else if
			
			
		});//filteyByType setOnAction
	 
	    root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(filterLayout,chart);
	  	layout.setCenter(root);
	  	
		
	}//createChart
	
	
}//end of Charts Class
