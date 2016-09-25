package Servlet;

import java.io.IOException;
import java.util.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Iterator;
import java.io.File;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;
import dao.connect;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	doUpload(request,response);
    	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doUpload(request,response);
	}
	protected void doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Get parameter from upload_material.jsp
		String type=request.getParameter("upload");
		String name=request.getParameter("folder");
		//Prepare a database class
		connect conn=new connect();
		//Save new test to database
		conn.saveTest(type, name);
		//Check if files is multiple
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 
		 		//Create new file write
		        FileItemFactory factory = new DiskFileItemFactory();
		        //Create new servlet to upload file
		        ServletFileUpload upload = new ServletFileUpload(factory);
		        //Create new list file item
		           List items=null;
		           try {
		        	   //Fill data to list file
		                items = upload.parseRequest(request);
		           } catch (FileUploadException e) {
		                   e.printStackTrace();
		           }
		           //Create new item
		           Iterator itr = items.iterator();
		           //Get all file need to upload
		           while (itr.hasNext()) {
		        	   //Create new file
		           FileItem item = (FileItem)(itr.next());
		           //Create new folder
		           new File("D:\\uploadFile\\").mkdir();
		           if (item.isFormField()) {
		                    try{
		                        String field=item.getFieldName();
		                        String value=item.getString();
		                    }
		                    catch(Exception e){}
		           } 
		           else {
		                   try {
		                	   	   //Get item name
		                           String itemName = item.getName();
		                           //Remove unused part
		                           String b=itemName.substring( itemName.lastIndexOf("\\"));
		                           //Create new file
		                           File savedFile = new File("D:\\uploadFile\\"+b);
		                           //Save file to disk
		                           item.write(savedFile);  
		                   } catch (Exception e) {
		                           e.printStackTrace();
		                   }
		           }
		           }
		         //Display success page
		           RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/upload_success.html");
		   		dispatcher.forward(request, response);
	}

}
