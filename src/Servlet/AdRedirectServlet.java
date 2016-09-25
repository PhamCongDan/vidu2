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
@WebServlet("/AdRedirectServlet")
public class AdRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=(String) request.getParameter("user");
		String pass=(String) request.getParameter("password");
		connect conn=new connect();
		int vlconn=conn.mysql(user, pass);
		if(vlconn==2)
		{
			HttpSession session=request.getSession();
			String contextPath=request.getContextPath();
			session.setAttribute("lgUser", user);
			session.setAttribute("Role", 1);
			response.sendRedirect(contextPath + "/myAccount");
			
			return;
		}
		else
		{
			{
				System.out.println("User \\ password incorect! ");
				String contextPath=request.getContextPath();
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
