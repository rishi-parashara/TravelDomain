package com.PHPTravels.TestScripts.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLogin {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net/admin");
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("admin@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//span[.='Login']")).click();
		Thread.sleep(4000);
		
		if (driver.findElement(By.xpath("//span[.='Dashboard']")).isDisplayed()) {
			System.out.println("PASS: Successfully logged in.");
		} else {
			System.out.println("FAIL: Not logged in.");
		}
		
		//Logout
		driver.findElement(By.xpath("//i[contains(@class,'down')]")).click();	
		Thread.sleep(200);
		driver.findElement(By.xpath("//i[contains(@class,'sign-out')]")).click();
		
		Thread.sleep(1000);
		driver.close();
	}
	
}


