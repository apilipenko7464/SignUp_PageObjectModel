package core;

import static org.junit.Assert.*;
//import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

public class SignUpTest_JUnit {

	public static  SignUpPage sup = new SignUpPage();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sup.readProperties("./src/main/resources/DataSource.properties");
		System.out.println("Starting Firefox driver.....");
		sup.before();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sup.after();
	}





	@Test
	public void test_01_verifyTitle () {
	     assertEquals(  "Test_01 FAILED: Unexpected Title ", sup.title_SignUp_expected,  sup.getTitlePage());	  
	     }

	
	@Test 
	  public void test_02_verify_link_facebook () {		
		Assert.assertEquals(sup.verify_imageLINK("id_img_facebook"), sup.title_facebook_expected); 	
}
	
	
	
	@Test //(enabled = false)
	public void test_03_verify_link_twitter () {		
		Assert.assertEquals(sup.verify_imageLINK("id_img_twitter"), sup.title_twitter_expected); 		
	}
	
	@Test //(enabled = false)
	  public void test_04_verify_link_flickr () {		
		Assert.assertEquals(sup.verify_imageLINK("id_img_flickr"), sup.title_flickr_expected); 		
	}
	
	@Test //(enabled = false)
	  public void test_05_verify_link_youtube () {		
		Assert.assertEquals(sup.verify_imageLINK("id_img_youtube"), sup.title_youtube_expected); 		
	}
	
}