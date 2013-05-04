/**
 * 
 */
package data;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Test methods for the DisplayDashboard class
 * @author rpacis
 *
 */
public class DisplayDashboardTest {
	/**
	 * Tests for DisplayDashboards Class
	 *  
	 */
	@Test
	public void testDisplayDashboardsClass() {
		ArrayList<DisplayGraph> graphList = new ArrayList<DisplayGraph>();
		
		/**Create graph 1
		 */
		DisplayGraph graph1 = new DisplayGraph();
		URL url = null;
		try {
			url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graph1.setUrl(url);
		graphList.add(graph1);
		
		/**Create graph 2
		 */
		DisplayGraph graph2 = new DisplayGraph();
		try {
			url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graph2.setUrl(url);
		graphList.add(graph2);
		
		/**Test Constructor
		 */
		DisplayDashboard dashboardTest = new DisplayDashboard(1, "dashboardNameTest",
				"dashboardDescriptionTest", graphList);
		assertNotNull(dashboardTest);
		
		/**
		 * Testing getGraphList
		 */
		assertTrue(dashboardTest.getGraphList().contains(graph2));
	}

}
