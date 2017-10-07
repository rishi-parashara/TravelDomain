package test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Suppliers {
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

		//Accounts -> Suppliers -> Add
		driver.findElement(By.xpath("//span[.='Accounts']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.linkText("Suppliers")).click();
//		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(4000);


		//Enter detail to create Suppliers
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Purpose");
		
		//Creating time stamp
		Date d = new Date();
		String ts = d.toString().replaceAll(":", ".").replaceAll(" ", "");
		
		String sEmailId = "testingpurpose" + ts + "@gmail.com";
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
			System.out.println("PASS: Successfully Suppliers created. 'Changes Saved!' displayed.");
		}else{
			System.out.println("FAIL: Suppliers NOT created. 'Changes Saved!' NOT displayed.");
		}


		//Logout using JS
		JavascriptExecutor j = (JavascriptExecutor)driver;

		WebElement da = driver.findElement(By.xpath("//i[contains(@class,'down')]"));
		j.executeScript("arguments[0].click()", da);

		WebElement lo = driver.findElement(By.xpath("//i[contains(@class,'sign-out')]"));
		j.executeScript("arguments[0].click()", lo);


		Thread.sleep(1000);
		driver.close();

	}

}
