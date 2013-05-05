/**
 * 
 */
package helpers;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;



import org.junit.Test;

/**
 * Test methods for the WebServiceHelper class
 * Tests the connection to the external web service 
 * and the data being retrieved
 * @author dbuckheister
 *
 */
public class WebServiceHelperTest {


	@Test
	public void testWebServiceClass() {
		//test constructor
		WebServiceHelper wb = new WebServiceHelper();
		URL url = null;
		try {
			url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=2012%20Fall&method=LEVEL");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test WebService response
		String webServiceData = wb.getWebServiceData(url);
		System.out.println(webServiceData);
		assertTrue(webServiceData.contains("DEGREE_LEVEL"));
	}

}
