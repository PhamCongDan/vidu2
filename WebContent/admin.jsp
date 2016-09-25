<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.IOException" %>
    <%@ page import="javax.servlet.ServletException" %>
    <%@ page import="javax.servlet.ServletOutputStream" %>
    <%@ page import="javax.servlet.annotation.WebInitParam" %>
    <%@ page import="javax.servlet.annotation.WebServlet" %>
    <%@ page import="javax.servlet.http.HttpServlet" %>
    <%@ page import="javax.servlet.http.HttpServletRequest" %>
    <%@ page import="javax.servlet.http.HttpServletResponse" %>
    <%@ page import="dao.readFile" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="java.util.Calendar" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="dao.connect" %>
<%
String UserName=(String) session.getAttribute("lgUser");
String role=(String) session.getAttribute("Role");
if(UserName==null)
{
	String contextPath=(String) session.getServletContext().getContextPath();
	response.sendRedirect(contextPath+"/index.jsp");
	return;
}
else
{
	if(role!="2")
	{
		String contextPath=(String) session.getServletContext().getContextPath();
		response.sendRedirect(contextPath+"/index.jsp");
		return;
	}
}
%>
<jsp:include page="admin_head.html" />
<%
connect conn=new connect();
try {
	ResultSet infoResult=conn.readInfo(UserName);
	while(infoResult.next())
	{                                                       
	    out.println("<div class=\"row\">");
	    out.println("<label class=\"label col col-2\">First Name:</label>");
	    out.println("<div class=\"col col-6\">");
	    out.println("<label class=\"input\">");
	    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("firstname")+"\">");
	    out.println("</label>");
	    out.println("</div>");
	    out.println("</div>");

	    out.println("<p class=\"text-blank\">blank</p>");
	                                            
	    out.println("<div class=\"row\">");
	    out.println("<label class=\"label col col-2\">Last Name:</label>");
	    out.println("<div class=\"col col-6\">");
	    out.println("<label class=\"input\">");
	    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("lastname")+"\">");
	    out.println("</label>");
	    out.println("</div>");
	    out.println("</div>");

	    out.println("<p class=\"text-blank\">blank</p>");
	    
	    out.println("<div class=\"row\">");
	    out.println("<label class=\"label col col-2\">E-mail:</label>");
	    out.println("<div class=\"col col-6\">");
	    out.println("<label class=\"input\">");
	    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("email")+"\">");
	    out.println("</label>");
	    out.println("</div>");
	    out.println("</div>");

	    out.println("<p class=\"text-blank\">blank</p>");
	    
	    out.println("<div class=\"row\">");
	    out.println("<label class=\"label col col-2\">Date of Birth:</label>");
	    out.println("<div class=\"col col-6\">");
	    out.println("<label class=\"input\">");
	    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("birthday")+"\">");
	    out.println("</label>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("<p class=\"text-blank\">blank</p>");
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

%>
<jsp:include page="admin_user.html" />
<%
try {
	ResultSet userResult=conn.getUser();
	while(userResult.next())
	{
	    out.println("<tr>");
	    out.println("<form action=\"\" class=\"sky-form\" method=\"post\">");                                            
	    out.println("<input type=\"hidden\" name=\"user\" value=\""+userResult.getString("username")+"\">");
	    out.println("<th>"+userResult.getString("username")+"</th>");
	    out.println("<th>"+userResult.getString("password")+"</th>");
	    out.println("<th>"+userResult.getString("firstname")+"</th>");
	    out.println("<th>"+userResult.getString("lastname")+"</th>");
	    out.println("<th>"+userResult.getString("joined")+"</th>");
	    out.println("<th>");
	    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" value=\""+userResult.getString("username")+"\" onClick=\"clic(this);\">Delete</button></a>");
	    out.println("</form>");
	    out.println("</th>"); 
	    out.println("</tr>");	    

	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
<SCRIPT>
function clic(element)
{
	document.getElementById("reading").value=element.value;
}
</SCRIPT>
<jsp:include page="admin_foot.html" />