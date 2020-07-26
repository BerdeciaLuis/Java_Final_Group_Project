package Dev.Team.Eggplant.Application.Reports;

import java.io.PrintWriter;

import Dev.Team.Eggplant.Application.Data.UserList;
import Dev.Team.Eggplant.Application.Gui.AlertBox;
import Dev.Team.Eggplant.Application.User.*;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class is in charge of creating reports and sending them to a txt file
 * 
 *
 */
public class Reports {
	
	//FIELDS//
	private String fileName;
	private PrintWriter outputStream;
	private Statistics stats;
	private int count = 0;
	
	
	//Default Constructor
	public Reports(){
		
		//No-Args Constructor
		
	}//Constructor
	
	/**
	 * This method will create a report for only one selected person
	 * from the program
	 * 
	 * @param person -  Person's report that will be sent to a txt File
	 */
	
	public void  writeUserReport(Person person){
		
		fileName = person.getName().getLastName()+"'s Report.txt";
		
		try{
			
			outputStream = new PrintWriter(fileName);
			outputStream.println(person.toString());
			outputStream.close();
			
			AlertBox.infoMessage("- "+fileName+ " was generated!");
			
			
		}catch(Exception e){
			
			AlertBox.errorMessage("- File Not Found!!!");
			
		}//catch
		
		
	}//writeUserReport
	
	/**
	 * This method will create a report for all the users depending on the 
	 * selection in the Filter By in the Main_Menu Class
	 * 
	 * @param user - ArrayList that holds all the users in the Program
	 * @param selection - They type of Occuaption selected
	 */
	
	public void writeAllUsersReport(UserList user, String selection){
		
		try{
			
				stats= new Statistics(user);
				double gpa = 0.0;
			
			if(selection.equals("Students")){
				
					fileName = "StudentReports.txt";
					outputStream = new PrintWriter(fileName);
					outputStream.println("                 Student Reports                     ");
					outputStream.println("-----------------------------------------------------");
				
				
				for(int z = 0; z < user.getUserList().size(); z++){
				
					if(user.getUserList().get(z).getOccupation().equals("Student")){
					
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Major: "+((Student)user.getUserList().get(z)).getMajor());
						outputStream.println("GPA: "+((Student)user.getUserList().get(z)).getGpa());
						outputStream.println("Credits: "+((Student)user.getUserList().get(z)).getCredits()+"/130");
						outputStream.println("-----------------------------------------------------");
						count++;
						gpa += ((Student)user.getUserList().get(z)).getGpa();
					
					}//if
				
				
				}//for loop
				
					
						outputStream.println("\n                Student Statistics                   ");
						outputStream.println(  "-----------------------------------------------------");
						outputStream.println("Students Currently in the Program: "+count);
						outputStream.println("\nGPA Average: "+String.format("%.2f",gpa/count));
						outputStream.println(  "-----------------------------------------------------");
						count = 0;
				
			}//if(selection)
			
			else if(selection.equals("Teachers")){
				
					fileName = "TeacherReports.txt";
					outputStream = new PrintWriter(fileName);
					outputStream.println("                 Teacher Reports                     ");
					outputStream.println("-----------------------------------------------------");
				
				
				for(int z = 0; z < user.getUserList().size(); z++){
				
					if(user.getUserList().get(z).getOccupation().equals("Teacher")){
					
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Subject Teaching: "+((Teacher)user.getUserList().get(z)).getSubject());
						outputStream.println("Number of Classes: "+((Teacher)user.getUserList().get(z)).getNumOfClasses());
						outputStream.println("Office Number: "+((Teacher)user.getUserList().get(z)).getOfficeNumber());
						outputStream.println("-----------------------------------------------------");
					
					}//if
				
				
				}//for loop
				
				
			}//else if(selection)
			
			
			else if(selection.equals("Janitors")){
				
						fileName = "JanitorReports.txt";
						outputStream = new PrintWriter(fileName);
						outputStream.println("                 Janitor Reports                     ");
						outputStream.println("-----------------------------------------------------");
			
			
				for(int z = 0; z < user.getUserList().size(); z++){
			
					if(user.getUserList().get(z).getOccupation().equals("Janitor")){
				
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Hourly Rate: "+((Janitor)user.getUserList().get(z)).getHourlyRate());
						outputStream.println("Years of Service: "+((Janitor)user.getUserList().get(z)).getYearsOfService());
						outputStream.println("-----------------------------------------------------");
				
					}//if
			
			
				}//for loop
			
			
			}//else if(selection)
			
			
			else if (selection.equals("All")){
						
						fileName = "AllUserReports.txt";
						outputStream = new PrintWriter(fileName);
						outputStream.println("                 AllUser Reports                     ");
						outputStream.println("-----------------------------------------------------");
	
	
				for(int z = 0; z < user.getUserList().size(); z++){
					
					if(user.getUserList().get(z).getOccupation().equals("Student")){
						
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Occupation: "+user.getUserList().get(z).getOccupation());
						outputStream.println("Major: "+((Student)user.getUserList().get(z)).getMajor());
						outputStream.println("GPA: "+((Student)user.getUserList().get(z)).getGpa());
						outputStream.println("Credits: "+((Student)user.getUserList().get(z)).getCredits()+"/130");
						outputStream.println("-----------------------------------------------------");
		
					}//if
					
					else if(user.getUserList().get(z).getOccupation().equals("Teacher")){
						
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Occupation: "+user.getUserList().get(z).getOccupation());
						outputStream.println("Subject Teaching: "+((Teacher)user.getUserList().get(z)).getSubject());
						outputStream.println("Number of Classes: "+((Teacher)user.getUserList().get(z)).getNumOfClasses());
						outputStream.println("Office Number: "+((Teacher)user.getUserList().get(z)).getOfficeNumber());
						outputStream.println("-----------------------------------------------------");
		
					}//else if
					
					else if(user.getUserList().get(z).getOccupation().equals("Janitor")){
						
						outputStream.println("Name: "+user.getUserList().get(z).getName());
						outputStream.println("Gender: "+user.getUserList().get(z).getGender());
						outputStream.println("DOB(MM/DD/YYYY): "+user.getUserList().get(z).getDateOfBirth());
						outputStream.println("Smoker: "+user.getUserList().get(z).getSmokerInfo());
						outputStream.println("\nAddress: "+user.getUserList().get(z).getAddress()+"\n");
						outputStream.println("Occupation: "+user.getUserList().get(z).getOccupation());
						outputStream.println("Hourly Rate: "+((Janitor)user.getUserList().get(z)).getHourlyRate());
						outputStream.println("Years of Service: "+((Janitor)user.getUserList().get(z)).getYearsOfService());
						outputStream.println("-----------------------------------------------------");
		
					}//else if
					
	
					
	
				}//for loop
				
				outputStream.println("\n                AllUser Statistics                   ");
				outputStream.println(  "-----------------------------------------------------");
				outputStream.println("Users Currently in the Program: "+user.getUserList().size());
				outputStream.println("\nOccupation: ");
				outputStream.println("Student: "+stats.getOccupationAmount("Student")+" ("+(stats.getOccupationAmount("Student")*100)/user.getUserList().size()+"%)");
				outputStream.println("Teacher: "+stats.getOccupationAmount("Teacher")+" ("+(stats.getOccupationAmount("Teacher")*100)/user.getUserList().size()+"%)");
				outputStream.println("Janitor: "+stats.getOccupationAmount("Janitor")+" ("+(stats.getOccupationAmount("Janitor")*100)/user.getUserList().size()+"%)");
				outputStream.println("\nGender: ");
				outputStream.println("M: "+stats.getGenderAmount("M")+" ("+(stats.getGenderAmount("M")*100)/user.getUserList().size()+"%)");
				outputStream.println("F: "+stats.getGenderAmount("F")+" ("+(stats.getGenderAmount("F")*100)/user.getUserList().size()+"%)");
				outputStream.println("U: "+stats.getGenderAmount("U")+" ("+(stats.getGenderAmount("U")*100)/user.getUserList().size()+"%)");
				outputStream.println("O: "+stats.getGenderAmount("O")+" ("+(stats.getGenderAmount("O")*100)/user.getUserList().size()+"%)");
				outputStream.println("\nSmoker: ");
				outputStream.println("Yes: "+stats.getSmokerAmount("Yes")+" ("+(stats.getSmokerAmount("Yes")*100)/user.getUserList().size()+"%)");
				outputStream.println("No:  "+stats.getSmokerAmount("No")+" ("+(stats.getSmokerAmount("No")*100)/user.getUserList().size()+"%)");
				outputStream.println(  "-----------------------------------------------------");
	
	
			}//else if (selection)
			
			
			outputStream.close();		
			AlertBox.infoMessage("- "+fileName+ " was generated!");
			
			
		}catch(Exception e){
			
			AlertBox.errorMessage("- File Not Found!!!");
			
		}//catch
		
		
	}//writeAllStudentReport
	

}//end of Reports Class
