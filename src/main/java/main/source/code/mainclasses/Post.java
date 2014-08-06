package main.source.code.mainclasses;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



//Publish Post

public class Post {
	
	WebDriver driver;
	private static Logger log=Logger.getLogger(Post.class);
	
	@FindBy(how=How.ID,using="title-prompt-text")
	WebElement title1;

	@FindBy(how=How.ID,using="content")
	WebElement content;
	
	@FindBy(how=How.ID,using="publish")
	WebElement publish;
	
	@FindBy(how=How.XPATH,using="//a[@id='content-html']")
	WebElement contentClick;
	
	
	public Post(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	

	
	public Dashboard addPost(String title,String descritpion)
	{
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  //WebElement title1=driver.findElement(By.id("title-prompt-text"));
		DOMConfigurator.configure("log4j.xml");
		  
		  title1.sendKeys(title);
		  //WebElement contentClick=driver.findElement(By.xpath("//a[@id='content-html']"));
		  //WebElement content=driver.findElement(By.id("content"));
		  //WebElement publish=driver.findElement(By.id("publish"));
		  contentClick.click();
		  content.sendKeys(descritpion);
		  publish.click();
		  log.info("Post is published");
		
		return PageFactory.initElements(driver, Dashboard.class);
	}
	

}
