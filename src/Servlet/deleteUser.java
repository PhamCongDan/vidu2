package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.connect;
import dao.readFile;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Delete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void Delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Prepare new database class
		connect conn=new connect();
		//Get Parameter with name user
		String UserID=request.getParameter("user");
		//Delete from login_info with username
		conn.deleteUser(UserID);
		//Prepare new file class
		readFile read=new readFile();
		//This is a local of project
		String local="D:\\uploadFile\\";
		//Make a string with username and examination code
		local+=UserID;
		System.out.println(local);
		try {
			//Delete form hard disk file and folder at location local
			read.Delete(local);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Display a notification success
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/delete_user.html");
		dispatcher.forward(request, response);
	}

}
