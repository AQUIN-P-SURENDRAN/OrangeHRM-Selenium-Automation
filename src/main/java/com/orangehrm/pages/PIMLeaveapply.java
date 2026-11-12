package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PIMLeaveapply {
	
	WebDriver driver;
    WebDriverWait wait;
	
	@FindBy(xpath="//span[normalize-space()='Leave']")
    WebElement pimleave;
	
	@FindBy(xpath="//a[normalize-space()='Apply']")
	WebElement applayleave;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	WebElement leavetype;
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-option')]//span[normalize-space()='CAN - Personal']")
	WebElement personalleaveoption;
	
	@FindBy(xpath = "//h6[normalize-space()='Leave']")
	WebElement leavetitle;
	
	@FindBy(xpath = "//label[normalize-space()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]")
	WebElement fromdate;
	
	@FindBy(xpath = "//label[normalize-space()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]")
	WebElement todate;
	
	@FindBy(xpath= "//label[normalize-space()='Comments']/following::textarea")
	WebElement comment;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text --error']")
	WebElement nosuffecentleave;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement applaybuttion;
	
	public PIMLeaveapply(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
	
	public void clickpimleave()
	{	    
		wait.until(ExpectedConditions.elementToBeClickable(pimleave));
		pimleave.click();
	}
	
	public boolean LeaveHeadingDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(leavetitle));
        return leavetitle.isDisplayed();
    }
	
	public void clickapplayleave()
	{
		wait.until(ExpectedConditions.elementToBeClickable(applayleave));
		applayleave.click();
	}
	
	public void selectLeaveType()
	{
	    wait.until(ExpectedConditions.elementToBeClickable(leavetype)).click();

	    wait.until(ExpectedConditions.elementToBeClickable(personalleaveoption)).click();
	}
	
	public void enterFromDate(String fromdate)
	{
	    wait.until(ExpectedConditions.visibilityOf(this.fromdate));
	    this.fromdate.clear();
	    this.fromdate.sendKeys(fromdate);
	}
	
	public void enterToDate(String todate) {

	    wait.until(ExpectedConditions.visibilityOf(this.todate));

	    this.todate.click();
	    this.todate.sendKeys(Keys.COMMAND, "a");
	    this.todate.sendKeys(Keys.BACK_SPACE);
	    this.todate.sendKeys(todate);

	    System.out.println("To Date entered: " +
	            this.todate.getAttribute("value"));
	}
	
	public void Resonforleave(String comment ) 
	{
	    wait.until(ExpectedConditions.visibilityOf(this.comment));
	    this.comment.clear();
	    this.comment.sendKeys(comment);
	}
	
	public void clickleaveapplaybuttion()
	{	    
		wait.until(ExpectedConditions.elementToBeClickable(applaybuttion));
		applaybuttion.click();
	}
	
	public boolean isInsufficientLeaveDisplayed() {
	    return wait.until(
	        ExpectedConditions.visibilityOf(nosuffecentleave)
	    ).isDisplayed();
	}
}
