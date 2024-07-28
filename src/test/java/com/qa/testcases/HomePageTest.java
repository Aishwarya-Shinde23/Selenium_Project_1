package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	TestUtil testUtil;
	
	String sheetName = "HomePage";

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateHomePageLogoTest() {
		Boolean flag = homePage.validateHomePageLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void validateHomePageTotalProductsTest() {
		int products = homePage.validateHomePageTotalProducts();
		Assert.assertEquals(products, 6, "Total number of products do not match");

	}

	@Test(priority = 3)
	public void validateShoppingCartIconTest() {
		Boolean flag = homePage.validateShoppingCartIcon();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void validateProductsNamesTest() {
		homePage.validateProductsNames();
	}

	@Test(priority = 5)
	public void validateFilterDropdownTest() {
		homePage.validateFilterDropdown();

	}
	
	@Test(priority = 6)
	public void validateSideMenuBarTest() {
		loginPage = homePage.validateSideMenuBar();
	}

	@Test(priority = 7)
	public void validateAddToCartTest() {
		cartPage = homePage.validateAddToCart();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
