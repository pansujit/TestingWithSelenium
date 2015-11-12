package test.radio.com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import sujit.com.test.Utility;

/*This will test the false error of the google apps usage in the web*/

public class DomainGoogleDisappear {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
	
//opening browser 
	@Test
public void OpenBrowser(){
	 driver= new FirefoxDriver();
	 driver.get(instance.base_URL);
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
}
//This Method will check "yes" button for google play
@Test(priority=1, dependsOnMethods={"OpenBrowser"})
public void clickListElement(){
	driver.findElement(By.cssSelector("#id_infos_use_google_apps_0")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
//this method will disappear the google domain name

@Test(priority=2,dependsOnMethods={"clickListElement"})
public void googleDomainDisappear() throws InterruptedException{
	driver.findElement(By.cssSelector("#id_authenticationpolicy_1")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	
}
// this method will try to click on domain name
@Test(priority=3,dependsOnMethods={"googleDomainDisappear"})
public void checkError(){
	driver.findElement(By.cssSelector("#id_domain_name")).click();
	
}
//closing website
@Test(priority=4,dependsOnMethods={"checkError"})
public void closeDriver(){
	driver.close();
}
	
}


