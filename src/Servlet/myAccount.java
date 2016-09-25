package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connect;

/**
 * Servlet implementation class myAccount
 */
@WebServlet("/myAccount")
public class myAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		myAcc(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void myAcc (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
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
			if(role=="2")
			{
				String contextPath=(String) session.getServletContext().getContextPath();
				response.sendRedirect(contextPath+"/index.jsp");
				return;
			}
		}
		ServletOutputStream out=response.getOutputStream();
		String servletPath="";
		servletPath=request.getServletPath();
		connect conn=new connect();
	    out.println("<!DOCTYPE html>");
	    out.println("<html lang=\"en\">");

	    out.println("<head>");

	    out.println("<meta charset=\"utf-8\">");
	    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
	    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
	    out.println("<meta name=\"description\" content=\"\">");
	    out.println("<meta name=\"author\" content=\"\">");

	    out.println("<title>User Information</title>");

	    out.println("<!-- Bootstrap Core CSS -->");
	    out.println("<link href=\"css/bootstrap.css\" rel=\"stylesheet\">");
	    out.println("<link rel=\"stylesheet\" href=\"css/sky-tabs.css\">");
	    out.println("<link rel=\"stylesheet\" href=\"css/sky-forms.css\">");
	    out.println("<link rel=\"stylesheet\" href=\"css/demo.css\">");
	    out.println("<link rel=\"stylesheet\" href=\"css/font-awesome-sky.css\">");

	    out.println("<!-- Custom CSS -->");
	    out.println("<link href=\"css/agency.css\" rel=\"stylesheet\">");
	    out.println("<link rel=\"stylesheet\" href=\"css/sky-tabs.css\">");
	    out.println("<!-- Custom Fonts -->");
	    out.println("<link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">");    
	    out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
	    out.println("<link rel=\"stylesheet\" href=\"font-awesome/css/font-awesome-animation.min.css\">");
	    out.println("<link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type=\"text/css\">");
	    out.println("<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>");
	    out.println("<link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>");
	    out.println("<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>");
	    
	    out.println("<script src=\"js/jquery.min-sky.js\"></script>");
	    out.println("<script src=\"js/jquery.validate.min-sky.js\"></script>");
	    out.println("<script src=\"js/jquery-ui.min-sky.js\"></script>");

	    out.println("<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->");
	    out.println("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->");
	    
	    out.println("</head>");

	    out.println("<body id=\"page-top\" class=\"bg-user\" class=\"index\">");
	    out.println("<!-- Navigation -->");
	    out.println("<nav class=\"navbar navbar-default navbar-fixed-top\" class=\"navbar-design\">");
	    out.println("<div class=\"container\">");
	    out.println("<!-- Brand and toggle get grouped for better mobile display -->");
	    out.println("<div class=\"navbar-header page-scroll\">");
	    out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">");
	    out.println("<span class=\"sr-only\">Toggle navigation</span>");
	    out.println("<span class=\"icon-bar\"></span>");
	    out.println("<span class=\"icon-bar\"></span>");
	    out.println("<span class=\"icon-bar\"></span>");
	    out.println("</button>");
	    out.println("<a class=\"navbar-brand page-scroll\" href=\"index.jsp\">Toeic Everyday</a>");
	    out.println("</div>");

	    out.println("<!-- Collect the nav links, forms, and other content for toggling -->");
	    out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
	    out.println("<ul class=\"nav navbar-nav navbar-right\">");
	    out.println("<li>");
	    out.println("<a href=\"/Final-New/myAccount\">My Account</a>");
	    out.println("</li>");

	    out.println("<li>");
	    out.println("<a href=\"file_management.html\">File Management</a>");
	    out.println("</li>");

	    out.println("<li>");
	    out.println("<a href=\"practice.jsp\">Practice</a>");
	    out.println("</li>");

	    out.println("<li>");
	    out.println("<a href=\"upload.html\">Upload</a>");
	    out.println("</li>");

	    out.println("<li>");
	    out.println("<a href=\"/Final-New/logOut\" data-toggle=\"modal\">Sign Out</a>");
	    out.println("</li>");
	    out.println("</ul>");
	    out.println("</div>");
	    out.println("<!-- /.navbar-collapse -->");
	    out.println("</div>");
	    out.println("<!-- /.container-fluid -->");
	    out.println("</nav>");
	    out.println("<section>");
	    out.println("<div class=\"container\">");
	    out.println("<section>");
	    out.println("<!-- tabs -->");
	    out.println("<div class=\"sky-tabs sky-tabs-pos-left sky-tabs-anim-flip sky-tabs-response-to-icons\">");
	    out.println("<input type=\"radio\" name=\"sky-tabs\" checked id=\"sky-tab1\" class=\"sky-tab-content-1\">");
	    out.println("<label for=\"sky-tab1\"><span><span><i class=\"fa fa-user\"></i>Information</span></span></label>");
	                            
	    out.println("<input type=\"radio\" name=\"sky-tabs\" id=\"sky-tab2\" class=\"sky-tab-content-2\">");
	    out.println("<label for=\"sky-tab2\"><span><span><i class=\"fa fa-cogs\"></i>Edit</span></span></label>");
	                            
	    out.println("<input type=\"radio\" name=\"sky-tabs\" id=\"sky-tab3\" class=\"sky-tab-content-3\">");
	    out.println("<label for=\"sky-tab3\"><span><span><i class=\"fa fa-bar-chart\"></i>My Result</span></span></label>");

	    out.println("<input type=\"radio\" name=\"sky-tabs\" id=\"sky-tab4\" class=\"sky-tab-content-4\">");
	    out.println("<label for=\"sky-tab4\"><span><span><i class=\"fa fa-phone\"></i>Contact</span></span></label>");
	    
	    out.println("<ul>");
	    try {
	    	ResultSet infoResult=conn.readInfo(UserName);
			while(infoResult.next())
			{
				out.println("<li class=\"sky-tab-content-1\">");
			    out.println("<form action=\"\" class=\"sky-form\">");
			    out.println("<header>User Information</header>");
			    out.println("<fieldset>");                                                            
			    out.println("<div class=\"row\">");
//			    out.println("<section class=\"col-md-2\">");
//			    out.println("<label>First Name:</label>");
//			    out.println("</section>");
//			    out.println("<section class=\"col-md-6\">");
//			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("firstname")+"\">");
//			    out.println("</section>");
			    out.println("<label class=\"label col col-2\">First Name:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("firstname")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>");

			    out.println("<p class=\"text-blank\">blank</p>");
			                                            
			    out.println("<div class=\"row\">");
//			    out.println("<section class=\"col-md-2\">");
//			    out.println("<label>Last Name:</label>");
//			    out.println("</section>");
//			    out.println("<section class=\"col-md-6\">");
//			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("lastname")+"\">");
//			    out.println("</section>");
			    out.println("<label class=\"label col col-2\">Last Name:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("lastname")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>");

			    out.println("<p class=\"text-blank\">blank</p>");
			    
			    out.println("<div class=\"row\">");
//			    out.println("<section class=\"col-md-2\">");
//			    out.println("<label>E-mail:</label>");
//			    out.println("</section>");
//			    out.println("<section class=\"col-md-6\">");
//			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("email")+"\">");
//			    out.println("</section>");
			    out.println("<label class=\"label col col-2\">E-mail:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("email")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>");

			    out.println("<p class=\"text-blank\">blank</p>");
			    
			    out.println("<div class=\"row\">");
//			    out.println("<section class=\"col-md-2\">");
//			    out.println("<label>Date of Birth:</label>");
//			    out.println("</section>");
//			    out.println("<section class=\"col-md-6\">");
//			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("birthday")+"\">");
//			    out.println("</section>");
			    out.println("<label class=\"label col col-2\">Date of Birth:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<input type=\"text\" disabled=\"\" placeholder=\""+infoResult.getString("birthday")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>");
			    out.println("<p class=\"text-blank\">blank</p>");
			    out.println("</fieldset>");
			    out.println("</form>");
			    out.println("</li>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    
	    try {
	    	ResultSet infoResult=conn.readInfo(UserName);
			while(infoResult.next())
			{
				out.println("<li class=\"sky-tab-content-2\">");
			    out.println("<form action=\"/Final-New/editUser\" id=\"sky-form\" class=\"sky-form\">");
			    out.println("<header>Edit User Information</header>");                                            
			    out.println("<fieldset>");              
			                                                                        
			    out.println("<div class=\"row\">");
			    out.println("<label class=\"label col col-2\">Username</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<i class=\"icon-append fa fa-user\"></i>");
			    out.println("<input type=\"text\" name=\"username\" disabled=\"\" id=\"username\" value=\""+UserName+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>"); 

			    out.println("<p class=\"text-blank\">blank</p>");
			                                                
			    out.println("<div class=\"row\">");
			    out.println("<label class=\"label col col-2\">E-mail:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<i class=\"icon-append fa fa-envelope-o\"></i>");
			    out.println("<input type=\"email\" name=\"email\" id=\"email\" value=\""+infoResult.getString("email")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>"); 

			    out.println("<p class=\"text-blank\">blank</p>");
			                                                
			    out.println("<div class=\"row\">");
			    out.println("<label class=\"label col col-2\">Edit Password:</label>");;
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<i class=\"icon-append fa fa-lock\"></i>");
			    out.println("<input type=\"password\" name=\"password\" id=\"password\" value=\""+infoResult.getString("password")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>"); 

			    out.println("<p class=\"text-blank\">blank</p>");

			    out.println("<div class=\"row\">");
			    out.println("<label class=\"label col col-2\">Confirm:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<i class=\"icon-append fa fa-lock\"></i>");
			    out.println("<input type=\"password\" name=\"passwordConfirm\" id=\"passwordConfirm\" value=\""+infoResult.getString("password")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>"); 

			    out.println("<p class=\"text-blank\">blank</p>");

			    out.println("<div class=\"row\">");
			    out.println("<label class=\"label col col-2\">Date of Birth:</label>");
			    out.println("<div class=\"col col-6\">");
			    out.println("<label class=\"input\">");
			    out.println("<i class=\"icon-append fa fa-calendar\"></i>");
			    out.println("<input type=\"text\" name=\"date\" id=\"date\" value=\""+infoResult.getString("birthday")+"\">");
			    out.println("</label>");
			    out.println("</div>");
			    out.println("</div>");
			    out.println("<p class=\"text-blank\">blank</p>");
			    out.println("</fieldset>");
			    out.println("<footer>");
			    out.println("<button type=\"submit\" class=\"button\">Save</button>");
			    out.println("</footer>");
			    out.println("</form>");         
			    out.println("</li>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	                                
	    out.println("<li class=\"sky-tab-content-3\">");
	    out.println("<div class=\"typography\">");
	    out.println("<table class=\"table table-striped\">");
	    out.println("<thead>");
	    out.println("<tr>");
	    out.println("<th>No.</th>");
	    out.println("<th>Examination Code</th>");
	    out.println("<th>Listening</th>");
	    out.println("<th>Reading</th>");
	    out.println("<th>Total</th>");
	    out.println("<th>Date Made</th>");
	    out.println("</tr>");
	    out.println("</thead>");
	    out.println("<tbody>");
	    out.println("<tr>");
	    out.println("<th>1</th>");
	    out.println("<th>Toeic 001</th>");
	    out.println("<th>100</th>");
	    out.println("<th>100</th>");
	    out.println("<th>200</th>");
	    out.println("<th>14/11/2015</th>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<th>2</th>");
	    out.println("<th>Listening 001</th>");
	    out.println("<th>300</th>");
	    out.println("<th>0</th>");
	    out.println("<th>300</th>");
	    out.println("<th>14/11/2015</th>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<th>3</th>");
	    out.println("<th>Listening 001</th>");
	    out.println("<th>0</th>");
	    out.println("<th>300</th>");
	    out.println("<th>300</th>");
	    out.println("<th>14/11/2015</th>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<th>4</th>");
	    out.println("<th>Toeic 002</th>");
	    out.println("<th>400</th>");
	    out.println("<th>400</th>");
	    out.println("<th>800</th>");
	    out.println("<th>14/11/2015</th>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<th>5</th>");
	    out.println("<th>Toeic 003</th>");
	    out.println("<th>150</th>");
	    out.println("<th>400</th>");
	    out.println("<th>550</th>");
	    out.println("<th>14/11/2015</th>");
	    out.println("</tr>");
	    out.println("</tbody>");
	    out.println("</table>");
	    out.println("</div>");
	    out.println("</li>");
	    out.println("<li class=\"sky-tab-content-4\">");
	    out.println("<div class=\"row text-center\">");
	    out.println("<h1>Contact us on:</h1>");
	    out.println("<div class=\"col-md-4\">");
	    out.println("<span class=\"fa-stack fa-4x\">");
	    out.println("<i class=\"fa fa-mobile fa-2x faa-shake animated\"></i>");
	    out.println("</span>");
	    out.println("<h4 class=\"service-heading\">Phone Number</h4>");
	    out.println("<p class=\"text-muted\">Call us if you get any problem</p>");
	    out.println("<p class=\"text-contact\">0169-59-79-171</p>");
	    out.println("</div>");
	    out.println("<div class=\"col-md-4\">");
	    out.println("<span class=\"fa-stack fa-4x\">");
	    out.println("<i class=\"fa fa-facebook-square fa-2x  faa-tada animated\"></i>");
	    out.println("</span>");
	    out.println("<h4 class=\"service-heading\">Facebook</h4>");
	    out.println("<p class=\"text-muted\">Follow us to get more news.</p>");
	    out.println("<a href=\"https://www.facebook.com/groups/toeiceveryday/\" target=\"_blank\" class=\"text-contact\">Facebook</a>");
	    out.println("</div>");
	    out.println("<div class=\"col-md-4\">");
	    out.println("<span class=\"fa-stack fa-4x\">");
	    out.println("<i class=\"fa fa-paper-plane-o fa-2x faa-vertical animated\"></i>");
	    out.println("</span>");
	    out.println("<h4 class=\"service-heading\">Mail</h4>");
	    out.println("<p class=\"text-muted\">Mail us if you get any problem</p>");
	    out.println("<p class=\"text-contact\">hanhoan43@gmail.com</p>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</li>");                   
	    out.println("</ul>");
	    out.println("</div>");
	    out.println("<!--/ tabs -->");
	    out.println("</section>");
	    out.println("</div>");
	    out.println("</section>");

	    out.println("<footer>");
	    out.println("<p align=\"center\">Copyright &copy; Toeic Everyday 2015</p>");
	    out.println("</footer>");

	    out.println("<script type=\"text/javascript\">");
	    out.println("$(function()");
	    out.println("{");
	                // Validation       
	    out.println("$(\"#sky-form\").validate(");
	    out.println("{");                   
	                    // Rules for form validation
	    out.println("rules:");
	    out.println("{");
	    out.println("username:");
	    out.println("{");
	    out.println("required: true");
	    out.println("},");
	    out.println("email:");
	    out.println("{");
	    out.println("required: true,");
	    out.println("email: true");
	    out.println("},");
	    out.println("password:");
	    out.println("{");
	    out.println("required: true,");
	    out.println("minlength: 3,");
	    out.println("maxlength: 20");
	    out.println("},");
	    out.println("passwordConfirm:");
	    out.println("{");
	    out.println("required: true,");
	    out.println("minlength: 3,");
	    out.println("maxlength: 20,");
	    out.println("equalTo: '#password'");
	    out.println("},");
	    out.println("firstname:");
	    out.println("{");
	    out.println("required: true");
	    out.println("},");
	    out.println("lastname:");
	    out.println("{");
	    out.println("required: true");
	    out.println("},");
	    out.println("date:");
	    out.println("{");
	    out.println("required: true");
	    out.println("},");
	    out.println("terms:");
	    out.println("{");
	    out.println("required: true");
	    out.println("}");
	    out.println("},");
	                    
	                    // Messages for form validation
	    out.println("messages:");
	    out.println("{");
	    out.println("username:");
	    out.println("{");
	    out.println("required: 'Please enter your username'");
	    out.println("},");
	    out.println("email:");
	    out.println("{");
	    out.println("required: 'Please enter your email address',");
	    out.println("email: 'Please enter a VALID email address'");
	    out.println("},");
	    out.println("password:");
	    out.println("{");
	    out.println("required: 'Please enter your password'");
	    out.println("},");
	    out.println("passwordConfirm:");
	    out.println("{");
	    out.println("required: 'Please enter your new password one more time',");
	    out.println("equalTo: 'Please enter the same password as above'");
	    out.println("},");
	    out.println("firstname:");
	    out.println("{");
	    out.println("required: 'Please select your first name'");
	    out.println("},");
	    out.println("lastname:");
	    out.println("{");
	    out.println("required: 'Please select your last name'");
	    out.println("},");
	    out.println("date:");
	    out.println("{");
	    out.println("required: 'Please select your birthday'");
	    out.println("},");
	    out.println("},");                  
	                    
	                    // Do not change code below
	    out.println("errorPlacement: function(error, element)");
	    out.println("{");
	    out.println("error.insertAfter(element.parent());");
	    out.println("}");
	    out.println("});");
	    out.println("});");         
	    out.println("</script>");
	    out.println("<!-- Date Picker -->");
	    out.println("<script type=\"text/javascript\">");
	    out.println("$(function()");
	    out.println("{");
	                // Regular datepicker
	    out.println("$('#date').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>'");
	    out.println("});");
	                
	                // Date range
	    out.println("$('#start').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>',");
	    out.println("onSelect: function( selectedDate )");
	    out.println("{");
	    out.println("$('#finish').datepicker('option', 'minDate', selectedDate);");
	    out.println("}");
	    out.println("});");
	    out.println("$('#finish').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>',");
	    out.println("onSelect: function( selectedDate )");
	    out.println("{");
	    out.println("$('#start').datepicker('option', 'maxDate', selectedDate);");
	    out.println("}");
	    out.println("});");
	                
	                // Inline datepicker
	    out.println("$('#inline').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>'");
	    out.println("});");
	                
	                // Inline date range
	    out.println("$('#inline-start').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>',");
	    out.println("onSelect: function( selectedDate )");
	    out.println("{");
	    out.println("$('#inline-finish').datepicker('option', 'minDate', selectedDate);");
	    out.println("}");
	    out.println("});");
	    out.println("$('#inline-finish').datepicker({");
	    out.println("dateFormat: 'dd-mm-yy',");
	    out.println("prevText: '<i class=\"fa fa-chevron-left\"></i>',");
	    out.println("nextText: '<i class=\"fa fa-chevron-right\"></i>',");
	    out.println("onSelect: function( selectedDate )");
	    out.println("{");
	    out.println("$('#inline-start').datepicker('option', 'maxDate', selectedDate);");
	    out.println("}");
	    out.println("});");
	    out.println("});");         
	    out.println("</script>");


	    out.println("<!-- Bootstrap Core JavaScript -->");
	    out.println("<script src=\"js/bootstrap.min.js\"></script>");
	    out.println("<!-- Plugin JavaScript -->");
	    out.println("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>");
	    out.println("<script src=\"js/classie.js\"></script>");
	    out.println("<script src=\"js/cbpAnimatedHeader.js\"></script>");

	    out.println("<!-- Custom Theme JavaScript -->");
	    out.println("<script src=\"js/agency.js\"></script>");

	    out.println("</body>");
	    out.println("</html>");

	}

}
