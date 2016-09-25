package Servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.readFile;

@WebServlet(urlPatterns={"/Mylove/*"},
initParams={@WebInitParam(name="StrRead",value="D:\\")})
public class ReadFile extends HttpServlet{
	
	private static final long serialVersionUID=1L;
	String strRead;
	
	public ReadFile(){
	}
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		this.strRead=config.getInitParameter("StrRead");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ServletOutputStream out=response.getOutputStream();
		
		String servletPath="";
		String URI=request.getRequestURI();
		servletPath=request.getServletPath();
		readFile read=new readFile();
		String[] tmpURI=URI.split("\\/");
		String nameTest="test.xlsx";
		String direct=strRead+tmpURI[3]+"\\"+tmpURI[4]+"\\"+nameTest;
		int[] chk=new int[2];
		out.println("<html>");
		out.println("<head><title>Read from file!</title></head>");
		out.println("<body BGCOLOR=\"#FFFFFF\" TEXT=\"red\">");
		out.println("<form action=\"ReadingResult\" method=\"post\">");
		try {
			out.println("<SCRIPT LANGUAGE=\"JavaScript\">");
			out.println("var answers = new Array(4);");
			out.println("var numQues = 4;");
			int h=0;
			for(int i=0;i<10;i++){
				if(read.ReadAnswer(direct, i))
				{
					out.println("answers["+h+"] = \""+read.ReadAnswer(direct, i)+"\";");
					h++;
				}
			}
			out.println("function getScore() {");
			out.println("var score = 0;");
			out.println("var currElt;");
			out.println("var currSelection;");
			out.println("for (i=0; i<numQues; i++) {");
			out.println("if(document.querySelector('input[name=\"Q'+i+'\"]:checked').value==answers[i])");
			out.println("score++;");
			out.println("}");
			out.println("}");
			out.println("</SCRIPT>");
			out.println("<p>For Mylove!</p>");
			int NO=1;
			for(int i=0;i<8;i+=5){
				out.println("<form action=\"ReadingResult\" name =\"Test"+i+"\">");
				out.println("<ul>");
				out.println("<li>"+read.Read(direct, i)+"</li>");
				for(int j=i+1;j<i+5;j++){
					out.println("<li><input name=\""+"Q"+NO+"\" type=\""+"radio\""+" value=\""+read.Read(direct, j)+"\"/>"+read.Read(direct, j)+"<br /></li>");
				}
				NO++;
				out.println("</ul>");
				out.println("</form>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<align=\"center\"><button type=\"button\">Submit your answer!</button></align>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		this.doGet(request, response);
	}
	public void Read(String strRead) throws FileNotFoundException, IOException, Exception{
		
	}
}
