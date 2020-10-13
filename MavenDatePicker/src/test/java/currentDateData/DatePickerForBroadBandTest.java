package currentDateData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DatePickerForBroadBandTest {
	//public static void main(String[] args) throws InterruptedException {
 
@Test
 public void datePicker() throws InterruptedException {
		
		String expMonth = "October 2020";
		
		//String expYear = "2020";
		
		// CHANGE expDay Value while executing
		
				
		String expDay = "05";
			
		System.setProperty("webdriver.chrome.driver", "E:\\javaChromeDriver\\newExe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://bms.eronet.in:8001/customer");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vctv_sureshS");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Viju@4546");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//click on report
		//driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li/a/span[starts-with(text(),'Reports')]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//click on report
		//driver.findElement(By.xpath("(//*[@id=\'sidebar\']//li[2]/a)[2]")).click();
		driver.findElement(By.xpath("(//*[@id=\"sidebar\"]/ul/li/ul/li/a)[3]")).click();
		
		
		Thread.sleep(30000);
		//click on from calendar
		driver.findElement(By.xpath("//input[@id='traffic_sdate']")).click();
		//To check specific month and year from calendar option using while loop
		
		while(true) {
  String text=driver.findElement(By.xpath("(//table/thead/tr[1]/th[2][@class='datepicker-switch'])[1]")).getText();
			
  if(text.equals(expMonth)) {
	  break;
           }//else {
        	   // click on arrow button
        	  // driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[1]")).click();
        	  // System.out.println("No need to click left arrow button in calendar");
         //  }
 
		}
	   // click on specific date
		//html/body/div[4]/div[1]/table/tbody
		
		//driver.findElement(By.xpath("//html/body/div[4]/div[1]/table/tbody[contains(text(),"+expDay+")]")).click();;
		
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td[@class='today day']")).click();
		Thread.sleep(3000);
		// select the daily basis from dropdown
		Select s = new Select(driver.findElement(By.id("period_type")));
		s.selectByVisibleText("Day Wise");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		

	}

}
