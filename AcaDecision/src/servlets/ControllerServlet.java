/**
 * 
 */
package servlets;


import helpers.WebServiceHelper;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DisplayGraph;

/**
 * Controller will dispatch a request to the WebService helper class to retrieve
 * data for a dashboard view.
 * @author blord
 */
@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Implement constructor for Controller
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Implement doGet
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData;
		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/dashboard.jsp");
		String termCode = request.getParameter("term_code");
		String term = URLDecoder.decode(termCode, "UTF-8");
		
		//List of graph objects
		ArrayList<DisplayGraph> graphList = new ArrayList<DisplayGraph>();
		WebServiceHelper wb = new WebServiceHelper();
		
		//TODO: Make routine this better
		//TODO: Use associative arrays for URL parameters
		//Create graph 1
		DisplayGraph graph = new DisplayGraph();
		URL url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=" + termCode + "&method=ALL");
		graph.setUrl(url);
		graphList.add(graph);
		
		//Create graph 2
		DisplayGraph genderGraph = new DisplayGraph();
		url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=" + termCode + "&method=GENDER");
		genderGraph.setUrl(url);
		graphList.add(genderGraph);
		
		jsonData = wb.getWebServiceData(graphList.get(0).getUrl());
		//Put the JSON data in an attribute
		request.setAttribute("enrollmentData", jsonData);
		jsonData = wb.getWebServiceData(graphList.get(1).getUrl());
		//Put the JSON data in an attribute
		request.setAttribute("enrollmentGenderData", jsonData);
		
		request.setAttribute("term", term);
		dispatcher.forward(request, response);
	}

}