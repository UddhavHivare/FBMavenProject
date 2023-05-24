package Facebook_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage 
{
	WebDriver driver;
	
	//Page Factory
	@FindBy(xpath = "//div[@class='x78zum5 x1n2onr6']//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z']")
	WebElement UserAccountBtn;
	@FindBy(xpath = "//a//div[starts-with(@class,'x9f619 x1n2onr6 x1ja2u2z x78zum5 x2lah0s x1qughib x6s0dn4 xozqiw3 x1q0g3np x1')]")
	WebElement UserProfile;
	@FindBy(xpath = "//h1[@class='x1heor9g x1qlqyl8 x1pd3egz x1a2a7pz']")
	WebElement UserFullName;
	
	//Constructor
	public FacebookHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnUserAccountBtn()
	{
		UserAccountBtn.click();
	}
	public void clickOnUserProfile()
	{
		UserProfile.click();
	}
	public String VerifyUserFullName()
	{
		String getUserText=UserFullName.getText();
		return getUserText;
		
		
	}
}
