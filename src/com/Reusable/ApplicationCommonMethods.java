package com.Reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationCommonMethods {
	
	public static String parent;
	
	//Invoke application
	public static void invoke(WebDriver driver){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		parent = driver.getWindowHandle();
		driver.manage().deleteAllCookies();
		driver.manage();
		driver.get("http://www.phptravels.net/admin");
		driver.manage().window().maximize();
	}
	
	//Login
	public static void login(WebDriver driver, String un, String pw){
		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	//Logout
	public static void logoff(WebDriver driver){
//		driver.findElement(By.xpath("//i[contains(@class,'down')]")).click();	
//		driver.findElement(By.xpath("//i[contains(@class,'sign-out')]")).click();
		
		JavascriptExecutor j = (JavascriptExecutor)driver;		
		WebElement da = driver.findElement(By.xpath("//i[contains(@class,'down')]"));
		j.executeScript("arguments[0].click()", da);
		
		WebElement lo = driver.findElement(By.xpath("//i[contains(@class,'sign-out')]"));
		j.executeScript("arguments[0].click()", lo);
		
	}
}
