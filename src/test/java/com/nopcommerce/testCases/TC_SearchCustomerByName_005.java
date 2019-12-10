package com.nopcommerce.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass
{
	
	@Test(priority=1)
	public void searchCustomerbyName() throws IOException, InterruptedException
	{		
		driver.get(configPropObject.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObject.getProperty("useremail"));
		lp.setPassword(configPropObject.getProperty("password"));
		lp.clickLogin();
		
		//Goto Search Page
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
			
		//Provide FirstName and LastName in Search Page
			
		SearchCustomerPage serachcust=new SearchCustomerPage(driver);
		serachcust.setFirstName("Victoria");
		serachcust.setLastName("Terces");	
		
		serachcust.clickSearch();
		
		Thread.sleep(5000);
		
		//validation
		boolean status=serachcust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
	
	
	
}