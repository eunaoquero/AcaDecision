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
		String referrer;
		String method;
		String groupId;
		
		//Check referrer
		if (request.getParameter("referrer") != null)
			referrer = request.getParameter("referrer");
		else
			referrer = "/administration.jsp";
		
		//Check method
		if (request.getParameter("method") != null)
			method = request.getParameter("method");
		else
			method = "";
		
		//Check groupId
		if (session.getAttribute("groupID") != null)
			groupId = session.getAttribute("groupID").toString();
		else 
			groupId = "";
		 
		// Check method if logout
		if (method.equals("logout")) {
			System.out.println("User logging out!\n");
			session.invalidate();
		}
		else {
			//Check if user is logged in as administrator, if yes get userList
			if (groupId.equals("1")) {
				setUserList(request, response);
			}
		}
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher(referrer);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext ctx = this.getServletContext();
		String referrer;
		
		//Check referrer
		if (request.getParameter("referrer") != null)
			referrer = request.getParameter("referrer");
		else
			referrer = "/administration.jsp";
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher(referrer);
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
				session.setAttribute("groupID", user.getGroupID());
				setUserList(request, response);
			}
			else {
				System.out.println("User not found!\n");
				request.setAttribute("userNotFound", "Yes");
			}
		} else if (method.equals("addUser")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int groupID = Integer.parseInt(request.getParameter("groupID"));
			
			if (email != "" && password != "" && firstName != "" && lastName != "") {
				
				DBHelper dbHelper = new DBHelper();
				User user = new User();
				user.setEmail(email);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(password);
				user.setGroupID(groupID);
				//Add user to db
				System.out.println("Adding User!\n");
				dbHelper.addUser(user);
				setUserList(request, response);
			} else {
				request.setAttribute("addUserError", "Yes");
				setUserList(request, response);
			}
			
		}
		
		dispatcher.forward(request, response);
	}
	
	/**
	 * Gets the user and group list and puts them in the request attribute
	 */
	protected void setUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBHelper dbHelper = new DBHelper();
		System.out.println("Getting user and group list!\n");
		request.setAttribute("userList", dbHelper.getUserList());
		request.setAttribute("groupList", dbHelper.getGroupList());
	}

}
