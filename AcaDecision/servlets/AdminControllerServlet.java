/**
 * 
 */
package servlets;

import java.io.IOException;

/**
 * This controller maps functions for all adminstrator level tasks.
 * AdminController will dispatch requests to the DBHelper class when
 * users are added, edited or deleted and as well as any group or role changes done
 * by an administrator level user.
 * @author rppacis
 */
@WebServlet("/Admin")
public class AdminControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Implement constructor for AdminController
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
		// TODO Implement doPost
	}

}
