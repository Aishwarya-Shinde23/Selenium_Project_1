package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//span[@class='title']")
	WebElement cartTitle;

	@FindBy(xpath = "//button[contains(text(), 'Remove')]")
	WebElement removebtn;

	@FindBy(id = "checkout")
	WebElement checkoutbtn;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cart_badge;

	@FindBy(id = "continue-shopping")
	WebElement continueShoppingbtn;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatecartTitle() {
		return cartTitle.getText();
	}

	public void validateremovebtn() {
		List<WebElement> cartlist = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for (int i = 0; i < cartlist.size(); i++) {

			if (cartlist.get(i).getText().equals(prop.getProperty("product3"))) {
				System.out.println("Number of products in cart before removing : " + cart_badge.getText());
				removebtn.click();
				System.out.println("Number of products in cart after removing : " + cart_badge.getText());
				System.out.println("Removed Product --> " + cartlist.get(i).getText());
			}
		}

	}

	public HomePage validatecontinueShoppingbtn() {
		try {

			List<WebElement> cartlist_1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			for (int i = 0; i < cartlist_1.size(); i++) {
				if (cartlist_1.get(i).getText().contains(prop.getProperty("product6"))) {
					checkoutbtn.click();
				} else {
					continueShoppingbtn.click();
				}

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
		return new HomePage();
	}

	public CheckOutPage validatcheckOutbtn() {
		checkoutbtn.click();
		return new CheckOutPage();

	}

}
