package sujit.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import sujit.com.test.Utility;

import org.testng.Assert;


/*this class will test the characterstics of red button(start button)*/

public class TestRedButton {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
	
	//Initialize the browser
@Test
public void OpenBrowser(){
	 driver= new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	 driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
	 
}

// get the background color
@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getBackgroundColor(){
	search=driver.findElement(By.xpath(".//*[@id='request']"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	String actualBackground= instance.rgbtoHex(search.getCssValue("background-color"));
	Assert.assertEquals(actualBackground,instance.expectedBackgroundColor,"Not Match background-color");
}

// get the color of the start button
@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getColor(){
	String actualColor= instance.rgbtoHex(search.getCssValue("color"));
	Assert.assertEquals(actualColor,instance.expectedColor,"Not Match color");
}

// get the font size of the button

@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getFontSize(){
	String actualFontSize= search.getCssValue("font-size");
	Assert.assertEquals(actualFontSize,instance.expectedFontSize,"Size not Match");
}

//closing the browser
@AfterClass
public void closingbrowser(){
	driver.close();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
}

}
