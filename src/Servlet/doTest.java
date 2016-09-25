package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.readFile;

/**
 * Servlet implementation class doReading
 */
@WebServlet(urlPatterns={"/Test/*"},
initParams={@WebInitParam(name="StrRead",value="D:\\")})
public class doTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Prepare session
		HttpSession session=request.getSession();

		//Get name of user who want to delete file
		String user= (String) session.getAttribute("lgUser");
		//Get a URI string
		String URI=request.getRequestURI();
		
		
		//Split string UserID to get correct style you want
		String[] tmpURI=URI.split("\\/");
		//Prepare a empty string
		String direct = "";
		//This is a local of project
		String local="D:\\uploadFile\\";
		//If this is do a read test
		if(tmpURI[3].equals("Reading"))
		{
			//Do a reading test with location
			direct=local+user+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\"+"read.xlsx";
			session.setAttribute("type", "practice_read");
		}
		else
		{
			//If this is do a listen test
			if(tmpURI[3].equals("Listening"))
			{
				//Do a listen test with location
				direct=local+user+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\"+"listen.xlsx";
				session.setAttribute("type", "practice_listen");
			}
			else
			{
				//If this is do a full test
				//Do a full test with location
				direct=local+user+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\";
				session.setAttribute("type", "practice_fulltest");
			}
		}
		//Set session Attribute name direct with value direct
		session.setAttribute("direct", direct);
		//Set session Attribute name nameTest with value tmpURI[4]
		session.setAttribute("nameTest", tmpURI[4]);

		//If this is do a read test
		if(tmpURI[3].equals("Reading"))
		{
			//Redirect to practice read page
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath + "/practice_read.jsp");
		}
		else
		{
			//If this is do a listen test
			if(tmpURI[3].equals("Listening"))
			{
				//Redirect to practice listen page
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath + "/practice_listen.jsp");
			}
			else
			{
				//If this is do a full test
				//Redirect to practice full page
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath + "/practice_full_listen.jsp");
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
