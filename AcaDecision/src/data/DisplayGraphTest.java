/**
 * 
 */
package data;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;



import org.junit.Test;

/**
 * Test methods for the DisplayGraph class
 * @author rsilva
 *
 */
public class DisplayGraphTest {
	
	/**
	 * Tests for DisplayGraph Class
	 *  
	 */
	@Test
	public void testDisplayGraphClass() {

		/**
		 * Test Default Constructor
		 */
		DisplayGraph graph1 = new DisplayGraph("termCode1",null,"graphTitle1");
		assertNotNull(graph1);
		



		/**
		 * Test Non-Arguments Constructor
		 */
		DisplayGraph graph2 = new DisplayGraph();
		assertNotNull(graph2);
		
		/**
		 * graphTitle Setter and Getter
		 */
		graph2.setGraphTitle("DataTitleTest");
		assertEquals("Data Title:", "DataTitleTest", graph2.getGraphTitle());
		
		/**
		 * termCode Setter and Getter
		 */
		graph2.setTermCode("DataTermCodeTest");
		assertEquals("Term Code:", "DataTermCodeTest", graph2.getTermCode());

		/**
		 * graphURL Setter and Getter
		 */
		URL url = null;
		try {
			url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=&method=ALL");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graph2.setUrl(url);
		assertEquals("Data Title:", url, graph2.getUrl());
}

}
