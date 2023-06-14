package com.obsquera.pageScripts;



import java.time.Duration;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='username']") WebElement userNameField;
	@FindBy(xpath="//input[@name='password']") WebElement passWordField;
	@FindBy(xpath="//button[@type='submit']") WebElement sigInButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]//child::h5") WebElement alertField;
	@FindBy(xpath="//div[@class='inner']//child::p[contains(text(),'Manage Pages')]") WebElement managePageTile;
	
	public LoginPage enterUserNameOnUserNameField(String userName)
	{
		userNameField.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passWordField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnSignInButton()
	{
		sigInButton.click();
		return this;
	}
	
	
	public String getLoginPageManagePageTileTitleAssertion()
	{
		String actualmanagePageTileTitle=managePageTile.getText();
		return actualmanagePageTileTitle;
		
	
	}
	
	public String getAlertMessageOfIncorrectUsernamePassword()
	{   
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(alertField));
		String actualalert=alertField.getText();
		return actualalert;
	}
}
