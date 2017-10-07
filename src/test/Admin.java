package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Admin {
	//##### Setting the path of the drivers #####
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception {

		//Invoke the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);

		driver.manage().deleteAllCookies();

		//Enter the URL to launch application
		driver.get("http://www.phptravels.net/admin");

		//Maximize the browser
		driver.manage().window().maximize();

		//Login to application
		driver.findElement(By.xpath("(//input[@type='text'])")).sendKeys("admin@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(5000);		
		if (driver.findElement(By.xpath("//span[.='Dashboard']")).isDisplayed()) {
			System.out.println("PASS: Successfully logged in.");
		} else {
			System.out.println("FAIL: Not logged in.");
		}
		
		//Accounts -> Admins -> Add
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.linkText("Admins")).click();
//		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(4000);
		
		
		//Enter detail to create Admin
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Purpose");
		String sEmailId = "testingpurpose1234@gmail.com";
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(sEmailId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd1234");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9876543210"); 
		
		WebElement listBox = driver.findElement(By.name("country"));				
		Select select = new Select(listBox);
		select.selectByVisibleText("India");
		
		//Car check box to select -> Submit
		driver.findElement(By.xpath("//input[@value='addCars']/..")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[.='Submit']")).click();		
//		Thread.sleep(6000);
		
		//Verify Changes Saved!
		if (driver.findElement(By.xpath("//h4[text()='Changes Saved!']")).isDisplayed()){
			System.out.println("PASS: Successfully Admins created. 'Changes Saved!' displayed.");
		}else{
			System.out.println("FAIL: Admins NOT created. 'Changes Saved!' NOT displayed.");
		}
		
		//Delete
		String xp = "//a[.='" + sEmailId + "']/../..//td[last()]//a[@title='DELETE']"; //a[.='ewrwerwe445@gmail.com']/../..//i[@class='fa fa-times']

		driver.findElement(By.xpath(xp)).click();		
//		Thread.sleep(1000);
		//Accept the JSpopup.
		driver.switchTo().alert().accept();		
//		Thread.sleep(6000);
		
		//Verify Changes Saved! 
//		driver.findElement(By.xpath("//div[3]/div/h4"));
		if (driver.findElement(By.xpath("//h4[text()='Changes Saved!']")).isDisplayed()){
			System.out.println("PASS: Successfully deleted. 'Changes Saved!' displayed.");
		}else{
			System.out.println("FAIL: NOT deleted. 'Changes Saved!' NOT displayed.");
		}
//		Thread.sleep(10000);
		
//		//Logout
//		driver.findElement(By.xpath("//i[contains(@class,'down')]")).click();	
//		Thread.sleep(200);
//		driver.findElement(By.xpath("//i[contains(@class,'sign-out')]")).click();

		//Logout using JS
		JavascriptExecutor j = (JavascriptExecutor)driver;
		
		WebElement da = driver.findElement(By.xpath("//i[contains(@class,'down')]"));
		j.executeScript("arguments[0].click()", da);
		
		WebElement lo = driver.findElement(By.xpath("//i[contains(@class,'sign-out')]"));
		j.executeScript("arguments[0].click()", lo);
		
		
		Thread.sleep(1000);
		driver.close();
		
//		driver.findElement(By.xpath("//input[@name='newssub']/..")).click();		
		
	}
	
}

//<>span Class="select2-chosen">Please Select</span>"

//ul[@class='select2-results']/li[.='India']