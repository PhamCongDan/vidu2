package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

	@WebServlet(urlPatterns={"/any/*"})
public class Asterisk extends HttpServlet{
	public static final long serialVersionUID=1L;
	public Asterisk(){
	}
	@Override
	
	//This page will be display if the URL string is not match with any urlPatterns
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ServletOutputStream out=response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Page not found</title></head>");
		out.println("<body>");
		out.println("<h3>Please sure you have right URL!</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}

}
