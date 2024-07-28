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
import com.qa.pages.OrderCompletePage;
import com.qa.pages.OrderConfirmationPage;
import com.qa.util.TestUtil;

public class OrderConfirmationPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OrderConfirmationPage orderconfirmationPage;
	OrderCompletePage ordercompletePage;
	TestUtil testUtil;

	public OrderConfirmationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = homePage.validateAddToCart();
		checkOutPage = cartPage.validatcheckOutbtn();
		orderconfirmationPage = checkOutPage.validatcheckOutPageDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
	}

	@Test(priority = 1)
	public void validateOrderConfirmationPageTitleTest() {
		String title = orderconfirmationPage.validateOrderConfirmationPageTitle();
		Assert.assertEquals(title, "Checkout: Overview", "Title does not match");
	}

	@Test(priority = 2)
	public void validateOrderConfirmationPagecancelBtnTest() {
		orderconfirmationPage.validateOrderConfirmationPagecancelBtn();
	}

	@Test(priority = 3)
	public void validateOrderConfirmationPagefinishBtnTest() {
		orderconfirmationPage.validateOrderConfirmationPagefinishBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
