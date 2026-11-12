package com.orangehrm.base;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.orangehrm.pages.OrangeLogin;
import com.orangehrm.pages.OrangePIMpage;
import com.orangehrm.pages.PIMFileUpload;
import com.orangehrm.pages.PIMLeaveapply;
import com.orangehrm.pages.orangeDashboard;

public class orangebase
{
	
	public static WebDriver driver;
	public OrangeLogin li;
	public WebDriverWait wait;
	public orangeDashboard dashboard;
	public OrangePIMpage pim ;
	public PIMFileUpload Pimfile;
	public PIMLeaveapply Pimleave;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		
	}
	
	@BeforeMethod
	public void bfrmthd()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));  //wait object created 
		li = new OrangeLogin(driver);
		dashboard = new orangeDashboard(driver);
		pim = new OrangePIMpage(driver);
		Pimfile = new PIMFileUpload(driver);
		Pimleave = new PIMLeaveapply(driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	public void login() {
        li.setvalues("Admin", "admin123");
        li.loginClick();
    }
	
	public void logout() {

	    dashboard.clickProfileMenu();
	    dashboard.ClickLogout();

	}
	
}