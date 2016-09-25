package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;
import dao.readFile;

/**
 * Servlet implementation class deleteFile
 */
@WebServlet("/deleteFile/*")
public class deleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDelete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Prepare new database class
		connect conn=new connect();
		//Get Parameter with name user
		String UserID=request.getParameter("user");
		
		//Prepare new file class
		readFile read=new readFile();
		//Prepare session
		HttpSession session=request.getSession();
		//Get name of user who want to delete file
		String user= (String) session.getAttribute("lgUser");
		//Split string UserID to get correct style you want
		String[] tmp=UserID.split("\\\\");
		//Print to see value
		System.out.println(tmp[1]);
		System.out.println(tmp[2]);
		//If this is delete from practice_read
		if(tmp[1].equals("Reading"))
		{
			//Delete from database reading test with username and examination_code
			conn.deleteReadTest(user,tmp[2]);
		}
		else
		{
			//If this is delete from practice_listen
			if(tmp[1].equals("Listening"))
			{
				//Delete from database listening test with username and examination_code
				conn.deleteListenTest(user,tmp[2]);
			}
			else
			{
				//If this is delete from practice_fulltest
				//Delete from database full test with username and examination_code
				conn.deleteFullTest(user,tmp[2]);
			}
		}
		//This is a local of project
		String local="D:\\uploadFile\\";
		//Make a string with username and examination code
		local+=user+UserID;
		//Print to see value
		System.out.println(local);
		try {
			//Delete form hard disk file and folder at location local
			read.Delete(local);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Display a notification success
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/delete_file.html");
		dispatcher.forward(request, response);
	}

}
