package Persistent.SeAutomation;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class getExcelData {
	
	@DataProvider
  public Object[][] getExcelContents() throws JXLException, IOException {
	  
	  Workbook book=Workbook.getWorkbook(new File("./src/test/Frends.xls"));
	  Sheet sheet=book.getSheet(0);
	  
	  Object[][] title=new Object[3][2];
	  title[0][0]=(String)sheet.getCell(0, 0).getContents();
	  title[1][0]=(String)sheet.getCell(0, 1).getContents();	
	  title[2][0]=(String)sheet.getCell(0, 2).getContents();
	  title[0][1]=(String)sheet.getCell(1, 0).getContents();
	  title[1][1]=(String)sheet.getCell(1, 1).getContents();	
	  title[2][1]=(String)sheet.getCell(1, 2).getContents();
	  
	  String name1=sheet.getCell(0, 0).getContents();
	  book.close();
	  return title;
	  	  	  
  }
	
	 @Test(dataProvider="getExcelContents",priority=1)
	  public void test2(String Title,String Description) {
		  
		  
		  System.out.println("Film Details:\n"+Title+" for "+Description);
	  }
	 
	
	
	@Test
	public void createExcel() throws JXLException, IOException {
		  
		
			
			WritableWorkbook newBook=Workbook.createWorkbook(new File("./src/test/Test.xls"));
			WritableSheet sheet=newBook.createSheet("Master", 0);
			Label l1= new Label(0,0,"one");
			sheet.addCell(l1);
			newBook.write();
			newBook.close();
		  
	}
	
	@Test
	public void modifyExcel() throws JXLException, IOException {
		  
		
		Workbook oldCopy=Workbook.getWorkbook(new File("./src/test/Test.xls"));
		WritableWorkbook newCopy=Workbook.createWorkbook(new File("./src/test/copyTest.xls"),oldCopy);
		WritableSheet sheet1=newCopy.getSheet(0);
		Label l2= new Label(2,2,"Copy Content");
		sheet1.addCell(l2);
		newCopy.write();
		oldCopy.close();
		newCopy.close();
	  
	}
	
		
	
 
}
