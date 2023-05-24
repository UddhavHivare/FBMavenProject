package Facebook_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage 
{
	WebDriver driver;
	
	//Page Factory
	@FindBy(xpath ="//input[@id='email']" )
	WebElement UserEmail;
	@FindBy(xpath = "//input[@id='pass']")
	WebElement UserPass;
	@FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
	WebElement LoginBtn;
	
	//Constructor
	public  FacebookLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterUserEmail(String userEmail)
	{
		UserEmail.sendKeys(userEmail);
	}
	public void enterUserPass(String userPass)
	{
		UserPass.sendKeys(userPass);
	}

	public void ClickOnLoginBtn()
	{
		LoginBtn.click();
	}
}
