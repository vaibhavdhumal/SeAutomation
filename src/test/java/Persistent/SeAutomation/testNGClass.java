package Persistent.SeAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGClass {
	

	  @BeforeTest
	  public void beforetest() {
		  
		  System.out.println("Before test");
	  }
	  
	  

	  @AfterTest
	  public void aftertest() {
		  
		  System.out.println("After test");
	  }
	  
	  

	  @BeforeSuite
	  public void beforesuite() {
		  
		  System.out.println("Before Suite");
	  }
	  
	  @AfterSuite
	  public void aftersuite() {
		  
		  System.out.println("After Suite");
	  }
	  
	  @BeforeClass
	  public void beforeclass() {
		  
		  System.out.println("Before Class");
	  }
	  
	  @AfterClass
	  public void afterclass() {
		  
		  System.out.println("After Class");
	  }
	  

	  @BeforeMethod
	  public void beforemethod() {
		  
		  System.out.println("Before Method");
	  }
	  
	  @AfterMethod
	  public void aftermethod() {
		  
		  System.out.println("After Method");
	  }
	
	
  @Test(priority=2)
  public void test1() {
	  
	  System.out.println("I am in test1");
  }
  
  
  @Test(dataProvider="movieData",priority=1)
  public void test2(String filmname,String status) {
	  
	  System.out.println("I am in test2");
	  System.out.println("Film Details:\n"+filmname+" is "+status);
  }
  
  
  @DataProvider
  public Object[][] movieData(){
	  
	Object[][] filmList=new Object[2][2];
	filmList[0][0]="Lai Bhaari";
	filmList[0][1]="HIT";	
	filmList[1][0]="ASTU";
	filmList[1][1]="flop";
	return filmList;
	  
	  
  }
  
  
  
}
