package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadingResult
 */
@WebServlet("/ReadingResult")
public class ReadingResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadingResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletOutputStream out= response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Reading result!</title></head>");
		out.println("<body BGCOLOR=\"#FFFFFF\" TEXT=\"red\">");
		out.println("<form name=\"log\" action=\"index.jsp\" method=\"post\">");
		out.println("<h3>Your result is: 2/2</h3>");
		out.println("<p></p>");
		out.println("</form>");
		out.println("<align=\"center\"><button type=\"button\">Go home!</button></align>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
