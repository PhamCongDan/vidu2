package Servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
 * Servlet implementation class premyAcc
 */
@WebServlet("/preLogin")
public class preLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public preLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doCheck(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doCheck(request, response);
	}
	private void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String passMD5;
		HttpSession session=request.getSession();
		String lgUser=(String)session.getAttribute("lgUser");
		System.out.println(lgUser);
		String lgPass=(String)session.getAttribute("lgUser");
		System.out.println(lgUser);
		connect conn=new connect();	
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(lgPass.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            passMD5 = number.toString(16);
            while (passMD5.length() < 32) {
            	passMD5 = "0" + passMD5;
            }
           
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		int vlconn=conn.mysql(lgUser, passMD5);
		if(vlconn==1)
		{
//			HttpSession session=request.getSession();
			session.setAttribute("lgUser", lgUser);
			System.out.println("Redirect to My Infomation");
			String contextPath=request.getContextPath();
//			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/proLogin");
//			dispatcher.forward(request, response);
			response.sendRedirect(contextPath + "/index.jsp");
			return;
		}
		else
		{
			if(lgUser==null)
			{
				System.out.println("Redirect to Home");
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath + "/index.jsp");
				return;
			}
			else
			{
//				session.setAttribute("lgUser", lgUser);
				System.out.println("Redirect to My Infomation 2");
				String contextPath=request.getContextPath();
//				RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/proLogin");
//				dispatcher.forward(request, response);
				response.sendRedirect(contextPath + "/index.jsp");
				return;
			}
		}
	}

}
