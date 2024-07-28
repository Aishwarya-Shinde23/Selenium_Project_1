package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class OrderConfirmationPage extends TestBase {
	
	@FindBy(xpath = "//span[@class='title']")
	WebElement PageTitle;
	
	@FindBy(id = "cancel")
	WebElement cancelBtn;
	
	@FindBy(id = "finish")
	WebElement finishBtn;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrderConfirmationPageTitle() {
		return PageTitle.getText();
	}
	
	public HomePage validateOrderConfirmationPagecancelBtn() {
		cancelBtn.click();
		return new HomePage();
			
	}
	
	public OrderCompletePage validateOrderConfirmationPagefinishBtn() {
		finishBtn.click();
		System.out.println("***************Confirm Order*****************");
		return new OrderCompletePage();
			
	}
	

}
