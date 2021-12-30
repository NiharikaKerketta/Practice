package com.crm.Practice.orgTest;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeSuite")
	public void createOrganizationTest() throws Throwable {
		
		//get RanDom number
				int ranDomNo = jLib.getRanDomNumber();
				
				//read Test data from excel sheet
				String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNo;
				
				//navigate to organisation module
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganisationLink();
				
				//click on create Organisation" button
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrg();
				
				
				//enter all the details and create new organisation
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				cop.createOrgAndSave(orgName);
				
				//verify organisation name in header of the msg
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String actMsg = oip.getOrgInfo();
				
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(actMsg.contains(orgName));
				Reporter.log("organisation created", true);
				sa.assertAll();
		
	}
	
	@Test(groups = "RegressionSuite")
	public void demoTest2() {
		System.out.println("===> Demo test regression<===");
	}
}
