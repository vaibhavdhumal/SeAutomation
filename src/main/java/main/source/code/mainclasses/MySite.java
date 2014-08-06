package main.source.code.mainclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MySite {
	
	WebDriver driver;
	
	public MySite(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public Dashboard navigate()
	{
		driver.findElement(By.xpath("//*[text()='My Sites'])")).click();;
		driver.findElement(By.xpath("//*[text()='Dashboard'])")).click();;
		return new Dashboard(driver);
	}
	
}
