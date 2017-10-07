package com.PHPTravels.TestScripts.Accounts.Admin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Reusable.ApplicationCommonMethods;
import com.Reusable.ApplicationSpecificMethods;
import com.Reusable.ReusableMethods;
import com.Reusable.ExcelReusableMethods;
public class CreateAdminUser {
	
	public static final String INPUT_PATH = "./Scripts/TestData.xlsx";	
	public static WebDriver driver;	
	public static String un;
	public static String pw;
	public static String fn;
	public static String ln;
	public static String eId;
	public static String uPw;
	public static String cNo;
	public static int i;
	
	//##### Setting the path of the drivers #####
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	
	public void execute() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);

		int rowCount = ExcelReusableMethods.getRowCount(INPUT_PATH, "CreateAdminUser");
		un = ExcelReusableMethods.getCellValue(INPUT_PATH, "Login", 1, 0);
		pw = ExcelReusableMethods.getCellValue(INPUT_PATH, "Login", 1, 1);
				
		//Invoke the Browser
		ApplicationCommonMethods.invoke(driver);

		//Login
		ApplicationCommonMethods.login(driver, un, pw);
		//Verify Login
		ApplicationSpecificMethods.verifyLogin(driver);

		for( i=1; i<=rowCount; i++){
			fn = ExcelReusableMethods.getCellValue(INPUT_PATH, "CreateAdminUser", i, 0);
			ln = ExcelReusableMethods.getCellValue(INPUT_PATH, "CreateAdminUser", i, 1);
			eId = ExcelReusableMethods.getCellValue(INPUT_PATH, "CreateAdminUser", i, 2);
			uPw = ExcelReusableMethods.getCellValue(INPUT_PATH, "CreateAdminUser", i, 3);
			cNo = ExcelReusableMethods.getCellValue(INPUT_PATH, "CreateAdminUser", i, 4);
		
			//Create Admin User
			ApplicationSpecificMethods.createUser(driver, "Admins", fn, ln, eId, uPw, cNo);			
			//Verify the user creation
			ApplicationSpecificMethods.verifyChangesSaved(driver, "Created");
		}
		
		//Logout
		ApplicationCommonMethods.logoff(driver);
		//Verify Logout
		ApplicationSpecificMethods.verifyLogout(driver);

		//Close the browser
		ReusableMethods.closeAllBrowser(driver);
	}

	public static void main(String[] args) {
		
		CreateAdminUser c = new CreateAdminUser();
		c.execute();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}










/*
public static void main(String[] args) {

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);

	//Invoke the Browser
	ApplicationCommonMethods.invoke(driver);

	//Login
	ApplicationCommonMethods.login(driver);
	//Verify Login
	ApplicationSpecificMethods.verifyLogin(driver);

	//Create Admin User
	ApplicationSpecificMethods.createUser(driver, "Admins");			
	//Verify the user creation
	ApplicationSpecificMethods.verifyChangesSaved(driver, "Created");

	//Logout
	ApplicationCommonMethods.logoff(driver);
	//Verify Logout
	ApplicationSpecificMethods.verifyLogout(driver);

	//Close the browser
	ReusableMethods.closeAllBrowser(driver);
}*/
