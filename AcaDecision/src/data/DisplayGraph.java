/**
 * 
 */
package data;

import java.net.URL;

/**
 * Contains data and information about a graph. Works with the
 * WebServiceHelper class.
 * @author rsilva
 *
 */
public class DisplayGraph {

	


	public String termCode;
	public URL url;
	public String graphTitle;

	/**
	 * Default Constructor 
	 * (all initial arguments required)
	 * 
	 * @param termCode Term's Code
	 * @param url Graph's URL
	 * @param graphTitle Graph's Title
	 */
	public DisplayGraph(String termCode, URL url, String graphTitle) {
		this.termCode = termCode;
		this.url = url;
		this.graphTitle = graphTitle;
	}
	
	public DisplayGraph() {

		termCode = "";
		url = null;
		graphTitle = "";
		
	}
	

	/**
	 * @return the termCode
	 */
	public String getTermCode() {
		return termCode;
	}

	/**
	 * @param termCode the termCode to set
	 */
	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}


	/**
	 * @return the url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * @return the graphTitle
	 */
	public String getGraphTitle() {
		return graphTitle;
	}

	/**
	 * @param graphTitle the graphTitle to set
	 */
	public void setGraphTitle(String graphTitle) {
		this.graphTitle = graphTitle;
	}
	

}
