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

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doResult(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doResult(request, response);
	}
	protected void doResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Get Parameter send from practice_read.jsp, practice_listen.jsp, practice_full_listen.jsp, or practice_full_read.jsp
		//Get Parameter with name reading
		String reading=(String) request.getParameter("reading");
		//Get Parameter with name listening
		String listening=(String) request.getParameter("listening");
		//Create a context path string
		String contextPath=request.getContextPath();
		//Do a practice_read.jsp or practice_listen.jsp
		if(listening!=null&&reading!=null)
		{
			//Create a temp value
			int total=0;
			total=Integer.parseInt(reading)+Integer.parseInt(listening);
			
			//Create a date format to take time
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			//Get current time of system to variable date
			java.util.Date date = Calendar.getInstance().getTime();
			//Create a string with format what you want
			String reportDate = df.format(date);
			//Prepare session
			HttpSession session=request.getSession();
			//Set session Attribute name read with value reading
			session.setAttribute("read", reading);
			//Set session Attribute name listen with value listening
			session.setAttribute("listen", listening);
			//Set session Attribute name total with value total
			session.setAttribute("total", total);
			//Set session Attribute name date with value reportDate
			session.setAttribute("date", reportDate);
			//Redirect to result page
			response.sendRedirect(contextPath + "/practice_result.jsp");
			//response.sendRedirect(contextPath + "/user.jsp");
		}
		else
		{
			//Do Reading Full Test
			if(reading!=null)
			{
				//Prepare session
				HttpSession session=request.getSession();
				//Get listen mark from session
				listening=(String) session.getAttribute("listen");
				//Create a temp value
				int total=0;
				total=Integer.parseInt(reading)+Integer.parseInt(listening);
				
				//Create a date format to take time
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				//Get current time of system to variable date
				java.util.Date date = Calendar.getInstance().getTime();
				//Create a string with format what you want
				String reportDate = df.format(date);
				
				//Set session Attribute name read with value reading
				session.setAttribute("read", reading);
				//Set session Attribute total lgUser with value total
				session.setAttribute("total", total);
				//Set session Attribute name date with value reportDate
				session.setAttribute("date", reportDate);
				//Redirect to result page
				response.sendRedirect(contextPath + "/practice_result.jsp");
			}
			//Do Listening Full Test
			else
			{
				//Prepare session
				HttpSession session=request.getSession();
				//Set session Attribute name listen with value listening
				session.setAttribute("listen", listening);
				//Redirect to full test reading page
				response.sendRedirect(contextPath + "/practice_full_read.jsp");
			}
		}
	}

}
