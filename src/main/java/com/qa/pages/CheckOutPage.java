package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CheckOutPage extends TestBase {

	@FindBy(xpath = "//span[@class='title']")
	WebElement cartTitle;

	@FindBy(xpath = "//span[@class='title']")
	WebElement checkOutPageTitle;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "cancel")
	WebElement cancelBtn;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='postalCode']")
	WebElement zipCode;

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatecheckOutPageTitle() {
		return checkOutPageTitle.getText();
	}

	public HomePage validatecheckOutPagecancelBtn() {
		cancelBtn.click();
		return new HomePage();

	}

	
	public OrderConfirmationPage validatcheckOutPageDetails(String FName, String LName, String ZCode) {
		firstName.clear();
		firstName.sendKeys(FName);

		lastName.clear();
		lastName.sendKeys(LName);

		zipCode.clear();
		zipCode.sendKeys(ZCode);

		continueBtn.click();
		System.out.println("***************Shipping Details Submitted*****************");
		
		return new OrderConfirmationPage();
	}

}