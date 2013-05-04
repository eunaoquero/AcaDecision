/**
 * 
 */
package data;

import java.util.ArrayList;

/**
 * Manages the DisplayGraph objects
 * @author rpacis
 *
 */
public class DisplayDashboard {
	int dashboardID;
	String dashboardName;
	String dashboardDescription;
	ArrayList<DisplayGraph> graphList = new ArrayList<DisplayGraph>();
	
	
	
	
	/**
 	 * Default Constructor 
	 * (all initial arguments required)
	 * 
	 * @param dashboardID Dashboard Identification Number
	 * @param dashboardName Dashboard's Name
	 * @param dashboardDescription Dashboard's Description
	 * @param graphList Dashboard's Graph List
	 */
	public DisplayDashboard(int dashboardID, String dashboardName,
			String dashboardDescription, ArrayList<DisplayGraph> graphList) {
		this.dashboardID = dashboardID;
		this.dashboardName = dashboardName;
		this.dashboardDescription = dashboardDescription;
		this.graphList = graphList;
	}
	
	/**
	 * 
	 * @return List of Graphs
	 */
	public ArrayList<DisplayGraph> getGraphList(){
		return graphList;
	}

	
}
	

