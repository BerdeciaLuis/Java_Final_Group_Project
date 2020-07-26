package Dev.Team.Eggplant.Application.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Luis Berdecia
 * @version Created on July 2020
 * 
 * @category This class will handle the Server for the Program
 *
 */

public class Server extends Application{

	
	//FIELDS//
	private static final long serialVersionUID = 2L;
	public Stage window;
	private TextArea taResult =  new TextArea();
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream fromClient; 
    private DataOutputStream toClient;
    private int count = 0;
	
	
	//Default Constructor
	public Server(){
		
		//No-Args Constructor
		
	}//constructor
	
	
	public static void main(String [] args){
		
		launch(args);
		
	}//main
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		window = stage;
		window.setResizable(false);
		window.setTitle("Server");
		window.setX(0);
		window.setY(0);
		BorderPane layout =  new BorderPane();
		Scene scene = new Scene(layout,300,200);
		window.setScene(scene);
		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
		window.show();
		taResult.setEditable(false);
		layout.setCenter(new ScrollPane(taResult));
		
		
		startServer();
		
	}
	
	
	/**
	 * This method will start the server
	 */

	public void startServer(){
		
		new Thread(() ->{
			
			try{
				
				serverSocket = new ServerSocket(8000);
				socket = serverSocket.accept();
				Platform.runLater(() -> taResult.appendText("Server Started at " + new Date() + "\n"));
				
				fromClient = new DataInputStream(socket.getInputStream());
				toClient = new DataOutputStream(socket.getOutputStream());
				
				while(true){
					
					
					String message = fromClient.readUTF();
					count++;
					toClient.writeUTF("Server has been Updated "+count+" time(s)!");
					
					
					Platform.runLater(() -> taResult.appendText("Connected to a Client at "+ new Date()+ "\n"));
					taResult.appendText(message+"\n");
					
					
				}//while loop
				
				
			}catch(Exception e){
				
				taResult.appendText("- An Issue has Occured in the Server!");
				
			}//catch
			
			
		}).start();
	
		
	}//startServer
	

	
}//end of Server Class
