/**
 * 
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Manages database access for administrator functions
 * @author rsilva
 *
 */
public class DBHelper {
	
	  /**
	   * Establish a connection to the database and create the
	   * PreparedStatements
	   */
		public DBHelper(){
		try{
				//TODO: Implement DBHelper constructor
				}
			    catch(Exception e){
			    	System.out.println("Error in constructor" + e.getClass().getName() + ": " + e.getMessage()); 
			    	e.printStackTrace();
			    }
		}//constructor
}
