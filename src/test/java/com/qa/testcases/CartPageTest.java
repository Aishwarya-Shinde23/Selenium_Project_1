package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CartPage;
import com.qa.pages.CheckOutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class CartPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;

	public CartPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = homePage.validateAddToCart();
	}

	@Test(priority = 1)
	public void validatecartTitleTest() {
		String title = cartPage.validatecartTitle();
		Assert.assertEquals(title, "Your Cart", "Title does not match");
	}

	@Test(priority = 2)
	public void validatecontinueShoppingbtnTest() {
		cartPage.validatecontinueShoppingbtn();
	}

	@Test(priority = 3)
	public void validateremovebtnTest() {
		cartPage.validateremovebtn();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
