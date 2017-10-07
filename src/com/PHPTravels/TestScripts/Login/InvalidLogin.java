package com.PHPTravels.TestScripts.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin {
	//##### Setting the path of the drivers #####
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception {

		//Invoke the browser
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		//Enter the URL to launch application
		driver.get("http://www.phptravels.net/admin");

		//Maximize the browser
		driver.manage().window().maximize();

		//Login to application with wrong password
		driver.findElement(By.xpath("(//input[@type='text'])")).sendKeys("admin@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demoadmin****");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		String sActualError = driver.findElement(By.xpath("//div[@class='alert alert-danger loading wow fadeIn animated animated']")).getText();

		String sExpected = "Invalid Login Credentials";

		if(sExpected.equals(sActualError)){
			System.out.println("PASS: Proper Error message is displayed as ' " + sActualError + " '");
		}else{
			System.out.println("FAIL: Proper Error message is NOT displayed.");
		}

		//Close the browser
		driver.close();
	}
}

