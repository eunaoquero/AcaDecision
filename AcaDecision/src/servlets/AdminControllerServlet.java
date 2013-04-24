/**
 * 
 */
package servlets;

import helpers.DBHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.User;


/**
 * This controller maps functions for all administrator level tasks.
 * AdminController will dispatch requests to the DBHelper class when
 * users are added, edited or deleted and as well as any group or role changes done
 * by an administrator level user.
 * @author rpacis
 */
@WebServlet("/Admin")
public class AdminControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControllerServlet() {
        super();
        // TODO Implement constructor for AdminController
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher(request.getParameter("referrer"));
		String method = request.getParameter("method");

		// Check method if logout
		if (method.equals("logout")) {
			System.out.println("User logging out!\n");
			session.invalidate();
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher(request.getParameter("referrer"));
		String method = request.getParameter("method");
		
		//Check method if login
		if (method.equals("login")) {			
			//login user
			String userName = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			DBHelper dbHelper = new DBHelper();
			User user = new User();
			user = dbHelper.authenticateUser(userName, password);
			
			//if username is not equals to "User not found", it means user was authenticated and we put user details
			//in a session variable, otherwise the userNotFound attribute is enabled
			if (user.getEmail() != "User not found") {
				System.out.println("User authenticated!\n");
				session.setAttribute("userName", user.getEmail());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("lastName", user.getLastName());
			}
			else {
				System.out.println("User not found!\n");
				request.setAttribute("userNotFound", "Yes");
			}
		}
		
		dispatcher.forward(request, response);
		
	}

}
