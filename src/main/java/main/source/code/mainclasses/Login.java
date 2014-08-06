package main.source.code.mainclasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


//import PageObject.Dashboard;

//Login related functions
public class Login {
WebDriver driver;

private static Logger log=Logger.getLogger(Login.class);

@FindBy(how=How.ID,using="user_login")
WebElement userId;

@FindBy(how=How.ID,using="user_pass")
WebElement passwd;

@FindBy(how=How.ID,using="wp-submit")
WebElement submit;

	
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public Dashboard login_success(String user, String pass)
	{
		/*WebElement userId=driver.findElement(By.id("user_login"));
		WebElement passwd=driver.findElement(By.id("user_pass"));
		WebElement submit=driver.findElement(By.id("wp-submit"));
		  
		 // logIn.click();
		  */
		
		DOMConfigurator.configure("log4j.xml");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		userId.sendKeys(user);
		passwd.sendKeys(pass);
		submit.click();	
		log.info("User is logged in to site");
		
		return PageFactory.initElements(driver, Dashboard.class);
		
	}
	
	public void invalidLogin(String UserName,String Passwrord)
	{
		
	}
	
	public void forgotPass(String Username)
	{
		
	}
	
	public void signUp()
	{
		
	}
}
