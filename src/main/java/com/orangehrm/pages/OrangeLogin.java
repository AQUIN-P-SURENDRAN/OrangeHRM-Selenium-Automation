package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrangeLogin {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(name="username")
	WebElement usernamefield;
	
	@FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement loginButtion;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement loginerror;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	WebElement usernamerequired;
	
	public OrangeLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void setvalues(String username, String password)
	{

	    wait.until(ExpectedConditions.visibilityOf(usernamefield));
	    usernamefield.sendKeys(username);

	    wait.until(ExpectedConditions.visibilityOf(passwordfield));
	    passwordfield.sendKeys(password);
	}
	
	public void loginClick()
	{
		loginButtion.click();
	}
	
	public boolean LoginErrorDisplayed()
	{
	    wait.until(ExpectedConditions.visibilityOf(loginerror));
	    return loginerror.isDisplayed();
	}
	
	public boolean EmptyFieldMessageDisplayed()
	{
	    wait.until(ExpectedConditions.visibilityOf(usernamerequired));
	    return usernamerequired.isDisplayed();
	}
	
	public boolean LoginPageDisplayed()
	{
	    wait.until(ExpectedConditions.visibilityOf(usernamefield));
	    wait.until(ExpectedConditions.visibilityOf(passwordfield));

	    return usernamefield.isDisplayed() && passwordfield.isDisplayed();
	}
}


