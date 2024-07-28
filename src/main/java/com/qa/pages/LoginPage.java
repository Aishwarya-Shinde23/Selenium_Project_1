package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//div[contains(text(), 'Swag Labs')]")
	WebElement loginLogo;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//h3[@data-test = 'error']")
	WebElement errorMessage;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateloginLogo() {
		return loginLogo.isDisplayed();
	}

	public String validateLoginPageError() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginBtn.click();
		return errorMessage.getText();

	}

	public HomePage validateLogin(String un, String pwd) {
		username.clear();
		username.sendKeys(un);

		password.clear();
		password.sendKeys(pwd);

		loginBtn.click();
		System.out.println("***************Login Successful*****************");
		return new HomePage();
	}

}
