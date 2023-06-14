package com.obsquera.pageScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsquera.utilities.WaitUtility;

import org.openqa.selenium.JavascriptExecutor;

public class ManagePage {
	
public WebDriver driver;
WaitUtility waitutility;
	public ManagePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//p[contains(text(),'Manage Pages')]//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement managePageTileMoreInfoButton;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-primary')][@onclick='click_button(2)']") WebElement searchButton;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-danger')][@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//input[@id='title']") WebElement addPageTitleTextField;
	@FindBy(xpath="//div[@class='note-editing-area']//child::div[@role='textbox']") WebElement addPageDescriptionTextField;
	@FindBy(xpath="//input[@class='form-control'][@id='page']") WebElement pageTextField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]//h5") WebElement successAlertField;
	@FindBy(xpath="//input[@class='form-control']") WebElement searchTextField;
	@FindBy(xpath="//button[contains(@class,'btn btn-danger btn-fix')]") WebElement searchButtoninsideSearchListPagesBand;
	@FindAll({@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//child::tbody//tr//td")}) List<WebElement> listPageTableContents;
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//child::tbody//td//i[contains(@class,'fas fa-edit')]") WebElement editIcon;
	@FindBy(xpath="//button[@name='update']") WebElement updateButton;
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//child::tbody//td//i[contains(@class,'fas fa-trash-alt')]") WebElement deleteIcon;
	
	public ManagePage clickOnManagePageTileMoreInfoButton()
	{
		managePageTileMoreInfoButton.click();
		return this;
	}
	public ManagePage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public ManagePage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManagePage enterDataInTitleField(String titleContent)
	{
		addPageTitleTextField.sendKeys(titleContent);
		return this;
	}
	public ManagePage enterDataInDescriptionField(String descriptionContent )
	{
		addPageDescriptionTextField.sendKeys(descriptionContent);
		return this;	
	}
	public ManagePage enterDataInPageField(String pageContent)
	{
		pageTextField.sendKeys(pageContent);
		return this;
	}
	
	public ManagePage pageScrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		return this;
	}
	
	public ManagePage clickOnSaveButton()
	{   
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
		return this;
	}
	public ManagePage navigateBackToOriginalScreen()
	{
		driver.navigate().back();
		return this;
	}
	
	public boolean checkSuccessAlertIsPresent()
	{
		boolean successAlertFieldStatus= successAlertField.isDisplayed();
		return successAlertFieldStatus;
	}
	public ManagePage enterDatatoSearchTextField(String textfielddata)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchTextField));
		searchTextField.sendKeys(textfielddata);
		return this;
	}
	public ManagePage clickOnSearchButtoninsideSearchListPagesBand()
	{
		searchButtoninsideSearchListPagesBand.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	
	public boolean checkWhetherResponseTableContainsCorrespondingEntry(String searchContent)
	{  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i=0;i<listPageTableContents.size();i++)
		{   
			String listPageTableDetail=listPageTableContents.get(i).getText().trim();
			if(listPageTableDetail.equalsIgnoreCase(searchContent.trim()))
				 return true;		
		}
		return false;
	}

	public boolean checkWhetherResponseTableContainsResultNotFoundEntry(String searchContent)
	{  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i=0;i<listPageTableContents.size();i++)
		{   
			String listPageTableDetail=listPageTableContents.get(i).getText().trim();
			if(listPageTableDetail.equalsIgnoreCase(searchContent.trim()))
				 return true;		
		}
		return false;
	}
	public ManagePage clickOnEditIcon()
	{
		editIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	
	public ManagePage clearAddPageTitleTextField()
	{
		addPageTitleTextField.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	public ManagePage clickOnUpdateButton()
	{  
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(updateButton));
		updateButton.click();
		return this;
	}
	public ManagePage clickOnDeleteIcon()
	{   JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(2000,0)");
		deleteIcon.click();
		return this;
	}
	public ManagePage clickOnAlertOkButton()
	{  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().alert().accept();
		return this;
	}
}
