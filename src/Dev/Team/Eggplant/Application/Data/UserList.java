package Dev.Team.Eggplant.Application.Data;

import java.util.ArrayList;
import Dev.Team.Eggplant.Application.User.*;

/**
 * 
 * @author Luis Berdecia 
 * @version Created on July 2020
 * 
 * @category This class will hold all the users for the program using ArrayList
 *
 */

public class UserList {

	
	private ArrayList<Person> Users =  new ArrayList<>();
	
	
	//Default Constructor
	public UserList(){
		
		//No-Args Constructor
		
	}//Constructor
	
	
	//GETTER AND SETTERS

	/** 
	 * @return Users -  The ArrayList that contains the Users
	 */
	
	public ArrayList<Person> getUserList(){
		
		return Users;
		
	}//getUserList
	
	
	/**
	 * @param person -  The person class that will be added
	 * to the ArrayList
	 */
	
	public void addUser(Person person){
		
		Users.add(person);
		
	}//addUser
	
	/**
	 * @param person- The selected user that will be remove from
	 * the ArrayList
	 */
	
	public void removeUser(Person person){
		
		for(int x = 0; x < Users.size(); x++){
			
			if(Users.get(x).equals(person));
			
		}//for loop
		
	}//removeUser
	
	
	
	
}//end of UserList Class
