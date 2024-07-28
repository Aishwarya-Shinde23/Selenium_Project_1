package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class OrderCompletePage extends TestBase {

	@FindBy(xpath = "//span[@class='title']")
	WebElement OrderCompletePageTitle;

	@FindBy(xpath = "//img[@alt='Pony Express']")
	WebElement OrderCompletePageLogo;

	@FindBy(xpath = "//h2[contains(text(), 'Thank you for your order!')]")
	WebElement OrderCompletePageordersuccessfulMessage;

	@FindBy(xpath = "//div[@class='complete-text']")
	WebElement OrderCompletePageMessage;

	@FindBy(id = "back-to-products")
	WebElement backToProductsBtn;

	public OrderCompletePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateOrderCompletePageTitle() {
		return OrderCompletePageTitle.getText();
	}

	public boolean validateOrderCompletePageLogo() {
		return OrderCompletePageLogo.isDisplayed();
	}

	public String validateOrderCompletePageordersuccessfulMessage() {
		TestUtil.takeScreenshot();
		System.out.println("***************Thank You !! Order Placed*****************");
		return OrderCompletePageordersuccessfulMessage.getText();
	}

	public String validateOrderCompletePageMessage() {
		System.out.println("********************Your order has been dispatched, and will arrive just as fast as the pony can get there!*******************");
		return OrderCompletePageMessage.getText();
	}

	public HomePage validateOrderCompletePagebackToProductsBtn() {
		backToProductsBtn.click();
		return new HomePage();
	}

}
