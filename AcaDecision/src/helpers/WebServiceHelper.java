/**
 * 
 */
package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Connects and retrieves the data from an external web service
 * that provides JSON formatted data for use in displaying 
 * the different graphs on the dashboard
 * @author dbuckheister
 */
public class WebServiceHelper {
	
	//No parameter constructor
	public WebServiceHelper() {
		
	}
	
	//Data Setter Method 
	public String getWebServiceData(URL urlString) {
		StringBuilder dataString = new StringBuilder();
		String line;

		try {
			//Establish connection and fetch data
			HttpURLConnection connection = (HttpURLConnection) urlString.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setAllowUserInteraction(false);
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			
			if (connection.getResponseCode() != 200) {
				    throw new IOException(connection.getResponseMessage());
			}
			
			// Place the result onto the string variable
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
			    dataString.append(line);
			}
			reader.close();
			connection.disconnect();
		}
		catch (Exception e){
	    	System.out.println("Error connecting to web service" + e.getClass().getName() + ": " + e.getMessage());
		}	
		return dataString.toString();
	}
}
