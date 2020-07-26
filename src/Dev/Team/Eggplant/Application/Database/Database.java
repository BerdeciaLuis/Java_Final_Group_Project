package Dev.Team.Eggplant.Application.Database;
import java.sql.*;

import Dev.Team.Eggplant.Application.Data.UserList;
import Dev.Team.Eggplant.Application.Gui.AlertBox;
import Dev.Team.Eggplant.Application.User.*;
import Dev.Team.Eggplant.Application.User.Info.*;
/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will be incharge of handling the Database for the program
 * 
 * The Steps for JDBC are the following:
 *
 * 1. Import ----> java.sql
 * 2. Load and Register the Driver --> "jdbc:mysql://localhost:3306/(database name)";
 * 3. Create Connection  ---> Connection
 * 4. Create a Statement --> Statement
 * 5. Execute a Query
 * 6. Process the Results
 * 7. Close 
 * 
 * The following code works if you want to see the data I had in MySQL go to Update_Info(README)
 * 
 */
public class Database {
	
	//FIELDS//
	
	private String url = "jdbc:mysql://localhost:3306/FinalProject";
	private String username = "username";
	private String password = "password";
	private String query;
	private Student student;
	private Teacher teacher;
	private Janitor janitor;

	
	//Default Constructor
	public Database(){
		
		//No-Args Constructor
		
	}//constructor
	
	
	/**
	 * This method will add the user from the ArrayList to the Database
	 * 
	 * @param user - The ArrayList containing the Users for the Program
	 * @param index - The index where the User will be added to the Database
	 */
	
	public void addUserToDatabase(UserList user,int index){
		
		try{
			
			query = "insert into Person(userid,fName,midInitial,lName,DateOfBirth,streetNumber,streetName,streetType,city,state,zipCode,gender,smoker,Occupation) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1,index);
			statement.setString(2, user.getUserList().get(index).getName().getFirstName());
			statement.setString(3, user.getUserList().get(index).getName().getMiddleInitial());
			statement.setString(4, user.getUserList().get(index).getName().getLastName());
			statement.setString(5, user.getUserList().get(index).getDateOfBirth());
			statement.setString(6, user.getUserList().get(index).getAddress().getStreetNumber());
			statement.setString(7, user.getUserList().get(index).getAddress().getStreetName());
			statement.setString(8, user.getUserList().get(index).getAddress().getStreetType());
			statement.setString(9, user.getUserList().get(index).getAddress().getCity());
			statement.setString(10, user.getUserList().get(index).getAddress().getStateCode().getStatesCode());
			statement.setString(11, user.getUserList().get(index).getAddress().getZipCode());
			statement.setString(12, user.getUserList().get(index).getGender());
			statement.setString(13, user.getUserList().get(index).getSmokerInfo());
			statement.setString(14, user.getUserList().get(index).getOccupation());
			statement.executeUpdate();
			
			if(user.getUserList().get(index).getOccupation().equals("Student")){
				
				student = new Student();
				student = (Student)user.getUserList().get(index);
				query = "insert into Student(studentid,major,gpa,credits) values (?,?,?,?);";
				statement = con.prepareStatement(query);
				
				statement.setInt(1, index);
				statement.setString(2, student.getMajor());
				statement.setDouble(3, student.getGpa());
				statement.setInt(4, student.getCredits());
				statement.executeUpdate();
				
			}//if
			
			if(user.getUserList().get(index).getOccupation().equals("Teacher")){
				
				teacher = new Teacher();
				teacher = (Teacher)user.getUserList().get(index);
				query = "insert into Teacher(teacherid,subjectTaught,numOfClasses,officeNumber) values (?,?,?,?);";
				statement = con.prepareStatement(query);
				
				statement.setInt(1, index);
				statement.setString(2, teacher.getSubject());
				statement.setInt(3, teacher.getNumOfClasses());
				statement.setString(4, teacher.getOfficeNumber());
				statement.executeUpdate();
				
			}//if

			if(user.getUserList().get(index).getOccupation().equals("Janitor")){
	
				janitor = new Janitor();
				janitor = (Janitor)user.getUserList().get(index);
				query = "insert into Janitor(janitorid,hourlyRate,yearsOfService) values (?,?,?);";
				statement = con.prepareStatement(query);
	
				statement.setInt(1, index);
				statement.setString(2, janitor.getHourlyRate().substring(1));
				statement.setInt(3, janitor.getYearsOfService());
				statement.executeUpdate();
				
	
			}//if 
			
		}catch(Exception e){
			
			AlertBox.errorMessage("- User was not able to be added to the Database!");
			
		}//catch
		
		
	}//addUserToDatabase
	
	
	/**
	 * This method will remove the user in the ArrayList from the Database
	 * 
	 * @param user - The ArrayList containing the Users for the Program
	 * @param index - The index where the User will be removed from the Database
	 */
	
	public void removeUserFromDatabase(UserList user, int index){
		
		try{
			
			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			PreparedStatement statement;
			
			if(user.getUserList().get(index).getOccupation().equals("Student")){
				
				query =  "delete from Student where studentid = "+index+";";
				statement = con.prepareStatement(query);
				statement.executeUpdate();
				
			}//if
			
			if(user.getUserList().get(index).getOccupation().equals("Teacher")){
				
				query =  "delete from Teacher where teacherid = "+index+";";
				statement = con.prepareStatement(query);
				statement.executeUpdate();
				
			}//if

			if(user.getUserList().get(index).getOccupation().equals("Janitor")){
	
				
				query =  "delete from Janitor where janitorid = "+index+";";
				statement = con.prepareStatement(query);
				statement.executeUpdate();

			}//if
			
			
			query =  "delete from Person where userid = "+index+";";
			statement = con.prepareStatement(query);
			statement.executeUpdate();	
			
			
		}catch(Exception e){
			
			AlertBox.errorMessage("- User was not found in the Database!!");;
			
		}//catch
		
	}//removeUserFromDatabase
	
	
	/**
	 * This method will get the Users from the Database and it
	 * will add it to the ArrayList
	 * 
	 * @param user - The ArrayList containing the Users for the Program 
	 */

	public void getUsersFromDatabase(UserList user){
		
		try{
			
			String occupation;
			int index;
			query = "select * from Person;";
			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while(rs.next()){
				
				occupation = rs.getString("Occupation");
				index = rs.getInt("userid");
				
				if(occupation.equals("Student")){
					
					getStudents(user,index);
					
				}
				
				else if(occupation.equals("Teacher")){
					
			
					getTeachers(user,index);
					
				}
				
				else if(occupation.equals("Janitor")){
					
					getJanitors(user,index);
					
				}
				
				
			}//while
			
			
		}catch(Exception e){
			
			AlertBox.exceptionMessage(e);
			
		}
		
		
	}//getUsersFromDatabase
	
	/**
	 * This method will add the Student type to the ArrayList
	 */
	
	public void getStudents(UserList user, int index){
		
		try{
		
			query = "select * from Person, Student where userid = "+index+" and studentid = "+index+";";
			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
				
				student = new Student();
				student.setName(new Name(rs.getString("fName"), rs.getString("midInitial"), rs.getString("lName")));
				student.setDateOfBirth(rs.getString("DateOfBirth"));
				student.setAddress(new Address(rs.getString("streetNumber"),rs.getString("streetName"),rs.getString("streetType"),
							rs.getString("city"),new States(rs.getString("state")),rs.getString("zipCode")));
				student.setGender(rs.getString("gender"));
				student.setSmokerInfo(rs.getString("smoker"));
					
				student.setMajor(rs.getString("major"));
				student.setGPA(String.valueOf(rs.getDouble("gpa")));
				student.setCredits(String.valueOf(rs.getInt("credits")));
				
				user.addUser(student);
				System.out.println(student.toString());

		
		}catch(Exception e){
		
			AlertBox.exceptionMessage(e);
		
		}
		
	}
	
	/**
	 *This method will add the Teacher type to the ArrayList.
	 */
	
	public void getTeachers(UserList user, int index){
		
		try{
		
			query = "select * from Person, Teacher where userid = "+index+" and teacherid = "+index+";";

			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
		
				
				teacher = new Teacher();
				teacher.setName(new Name(rs.getString("fName"), rs.getString("midInitial"), rs.getString("lName")));
				teacher.setDateOfBirth(rs.getString("DateOfBirth"));
				teacher.setAddress(new Address(rs.getString("streetNumber"),rs.getString("streetName"),rs.getString("streetType"),
				rs.getString("city"),new States(rs.getString("state")),rs.getString("zipCode")));
				teacher.setGender(rs.getString("gender"));
				teacher.setSmokerInfo(rs.getString("smoker"));
					
				teacher.setSubject(rs.getString("subjectTaught"));
				teacher.setNumOfClasses(String.valueOf(rs.getInt("numOfClasses")));
				teacher.setOfficeNumber(rs.getString("officeNumber"));
		
				user.addUser(teacher);
				System.out.println(teacher.toString());
			
		
		}catch(Exception e){
		
			AlertBox.exceptionMessage(e);
		
		}
		
	}
	
	
	/**
	 * This method will add the Janitor type to the ArrayList
	 */
	
	public void getJanitors(UserList user,int index){
		
		try{
		
			query = "select * from Person, Janitor where userid = "+index+" and janitorid = "+index+";";
			Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			
				janitor = new Janitor();
				janitor.setName(new Name(rs.getString("fName"), rs.getString("midInitial"), rs.getString("lName")));
				janitor.setDateOfBirth(rs.getString("DateOfBirth"));
				janitor.setAddress(new Address(rs.getString("streetNumber"),rs.getString("streetName"),rs.getString("streetType"),
				rs.getString("city"),new States(rs.getString("state")),rs.getString("zipCode")));
				janitor.setGender(rs.getString("gender"));
				janitor.setSmokerInfo(rs.getString("smoker"));
				janitor.setHourlyRate("hourlyRate");
				janitor.setYearsOfService(String.valueOf(rs.getInt("yearsOfService")));
				
				user.addUser(janitor);
				System.out.println(janitor.toString());

		
		}catch(Exception e){
		
			AlertBox.exceptionMessage(e);
		
		}
		
	}
	
	/**
	 * This method will add Users into the Program replacing the 
	 * getUsersFromDatabase()
	 * 
	 * @param user - The ArrayList that will hold the Users for
	 * the program
	 */
	
	public void getUsers(UserList user){
		
		student = new Student();
		student.setName(new Name("Luis","D","Berdecia"));
		student.setDateOfBirth("04/08/1997");
		student.setAddress(new Address("3046","Cameron","Drive","Kissimmee",new States("FL"),"34743"));
		student.setGender("M");
		student.setSmokerInfo("No");
		student.setMajor("Computer Science");
		student.setCredits("35");
		student.setGPA("3.5");
		user.addUser(student);
		//addUserToDatabase(Users, 0);
		
		student = new Student();
		student.setName(new Name("Yeiraliz","Borelli"));
		student.setDateOfBirth("08/27/1998");
		student.setAddress(new Address("1234","Imaginary","Lane","Orlando",new States("FL"),"34745"));
		student.setGender("F");
		student.setSmokerInfo("Yes");
		student.setMajor("Nursing");
		student.setCredits("55");
		student.setGPA("3.30");
		user.addUser(student);
		//addUserToDatabase(Users, 1);
	
		teacher = new Teacher();
		teacher.setName(new Name("Carmen","Pratts"));
		teacher.setDateOfBirth("12/28/1978");
		teacher.setAddress(new Address("4321","Mystery","Drive","Miami",new States("FL"),"34747"));
		teacher.setGender("F");
		teacher.setSmokerInfo("Yes");
		teacher.setSubject("Spanish");
		teacher.setNumOfClasses("3");
		teacher.setOfficeNumber("105");
		user.addUser(teacher);
		//addUserToDatabase(Users, 2);
		
		janitor = new Janitor();
		janitor.setName(new Name("Miguel","Angel","Santiago"));
		janitor.setDateOfBirth("07/25/1990");
		janitor.setAddress(new Address("5678","Garden","Cove","Poinciana",new States("FL"),"34748"));
		janitor.setGender("M");
		janitor.setSmokerInfo("Yes");
		janitor.setHourlyRate("15.75");
		janitor.setYearsOfService("4");
		user.addUser(janitor);
		//addUserToDatabase(Users, 3);
		
		student = new Student();
		student.setName(new Name("Michael","Gary","Scott"));
		student.setDateOfBirth("03/15/1964");
		student.setAddress(new Address("13927","Saticoy","Street","Scranton",new States("PA"),"18503"));
		student.setGender("M");
		student.setSmokerInfo("Yes");
		student.setMajor("Business");
		student.setCredits("80");
		student.setGPA("3.00");
		user.addUser(student);
		//addUserToDatabase(Users,4);
	
		teacher = new Teacher();
		teacher.setName(new Name("Leslie","Knope"));
		teacher.setDateOfBirth("10/15/1982");
		teacher.setAddress(new Address("5487","Parks","Lane","Pawnee",new States("IN"),"65897"));
		teacher.setGender("F");
		teacher.setSmokerInfo("No");
		teacher.setSubject("U.S Governement");
		teacher.setNumOfClasses("5");
		teacher.setOfficeNumber("201");
		user.addUser(teacher);
		//addUserToDatabase(Users, 5);
		
		janitor = new Janitor();
		janitor.setName(new Name("Roger","Smith"));
		janitor.setDateOfBirth("03/08/1989");
		janitor.setAddress(new Address("2103","American","Drive","LangleyFalls",new States("VA"),"78523"));
		janitor.setGender("O");
		janitor.setSmokerInfo("Yes");
		janitor.setHourlyRate("18.25");
		janitor.setYearsOfService("6");
		user.addUser(janitor);
		//addUserToDatabase(Users, 6);
		
		teacher = new Teacher();
		teacher.setName(new Name("Ann","Perkins"));
		teacher.setDateOfBirth("10/15/1982");
		teacher.setAddress(new Address("4453","Blossom","Trail","AnnArbor",new States("MI"),"48108"));
		teacher.setGender("U");
		teacher.setSmokerInfo("No");
		teacher.setSubject("Intro To Biology");
		teacher.setNumOfClasses("2");
		teacher.setOfficeNumber("107");
		user.addUser(teacher);
		//addUserToDatabase(Users, 7);
		
	}
	


}//end of Database Class
