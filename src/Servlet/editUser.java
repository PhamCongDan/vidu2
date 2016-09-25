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
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doEidit(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doEidit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Prepare session
		HttpSession session=request.getSession();
		//Set string with session Attribute name lgUser
		String user=(String) session.getAttribute("lgUser");
		//Set string with session Attribute name email
		String email=request.getParameter("email");
		//Set string with session Attribute name password
		String pass=request.getParameter("password");
		//Set string with session Attribute name date
		String birthday=request.getParameter("date");
		//Prepare new database class
		connect conn=new connect();
		//Begin update database
		conn.editUser(user, pass, email, birthday);
		//Create a string context path
		String contextPath=request.getContextPath();
		//Go to user info page
		response.sendRedirect(contextPath + "/user.jsp");
	}

}
