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
import com.dollardays.pages.MyWalletPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class MyWalletTestcase extends BaseTest {

	
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet3",  testcaseID = "TC_DD_AddressBook_02", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void addWallet(Hashtable<String, String> datatable) throws Exception {	
	try {
		
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Creating the Wallet POM Page...");
		Thread.sleep(1000);
		
		// Create a new object of the MyWalletPage
		MyWalletPage myWalletPage = new MyWalletPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Login into DollarDays Website...");

		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		//myWalletPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		myAddressBookPage.login(datatable.get("UserName"), datatable.get("Password"));		
		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Identify and click the Signed In Dropdown button...");
		myWalletPage.getSignedInDropdown().click();
		
		// You click and navigate to theWalletusing Wallet Link within the SignedIn Dropdown
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Identify and click the Wallet button...");
		myWalletPage.getWalletBtn().click();
		
		//you click on the Add a new card Button in wallet.aspx page
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Identify and click the Add New Card Link...");
		myWalletPage.getAddNewCardLink().click();
				
	
		//you are passing name in name on card text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Identify and Enter Name for Wallet...");
		myWalletPage.getNameOnCardTxtBox().sendKeys(datatable.get("NameOnCard"));	
		
		//you are passing number in card number text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Identify and Enter Card Number for Wallet...");
		myWalletPage.getCardNumberTxtBox().sendKeys(datatable.get("CardNumber"));
		
		//you are selecting expiration date from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Identify Card Expiry Date Dropdown for Wallet...");
		WebElement countryWebElement = myWalletPage.getExpirationDateDropDown();
		
		Select countryDropDownElement = new Select(countryWebElement);
		ExtentTestManager.getTest().log(Status.INFO, "Step 9: Select Card Expiry Date for Wallet...");
		countryDropDownElement.selectByVisibleText(datatable.get("ExpirationDate"));
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are selecting expiration year from drop down box
		Thread.sleep(1000);
								
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Select Card Expiry Year for Wallet...");
        WebElement yearWebElement = myWalletPage.getExpirationYearDropDown();
		
		Select expirationYearDropDown = new Select(yearWebElement);
		expirationYearDropDown.selectByVisibleText(datatable.get("Year"));
		
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are passing Security Code
		
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Select security code for Wallet...");
	    myWalletPage.getSecurityCodeTxtBox().sendKeys(datatable.get("Security Code"));	
	    
	    
	    //you are passing Street Address
  		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Select Street Address for Wallet...");
  	    myWalletPage.getStreetAddressTxtBox().sendKeys(datatable.get("Street Address"));	
	  	    
	  	//you are passing City			
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Select City for Wallet...");
	    myWalletPage.getCityTxtBox().sendKeys(datatable.get("City"));	
	    
		//you are selecting expiration State from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Select State for Wallet...");
        WebElement stateWebElement = myWalletPage.getStateDropDown();
		
		Select stateDropDown = new Select(stateWebElement);
		stateDropDown.selectByVisibleText(datatable.get("State"));
		
		myWalletPage.getStateDropDown().click();   
		
		//you are passing number in Zip code
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Select Zip code for Wallet...");
		myWalletPage.getZipCodeTxtBox().sendKeys(datatable.get("Zip Code"));
			
		// select add new card button
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Click Save to Add a new card in the Wallet...");
		myWalletPage.getAddNewCardSubmitBtn().click();  
  	
		Thread.sleep(1000);
			
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	catch(Exception ex) 
	{
		System.out.println(ex.toString());	
	}
  }
	
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet3",  testcaseID = "TC_DD_AddressBook_02", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void cancelWalletAdd(Hashtable<String, String> datatable) throws Exception {	
	try {
		
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Creating the Wallet POM Page...");
		Thread.sleep(1000);
		
		// Create a new object of the MyWalletPage
		MyWalletPage myWalletPage = new MyWalletPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Login into DollarDays Website...");

		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		//myWalletPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		myAddressBookPage.login(datatable.get("UserName"), datatable.get("Password"));		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Identify and click the Signed In Dropdown button...");
		myWalletPage.getSignedInDropdown().click();
		
		// You click and navigate to the Wallet using Wallet Link within the SignedIn Dropdown
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Identify and click the Wallet button...");
		myWalletPage.getWalletBtn().click();
		
		//you click on the Add a new card Button in wallet.aspx page
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Identify and click the Add New Card button...");
		myWalletPage.getAddNewCardLink().click();
				
		//you are passing name in name on card text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Identify and Enter Name for Wallet...");
		myWalletPage.getNameOnCardTxtBox().sendKeys(datatable.get("NameOnCard"));	
		
		//you are passing number in card number text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Identify and Enter Card Number for Wallet...");
		myWalletPage.getCardNumberTxtBox().sendKeys(datatable.get("CardNumber"));
		
		//you are selecting expiration date from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Identify Card Expiry Date Dropdown for Wallet...");
		WebElement countryWebElement = myWalletPage.getExpirationDateDropDown();
		
		Select countryDropDownElement = new Select(countryWebElement);
		ExtentTestManager.getTest().log(Status.INFO, "Step 9: Select Card Expiry Date for Wallet...");
		countryDropDownElement.selectByVisibleText(datatable.get("ExpirationDate"));
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are selecting expiration year from drop down box
		Thread.sleep(1000);
								
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Select Card Expiry Year for Wallet...");
        WebElement yearWebElement = myWalletPage.getExpirationYearDropDown();
		
		Select expirationYearDropDown = new Select(yearWebElement);
		expirationYearDropDown.selectByVisibleText(datatable.get("Year"));
		
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are passing Security Code
		
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Select security code for Wallet...");
	    myWalletPage.getSecurityCodeTxtBox().sendKeys(datatable.get("Security Code"));	
	    
	    
	    //you are passing Street Address
  		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Select Street Address for Wallet...");
  	    myWalletPage.getStreetAddressTxtBox().sendKeys(datatable.get("Street Address"));	
	  	    
	  	//you are passing City			
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Select City for Wallet...");
	    myWalletPage.getCityTxtBox().sendKeys(datatable.get("City"));	
	    
		//you are selecting expiration State from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Select State for Wallet...");
        WebElement stateWebElement = myWalletPage.getStateDropDown();
		
		Select stateDropDown = new Select(stateWebElement);
		stateDropDown.selectByVisibleText(datatable.get("State"));
		
		myWalletPage.getStateDropDown().click();   
		
		//you are passing number in Zip code
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Select Zip code for Wallet...");
		myWalletPage.getZipCodeTxtBox().sendKeys(datatable.get("Zip Code"));
			    
		// select Cancel card button
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Click Cancel to cancel the new Wallet...");
		myWalletPage.getCancelBtn().click();  
		
		Thread.sleep(1000);
			
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	catch(Exception ex) 
	{
		System.out.println(ex.toString());	
	}
  }

	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet3",  testcaseID = "TC_DD_AddressBook_04", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void editWallet(Hashtable<String, String> datatable) throws Exception {	
	try {
		
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Creating the Wallet POM Page...");
		Thread.sleep(1000);
		
		// Create a new object of the MyWalletPage
		MyWalletPage myWalletPage = new MyWalletPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Login into DollarDays Website...");

		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		//myWalletPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		myAddressBookPage.login(datatable.get("UserName"), datatable.get("Password"));		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Identify and click the Signed In Dropdown button...");
		myWalletPage.getSignedInDropdown().click();
		
		// You click and navigate to theWalletusing Wallet Link within the SignedIn Dropdown
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Identify and click the Wallet button...");
		myWalletPage.getWalletBtn().click();
		
		//you click on the Add a new card Button in wallet.aspx page
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Identify and click Edit existing Wallet Link...");
		myWalletPage.getEditWalletLink().click();
				
		//you are passing name in name on card text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Identify and Enter Name for Wallet...");
		myWalletPage.getNameOnCardTxtBox().sendKeys(datatable.get("NameOnCard"));	
		
		//you are passing number in card number text box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Identify and Enter Card Number for Wallet...");
		myWalletPage.getCardNumberTxtBox().sendKeys(datatable.get("CardNumber"));
		
		//you are selecting expiration date from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Identify Card Expiry Date Dropdown for Wallet...");
		WebElement countryWebElement = myWalletPage.getExpirationDateDropDown();
		
		Select countryDropDownElement = new Select(countryWebElement);
		ExtentTestManager.getTest().log(Status.INFO, "Step 9: Select Card Expiry Date for Wallet...");
		countryDropDownElement.selectByVisibleText(datatable.get("ExpirationDate"));
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are selecting expiration year from drop down box
		Thread.sleep(1000);
								
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Select Card Expiry Year for Wallet...");
        WebElement yearWebElement = myWalletPage.getExpirationYearDropDown();
		
		Select expirationYearDropDown = new Select(yearWebElement);
		expirationYearDropDown.selectByVisibleText(datatable.get("Year"));
		
		myWalletPage.getExpirationDateDropDown().click();
		
		//you are passing Security Code
		
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Select security code for Wallet...");
	    myWalletPage.getSecurityCodeTxtBox().sendKeys(datatable.get("Security Code"));	
	    
	    //you are passing Street Address
  		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Select Street Address for Wallet...");
  	    myWalletPage.getStreetAddressTxtBox().sendKeys(datatable.get("Street Address"));	
	  	    
	  	//you are passing City			
		Thread.sleep(1000);		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Select City for Wallet...");
	    myWalletPage.getCityTxtBox().sendKeys(datatable.get("City"));	
	    
		//you are selecting expiration State from drop down box
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Select State for Wallet...");
        WebElement stateWebElement = myWalletPage.getStateDropDown();
		
		Select stateDropDown = new Select(stateWebElement);
		stateDropDown.selectByVisibleText(datatable.get("State"));
		
		myWalletPage.getStateDropDown().click();   
		
		//you are passing number in Zip code
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Select Zip code for Wallet...");
		myWalletPage.getZipCodeTxtBox().sendKeys(datatable.get("Zip Code"));
			
		// select add new card button
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Click Save to Edit the existing Wallet...");
		myWalletPage.getAddNewCardSubmitBtn().click();  
  	
		Thread.sleep(1000);
			
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	catch(Exception ex) 
	{
		System.out.println(ex.toString());	
	}
  }
	
	
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet3",  testcaseID = "TC_DD_AddressBook_02", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void setAsDefault(Hashtable<String, String> datatable) throws Exception {	
	try {
		
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Creating the Wallet POM Page...");
		Thread.sleep(1000);
		
		// Create a new object of the MyWalletPage
		MyWalletPage myWalletPage = new MyWalletPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Login into DollarDays Website...");

		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		//myWalletPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		myAddressBookPage.login(datatable.get("UserName"), datatable.get("Password"));		
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Identify and click the Signed In Dropdown button...");
		myWalletPage.getSignedInDropdown().click();
		
		// You click and navigate to theWalletusing Wallet Link within the SignedIn Dropdown
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Identify and click the Wallet button...");
		myWalletPage.getWalletBtn().click();
		
		// select add new card button
		Thread.sleep(1000);
		myWalletPage.getSetAsDefaultLink().click();
  	
		Thread.sleep(1000);
			
		//Stop video recording
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	catch(Exception ex) 
	{
		System.out.println(ex.toString());	
	}
  }
	
/*	
	@DDDataProvider(datafile = "testdata/TestData_AddressBook.xlsx", sheetName = "Sheet3",  testcaseID = "TC_DD_AddressBook_02", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void walletDelete(Hashtable<String, String> datatable) throws Exception {	
	try {
		
		//Start video recording
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Creating the Wallet POM Page...");
		Thread.sleep(1000);
		
		// Create a new object of the MyWalletPage
		MyWalletPage myWalletPage = new MyWalletPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Login into DollarDays Website...");

		// Execute the LOGIN TestCase by passing the login credentials via Data Driven Design and getting the TEST DATA From Excel
		myWalletPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		
		// You click the SignedIn (Shihka S.) Dropdown to identify the Address Book Link
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Identify and click the Signed In Dropdown button...");
		myWalletPage.getSignedInDropdown().click();
		
		// You click and navigate to theWalletusing Wallet Link within the SignedIn Dropdown
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Identify and click the Wallet button...");
		myWalletPage.getWalletBtn().click();
		
		//you click deletelink to delete the card
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Identify the delete button and click");
		myWalletPage.getDeleteLink().click();
		
		//you click deletelink to delete the card
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Identify the yes button and click");
		myWalletPage.getDeleteConfirmYes().click();
				
		
		Thread.sleep(1000);
	}
	catch(Exception ex) 
	{
		System.out.println(ex.toString());	
	}
	}*/
	
}
