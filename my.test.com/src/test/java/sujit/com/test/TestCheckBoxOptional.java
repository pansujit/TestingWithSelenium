package sujit.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import sujit.com.test.Utility;

import org.testng.Assert;
/*Veuillez me tenir informé des nouvelles études de cas, 
 des livres blancs ou de toutes autres événements de Fujitsu RunMyProcess.
 */

public class TestCheckBoxOptional {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
	
	//Initialize the web browser
@Test
public void OpenBrowser() throws Throwable{
	 driver= new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	 driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
	 Thread.sleep(3000);
}
// The get the font size of the checkbox

@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getFontSize(){
	search=driver.findElement(By.cssSelector("#id_informed_of_updates_case_studies_webinar_event_label"));
	String actualFontSize= search.getCssValue("font-size");
	Assert.assertEquals(actualFontSize,instance.expectedFontSize1,"font-Size not matched");
}

// get the fonts are using in the check box
@Test(priority=2,dependsOnMethods= {"OpenBrowser"})
public void getFontFamily(){
	search=driver.findElement(By.cssSelector("#id_informed_of_updates_case_studies_webinar_event_label"));
	String actualFontFamily= search.getCssValue("font-family");
	//System.out.println(actualFontFamily);
	Assert.assertEquals(actualFontFamily,instance.expectedFontFamily,"font-family not Match");
}




@AfterClass
public void closingbrowser(){
	driver.close();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
}

}

