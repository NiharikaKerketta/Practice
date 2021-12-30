package com.crm.Practice.createContactTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createContact() throws Throwable {
		
		//get RanDom number
		int ranDomNo = jLib.getRanDomNumber();				
		
		//read Test data from excel sheet
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 2) + ranDomNo;
	
		//navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//click on contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//enter all the details and create a new contact
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.CreateContact(lastName);
		
		//verify the contact name in the header of the message
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actMsg = cip.getContactInfo();
		boolean expResult = true;
		boolean actResult = actMsg.contains(lastName);
		Assert.assertEquals(expResult, actResult);
		Reporter.log("contact created succesfully",true);
	
}
	@Test(groups = "RegressionSuite")
	public void demoTest() {
		System.out.println("====>Demo test ran<====");
	}
}
