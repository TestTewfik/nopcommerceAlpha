package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		//Login - Initial flow
		driver.get(configPropObject.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);

		logger.info("**************** Providing login details ************* ");
		lp.setUserName(configPropObject.getProperty("useremail"));
		lp.setPassword(configPropObject.getProperty("password"));
		lp.clickLogin();
		
		logger.info("**************** Starting TC_AddCustomerTest_003 ************* ");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		
		logger.info("***************  Providing customer details  *********** ");
		
		String email=randomestring()+"@gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("test123");
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		addcust.setGender("Male");
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setCustomerRoles("Vendors");
		addcust.setManagerOfVendor("Vendor 2");
		Thread.sleep(3000);
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();

		if(addcust.verifyConfirmationMsg()==true)
		{
			logger.info("***************  Customer added succesfully *********** ");
			Assert.assertTrue(true);
		}
		else {
			logger.error("*************** Customer Not added succesfully *********** ");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
	}
	
}
