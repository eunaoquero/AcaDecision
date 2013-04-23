/**
 * 
 */
package servlets;


import helpers.WebServiceHelper;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		WebServiceHelper wb = new WebServiceHelper();
		URL url = new URL("http://service.irp.gatech.edu/api/engg/index.php?term_code=" + termCode + "&method=ALL");
		jsonData = wb.getWebServiceData(url);
		//Put the JSON data in an attribute
		request.setAttribute("enrollmentData", jsonData);
		request.setAttribute("term", term);
		dispatcher.forward(request, response);
	}

}