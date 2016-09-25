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
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void Admin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
			if(role!="2")
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

	    out.println("<title>Admin</title>");

	    out.println("<!-- Bootstrap Core CSS -->");
	    out.println("<link href=\"css/bootstrap.css\" rel=\"stylesheet\">");
	    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/sweetalert.css\">");
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

	    out.println("<body id=\"page-top\" class=\"bg-admin\" class=\"index\">");
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
	    out.println("<a class=\"navbar-brand page-scroll\" href=\"#\">Toeic Everyday</a>");
	    out.println("</div>");

	    out.println("<!-- Collect the nav links, forms, and other content for toggling -->");
	    out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
	    out.println("<ul class=\"nav navbar-nav navbar-right\">");
	    out.println("<li>");
	    out.println("<a href=\"/Final-New/Admin\">Admin</a>");
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
	    out.println("<label for=\"sky-tab1\"><span><span><i class=\"fa fa-cogs\"></i>Delete User</span></span></label>");
	    
	    out.println("<input type=\"radio\" name=\"sky-tabs\" id=\"sky-tab2\" class=\"sky-tab-content-2\">");
	    out.println("<label for=\"sky-tab2\"><span><span><i class=\"fa fa-user\"></i>Information</span></span></label>");
	                            

	                                
	    out.println("<ul>");
	    try {
	    	ResultSet infoResult=conn.readInfo(UserName);
			while(infoResult.next())
			{
				out.println("<li class=\"sky-tab-content-2\">");
			    out.println("<form action=\"\" class=\"sky-form\">");
			    out.println("<header>Admin Information</header>");
			    out.println("<fieldset>");                                                            
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
			    out.println("</fieldset>");
			    out.println("</form>");
			    out.println("</li>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    
	    try {
	    	ResultSet userResult=conn.getUser();
			out.println("<li class=\"sky-tab-content-1\">");
		    out.println("<div class=\"typography\">");
		    out.println("<table class=\"table table-striped\">");                                            
		    out.println("<thead>");              
		                                                                        
		    out.println("<tr>");
		    out.println("<th>Username</th>");
		    out.println("<th>Password</th>");
		    out.println("<th>First Name</th>");
		    out.println("<th>Last Name</th>");
		    out.println("<th>Joined</th>");
		    out.println("<th>Delete</th>");
		    out.println("</tr>");
		    out.println("</thead>");
		    out.println("<tbody>");
//		    out.println("<form action=\"deleteUser\" class=\"sky-form\" method=\"post\">");     
			while(userResult.next())
			{
			    out.println("<tr>");
			    out.println("<form action=\"deleteUser\" class=\"sky-form\" method=\"post\">");                                            
			    out.println("<input type=\"hidden\" name=\"user\" value=\""+userResult.getString("username")+"\">");
			    out.println("<th>"+userResult.getString("username")+"</th>");
			    out.println("<th>"+userResult.getString("password")+"</th>");
			    out.println("<th>"+userResult.getString("firstname")+"</th>");
			    out.println("<th>"+userResult.getString("lastname")+"</th>");
			    out.println("<th>"+userResult.getString("joined")+"</th>");
			    out.println("<th>");
			    out.println("<button type=\"submit\" class=\"btn btn-link\" class=\"modal\">Delete</button>");
			    out.println("</form>");
			    out.println("</th>"); 
			    out.println("</tr>");
				
				
//				out.println("<tr>");
////			    out.println("<form action=\"deleteUser\" class=\"sky-form\" method=\"post\">");                                            
////			    out.println("<input type=\"hidden\" name=\"user\" value=\""+userResult.getString("username")+"\">");
//			    out.println("<th>"+userResult.getString("username")+"</th>");
//			    out.println("<th>"+userResult.getString("password")+"</th>");
//			    out.println("<th>"+userResult.getString("firstname")+"</th>");
//			    out.println("<th>"+userResult.getString("lastname")+"</th>");
//			    out.println("<th>");
//			    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" onclick=\"submitter(this)\">Delete</button>");
//			    
//			    out.println("</th>"); 
//			    out.println("</tr>");
			    
//			    out.println("<form action=\"\" class=\"sky-form\" id=\"deleted\">");
//			    out.println("<input type=\"hidden\" name=\"param\" />");
//			    out.println("<tr id=\"mylove\">");
//			                                                
//			    
//			    out.println("<th>billgates</th>");
//			    out.println("<th>microsoft</th>");
//			    out.println("<th>Bill</th>");
//			    out.println("<th>Gates</th>");
//			    out.println("<th>14/11/2015</th>");
//			    out.println("<th>");
//			    out.println("<a href=\"#btn-submit\" class=\"modal-opener\"><button type=\"button\" class=\"btn btn-link\" class=\"modal\" onclick=\"submitter(this)\">Delete</button></a>");
//			    out.println("</th>"); 
//
//			    
//			    
//			    out.println("</tr>");
//			    out.println("</form>");
			    

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    out.println("</form>");
	    out.println("</tbody>");
	    out.println("</table>");
	    out.println("</div>");
	    out.println("</li> ");
	    out.println("</ul>");
	    out.println("</div>");
	    out.println("<!--/ tabs -->");
	    out.println("</section>");
	    out.println("</div>");
	    out.println("</section>");

	    out.println("<!-- Confirm Delele -->");

	    out.println("<form action=\"\" id=\"btn-submit\" class=\"sky-form sky-form-modal\">");
	    out.println("<header align=\"center\">Notification!!!</header>");
	                    
	    out.println("<fieldset>");                 
	    out.println("<p class=\"text-test\">Are you sure you want to delete this user?</p>");
	    out.println("</fieldset>");
	    out.println("<footer>");
	    out.println("<button class=\"button modal-closer\" onclick=\"swal('This user has been deleted', '', 'success');\"\">Yes</button>");
	    out.println("<button class=\"button button-secondary modal-closer\" onclick=\"swal('This user has not been deleted', '', 'error');\">No</button>");
	    out.println("</footer>");
	    out.println("</form>");
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

	    out.println("<script>");
	    out.println("function submitter(btn) {");
	    out.println("var param = btn.parentElement.parentElement.id;");
	    out.println("var myForm = document.forms[\"deleted\"];");
	    out.println("deleted.elements[\"param\"].value = param;");
	    out.println("alert(param)");
//	    out.println("myForm.submit();");
	    out.println("}");
	    out.println("</script>");

	    out.println("<!-- Bootstrap Core JavaScript -->");
	    out.println("<script src=\"js/sweetalert-dev.js\"></script>");
	    out.println("<script src=\"js/sweetalert.min.js\"></script>");
	    out.println("<!-- Plugin JavaScript -->");
	    out.println("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>");
	    out.println("<script src=\"js/classie.js\"></script>");
	    out.println("<script src=\"js/cbpAnimatedHeader.js\"></script>");
	    out.println("<script src=\"js/jquery.modal-sky.js\"></script>");

	    out.println("<!-- Custom Theme JavaScript -->");
	    out.println("<script src=\"js/agency.js\"></script>");

	    out.println("</body>");
	    out.println("</html>");

	}

}
