package dao;

import java.io.IOException;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;

public class readFile{
	//Create a static variable
	static XSSFRow row;
	
	
	public readFile(){
	}
	
	
	//Read one row in excel file
	//The location of file is get from outside
	//The row index is get from outside
	//Return a string that read from index, excel file
	public String Read(String strRead, int index) throws FileNotFoundException, IOException, Exception{
		//Prepare a empty string
		String result="";
		//Prepare a File pointer
		File fs=null;
		//Prepare a File stream to read file
		FileInputStream fis=null;
		try
		{
			//Set value of variable result
			result=strRead;
			//Create new File pointer
			fs=new File(strRead);
			//Create new File stream
			fis=new FileInputStream(fs);

			//Create a workbook to read data from excel file
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//Get sheet with index 0
			//The excel file is used only one  sheet
			//The only sheet is the first sheet
			XSSFSheet sheet=workbook.getSheetAt(0);
			//Get a row with index value
			Row row=sheet.getRow(index);
			//Get value from the first cell
			//The excel file is used only one cell
			//The only cell is the first cell
			Cell cell=row.getCell(0);
			//Set variable result by cell value
			result=cell.getStringCellValue();
			//Close workbook
			workbook.close();
		}
		catch (FileNotFoundException ex)
		{
			throw new FileNotFoundException(ex.getMessage());
		}
		catch (IOException ex)
		{
			throw new IOException(ex.getMessage());
		}
		catch (Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
		finally
		{
			//Return result anyway
			//The index or location may be incorrect
			return result;
		}
	}
	
	//Read one row in excel file
	//Check index row if it current background color difference from white
	//The location of file is get from outside
	//The row index is get from outside
	//Return a flag that let other process know true or false
	public boolean ReadAnswer(String strRead, int index) throws FileNotFoundException, IOException, Exception{
		//Prepare a return variable
		boolean finalResult=false;
		//Prepare a File pointer
		File fs=null;
		//Prepare a File stream to read file
		FileInputStream fis=null;
		try
		{
			//Prepare a empty string
			String result="";
			//Create new File pointer
			fs=new File(strRead);
			//Create new File stream
			fis=new FileInputStream(fs);

			//Create a workbook to read data from excel file
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//Get sheet with index 0
			//The excel file is used only one  sheet
			//The only sheet is the first sheet
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			Row row=sheet.getRow(index);
			//Get value from the first cell
			//The excel file is used only one cell
			//The only cell is the first cell
			Cell cell=row.getCell(0);
			//Set variable result by cell value
			result=cell.getStringCellValue();
			//Create new cell style
			//Get cell style from current cell
			//Set cell style to variable style
			CellStyle style = cell.getCellStyle();
			//Create variable to get color
			//Get background color of current cell
			//Set variable colorIdx by current cell background color
		    short colorIdx = style.getFillForegroundColor();
		    //Check if color code is not white
			if(colorIdx!=64)
			{
				//Set variable finalResult to true
				finalResult=true;
			}
			//Close workbook
			workbook.close();
		}
		catch (FileNotFoundException ex)
		{
			throw new FileNotFoundException(ex.getMessage());
		}
		catch (IOException ex)
		{
			throw new IOException(ex.getMessage());
		}
		catch (Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
		finally
		{
			//Return finalResult
			return finalResult;
		}
	}
	
	//Read one row in excel file
	//The location of file is get from outside
	//The row index is get from outside
	//Return number of excel file
	public int Read(String strRead) throws FileNotFoundException, IOException, Exception{
		//Create a return variable
		//Set default value to zero
		int result=0;
		//Prepare a File pointer
				File fs=null;
				//Prepare a File stream to read file
				FileInputStream fis=null;
		try
		{
			//Create new File pointer
			fs=new File(strRead);
			//Create new File stream
			fis=new FileInputStream(fs);

			//Create a workbook to read data from excel file
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			//Get sheet with index 0
			//The excel file is used only one  sheet
			//The only sheet is the first sheet
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			//Get Physical Number Of Rows of current sheet
			result=sheet.getPhysicalNumberOfRows();
			//Close workbook
			workbook.close();
		}
		catch (FileNotFoundException ex)
		{
			throw new FileNotFoundException(ex.getMessage());
		}
		catch (IOException ex)
		{
			throw new IOException(ex.getMessage());
		}
		catch (Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
		finally
		{
			//Return variable result
			return result;
		}
	}
	
	//Delete Folder
	//Location is take from outside
	public int Delete(String strDelete) throws FileNotFoundException, IOException, Exception{
		//Create a return variable
		int result=0;
		//Prepare a File pointer
		File fs=null;
		try
		{
			//Create new File pointer
			fs=new File(strDelete);
			//Using apache poi to delete file
			FileUtils.deleteDirectory(fs);
			result=1;
		}
		catch (FileNotFoundException ex)
		{
			throw new FileNotFoundException(ex.getMessage());
		}
		catch (IOException ex)
		{
			throw new IOException(ex.getMessage());
		}
		catch (Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
		finally
		{
			//Return variable value
			return result;
		}
	}

}
