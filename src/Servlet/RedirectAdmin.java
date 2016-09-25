package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;

/**
 * Servlet implementation class AdRedirectServlet
 */
@WebServlet("/RedirectAdmin")
public class RedirectAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Get Parameter send from login_admin.jsp
		//Get Parameter with name user
		String user=(String) request.getParameter("user");
		//Get Parameter with name password
		String pass=(String) request.getParameter("password");
		//Prepare new database class
		connect conn=new connect();
		//Prepare a variable
		int vlconn=0;
		//Set variable vlconn by doing check login
		vlconn=conn.mysql(user, pass);
		//If user is a Admin, vlconn will be equal 2
		if(vlconn==2)
		{
			//Prepare session
			HttpSession session=request.getSession();
			//Create a context path string
			String contextPath=request.getContextPath();
			//Set session Attribute name lgUser with value user
			session.setAttribute("lgUser", user);
			//Set session Attribute name Role with value "2"
			session.setAttribute("Role", "2");
			//Redirect to admin page
			response.sendRedirect(contextPath + "/admin.jsp");
			
			return;
		}
		else
		{
			{
				//Create a context path string
				String contextPath=request.getContextPath();
				//Redirect to normal login page
				response.sendRedirect(contextPath + "/signin_user.jsp");
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
