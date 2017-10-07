package com.Reusable;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReusableMethods {

	//------------------------------------------------------------------------------------------------------------------------------
	
	//get Cell Value
	public static String getCellValue(String path, String sheet,int r, int c){
		String v="";
		try{
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
		}
		return v;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	
	//get Row Count
	public static int getRowCount(String path, String sheet){
		int row=0;
		try{
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			row=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
		}
		return row;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	//get Column Count
	public static int getColumnCount(String path, String sheet){
		int column=0;
		try{
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			column=wb.getSheet(sheet).getRow(0).getLastCellNum();
		}
		catch(Exception e){
		}
		return column;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------

}
