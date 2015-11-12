package test.radio.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/* This class will check the optional box (GOOGLE APPS) that by clicking the  "oui"*/

public class CheckRadioButton {
	WebDriver driver;
	WebElement search; 
	//Initialize the driver and open the web
	@Test
	public void OpenBrowser(){
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	//This Method will check "yes" button for google play
	@Test(priority=1, dependsOnMethods={"OpenBrowser"})
	public void clickListElement(){
		driver.findElement(By.id("id_infos_use_google_apps_0")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//This will check the items that displayed after clicking "oui" 
	
	@Test(priority=2,dependsOnMethods={"OpenBrowser","clickListElement"})
	public void checkGoogleElement(){
		
		System.out.println(driver.findElement(By.cssSelector("#id_EzEc4S>h2>strong>p")).getSize());
		//this is very hard to find the no of element using webdriver for me.
	}
	
	
	//post operation after completing the website will close.
	
	@Test(priority=3,dependsOnMethods= {"OpenBrowser","checkGoogleElement"})
	public void closingbrowser(){
		driver.close();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}

}
