package com.Reusable;

import java.util.Set;

import org.openqa.selenium.WebDriver;


public class ReusableMethods {
	
	//close Browser is used to close all browsers
	public static void closeBrowser(WebDriver driver){
		driver.quit();
	}
	
	//Close Browsers will close current browser
	public static void closeCurrentBrowser(WebDriver driver){
		driver.close();
	}
	
	//Close Browsers will close
	public static void closeAllBrowser(WebDriver driver){
		Set<String> lWindowHandles = driver.getWindowHandles();
		for(String a:lWindowHandles){
			driver.switchTo().window(a);
			String sTitle = driver.getTitle();
			driver.close();
			System.out.println("\n" + sTitle + " Page closed.");
		}
	}
	
}
