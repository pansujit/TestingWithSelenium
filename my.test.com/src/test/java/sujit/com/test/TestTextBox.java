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

/*the input fields (text boxes are tested here. there are six text input
 * field that need to be testes*/


public class TestTextBox {
	public static WebDriver driver;
	public WebElement search;
	Utility instance= new Utility();
	// Initialize the browser
@Test
public void OpenBrowser() throws Throwable{
	 driver= new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	 driver.get("https://live.runmyprocess.com/pub/621758689/appli/25209?P_mode=LIVE&P_language=fr");
	 Thread.sleep(3000);
}
// getting attributes of first name fields and getting font-family used
@Test(priority=1,dependsOnMethods= {"OpenBrowser"})
public void getFirstNameAttribute(){
	search=driver.findElement(By.cssSelector("#id_content_contact_first_name"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	
}

// getting the font-size of first name input field
@Test(priority=2,dependsOnMethods= {"OpenBrowser"})
public void getFirstNameAttribute1(){
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );
	
}
//getiing the alignment of text  of the first name input field
@Test(priority=3,dependsOnMethods= {"OpenBrowser"})
public void getFirstNameAttribute2(){
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );

}
// second second input field Surname and getting font-family

@Test(priority=4,dependsOnMethods= {"OpenBrowser"})
public void getNameAttribute(){
	search=driver.findElement(By.cssSelector("#id_content_contact_last_name"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	
}
// text align 
@Test(priority=5,dependsOnMethods= {"OpenBrowser"})
public void getNameAttribute1(){
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );

}
// font size
@Test(priority=6,dependsOnMethods= {"OpenBrowser"})
public void getNameAttribute2(){
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );
	

}
// email input field and font family
@Test(priority=7,dependsOnMethods= {"OpenBrowser"})
public void getEmailAttribute(){
	search=driver.findElement(By.cssSelector("#id_content_contact_email"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	
}

// font-size
@Test(priority=8,dependsOnMethods= {"OpenBrowser"})
public void getEmailAttribute1(){
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );

}
//alignment of text
@Test(priority=9,dependsOnMethods= {"OpenBrowser"})
public void getEmailAttribute2(){
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );

}

// confirm email address and getting font family of text
@Test(priority=10,dependsOnMethods= {"OpenBrowser"})
public void getConfirmEmailAttribute(){
	search=driver.findElement(By.cssSelector("#id_confirm"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	
}

// getting font-size
@Test(priority=11,dependsOnMethods= {"OpenBrowser"})
public void getConfirmEmailAttribute1(){
	search=driver.findElement(By.cssSelector("#id_confirm"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );
	
}

// getting alignment of the text
@Test(priority=12,dependsOnMethods= {"OpenBrowser"})
public void getConfirmEmailAttribute2(){
	search=driver.findElement(By.cssSelector("#id_confirm"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );
	
}

//testing telephone input field properties and compare font family
@Test(priority=13,dependsOnMethods= {"OpenBrowser"})
public void getTelephoneAttribute(){
	search=driver.findElement(By.cssSelector("#id_content_contact_phone"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
	
}
// comapre font-size
@Test(priority=14,dependsOnMethods= {"OpenBrowser"})
public void getTelephoneAttribute1(){
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );
}

// getting and comapring alignment of text
@Test(priority=15,dependsOnMethods= {"OpenBrowser"})
public void getTelephoneAttribute2(){
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );

}
//getting enterprise attributes and comapring the font family

@Test(priority=16,dependsOnMethods= {"OpenBrowser"})
public void getEnterpriseAttribute(){
	search=driver.findElement(By.cssSelector("#id_content_company_name"));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	Assert.assertEquals(search.getCssValue("font-family"),instance.expectedFontFamily,"Not Matching font-family");
}

// comapring the font size
@Test(priority=17,dependsOnMethods= {"OpenBrowser"})
public void getEnterpriseAttribute1(){
	Assert.assertEquals(search.getCssValue("font-size"),instance.expextedFontSizeTextBox,"Not Matching font-size" );
}

//comparing alignment of text
@Test(priority=18,dependsOnMethods= {"OpenBrowser"})
public void getEnterpriseAttribute2(){
	
	Assert.assertEquals(search.getCssValue("text-align"),instance.expectedTextAlignTextBox,"Not Matching text-Align" );
}

//closing of browser
@AfterClass
public void closingbrowser(){
	driver.close();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
}

}
