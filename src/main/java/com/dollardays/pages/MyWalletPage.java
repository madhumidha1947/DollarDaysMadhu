package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dollardays.commons.Base64;

public class MyWalletPage {

	WebDriver driver;

	// This is the constructor for MyWalletPage Class
	public MyWalletPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    // 
	@FindBy(xpath = "//a[normalize-space(.)='Sign in']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	@FindBy(xpath = "//a[normalize-space(.)='Sign In']")
	private WebElement dropdownsignIn;

	public WebElement getDropdownsignIn() {
		return dropdownsignIn;
	}

	@FindBy(xpath = "//*[@id='inputLoginUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = "//*[@id='inputLoginPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[normalize-space(.)='Sign in']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
	private WebElement userDrodown;

	public WebElement getUserDrodown() {
		return userDrodown;
	}	
	
	@FindBy(xpath = "//a[normalize-space(.)='Sign Out']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}	
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']//img[@class='header-user']")
	private WebElement signedInDropdown;


	public WebElement getSignedInDropdown() {
		return signedInDropdown;
	}
	
	//Find all the elements to navigate to Wallet
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/ul[1]/li[8]/a[1]")
	private WebElement  walletBtn;
	
	public WebElement getWalletBtn() {
		return walletBtn;
		
	}
		
	@FindBy(xpath = "//h5[contains(text(),'+ Add a new card')]")
	private WebElement  addNewCardLink;
	
	public WebElement getAddNewCardLink() {
		return addNewCardLink;
	}	
	
	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
	private WebElement  nameOnCardTxtBox;
	
	public WebElement getNameOnCardTxtBox() {
		return nameOnCardTxtBox;
	}	
	
	
	@FindBy(xpath ="//input[@id='ctl00_cphContent_txtCCNumber']")
	private WebElement  cardNumberTxtBox;
	
	public WebElement getCardNumberTxtBox() {
		return cardNumberTxtBox;
	}
	
	@FindBy(xpath ="//select[@id='ctl00_cphContent_ddlCCExpireMnth']")
	private WebElement  expirationDateDropDown;
	
	public WebElement getExpirationDateDropDown() {
		return  expirationDateDropDown;
	}	
		
		
	@FindBy(xpath ="//select[@id='ctl00_cphContent_ddlCCExpireYear']")
	private WebElement  expirationYearDropDown;
	
	public WebElement getExpirationYearDropDown() {
		return  expirationYearDropDown;
	}	
		
	@FindBy(xpath ="//input[@id='ctl00_cphContent_txtCCCVV2ID']")
	private WebElement  securityCodeTxtBox;
	
	public WebElement getSecurityCodeTxtBox() {
		return  securityCodeTxtBox;
	}
	
	
	@FindBy(xpath ="//input[@id='ctl00_cphContent_txtAddrBillingaddr1']")
	private WebElement  streetAddressTxtBox;
	
	public WebElement getStreetAddressTxtBox() {
		return  streetAddressTxtBox;
	}
	
	
	@FindBy(xpath ="//input[@id='ctl00_cphContent_txtAddrBillingcity']")
	private WebElement  cityTxtBox;
	
	public WebElement getCityTxtBox() {
		return  cityTxtBox;
	}

	@FindBy(xpath ="//select[@id='ctl00_cphContent_ddlBillingstate']")
	private WebElement stateDropDown;
	
	public WebElement getStateDropDown() {
		return  stateDropDown;
	}
	
	
	@FindBy(xpath ="//input[@id='txtAddrBillingzip']")
	private WebElement zipCodeTxtBox;
	
	public WebElement getZipCodeTxtBox() {
		return  zipCodeTxtBox;
	}
		
	@FindBy(xpath ="//input[@id='ctl00_cphContent_btnUpdateCard']")
	private WebElement addNewCardSubmitBtn;
	
	public WebElement getAddNewCardSubmitBtn() {
		return  addNewCardSubmitBtn;
	}
	
	@FindBy(xpath ="//body/form[@id='aspnetForm']/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/input[3]")
	private WebElement cancelBtn;
	
	public WebElement getCancelBtn() {
		return  cancelBtn;
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	private WebElement editWalletLink;
	
	public WebElement getEditWalletLink() {
		return  editWalletLink;
	}
	
	@FindBy(xpath="//body/form[@id='aspnetForm']/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[4]/ul[1]/li[2]/a[1]")
	private WebElement deleteLink;
	
	public WebElement getDeleteLink() {
		return  deleteLink;
	}
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	private WebElement deleteConfirmYes;
	
	public WebElement getDeleteConfirmYes() {
		return  deleteConfirmYes;
	}
	
	
	@FindBy(xpath="//body/form[@id='aspnetForm']/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/a[1]")
	private WebElement setAsDefault;
	
	public WebElement getSetAsDefaultLink() {
		return  setAsDefault;
	}
	
	
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		Thread.sleep(1000);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		Thread.sleep(500);
		getPassword().submit();
		
		String expectedTitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, " Successfully Logged into the HomePage");
	}
		
	public void invokeLogin() throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		getUsername().sendKeys("srikanthtesting100@gmail.com");
		getPassword().sendKeys(Base64.decrypt("cGFzc3dvcmQxMjM="));
		getPassword().submit();
		//getLoginBtn().click();
	}
	
}	