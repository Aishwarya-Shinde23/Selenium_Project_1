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

public class OrderCompletePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OrderConfirmationPage orderconfirmationPage;
	OrderCompletePage ordercompletePage;

	public OrderCompletePageTest() {
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
		ordercompletePage = orderconfirmationPage.validateOrderConfirmationPagefinishBtn();
	}

	@Test(priority = 1)
	public void validateOrderCompletePageTitleTest() {
		String title = ordercompletePage.validateOrderCompletePageTitle();
		Assert.assertEquals(title, "Checkout: Complete!", "Title does not match");
	}

	@Test(priority = 2)
	public void validateOrderCompletePageLogoTest() {
		Boolean flag = ordercompletePage.validateOrderCompletePageLogo();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void validateOrderCompletePageordersuccessfulMessageTest() {
		String title = ordercompletePage.validateOrderCompletePageordersuccessfulMessage();
		Assert.assertEquals(title, "Thank you for your order!", "Title does not match");
	}

	@Test(priority = 4)
	public void validateOrderCompletePageMessageTest() {
		String title = ordercompletePage.validateOrderCompletePageMessage();
		Assert.assertEquals(title,
				"Your order has been dispatched, and will arrive just as fast as the pony can get there!",
				"Title does not match");
	}

	@Test(priority = 5)
	public void validateOrderCompletePagebackToProductsBtnTest() {
		ordercompletePage.validateOrderCompletePagebackToProductsBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
