package Dev.Team.Eggplant.Application.User.Info;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Luis Berdecia 
 * @version Created on July 2020
 * 
 * @category This class will have the list of available majors in the program
 */

public class Majors {

	//FIELDS//
	private ArrayList<String> listOfMajors = new ArrayList<>();

	//Default Constructors
	public Majors(){
		
		listOfMajors.add("General Studies");
		listOfMajors.add("Computer Science");
		listOfMajors.add("Communications");
		listOfMajors.add("Political Science");
		listOfMajors.add("Business");
		listOfMajors.add("Economics");
		listOfMajors.add("English Literature");
		listOfMajors.add("Nursing");
		listOfMajors.add("Chemical Engineering");
		listOfMajors.add("Psychology");
		listOfMajors.add("Biology");
		listOfMajors.add("Criminology");
		listOfMajors.add("Accounting");
			
	}//constructor
	
	
	//METHODS//
	
	/**
	 * This generic method will sort the list
	 */
	
	public <T> void sortList(){
		
		Collections.sort(listOfMajors);
		
	}
	
	
	/**
	 * @return list of majors available in the school
	 */
	
	public ArrayList<String> getListOfMajors(){
			
		sortList();
		
		return listOfMajors;
		
	}//getListOfMajors
	
	
	
	
}//end of Majors Class
