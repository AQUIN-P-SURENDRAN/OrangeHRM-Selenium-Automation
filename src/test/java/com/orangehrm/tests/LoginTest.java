package com.orangehrm.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.orangebase;


public class LoginTest extends orangebase
{
	@Test(priority = 1)	 
	public void loginTest() 
	{
	     System.out.println("OrangeHRM Login Page Opened");
	     li.setvalues("Admin", "admin123");
	     li.loginClick();
	     System.out.println("Login Successful");
	 }
	
	@Test(priority = 2)

	public void verifyTitle()
	{
	   String pageTitle = driver.getTitle();
	   Assert.assertEquals(pageTitle, "OrangeHRM");
	}
	
	@Test(priority = 3)

	public void verifyurl()
	{
		String currenturl=driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("/dashboard"));
        System.out.println("Login Successful - Dashboard is displayed");
	}
}

