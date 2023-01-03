package com.crm.qa.pageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pageObjects.HomePage;
import com.crm.qa.pageObjects.LoginPage;

import base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag=loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
