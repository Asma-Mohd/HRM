package loginpage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;



public class login {
	WebDriver drive;
	String bpath="http://apps.qaplanet.in/qahrm/login.php";
  @Test(enabled=true,priority=1,groups="login")
  public void TC0001() {
	 //drive.get("http://apps.qaplanet.in/qahrm/login.php");
	 drive.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("qaplanet1");
	 drive.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("lab1");
	 drive.findElement(By.xpath("//input[@name='Submit']")).click();
	 Assert.assertEquals(drive.getTitle(),"OrangeHRM");
  }
  @Test(enabled=true,priority=2,groups="login")
  public void TC0002() throws InterruptedException{
	 drive.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("qaplan");
	 drive.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("lab1");
	 Thread.sleep(3000);
	 drive.findElement(By.xpath("//input[@name='Submit']")).click();
	 Assert.assertEquals(drive.findElement(By.xpath("//font[contains(text(),'Invalid Login')]")).getText(),"Invalid Login");
	  
  }
  @Test()
  public void TC0003() throws InterruptedException {
	  drive.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("qaplanet1");
	  drive.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("lab");
	  Thread.sleep(3000);
	  drive.findElement(By.xpath("//input[@name='Submit']")).click();
	  Assert.assertEquals(drive.findElement(By.xpath("//font[contains(text(),'Invalid Login')]")).getText(),"Invalid Login");
  }
  @Parameters("Browser")
 public void browser(String nrs) {
	 if(nrs.equalsIgnoreCase("gg")) {
		 drive=new ChromeDriver();
	 }
	 else if(nrs.equalsIgnoreCase("ff")) {
		 drive=new FirefoxDriver();
		 System.out.println("running with ff");
	 }
 }
 @BeforeMethod
 public void b() {
 drive=new ChromeDriver();
 drive.get(bpath);
 }
@AfterMethod
public void bt() {
	drive.quit();
}
}