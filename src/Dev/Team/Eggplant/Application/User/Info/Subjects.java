package Dev.Team.Eggplant.Application.User.Info;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will have the list of available subjects in the program
 *
 */
public class Subjects {

	//FIELDS//
	private ArrayList<String> listOfSubjects = new ArrayList<>();

	//Default Constructor
	public Subjects(){
			
		listOfSubjects.add("English");
		listOfSubjects.add("Algebra");
		listOfSubjects.add("Geometry");
		listOfSubjects.add("Calculus");
		listOfSubjects.add("Physics");
		listOfSubjects.add("Chemistry");
		listOfSubjects.add("Java Programming");
		listOfSubjects.add("U.S History");
		listOfSubjects.add("International Politics");
		listOfSubjects.add("Intro To Criminology");
		listOfSubjects.add("Intro To Biology");
		listOfSubjects.add("Humanities");
		listOfSubjects.add("Statistics");
		listOfSubjects.add("Drama");
		listOfSubjects.add("Spanish");
		listOfSubjects.add("French");
		listOfSubjects.add("Japanese");
		listOfSubjects.add("U.S Governement");
		listOfSubjects.add("Intro to Psychology");
		listOfSubjects.add("Web Design");
		listOfSubjects.add("Physical Fitness");
		listOfSubjects.add("Digital Media");;
			
	}//Constructor

		
	//METHODS//
		
	/**
	 * This generic Method will sort the list
	 */
	
	public <T> void sortList(){
			
			Collections.sort(listOfSubjects);
			
	}//sortList
		
		
	/**
	 * @return list of subjects available in the school
	 */
		
	public ArrayList<String> getListOfSubjects(){
			
		sortList();
			
		return listOfSubjects;
			
	}//getListOfSubjects
	
}
