package Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.connect;
 import java.math.BigInteger;
 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRegister(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String passMD5;
		//Get Parameter send from signup_user.jsp
		//Get Parameter with name username
		String UserID=request.getParameter("username");
		//Get Parameter with name email
		String UserEmail=request.getParameter("email");
		//Get Parameter with name password
		String UserPass=request.getParameter("password");
		//Get Parameter with name firstname
		String UserFirstName=request.getParameter("firstname");
		//Get Parameter with name lastname
		String UserLastName=request.getParameter("lastname");
		//Get Parameter with name date
		String UserBirthDay=request.getParameter("date");
		try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(UserPass.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            passMD5 = number.toString(16);
            while (passMD5.length() < 32) {
            	passMD5 = "0" + passMD5;
            }
           
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		//Prepare new database class
		connect conn=new connect();
		//This is a local of project
		String local="G:\\Web Programming\\Exercise\\Final-New\\WebContent\\uploadFile\\";
		//checkUser will return true if the username is available
		if(conn.checkUser(UserID))
		{
			//Insert into login_info new user
			conn.register(UserID, passMD5, UserEmail, UserFirstName, UserLastName, UserBirthDay);
			//Create a context path string
			String contextPath=request.getContextPath();
			//Redirect to normal error login page
			response.sendRedirect(contextPath + "/signin_user.jsp");
		}
		else
		{
			//Dispatcher to signup_error.html
			RequestDispatcher dispatcher=request.getServletContext()
					.getRequestDispatcher("/signup_error.html");
			dispatcher.forward(request, response);
		}
	}

}
