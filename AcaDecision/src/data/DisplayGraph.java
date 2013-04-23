/**
 * 
 */
package data;

import java.net.URL;

/**
 * Contains data and information about a graph. Works with the
 * WebServiceHelper class.
 * @author rppacis
 *
 */
public class DisplayGraph {
	
	//TODO: Redevelop the DisplayGraph class to be more modular
	
	public String termCode;
	public URL url;
	public String graphTitle;
	public String dataMethod;
	
	//No parameter constructor
	public DisplayGraph() {
		
	}
	
	/**
	 * @return the dataMethod
	 */
	public String getDataMethod() {
		return dataMethod;
	}

	/**
	 * @param dataMethod the dataMethod to set
	 */
	public void setDataMethod(String dataMethod) {
		this.dataMethod = dataMethod;
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
