package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {

	private WebDriver driver;

	@Test
	public void test() {
		driver.get("https://www.seleniumhq.org/download/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Download"));
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\lakshh\\Documents\\workspace\\WebDriverTest\\src\\main\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
