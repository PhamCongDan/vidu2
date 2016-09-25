package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;

/**
 * Servlet implementation class promyAcc
 */
@WebServlet("/proLogin")
public class proLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public proLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String lgUser=(String)session.getAttribute("lgUser");
		if(lgUser==null)
		{
			RequestDispatcher dispatcher=request.getServletContext()
					.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
//			RequestDispatcher dispatcher=request.getServletContext()
//					.getRequestDispatcher("/myAcc.jsp");
//			dispatcher.forward(request, response);
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath + "/myAcc.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session=request.getSession();
//		String lgUser=(String)session.getAttribute("lgUser");
//		if(lgUser==null)
//		{
//			RequestDispatcher dispatcher=request.getServletContext()
//					.getRequestDispatcher("/index.jsp");
//			dispatcher.forward(request, response);
//		}
//		else
//		{
//			RequestDispatcher dispatcher=request.getServletContext()
//					.getRequestDispatcher("/myAcc.jsp");
//			dispatcher.forward(request, response);
//		}
	}

}
