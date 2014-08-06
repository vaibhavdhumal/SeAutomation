package test.source.testclasses;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import main.source.code.mainclasses.Dashboard;
import main.source.code.mainclasses.MySite;
import main.source.code.mainclasses.Login;
import main.source.code.mainclasses.Post;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class LoginTestClass {
	
	WebDriver driver;
	Login loginUser;
	MySite site;
	Dashboard dash;
	Post post1;
	
	private static Logger log=Logger.getLogger(LoginTestClass.class);

  @Test(dataProvider="getExcelContents",priority=1)
  public void VerifyLogin_Successful(String title,String descritpion) {
	  
	//Check with valid uname and password;
	  
	  	DOMConfigurator.configure("log4j.xml");
	  		  
	  	driver = new FirefoxDriver();		
		
	  	driver.get("https://wordpress.com/wp-login.php");
	  	log.info("URL is fetched in browser");
		driver.manage().window().maximize();
		loginUser= PageFactory.initElements(driver, Login.class);
		//dash=new Dashboard(driver);
		log.info("On Login page");
		dash=loginUser.login_success("vaibhavdhumal09@gmail.com", "Hariom609");
		
		//dash=site.navigate();
		post1=dash.navigate1();
		System.out.println(title+""+descritpion);
		//post2.navigate2();
		dash=post1.addPost(title, descritpion);
		try{
		dash.logout();
		}
		catch(Exception e){
			log.error("Error is",e);
		}
	  
  }
  
  @DataProvider
  public Object[][] getExcelContents() throws JXLException, IOException {
	  
	  Workbook book=Workbook.getWorkbook(new File("./src/test/Frends.xls"));
	  Sheet sheet=book.getSheet(0);
	  
	  Object[][] title=new Object[1][2];
	  title[0][0]=(String)sheet.getCell(0, 1).getContents();
	  title[0][1]=(String)sheet.getCell(1, 1).getContents();
	  
	  //String name1=sheet.getCell(0, 0).getContents();
	  book.close();
	  return title;
	  	  	  
  }
  
  
  
  
}
