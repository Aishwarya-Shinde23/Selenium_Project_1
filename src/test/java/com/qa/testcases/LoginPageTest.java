package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	String sheetName = "LoginPage";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs", "Page_Title does not match");
	}

	@Test(priority = 2)
	public void validateloginLogoTest() {
		Boolean flag = loginPage.validateloginLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void validateLoginPageErrorTest() {
		String errorMsg = loginPage.validateLoginPageError();
		Assert.assertEquals(errorMsg, "Epic sadface: Username is required", "Error Message does not match");
	}
	
	@Test(priority = 4)
	public void validateLoginTest() {
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@DataProvider()
		public Object[][] getLoginPageTestData() {
			Object data [][] = TestUtil.getTestData(sheetName);
			return data;
		}
	
	@Test(priority = 5, dataProvider = "getLoginPageTestData")
	public void validateLoginTest(String Username, String Password) {
		homePage = loginPage.validateLogin(Username, Password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
