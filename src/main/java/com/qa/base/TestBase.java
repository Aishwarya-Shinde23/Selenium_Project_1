package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:/Users/AISHWARYA R SHINDE/eclipse-workspace/TestAutomation_1/src/main/java/com/qa/config/config.properties");

			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browser_name = prop.getProperty("browser");
		if (browser_name.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:/SeleniumAutomationProject/BrowserDrivers/ChromeDriver/chromedriver.exe/");

			driver = new ChromeDriver();

		}

		else if (browser_name.equals("firefox")) {

			System.setProperty("webDriver.gecko.driver",
					"D:/SeleniumAutomationProject/BrowserDrivers/GeckoDriver/geckodriver.exe/");

			driver = new FirefoxDriver();

		}

		else if (browser_name.equals("MicrosoftEdge")) {

			System.setProperty("webdriver.msedge.driver",
					"D:/SeleniumAutomationProject/BrowserDrivers/EdgeDriver/msedgedriver.exe/");

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

}
