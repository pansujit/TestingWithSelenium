package sujit.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import sujit.com.test.Utility;

import org.testng.Assert;

/*This class test the check box Veuillez me tenir informé des informations 
 * techniques et des mises à jour de Fujitsu RunMyProcess (FORTEMENT RECOMMANDÉ).*/

public class TestCheckBoxRecomm {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
// this will open the browser
	@Test
public void OpenBrowser() throws InterruptedException{
	 driver= new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	 driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
	 Thread.sleep(3000);
}

//this will get font size of the first tick box
@Test(priority=2,dependsOnMethods= {"OpenBrowser"})
public void getFontSize(){
	search=driver.findElement(By.cssSelector("#id_informed_of_admins_label"));
	String actualFontSize= search.getCssValue("font-size");
	Assert.assertEquals(actualFontSize,instance.expectedFontSize1,"font-Size not matched");
}
//this will get font family of the first tick box
@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getFontFamily(){
	String actualFontFamily="";
	try{
	actualFontFamily= search.getCssValue("font-family");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	//System.out.println(actualFontFamily);
	Assert.assertEquals(actualFontFamily,instance.expectedFontFamily,"font-family not Match");
}




@AfterTest
public void closingbrowser(){
	
	driver.close();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
}

}

