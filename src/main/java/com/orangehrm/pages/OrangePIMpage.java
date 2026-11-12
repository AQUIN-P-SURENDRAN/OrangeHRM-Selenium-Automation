package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrangePIMpage {
	
	WebDriver driver;
    WebDriverWait wait;

   
    @FindBy(xpath="//h6[normalize-space()='PIM']")
    WebElement pimHeading;
    
    @FindBy(xpath="//a[normalize-space()='Add Employee']")
    WebElement addemploye;
    
    @FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    WebElement addemployetitle;
    
    @FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']")
    WebElement addempimage;
    
    @FindBy(xpath = "//input[@type='file']")
    WebElement fileinput;
    
    @FindBy(name="firstName")
    WebElement EMPfirstname;
    
    @FindBy(name="middleName")
    WebElement EMPmidname;
    
    @FindBy(name="lastName")
    WebElement EMPlastname;
    
    @FindBy(xpath="//label[normalize-space()='Employee Id']/following::input[1]")
    WebElement EMPID;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement EMPsavebuttion;
    
    @FindBy(xpath="//h6[normalize-space()='Personal Details']")
    WebElement PersonalDetailtitle;
    
    @FindBy(xpath="//a[normalize-space()='Employee List']")
    WebElement emplistmenu;
    
    @FindBy(xpath="//div[contains(@class,'oxd-input-group')][.//label[normalize-space()='Employee Id']]//input")
    WebElement empidsearch;
    
    @FindBy(xpath="//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    WebElement empnamesearch;
  
    @FindBy(xpath="//button[@type='submit' and normalize-space()='Search']")
    WebElement empsearchbuttion;
    
    @FindBy(xpath = "//*[normalize-space()='(1) Record Found']")
    WebElement deltrecordfound;
    
    @FindBy(xpath="//i[@class='oxd-icon bi-trash']")
    WebElement deltbuttion;
    
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
    WebElement conformdeletaleart;
    
    public OrangePIMpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public boolean PIMHeadingDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(pimHeading));
        return pimHeading.isDisplayed();
    }
    
    public void addnewemploye()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addemploye));
        addemploye.click();
    }
    
    public boolean addnewemployetitleverfy()
    {
        wait.until(ExpectedConditions.visibilityOf(pimHeading));
        return pimHeading.isDisplayed();
    }
      
    public void uploadempimage(String filePath)
	{
		fileinput.sendKeys(filePath);
	}
    
    public void enterEmployeeName(String firstname, String midname, String lastname, String empid)
    {
        wait.until(ExpectedConditions.visibilityOf(EMPfirstname));

        EMPfirstname.clear();
        EMPfirstname.sendKeys(firstname);

        EMPmidname.clear();
        EMPmidname.sendKeys(midname);

        EMPlastname.clear();
        EMPlastname.sendKeys(lastname);
        
        wait.until(ExpectedConditions.visibilityOf(EMPID));

        EMPID.click();
        EMPID.sendKeys(Keys.COMMAND, "a");
        EMPID.sendKeys(Keys.BACK_SPACE);
        EMPID.sendKeys(empid);
        System.out.println("Employe data entered success full id= "+ EMPID.getAttribute("value"));
    }
    
    public void clickSave()
    {
        wait.until(ExpectedConditions.elementToBeClickable(EMPsavebuttion));
        EMPsavebuttion.click();
    }  
    
    public String PersonalDetailverification()
    {
    	wait.until(ExpectedConditions.visibilityOf(PersonalDetailtitle));
    	return PersonalDetailtitle.getText();
    }
    
    public void openEmplist()
    {
        wait.until(ExpectedConditions.elementToBeClickable(emplistmenu));
        emplistmenu.click();
    } 
    
    public void searchByEmployeeID(String empid)
    {
    	wait.until(ExpectedConditions.visibilityOf(empidsearch));
    	empidsearch.click();
    	empidsearch.sendKeys(empid);
    	
    	wait.until(ExpectedConditions.elementToBeClickable(empsearchbuttion));
    	empsearchbuttion.click();
    	System.out.println("Searched Employee ID: " + empid);
  
    }
    
    //verifying a specific empid
    public boolean employeeIDRecordDisplayed(String empid)
    {
    	By employeeIDCell = By.xpath("//div[@role='table']//div[@role='cell' and normalize-space()='" + empid + "']");
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIDCell)).isDisplayed();
    }

    
    public void searchByEmployeeName(String empname)
    {
    	wait.until(ExpectedConditions.visibilityOf(empnamesearch));
    	empnamesearch.click();
    	empnamesearch.clear();
    	empnamesearch.sendKeys(empname);
    	
    	By nameSuggestion = By.xpath("//div[contains(@class,'oxd-autocomplete-option')][contains(.,'"+ empname + "')]");
    	wait.until(ExpectedConditions.elementToBeClickable(nameSuggestion)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(empsearchbuttion));
    	empsearchbuttion.click();
    	
    	System.out.println("Searched Employee Name: " + empname);
    }
    
    
    // Verify that the employee name is displayed in the results
    public boolean employeedRecordName(String empname)
    {
    	By employeeNameCell = By.xpath(
         "//div[@role='row']//div[@role='cell'][contains(normalize-space(),'"
         + empname + "')]"
    			);

    	return wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(employeeNameCell)
    	    ).isDisplayed();
    }
    
    //delecting the employe using search 
    public void searchByEmpNamedelete(String empname) {

        wait.until(ExpectedConditions.visibilityOf(empnamesearch));

        empnamesearch.click();
        empnamesearch.clear();
        empnamesearch.sendKeys(empname);

        By nameSuggestion = By.xpath(
            "//div[contains(@class,'oxd-autocomplete-option')][contains(.,'"
            + empname + "')]"
        );

        wait.until(ExpectedConditions.elementToBeClickable(nameSuggestion)).click();

        wait.until(ExpectedConditions.elementToBeClickable(empsearchbuttion));
        empsearchbuttion.click();

        System.out.println("Searched Employee Name: " + empname);
        
      } 
    
    public boolean isDeleteRecordFound() {
        wait.until(ExpectedConditions.visibilityOf(deltrecordfound));
        return deltrecordfound.isDisplayed();
    }
    
    public void clickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deltbuttion));
        deltbuttion.click();
    }
    
    public void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(conformdeletaleart));
        conformdeletaleart.click();
    }
    
    
    
}


