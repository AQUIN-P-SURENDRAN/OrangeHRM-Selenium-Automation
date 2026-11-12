package com.orangehrm.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeDashboard {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//h6[normalize-space()='Dashboard']")
    WebElement dashboardHeading;
    
    @FindBy(xpath="//span[normalize-space()='PIM']")
    WebElement pimmenu;
    
    @FindBy(xpath="//span[normalize-space()='My Info']")
    WebElement myinfomenu;
    
    @FindBy(xpath="//span[normalize-space()='Leave']")
    WebElement leavemenu;
    
    @FindBy(xpath="//span[normalize-space()='Time']") 
    WebElement timemenu;
    
    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement proinfo;
    
    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement searchmenu;

    @FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li")
    List<WebElement> menuItems;
    
    @FindBy(xpath="//img[@class='oxd-userdropdown-img']")
    WebElement profilepic;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
    WebElement username;
    
    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")//to click the profile menu so it opens
    WebElement profilemenuclick;
    
    @FindBy(xpath="//ul[contains(@class,'oxd-dropdown-menu')]/li")//list of the profile menu
    List<WebElement> profilemenu;
    
    @FindBy(xpath="//a[@role='menuitem' and normalize-space()='Logout']")
    WebElement logout;
    
  
    public orangeDashboard(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean DashboardDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(dashboardHeading));
        return dashboardHeading.isDisplayed();
    }
    
    public boolean Pimdisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(pimmenu));
        return pimmenu.isDisplayed();
    }
    
    public boolean Myinfodisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(myinfomenu));
        return myinfomenu.isDisplayed();
    }
    
    public boolean Leaveisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(leavemenu));
        return leavemenu.isDisplayed();
    }
    
    public boolean Timeisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(timemenu));
        return timemenu.isDisplayed();
    }
    
    public boolean Profileisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(proinfo));
        return  proinfo.isDisplayed();
    }
    
    public boolean Searchisplayed()
    {
    	wait.until(ExpectedConditions.visibilityOf(searchmenu));
        return  searchmenu.isDisplayed();
    }
    
    public int getMenuCount()
    {
        return menuItems.size();
    }
    
    public boolean ProfilePictureDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(profilepic));
        return profilepic.isDisplayed();
    }

    public boolean UsernameDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(username));
        return username.isDisplayed();
    }
    
    public void clickProfileMenu()
    {
        wait.until(ExpectedConditions.elementToBeClickable(profilemenuclick));
        profilemenuclick.click();
    }

    public int profileMenuCount()
    {
        return profilemenu.size();
    }
    
    //to verify the elements in the profile menu
    public List<String> getProfileMenuTexts()
    {
        List<String> menuTexts = new ArrayList<>();

        for(WebElement menu : profilemenu)
        {
            menuTexts.add(menu.getText().trim());
        }

        return menuTexts;
    }
    
    public boolean LogoutDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(logout));
        return logout.isDisplayed();
    }

	public void ClickLogout() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
	}
	
	public void clickPIM() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(pimmenu));
		pimmenu.click();
	}
    
}