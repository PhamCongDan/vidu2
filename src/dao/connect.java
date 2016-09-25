package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class connect {
	
	//Create a connection to database
	public static Connection connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//Chose local server
		String url="jdbc:mysql://localhost:3306/";
		//Chose what database you used
		String dbName="toeic_everyday";
		//Chose driver to take data from database
		String driver="com.mysql.jdbc.Driver";
		//Enter username of MySQL
		String username="root";
		//Enter password to login
		String pass="1295";
		//Prepare connection
		Connection conn=null;
		//Prepare driver to read data
		Class.forName(driver).newInstance();
		//Create connection with your option
		conn = DriverManager.getConnection(url+dbName,
		            username, pass);
		//Return a connection
		 return conn;
	}
	
	//Login Function
	//Check if the username or password is incorrect
	public int mysql(String IDuser, String IDpass)
	{
		//Set value is false
		int value=0;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("select username, password, accType from login_info where username=?");
			//Set the first element with username
			pst.setString(1, IDuser);
			//Prepare a resultset to save temporary data take from SQL
			ResultSet result=null;
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
			//If the result has one row or more
			while(result.next())
			{
				//With any result get from database
				//Check if the password is correct
				if(IDpass.equals(result.getString("password")))
				{
					//Return account type to process login
					value=result.getInt("accType");
					//Break the loop if any result is match
					return value;
				}
			}
			//If the result has no row
			//The value = 0
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return value if there is no row select or a problem is occured
			return value;
		}
	}
	
	//Check a User if exit or not
	public boolean checkUser(String IDuser)
	{
		//Prepare a return value
		//Set value is true
		boolean value=true;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("select username, password, accType from login_info where username=?");
			//Set the first element with username
			pst.setString(1, IDuser);
			//Prepare a resultset to save temporary data take from SQL
			ResultSet result=null;
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
			//If the result has one row or more
			while(result.next())
			{
				//The user must be have a difference name
				//The value will be set to false
				value=false;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The value will be true if the username is the only
			//The value will be false if the username is exit in database
			return value;
		}
	}
	
	//Register to a user to use system
	public int register(String UserID, String UserPass, String Mail, String FName, String LName, String birthday)
	{
		//Prepare a return value
		int value=0;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("insert into login_info(username, password, accType, email, firstname, lastname, joined, birthday) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?);");
			//Admin can not register by this way
			//The user role is always "1"
			String role="1";
			//Create a date format to take time
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			//Get current time of system to variable date
			java.util.Date date = Calendar.getInstance().getTime();
			//Create a string with format what you want
			String reportDate = df.format(date);
			//Set the first element with username
			pst.setString(1, UserID);
			//Set the second element with password
			pst.setString(2, UserPass);
			//Set the third element with role
			pst.setString(3, role);
			//Set the fourth element with email
			pst.setString(4, Mail);
			//Set the fifth element with first name
			pst.setString(5, FName);
			//Set the six element with last name
			pst.setString(6, LName);
			//Set the seven element with date joined
			pst.setString(7, reportDate);
			//Set the eight element with birthday
			pst.setString(8, birthday);
			//Begin insert to database
			value=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Value will be 0 if excute is success
			//Value will be difference from 0 if excute is false
			return value;
		}
	}
	
	//Get information by user
	public ResultSet readInfo(String UserName)
	{
		//Prepare a return value and this is also
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("select firstname, lastname, email, birthday, password from login_info where username=?");
			////Set the first element with username
			pst.setString(1, UserName);
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The resultset will be return anyway
			//May be the username is incorrect
			return result;
		}
	}
	
	//Get result by user
	public ResultSet readResult(String UserName)
	{
		//Prepare a return value
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("select * from my_result where username=?");
			//Set the first element with username
			pst.setString(1, UserName);
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The resultset will be return anyway
			//May be the username is incorrect
			return result;
		}
	}
	
	//Edit information by user
	public boolean editUser(String UserID, String UserPass, String Mail, String birthday)
	{
		//Prepare a return value
		boolean value=false;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("update login_info set password=?, email=?, birthday=?"
					+ "where username=?");
			//Set the first element with password
			pst.setString(1, UserPass);
			//Set the second element with email
			pst.setString(2, Mail);
			//Set the first element with birthday
			pst.setString(3, birthday);
			//Set the first element with usename
			pst.setString(4, UserID);
			//Begin update database
			pst.executeUpdate();
			//Set the value to true
			value=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return varialbe anyway
			return value;
		}
	}
	
	//Delete a user form database
	public boolean deleteUser(String UserID)
	{
		//Prepare a return value
		boolean value=false;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("delete from login_info where username=?;");
			//Set the first element with username
			pst.setString(1, UserID);
			//Begin update database
			pst.executeUpdate();
			//Set value to true
			value=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return variable value anyway
			return value;
		}
	}
	
	//Get the list of user
	//Exclude admin info
	public ResultSet getUser()
	{
		//Prepare a return value
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("select username,password, firstname, lastname, joined from toeic_everyday.login_info where accType='1'");
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return variable value anyway
			return result;
		}
	}
	
	//Save result of a test to database
	public int saveResult(String examination_code, String username, int reading, int listening, String date_made)
	{
		//Prepare a return value
		int value=0;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("insert into my_result(examination_code, username, listening, reading, total, date_made) "
					+ "values (?, ?, ?, ?, ?, ?);");
			//Create a variable 
			int total=0;
			//Set value of total by add two another mark
			total=listening+reading;
			//Set the first element with examination code
			pst.setString(1, examination_code);
			//Set the second element with username
			pst.setString(2, username);
			//Set the third element with listening test mark
			pst.setInt(3, listening);
			//Set the fourth element with reading test mark
			pst.setInt(4, reading);
			//Set the fifth element with total test mark
			pst.setInt(5, total);
			//Set the sixth element with date make test
			pst.setString(6, date_made);
			//Begin insert new row to database
			//Set value to variable value
			value=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Value will be 0 if excute is success
			//Value will be difference from 0 if excute is false
			return value;
		}
	}
	public int saveTest(String examination_code, String username)
	{
		//Prepare a return value
		int value=0;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("INSERT INTO toeic_everyday.practice_read (examination_code, username, date_added, times)"
					+ " values (?, ?, ?, ?);");
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			java.util.Date date = Calendar.getInstance().getTime();
			String reportDate = df.format(date);
			//Set the first element with examination code
			pst.setString(1, examination_code);
			//Set the second element with username
			pst.setString(2, username);
			//Set the third element with date make test
			pst.setString(3, reportDate);
			//Set the sixth element with date make test
			pst.setInt(4, 0);
			//Begin insert new row to database
			//Set value to variable value
			value=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Value will be 0 if excute is success
			//Value will be difference from 0 if excute is false
			return value;
		}
	}
	public int editResult(String examination_code, String username, int listening, int reading, String date_made)
	{
		int value=0;
		try
		{
			Connection conn=connect();
			PreparedStatement pst= null;
			pst= (PreparedStatement) conn.prepareStatement("update my_result set listening=?, reading=?, total=?, date_made=? "
					+ "where username=? and examination_code=?");
			int total=0;
			total=listening+reading;
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			java.util.Date date = Calendar.getInstance().getTime();
			String reportDate = df.format(date);
			pst.setInt(1, listening);
			pst.setInt(2, reading);
			pst.setInt(3, total);
			pst.setString(4, date_made);
			pst.setString(5, username);
			pst.setString(6, examination_code);
			value=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return value;
		}
	}
	
	//Auto increase count time when do test
	public int updateData(String examination_code, String username, String type)
	{
		//Prepare a return value
		int value=0;
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			PreparedStatement pst2= null;
			//Set value to query
			pst2= (PreparedStatement) conn.prepareStatement("select times from "+type+" "
					+ "where username=? and examination_code=?");
			//Set the first element with username
			pst2.setString(1, username);
			//Set the second element with examination_code
			pst2.setString(2, examination_code);
			//Fill data take form SQL to resultset
			result=pst2.executeQuery();
			//For match row selected
			while(result.next())
			{
				//Get value of column times
				//Set value of column times to variable value
			    value = result.getInt("times");
			}
			//Increase count time plus one
			value++;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("update "+type+" set times=? "
					+ "where username=? and examination_code=?");
			//Set the first element with times
			pst.setInt(1, value);
			//Set the first element with username
			pst.setString(2, username);
			//Set the first element with examination_code
			pst.setString(3, examination_code);
			//Begin update column times
			value=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Value will be 0 if excute is success
			//Value will be difference from 0 if excute is false
			return value;
		}
	}
	
	//Get list of full test by user
	public ResultSet getFullTest(String UserName)
	{
		//Prepare a return value
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("SELECT * FROM toeic_everyday.practice_fulltest;");
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The resultset will be return any way
			//May be the username is incorrect
			return result;
		}
	}
	
	//Get list of reading test by user
	public ResultSet getReadTest(String UserName)
	{
		//Prepare a return value
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("SELECT * FROM toeic_everyday.practice_read;");
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The resultset will be return any way
			//May be the username is incorrect
			return result;
		}
	}
	
	//Get list of listening test by user
	public ResultSet getListenTest(String UserName)
	{
		//Prepare a return value
		//Prepare a resultset to save temporary data take from SQL
		ResultSet result = null;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("SELECT * FROM toeic_everyday.practice_listen;");
			//Fill data take form SQL to resultset
			result=pst.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//The resultset will be return any way
			//May be the username is incorrect
			return result;
		}
	}
	
	//Delete a user full test
	public boolean deleteFullTest(String UserID, String examCode)
	{
		//Prepare a return value
		boolean value=false;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("DELETE FROM toeic_everyday.practice_fulltest WHERE examination_code=?;");
			//Set the first element with examination code
			pst.setString(1, examCode);
			//Set the second element with username
			pst.setString(2, UserID);
			//Begin update database
			pst.executeUpdate();
			//Set variable value to true
			value=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return variable value
			return value;
		}
	}
	
	//Delete a user listening test
	public boolean deleteListenTest(String UserID, String examCode)
	{
		//Prepare a return value
		boolean value=false;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("delete from practice_listen where and examination_code=? ;");
			//Set the first element with username
			pst.setString(1, UserID);
			//Set the second element with examination code
			pst.setString(2, examCode);
			//Begin update database
			pst.executeUpdate();
			//Set variable value to true
			value=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return variable value
			return value;
		}
	}
	
	//Delete a user listening test
	public boolean deleteReadTest(String UserID, String examCode)
	{
		//Create return variable
		boolean value=false;
		try
		{
			//Create a connection
			Connection conn=connect();
			//Prepare a null query
			PreparedStatement pst= null;
			//Set value to query
			pst= (PreparedStatement) conn.prepareStatement("delete from practice_read where and examination_code=? ;");
			//Set the first element with username
			pst.setString(1, UserID);
			//Set the second element with examination code
			pst.setString(2, examCode);
			//Begin update database
			pst.executeUpdate();
			//Set variable value to true
			value=true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Return variable value
			return value;
		}
	}
}
