package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CartPage;
import com.qa.pages.CheckOutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OrderConfirmationPage;
import com.qa.util.TestUtil;

public class CheckOutPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OrderConfirmationPage orderconfirmationPage;
	TestUtil testUtil;

	String sheetName = "CheckOutPage";

	public CheckOutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		cartPage = homePage.validateAddToCart();
		checkOutPage = cartPage.validatcheckOutbtn();

	}

	@Test(priority = 1)
	public void checkOutPageTitleTest() {
		String title = checkOutPage.validatecheckOutPageTitle();
		Assert.assertEquals(title, "Checkout: Your Information", "Title does not match");
	}

	@Test(priority = 2)
	public void validatecheckOutcancelBtnTest() {
		checkOutPage.validatecheckOutPagecancelBtn();

	}

	@Test(priority = 3)
	public void validatcheckOutDetailTest() {
		orderconfirmationPage = checkOutPage.validatcheckOutPageDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
	}
	
	@DataProvider()
	public Object[][] getcheckOutPageTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}


	@Test(priority = 4, dataProvider = "getcheckOutPageTestData")
	public void validatcheckOutDetailsTest(String FirstName, String LastName, String ZipCode) {
		orderconfirmationPage = checkOutPage.validatcheckOutPageDetails(FirstName, LastName, ZipCode);
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
