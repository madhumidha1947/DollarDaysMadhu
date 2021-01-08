package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.MyAddressBookPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class MyAddressBookTestCase extends BaseTest{

	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet1",  testcaseID = "TC_DD_AddressBook_01", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void login(Hashtable<String, String> datatable) throws Exception {	
		try {
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
		Thread.sleep(1000);
		
		// Create a new object of the AddressBookPage
		MyAddressBookPage myAddressBookPage = new MyAddressBookPage(driver);
				
		// Execute the LOGIN TestCase by passing the login credentials directly via hard code 
		//myAddressBookPage.login("srikanthtesting100@gmail.com", "password123");
		
		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		myAddressBookPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		
		
		Thread.sleep(1000);

		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
		
		}
		catch(Exception ex) 
		{
			System.out.println(ex.toString());	
		}
	}
	
	// This test case is for Cancel button
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet2",  testcaseID = "TC_DD_AddressBook_09", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void addressBookLastCancel(Hashtable<String, String> datatable) throws Exception {	
		try {
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
		Thread.sleep(1000);
		
		// Create a new object of the AddressBookPage
		MyAddressBookPage myAddressBookPage = new MyAddressBookPage(driver);
				
		// Execute the LOGIN TestCase by passing the login credentials directly via hard code 
		//myAddressBookPage.login("srikanthtesting100@gmail.com", "password123");
		
		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		myAddressBookPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		myAddressBookPage.getSignedInDropdown().click();
		
		// You click and navigate to the Address Book using Address Book Link within the SignedIn Dropdown
		Thread.sleep(1000);
		myAddressBookPage.getAddressBookBtn().click();
		
		// You click and add new Address Book
		Thread.sleep(1000);
		myAddressBookPage.getAddNewShipAddressBtn().click();
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		System.out.println(datatable.toString());
		myAddressBookPage.getFirstNameTxtBox().sendKeys(datatable.get("FirstName"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getLastNameTxtBox().sendKeys(datatable.get("LastName"));

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getCompNameTxtBox().sendKeys(datatable.get("CompanyName"));
	
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getstreetAddressTxtBox().sendKeys(datatable.get("StreetAddress"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getAptSteBldgTxtBox().sendKeys(datatable.get("Apt"));

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		WebElement countryWebElement = myAddressBookPage.getCountryDropdown();
		
		Select countryDropDownElement = new Select(countryWebElement);
		countryDropDownElement.selectByVisibleText(datatable.get("Country"));
		
		myAddressBookPage.getCountryDropdown().click();

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getCityTxtBox().sendKeys(datatable.get("City"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		
		// It will find the StateDropdown webelement and return as WebElement
		WebElement stateWebElement = myAddressBookPage.getStateDropdown();
		
		// You are converting the WebElement to a Select DropDown Element
		Select stateDropDownElement = new Select(stateWebElement);
		stateDropDownElement.selectByVisibleText(datatable.get("State"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getPhoNumTxtBox().sendKeys(datatable.get("PhoneNumber"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getExtTxtBox().sendKeys(datatable.get("Ext"));

		// Fill all the fields in Zip Code
		Thread.sleep(1000);
		myAddressBookPage.getZipCodeTxtBox().sendKeys(datatable.get("ZipCode"));
		
		// Fill all the fields in Residential Radio Btn
		Thread.sleep(1000);
		myAddressBookPage.getResidentialRadioBtn().click(); 
		
		// Fill all the fields in Zip Code
		//Thread.sleep(1000);
		//myAddressBookPage.getSaveChangesBtn().click();
		//to cancel the 
		Thread.sleep(1000);
		myAddressBookPage.getCancelBtn().click(); 
		
		Thread.sleep(1000);
		
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
		
		}
		catch(Exception ex) 
		{
			System.out.println(ex.toString());	
		}
	}
	
	// This test case is for Address Book Save
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet2",  testcaseID = "TC_DD_AddressBook_13", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void addressBookCreate(Hashtable<String, String> datatable) throws Exception {	
		try {
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
		Thread.sleep(1000);
		
		// Create a new object of the AddressBookPage
		MyAddressBookPage myAddressBookPage = new MyAddressBookPage(driver);
				
		// Execute the LOGIN TestCase by passing the login credentials directly via hard code 
		//myAddressBookPage.login("srikanthtesting100@gmail.com", "password123");
		
		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		myAddressBookPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		myAddressBookPage.getSignedInDropdown().click();
		
		// You click and navigate to the Address Book using Address Book Link within the SignedIn Dropdown
		Thread.sleep(1000);
		myAddressBookPage.getAddressBookBtn().click();
		
		// You click and add new Address Book
		Thread.sleep(1000);
		myAddressBookPage.getAddNewShipAddressBtn().click();
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		System.out.println(datatable.toString());
		myAddressBookPage.getFirstNameTxtBox().sendKeys(datatable.get("FirstName"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getLastNameTxtBox().sendKeys(datatable.get("LastName"));

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getCompNameTxtBox().sendKeys(datatable.get("CompanyName"));
	
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getstreetAddressTxtBox().sendKeys(datatable.get("StreetAddress"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getAptSteBldgTxtBox().sendKeys(datatable.get("Apt"));

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		WebElement countryWebElement = myAddressBookPage.getCountryDropdown();
		
		// You are creating a Select object - This is what converts a normal WebElement into a Selenium Select UI Element
		// why are we doing this ? - Because this is a special case (select Dropdown). Thats why we need to convert this into Select UI Element.
		// IF we dont convert this, You cannot pick an item inside a Dropdownlist.
		// Select countryDropDownElement = new Select(myAddressBookPage.getCountryDropdown());
		Select countryDropDownElement = new Select(countryWebElement);
		countryDropDownElement.selectByVisibleText(datatable.get("Country"));
		
		myAddressBookPage.getCountryDropdown().click();

		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getCityTxtBox().sendKeys(datatable.get("City"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		
		// It will find the StateDropdown webelement and return as WebElement
		WebElement stateWebElement = myAddressBookPage.getStateDropdown();
		
		// You are converting the WebElement to a Select DropDown Element
		Select stateDropDownElement = new Select(stateWebElement);
		stateDropDownElement.selectByVisibleText(datatable.get("State"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getPhoNumTxtBox().sendKeys(datatable.get("PhoneNumber"));
		
		// Fill all the fields in Address Book
		Thread.sleep(1000);
		myAddressBookPage.getExtTxtBox().sendKeys(datatable.get("Ext"));

		// Fill all the fields in Zip Code
		Thread.sleep(1000);
		myAddressBookPage.getZipCodeTxtBox().sendKeys(datatable.get("ZipCode"));
		
		// Recieving Type Radio Button is selected based on the button choice from the Test Data Sheet
		Thread.sleep(1000);
		if(datatable.get("ReceivingType").equals("residentialRadioBtn"))
			myAddressBookPage.getResidentialRadioBtn().click(); 
		else if(datatable.get("ReceivingType").equals("shipWithDockRadioBtn"))
			myAddressBookPage.getshipWithDockRadioBtn().click();
		else
			myAddressBookPage.getshipWithOutDockRadioBtn().click();
		
		// Fill all the fields in Zip Code
		Thread.sleep(1000);
		myAddressBookPage.getSaveChangesBtn().click();
		
		Thread.sleep(2000);
		
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
		
		}
		catch(Exception ex) 
		{
			System.out.println(ex.toString());	
		}
	}
	
	/* @DDDataProvider(datafile = "testdata/testdata.json", runmode = "", sheetName = "", testcaseID = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = JsonReader.class)
	public void invokeLogin1(Map<String, String> datatable) throws Exception{
		System.out.println("====>"+ datatable);
		System.out.println("Username====>"+ datatable.get("usernme"));
		
		System.out.println("Password====>"+ Base64.decrypt(datatable.get("password")));
		
	}*/
	
}