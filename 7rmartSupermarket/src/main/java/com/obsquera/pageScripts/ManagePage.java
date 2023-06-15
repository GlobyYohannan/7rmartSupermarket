package com.obsquera.pageScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsquera.utilities.PageUtility;
import com.obsquera.utilities.WaitUtility;
import org.openqa.selenium.JavascriptExecutor;

public class ManagePage {
	
public WebDriver driver;
WaitUtility waitutility;
PageUtility pageutility;

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
	{   waitutility=new WaitUtility();
	    waitutility.waitForElement(driver, searchButton);
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
		pageutility=new PageUtility();
		pageutility.ScrollBy(driver);
		return this;
	}
	
	public ManagePage clickOnSaveButton()
	{   
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver, saveButton);
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
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver, searchTextField);
		searchTextField.sendKeys(textfielddata);
		return this;
	}
	public ManagePage clickOnSearchButtoninsideSearchListPagesBand()
	{  
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver);
		searchButtoninsideSearchListPagesBand.click();
		return this;
	}
	
	public boolean checkWhetherResponseTableContainsCorrespondingEntry(String searchContent)
	{   
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver);
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
		waitutility=new WaitUtility();
		editIcon.click();
		waitutility.waitForElement(driver);
		return this;
	}
	
	public ManagePage clearAddPageTitleTextField()
	{  
		waitutility=new WaitUtility();
		addPageTitleTextField.clear();
		waitutility.waitForElement(driver);
		return this;
	}
	public ManagePage clickOnUpdateButton()
	{  
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver, updateButton);
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
	{   
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver);
		pageutility=new PageUtility();
		pageutility.alertHandlingaccept(driver);
		return this;
	}
}
