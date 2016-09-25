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
@WebServlet(urlPatterns={"/Reading/*"},
initParams={@WebInitParam(name="StrRead",value="D:\\")})
public class doReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doReading() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext config=request.getServletContext();
		HttpSession session=request.getSession();
		response.getWriter();
		
		String user= (String) session.getAttribute("lgUser");
		String URI=request.getRequestURI();
		
		

		String[] tmpURI=URI.split("\\/");
		String direct = "";
		if(tmpURI[3]=="Reading")
		{
			direct=config.getRealPath("/")+"uploadFile\\"+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\"+"read.xlsx";
		}
		else
		{
			if(tmpURI[3]=="Listening")
			{
				direct=config.getRealPath("/")+"uploadFile\\"+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\"+"listen.xlsx";
			}
			else
			{
				direct=config.getRealPath("/")+"uploadFile\\"+"\\"+tmpURI[3]+"\\"+tmpURI[4]+"\\"+"listen.xlsx";
			}
		}
		session.setAttribute("direct", direct);
		System.out.println(direct);
//		RequestDispatcher dispatcher=request.getServletContext()
//				.getRequestDispatcher("/pra_read_body.jsp");
//		dispatcher.forward(request, response);
		
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath + "/pra_read_body.jsp");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
