package com.auto.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.xml.XmlTest;

@Listeners(CustomListeners.class)
public class BasePage {

	public BasePage() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public String chromeDriverProperty = "webdriver.chrome.driver";
	public String chromeDriverPath = System.getProperty("user.dir") + "\\resources\\exeFiles\\chromedriver.exe";
	public String firefoxDriverProperty = "webdriver.gecko.driver";
	public String firefoxDriverPath = System.getProperty("user.dir") + "\\resources\\exeFiles\\geckodriver.exe";
	public String IEDriverProperty = "webdriver.ie.driver";
	public String IEDriverPath = System.getProperty("user.dir") + "\\resources\\exeFiles\\IEDriverServer.exe";

	// File file = new File(System.getProperty("user.dir") +
	// "\\resources\\config\\configuration.properties");
	// FileInputStream inStream = new FileInputStream(file);
	// Properties prop = new Properties();
	// prop.

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void preCondition(XmlTest xmlTest) {
		String browser = xmlTest.getParameter("browser");
		Reporter.log("Browser is " + browser, true);
		if (browser.equals("chrome")) {
			System.setProperty(chromeDriverProperty, chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty(firefoxDriverProperty, firefoxDriverPath);
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty(IEDriverProperty, IEDriverPath);
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid browser");
			System.exit(0);
		}

		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void postConditions() {
		driver.close();
	}
}
