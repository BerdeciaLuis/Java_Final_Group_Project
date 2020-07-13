package Dev.Team.Eggplant.Application.Data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	
	public ArrayList<Person> Users =  new ArrayList<>();
	
	
	//Default Constructor
	public UserList(){
		
		//No-Args Constructor
		
	}//Constructor
	
	
	//GETTER AND SETTERS

	public ArrayList<Person> getUserList(){
		
		return Users;
		
	}//getUserList
	
	
	public void addUser(Person person){
		
		Users.add(person);
		
	}//addUser
	
	
	public void removeUser(Person person){
		
		for(int x = 0; x < Users.size(); x++){
			
			if(Users.get(x).getSSN().equals(person));
			JOptionPane.showMessageDialog(null, "User was removed from the System", "Server", 1);
			
		}//for loop
		
	}//removeUser
	
	
	
	
}//end of UserList Class
