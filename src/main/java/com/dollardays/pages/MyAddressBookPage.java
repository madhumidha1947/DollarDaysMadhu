package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dollardays.commons.Base64;

public class MyAddressBookPage {

	WebDriver driver;

	// This is the constructor for MyAddressBookPage Class
	public MyAddressBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	
	//Find all the elements to navigate to AddressBook
	@FindBy(xpath = "//a[contains(text(),'Address Book')] [@href='/myaccount/addressbook.aspx']")
	private WebElement addressBookBtn;

	public WebElement getAddressBookBtn() {
		return addressBookBtn;
	}	
	
	//Find all the elements to Add New AddressBook
	@FindBy(xpath = "//h5[contains(text(),'+ Add a new ship-to address')]")
	private WebElement addNewShipAddressBtn;

	public WebElement getAddNewShipAddressBtn() {
		return addNewShipAddressBtn;
	}	
	
	//Find the First name
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtfirstname']")
	private WebElement firstNameTxtBox;

	public WebElement getFirstNameTxtBox() {
		return firstNameTxtBox;
	}	
	
	//Find the Last name
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtlastname']")
	private WebElement lastNameTxtBox;

	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}	

	//Find the Company name
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipcompany']")
	private WebElement compNameTxtBox;

	public WebElement getCompNameTxtBox() {
		return compNameTxtBox;
	}	

	//Find the Street Address
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipaddr1']")
	private WebElement streetAddressTxtBox;

	public WebElement getstreetAddressTxtBox() {
		return streetAddressTxtBox;
	}	
	
	//Find the Apt,ste,Bldg
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipaddr2']")
	private WebElement aptSteBldgTxtBox;

	public WebElement getAptSteBldgTxtBox() {
		return aptSteBldgTxtBox;
	}	
	
	//Find the Country
	@FindBy(xpath = "//select[@id='ctl00_cphContent_ddlcountry']")
	private WebElement countryDropdown;

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}
	
	//Find the City
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipcity']")
	private WebElement cityTxtBox;

	public WebElement getCityTxtBox() {
		return cityTxtBox;
	}	
	
	//Find the State
	@FindBy(xpath = "//select[@id='ctl00_cphContent_ddlshipstate']")
	private WebElement stateDropdown;

	public WebElement getStateDropdown() {
		return stateDropdown;
	}	
		
	//Find the  Phone Number
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipphone']")
	private WebElement phoNumTxtBox;

	public WebElement getPhoNumTxtBox() {
		return phoNumTxtBox;
	}	
			
	//Find the  Ext
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipphoneExt']")
	private WebElement extTxtBox;

	public WebElement getExtTxtBox() {
		return extTxtBox;
	}	
		
	//Find the  Ext
	@FindBy(xpath = "//input[@id='txtAddrshipzip']")
	private WebElement zipCodeTxtBox;

	public WebElement getZipCodeTxtBox() {
		return zipCodeTxtBox;
	}
		
	//Find the Ship with Dock
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[12]/div[1]/ul[1]/li[1]/label[1]")
	private WebElement shipWithDockRadioBtn;

	public WebElement getshipWithDockRadioBtn() {
		return shipWithDockRadioBtn;
	}	

	//Find the Ship without Dock
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrshipphone']")
	private WebElement shipWithOutDockRadioBtn;

	public WebElement getshipWithOutDockRadioBtn() {
		return shipWithOutDockRadioBtn;
	}	

	//Find the Residential Location
	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[12]/div[1]/ul[1]/li[3]/label[1]")
	private WebElement residentialRadioBtn;

	public WebElement getResidentialRadioBtn() {
		return residentialRadioBtn;
	}	
   
	//Find the  Search Changes Button
	@FindBy(xpath = "//input[@id='ctl00_cphContent_btnAddAddress']")
	private WebElement saveChangesBtn;

	public WebElement getSaveChangesBtn() {
		return saveChangesBtn;
	}
			
	//Find the Cancel Button
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[5]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[13]/input[2]")
	private WebElement cancelBtn;

	public WebElement getCancelBtn() {
		return cancelBtn;
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

