package test.exercise3.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import sujit.com.test.Utility;


public class Exercise3 {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
	
@Test
public void OpenBrowser(){
	 driver= new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	 driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
	 
}

// this method test the border of telephone input field(must be red) and tooltip message
@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getTelephoneAttribute(){
	driver.findElement(By.xpath(".//*[@id='request']")).click();
	search=driver.findElement(By.cssSelector("#id_content_contact_phone"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	//Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	Assert.assertEquals(instance.rgbtoHex(search.getCssValue("border-top-color")),instance.testColor);
	Assert.assertEquals(instance.rgbtoHex(search.getCssValue("border-bottom-color")),instance.testColor);
	Assert.assertEquals(instance.rgbtoHex(search.getCssValue("border-left-color")),instance.testColor);
	Assert.assertEquals(instance.rgbtoHex(search.getCssValue("border-right-color")),instance.testColor);

}

// tesing toltip message
@Test(priority=2,dependsOnMethods= {"OpenBrowser"})
public void getTelephoneAttribute1(){
	Actions builder= new Actions(driver);
	WebElement username_tooltip=driver.findElement(By.cssSelector("#id_content_contact_phone"));
	//Mouse hover to that text message
	builder.moveToElement(username_tooltip).build().perform();
	// Extract text from tooltip
	String tooltip_msg=username_tooltip.getText();
	Assert.assertEquals(tooltip_msg, instance.toolTip_Msg, "no match found");


}

// closing browser
@Test(priority=3,dependsOnMethods= {"OpenBrowser"})
public void closingbrowser(){
	driver.close();
	
}

}

