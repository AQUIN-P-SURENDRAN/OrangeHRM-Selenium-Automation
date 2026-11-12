package com.orangehrm.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMFileUpload {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath="//h6[normalize-space()='PIM']")
    WebElement pimHeading;
    
    @FindBy(xpath="//span[normalize-space()='PIM']")
    WebElement pimmenu;
    
    @FindBy(xpath="//li[@class='oxd-topbar-body-nav-tab --parent']")
    WebElement config;
    
    @FindBy(xpath="//a[normalize-space()='Data Import']")
    WebElement datainportoption;
    
    @FindBy(xpath = "//p[normalize-space()='Data Import']")
    WebElement titledataimport;
    
    @FindBy(xpath = "//input[@type='file']")
    WebElement fileinput;
    
    @FindBy(xpath = "//button[normalize-space()='Upload']")
    WebElement fileuploadButton;
    
    @FindBy(xpath = "//*[normalize-space()='No Records Imported']")
    WebElement importResultMessage;

    @FindBy(xpath = "//button[normalize-space()='Ok']")
    WebElement okButton;

    public PIMFileUpload(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
	
	public void clickPIM() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(pimmenu));
		pimmenu.click();
	}
	
	public boolean PIMHeadingDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(pimHeading));
        return pimHeading.isDisplayed();
    }
	
	public void clickConfig() {
	    wait.until(ExpectedConditions.elementToBeClickable(config));
	    config.click();
	}
	
	public void clickDataImport() {
	    wait.until(ExpectedConditions.elementToBeClickable(datainportoption));
	    datainportoption.click();
	}
	
	public boolean TitledatainportDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(titledataimport));
        return titledataimport.isDisplayed();
    }
	
	public void uploadFile(String filePath)
	{
		fileinput.sendKeys(filePath);
	}
	
	public boolean isFileSelected() 
	{
	    String fileValue = fileinput.getAttribute("value");
	    return fileValue != null && fileValue.endsWith("importData.csv");
	}
	
	public void clickUpload() 
	{
		fileuploadButton.click();
	}
	
	public boolean isImportResultDisplayed() {
	    wait.until(ExpectedConditions.visibilityOf(importResultMessage));
	    return importResultMessage.isDisplayed();
	}

	public void clickOkalert() 
	{
	    okButton.click();
	}
}
