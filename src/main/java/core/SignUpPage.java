package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SignUpPage 
{
   
	String url = null;
   	String title_SignUp_expected = null;

	String title_facebook_expected = null;
	String title_twitter_expected = null;
	String title_flickr_expected = null;
	String title_youtube_expected = null;
	
 	String error_fname_empty_expected = null;
	String error_lname_empty_expected = null;
	String error_email_empty_expected = null;
	String error_phone_empty_expected = null;
	
	String error_firstName_invalidImput_expected = null;
	String error_lastName_invalidImput_expected = null;
	String error_email_invalidImput_expected = null;
	String error_phone_invalidImput_expected = null;
	
	String fname = null;
	String lname = null;
	String email = null;
	String phone = null;	

	//public static WebDriver  driver;
	 
	//WebDriver driver = new HtmlUnitDriver();
	WebDriver driver = new FirefoxDriver();  
	
	public void before(){
	
	//	driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	public void after(){		
		driver.close();
		driver.quit();
		System.out.println("All Test Cases - DONE");
	}
	
	public  String getTitlePage (){
		String actual_title = driver.getTitle();
        return actual_title;
	}
	
	public static Boolean isElementExist(WebDriver driver, String element_id,  String elementName)  {
		boolean isExist = true;
		try { 
			driver.findElement(By.id(element_id)).isDisplayed();
	
		} 
		catch ( NoSuchElementException e  ){
			isExist = false;
				}		
			return isExist;  
	}

	public  Boolean verifyTitlePage (String expected_title){
		Boolean b =    getTitlePage ().equals(expected_title);
		return b; }

	public String verify_imageLINK( String id_link) {
		driver.findElement(By.id(id_link)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	
		ArrayList<String> allTabs = new ArrayList<String>(
			   driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		String title_link_actual = getTitlePage();
		System.out.println("Title acctual is: " + title_link_actual);
		driver.close();
		driver.switchTo().window(allTabs.get(0));
		return title_link_actual;
	}
	
	
	public void readProperties (String file_path){
	// String	file_path = "./src/main/resources/DataSource.properties";	
try {
	Properties property = new Properties();
	property.load(new FileInputStream(file_path));
	
url = property.getProperty("url");
title_SignUp_expected = property.getProperty("title_SignUp_expected" );

title_facebook_expected = property.getProperty("title_facebook_expected");
title_twitter_expected = property.getProperty("title_twitter_expected");
title_flickr_expected = property.getProperty("title_flickr_expected");
title_youtube_expected = property.getProperty("title_youtube_expected");
	
error_fname_empty_expected = property.getProperty("error_fname_empty_expected");
error_lname_empty_expected = property.getProperty("error_lname_empty_expected");
error_email_empty_expected = property.getProperty("error_email_empty_expected");
error_phone_empty_expected = property.getProperty("error_phone_empty_expected");
	
error_firstName_invalidImput_expected = property.getProperty("error_firstName_invalidImput_expected");
error_lastName_invalidImput_expected =  property.getProperty("error_lastName_invalidImput_expected");
error_email_invalidImput_expected =  property.getProperty("error_email_invalidImput_expected");
error_phone_invalidImput_expected =  property.getProperty("error_phone_invalidImput_expected");
	
fname = property.getProperty("fname");
lname = property.getProperty("lname");
email = property.getProperty("email");
phone = property.getProperty("phone");
	
	
	
} catch (FileNotFoundException e) {
	System.out.println("Method 'readProperties()' - BLOCK");
	System.out.println();
	System.out.println(e.getMessage());
} catch (IOException e) {
	System.out.println("Method 'readProperties()' - BLOCK");
	System.out.println();
	System.out.println(e.getMessage());
}	

}//END readProperties	




}//End of Class