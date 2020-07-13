package Dev.Team.Eggplant.Application.Database;
import java.sql.*;
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
 */
public class Database {
	
	private String url = "jdbc:mysql://localhost:3306/abc";
	private String username = "root";
	private String password = "password";
	private String query = "select name, address from person where ssn=4";
	
	
	//Default Constructor
	public void Load_Database() throws Exception{
		
		Connection con = DriverManager.getConnection(url,username,password); //Creates the Connection
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		
	}//constructor
	


}//end of Database Class
