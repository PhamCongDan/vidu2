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
<jsp:include page="file_mana_head.html" />
<%
//String UserName=(String) session.getAttribute("lgUser");
connect conn=new connect();
ResultSet readFullTest=conn.getFullTest(UserName);
int no=1;
while(readFullTest.next())
{
	out.println("<tr>");
    out.println("<th>"+no+"</th>");
    out.println("<th>"+readFullTest.getString("examination_code")+"</th>");
    out.println("<th>"+readFullTest.getString("date_added")+"</th>");    
    out.println("<th>");
    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" value=\"\\FullTest\\"+readFullTest.getString("examination_code")+"\" onClick=\"clic(this);\">Delete</button></a>");
    out.println("</th>");
    out.println("</tr>");
    no++;
}
%>

<jsp:include page="file_mana_listen.html" />
<%
//String UserName=(String) session.getAttribute("lgUser");
ResultSet readListenTest=conn.getListenTest(UserName);
no=1;
while(readListenTest.next())
{
	out.println("<tr>");
    out.println("<th>"+no+"</th>");
    out.println("<th>"+readListenTest.getString("examination_code")+"</th>");
    out.println("<th>"+readListenTest.getString("date_added")+"</th>");    
    out.println("<th>");
    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" value=\"\\Listening\\"+readListenTest.getString("examination_code")+"\" onClick=\"clic(this);\">Delete</button></a>");
    out.println("</th>");
    out.println("</tr>");
    no++;
}
%>

<jsp:include page="file_mana_read.html" />
<%
//String UserName=(String) session.getAttribute("lgUser");
ResultSet readReadTest=conn.getReadTest(UserName);
no=1;
while(readReadTest.next())
{
	out.println("<tr>");
    out.println("<th>"+no+"</th>");
    out.println("<th>"+readReadTest.getString("examination_code")+"</th>");
    out.println("<th>"+readReadTest.getString("date_added")+"</th>");    
    out.println("<th>");
    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" value=\"\\Reading\\"+readReadTest.getString("examination_code")+"\" onClick=\"clic(this);\">Delete</button></a>");
    out.println("</th>");
    out.println("</tr>");
    no++;
}
%>
<SCRIPT>
function clic(element)
{
	document.getElementById("reading").value=element.value;
}
</SCRIPT>
<jsp:include page="file_mana_foot.html" />