package test;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Reusable.ExcelReusableMethods;

public class DemoExcel {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream xl = new FileInputStream("D:/TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(xl);
		
		Sheet ws = wb.getSheet("CreateUser");
		
		//get Row Count
		int rowCount = ws.getLastRowNum();
		System.out.println("No. of Rows = " +  rowCount);
		
		//get Column Count
		Row r = ws.getRow(0);
		int clmCount = r.getLastCellNum();
		System.out.println("No. of Columns = " + clmCount);
		
		//get value
		String val = ws.getRow(1).getCell(0).toString();
		System.out.println(val);
				
//		System.out.println(ws.getRow(0).getCell(0).toString());
//		System.out.println(ws.getRow(0).getCell(1).toString());
//		System.out.println(ws.getRow(1).getCell(0).toString());
//		System.out.println(ws.getRow(1).getCell(1).toString());
		
//		System.out.println(ws.getRow(2).getCell(0).toString());
//		System.out.println(ws.getRow(2).getCell(1).toString());
//
//		String a = ws.getRow(2).getCell(0).toString();
//		System.out.println(Integer.parseInt(a));
		
		
//		for(i=1; i<=rowCount; i++){
//			un=ExcelReusableMethods.getCellValue(INPUT_PATH, "Login", i, 0);
//			pw=ExcelReusableMethods.getCellValue(INPUT_PATH, "Login", i, 1);
//		}
	}
}
