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

import test.source.testclasses.LoginTestClass;

//import PageObject.Login;

public class Dashboard {
	

WebDriver driver;

private static Logger log=Logger.getLogger(LoginTestClass.class);

@FindBy(how=How.XPATH,using="//div[text()='Posts']")
WebElement posts;

@FindBy(how=How.LINK_TEXT,using="Add New")
WebElement addNew;

	
	public Dashboard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	public Login logout()
	{
		
		return PageFactory.initElements(driver, Login.class);
	}
	
	public Post navigate1()
	{
		
		DOMConfigurator.configure("log4j.xml");
		//WebElement posts=driver.findElement(By.xpath("//div[text()='Posts']"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		posts.click();
		log.info("Under Posts menu");
		//WebElement addNew=driver.findElement(By.linkText("Add New"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addNew.click();
		log.info("Add New post window is available");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, Post.class);
		
	}
	

}
