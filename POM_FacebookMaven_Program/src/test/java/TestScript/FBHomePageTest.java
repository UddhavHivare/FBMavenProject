package TestScript;

import org.testng.annotations.Test;

import Facebook_Pages.FacebookHomePage;
import Facebook_Pages.FacebookLoginPage;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class FBHomePageTest implements IRetryAnalyzer
{	WebDriver driver;
	FacebookHomePage fhp;
	FacebookLoginPage flp;
  @Test(priority = 1)
  public void LoginTest() 
  {
	flp=new FacebookLoginPage(driver);
	flp.enterUserEmail("8698702976");
	flp.enterUserPass("Sandeep@123");
	flp.ClickOnLoginBtn();
  }
  @Test(priority = 2)
  public void HomePageTest()
  {
	  fhp=new FacebookHomePage(driver);
	  fhp.clickOnUserAccountBtn();
	  fhp.clickOnUserProfile();
	  fhp.VerifyUserFullName();
	  Assert.assertEquals(fhp.VerifyUserFullName(),"Sandeep S. Godse");
  }
  @Test(priority = 3)
  public void ScreenShot() throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File srcfile=ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(srcfile, new File("C:\\Users\\Lenovo\\eclipse-workspace\\POM_FacebookMaven_Program\\ScreenShot\\abcd.jpeg"));
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  ChromeOptions option=new ChromeOptions();
	  option.addArguments("--disable-notifications");
	  driver=new ChromeDriver(option);
	  driver.get("https://www.facebook.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  System.out.println(driver.getTitle());
  }

  @AfterClass
  public void afterClass() 
  {
	 driver.quit();
 }
  int counter=0;
  int retrylimit=4;
@Override
public boolean retry(ITestResult result) 
{
	if(counter<retrylimit)
	{
		counter++;
		
		return true;
	}
	return false;
}

}

  



