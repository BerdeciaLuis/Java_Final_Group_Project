package Dev.Team.Eggplant.Application.User.Info;

import java.util.*;
import java.util.Map.Entry;

import Dev.Team.Eggplant.Application.ErrorHandler.ErrorManager;

/**
 * 
 * @author Luis Berdecia
 * @version Created On: June 2020
 *  
 *  @category States Class will take care of the following information
 *  -- State Description of the Location
 *  -- State Code of the Location
 *  
 */

public class States {
	
	
	//FIELDS//
	
	private final HashMap<String,String> hMap = new HashMap<String,String>(); //Used to Assign each State Code its State Name
	private final TreeMap<Integer, String> tMap =  new TreeMap<Integer, String>(); //Used to Add an ID Value to each State Code
	private String stateDescription; //State Name
	
	//Default Constructor
	public States()
	{
		
		setStatesCodes();
		
	}//constructor
	
	public States(String stateCode)
	{
		
		setStatesCodes();
		setStateDescription(stateCode);
	
	}//constructor
	
	
	
	//GETTERS AND SETTERS//
	
	
	/**
	 * @return The State Description or State Name of the State Code
	 */
	
	public String getStateDescription(){
		
		return stateDescription;
		
	}//getStateDescription
	
	
	/**
	 * @param stateCode -  The stateCode to set
	 */
	
	public void setStateDescription(String stateCode){
		
		if(!(stateCode.isEmpty())){
			
			this.stateDescription = hMap.get(stateCode);
			
		}
		
		else{
			
				ErrorManager.addErrorMessage("- No State was Selected!");
				
		}
		
		
	}//setStateDescription
	
	public String getStatesCode(){
		
		for(Entry<String, String> entry: hMap.entrySet()){
			
			if(entry.getValue().equals(getStateDescription())){
				
				return entry.getKey();
				
			}//if
			
		}//for
		
		return "";
		
	}//getStatesCode
	
	
	/**
	 * The getStatesCodes method will allow the user to get all the States Codes in the States Class
	 * @param list - list that will hold all of the state codes
	 */
	
	public void getStatesCodesList(String [] list)
	{
		
		
		for(int x = 0; x < tMap.size(); x++)
		{
			
			list[x] = tMap.get(x+1);
			
		}//for loop
		
	
	}//getStatesCodes
	
	
	/**
	 *Sets the StatesCodes of the states and locations in the U.S. 
	 */
	
	public void setStatesCodes()
	{
		
		 hMap.put("AL", "Alabama");	
		 tMap.put(1,"AL");
		 hMap.put("AK", "Alaska");
		 tMap.put(2,"AK");
		 hMap.put("AS","American Samoa"); 
		 tMap.put(3,"AS");
		 hMap.put("AZ","Arizona"); 
		 tMap.put(4,"AZ");
		 hMap.put("AR","Arkansas"); 
		 tMap.put(5,"AR");
		 hMap.put("CA","California");
		 tMap.put(6,"CA");
		 hMap.put("CO","Colorado"); 
		 tMap.put(7,"CO");
		 hMap.put("CT","Connecticut"); 
		 tMap.put(8,"CT");
		 hMap.put("DE","Delaware"); 
		 tMap.put(9,"DE");
		 hMap.put("DC","District of Columbia"); 
		 tMap.put(10,"DC");
		 hMap.put("FL","Florida"); 
		 tMap.put(11,"FL");
		 hMap.put("GA","Georgia");
		 tMap.put(12,"GA");
		 hMap.put("GU","Guam"); 
		 tMap.put(13,"GU");
		 hMap.put("HI","Hawaii"); 
		 tMap.put(14,"HI");
	     hMap.put("ID","Idaho");
	     tMap.put(15,"ID");
	     hMap.put("IL","Illinois");
	     tMap.put(16,"IL");
	     hMap.put("IN","Indiana"); 
	     tMap.put(17,"IN");
	     hMap.put("IA","Iowa"); 
	     tMap.put(18,"IA");
	     hMap.put("KS","Kansas");
	     tMap.put(19,"KS");
	     hMap.put("KY","Kentucky");
	     tMap.put(20,"KY");
	     hMap.put("LA","Louisiana");
	     tMap.put(21,"LA");
	     hMap.put("ME","Maine");
	     tMap.put(22,"ME");
	     hMap.put("MD","Maryland");
	     tMap.put(23,"MD");
	     hMap.put("MA","Massachusetts"); 
	     tMap.put(24,"MA");
	     hMap.put("MI","Michigan");
	     tMap.put(25,"MI");
	     hMap.put("MN","Minnesota"); 
	     tMap.put(26,"MN");
	     hMap.put("MS","Mississippi"); 
	     tMap.put(27,"MS");
	     hMap.put("MO","Missouri");
	     tMap.put(28,"MO");
	     hMap.put("MT","Montana");
	     tMap.put(29,"MT");
	     hMap.put("NE","Nebraska");
	     tMap.put(30,"NE");
	     hMap.put("NV","Nevada"); 
	     tMap.put(31,"NV");
	     hMap.put("NH","New Hampshire"); 
	     tMap.put(32,"NH");
	     hMap.put("NJ","New Jersey"); 
	     tMap.put(33,"NJ");
	     hMap.put("NM","New Mexico"); 
	     tMap.put(34,"NM");
	     hMap.put("NY","New York"); 
	     tMap.put(35,"NY");
	     hMap.put("NC","North Carolina");
	     tMap.put(36,"NC");
	     hMap.put("ND","North Dakota"); 
	     tMap.put(37,"ND");
	     hMap.put("OH","Ohio");
	     tMap.put(38,"OH");
	     hMap.put("OK","Oklahoma"); 
	     tMap.put(39,"OK");
	     hMap.put("OR","Oregon"); 
	     tMap.put(40,"OR");
	     hMap.put("PW","Palau");
	     tMap.put(41,"PW");
	     hMap.put("PA","Pennsylvania"); 
	     tMap.put(42,"PA");
	     hMap.put("PR","Puerto Rico");
	     tMap.put(43,"PR");
	     hMap.put("RI","Rhode Island"); 
	     tMap.put(44,"RI");
	     hMap.put("SC","South Carolina");
	     tMap.put(45,"SC");
	     hMap.put("SD","South Dakota"); 
	     tMap.put(46,"SD");
	     hMap.put("TN","Tennessee"); 
	     tMap.put(47,"TN");
	     hMap.put("TX","Texas"); 
	     tMap.put(48,"TX");
	     hMap.put("UT","Utah"); 
	     tMap.put(49,"UT");
	     hMap.put("VT","Vermont"); 
	     tMap.put(50,"VT");
	     hMap.put("VI","Virgin Islands");
	     tMap.put(51,"VI");
	     hMap.put("VA","Virginia");
	     tMap.put(52,"VA");
	     hMap.put("WA","Washington");
	     tMap.put(53,"WA");
	     hMap.put("WV","West Virginia");
	     tMap.put(54,"WV");
	     hMap.put("WI","Wisconsin");
	     tMap.put(55,"WI");
	     hMap.put("WY","Wyoming"); 
	     tMap.put(56,"WY");
	     
	}//setHashMap

	
	//OTHER METHODS//
	
  	/**
  	 * @see java.lang.Object#toString()
  	 */

	@Override
	public String toString() {
		
		return getStateDescription(); 
		
	}//toString
	
	
	@Override
  	public boolean equals(Object obj) {
  		
  		boolean flag = false;
  		
  		if(obj instanceof States)
  		{
  			
  			if(getStateDescription() == ((States)obj).getStateDescription()){
  					
  					flag = true;
  				
  			}//if
  			
  			
  		}//if
  		
  		return flag;
  		
  	}//equals 
	
	
   
}//States
