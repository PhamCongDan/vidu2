package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet{
	private static final long serialVersonUID=1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		//Get Parameter send from login_user.jsp
		//Get Parameter with name user
		String user=(String) request.getParameter("user");
		//Get Parameter with name password
		String pass=(String) request.getParameter("password");
		String passMD5;
		//Prepare new database class
		connect conn=new connect();
		//Prepare a variable
		int vlconn=0;
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pass.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            passMD5 = number.toString(16);
            while (passMD5.length() < 32) {
            	passMD5 = "0" + passMD5;
            }
           
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);}
		//Set variable vlconn by doing check login
		vlconn=conn.mysql(user, passMD5);
		//If user is a Admin, vlconn will be equal 1
		if(vlconn==1)
		{
			//Prepare session
			HttpSession session=request.getSession();
			//Create a context path string
			String contextPath=request.getContextPath();
			//Set session Attribute name lgUser with value user
			session.setAttribute("lgUser", user);
			//Redirect to user page
			response.sendRedirect(contextPath + "/user.jsp");
			
			return;
		}
		else
		{
			//Create a context path string
			String contextPath=request.getContextPath();
			//Redirect to normal error report page
			response.sendRedirect(contextPath + "/signin_error.html");
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
	

}
