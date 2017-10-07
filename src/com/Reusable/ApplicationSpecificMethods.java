package com.Reusable;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApplicationSpecificMethods {

	//--------------------------------------------------------------------------------------------------------------------------------

	// Create User method
	public static void createUser(WebDriver driver, String userType, String fn, String ln, String eId, String uPw, String cNo){
		//Accounts -> userType -> Add
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
		driver.findElement(By.linkText(userType)).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Enter detail to create Customers
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(fn);
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(ln);
		
//		//Creating time stamp
//		Date d = new Date();
//		String ts = d.toString().replaceAll(":", ".").replaceAll(" ", "");
//		String sEmailId = "user." + ts + "@gmail.com";
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(eId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(uPw);
		
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(cNo); 

		WebElement listBox = driver.findElement(By.name("country"));				
		Select select = new Select(listBox);
		select.selectByVisibleText("India");

		//Car check box to select -> Submit
		if (userType.equals("Admins") || userType.equals("Suppliers")){
			driver.findElement(By.xpath("//input[@value='addCars']/..")).click();
			driver.findElement(By.xpath("//input[@value='addHotels']/..")).click();
			driver.findElement(By.xpath("//input[@value='addFlights']/..")).click();
			driver.findElement(By.xpath("//input[@value='addTours']/..")).click();
		}

		driver.findElement(By.xpath("//button[.='Submit']")).click();

	}

	//--------------------------------------------------------------------------------------------------------------------------------

	// Delete User method
	public static void deleteUser(WebDriver driver, String userType, String sEmailId){
		//Accounts -> userType -> Add
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
		driver.findElement(By.linkText(userType)).click();
		
		//Delete
		String xp = "//a[.='" + sEmailId + "']/../..//i[@class='fa fa-times']"; 

		driver.findElement(By.xpath(xp)).click();		
		//Accept the JSpopup.
		driver.switchTo().alert().accept();		

	}

	//--------------------------------------------------------------------------------------------------------------------------------

	// Modify User method
	public static void ModifyUser(WebDriver driver, String emailID){

	}	

	//--------------------------------------------------------------------------------------------------------------------------------

	//Verify Changes Saved method
	public static void verifyChangesSaved(WebDriver driver, String operationType){
		//Verify Changes Saved!
		if (driver.findElement(By.xpath("//h4[text()='Changes Saved!']")).isDisplayed()){
			System.out.println("PASS: User " + operationType + " Successfully. 'Changes Saved!' displayed.");
		}else{
			System.out.println("FAIL: User NOT " + operationType + ". 'Changes Saved!' NOT displayed.");
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	//Verify Login method
	public static void verifyLogin(WebDriver driver){
		if (driver.findElement(By.xpath("//span[.='Dashboard']")).isDisplayed()) {
			System.out.println("PASS: Login is Successful.");
		} else {
			System.out.println("FAIL: NOT able to Login.");
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	//Verify Logout method
	public static void verifyLogout(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.findElement(By.name("password")).isDisplayed()) {
			System.out.println("PASS: Logout is Successful.");
		} else {
			System.out.println("FAIL: NOT able to Logout.");
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------

}
