package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;

/**
 * Servlet implementation class saveResult
 */
@WebServlet("/saveResult")
public class saveResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doSave(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doSave (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prepare session
		HttpSession session=request.getSession();
		//Get examination code from session
		String examination_code=(String) session.getAttribute("nameTest");
		//Get username from session
		String username= (String) session.getAttribute("lgUser");
		//Get read mark from session
		String reading=(String) session.getAttribute("read");
		//Convert read mark to int
		int vlRead=Integer.parseInt(reading);
		//Get listen mark from session
		String listening=(String) session.getAttribute("listen");
		//Convert listen mark to int
		int vlListen=Integer.parseInt(listening);
		//Get date_made from session
		String date_made =(String) session.getAttribute("date");
		//Prepare new database class
		connect conn=new connect();
		//Begin save result
		conn.saveResult(examination_code, username, vlRead, vlListen, date_made);
		//Get listen mark from session
		String type=(String) session.getAttribute("type");
		//Begin update times of test
		conn.updateData(examination_code, username, type);
		//Display user.jsp page 
		RequestDispatcher dispatcher=request.getServletContext()
				.getRequestDispatcher("/user.jsp");
		dispatcher.forward(request, response);
	}

}
