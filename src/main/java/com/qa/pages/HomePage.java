package com.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[contains(text(), 'Swag Labs')]")
	WebElement homePageLogo;

	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	WebElement addToCart;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartIcon;

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	WebElement product_name;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cart_badge;

	@FindBy(xpath = "//select[@class = 'product_sort_container']")
	WebElement filter_dropdown;

	@FindBy(xpath = "//button[contains(text(), 'Open Menu')]")
	WebElement sideMenuIcon;
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	WebElement logOutBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateHomePageLogo() {
		return homePageLogo.isDisplayed();
	}

	public int validateHomePageTotalProducts() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		System.out.println("Total number of products --> " + list.size());
		return list.size();
	}

	public boolean validateShoppingCartIcon() {
		return cartIcon.isDisplayed();
	}

	public void validateProductsNames() {
		System.out.println("List of all products on HomePage --> ");
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		for (int i = 0; i < products.size(); i++) {
			System.out.println("Product Name : " + products.get(i).getText());
		}
		return;
	}

	public void validateFilterDropdown() {
		Select select = new Select(filter_dropdown);
		select.selectByVisibleText(prop.getProperty("dropdown_value"));
	}
	
	public LoginPage validateSideMenuBar() {
		sideMenuIcon.click();
		TestUtil.clickOn(driver, logOutBtn, Duration.ofSeconds(10));
		System.out.println("****************************Logged Out*****************************");
		
		return new LoginPage();
	}

	public CartPage validateAddToCart() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(prop.getProperty("product"))) {
				System.out.println("Added Product to Cart --> " + list.get(i).getText());
				addToCart.click();
				System.out.println("Total number of products in cart : " + cart_badge.getText());

			}

		}
		cartIcon.click();
		System.out.println("***************Products added to Cart*****************");
		return new CartPage();
	}

}
