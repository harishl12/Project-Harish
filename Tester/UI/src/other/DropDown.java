package other;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://catprd.corp.emc.com/Tests/Edit.aspx");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 3);

		WebElement dropArrow = driver.findElement(By.xpath("//a[@id='ctl00_m_featureProductVersionFilter_cb_Arrow']"));
		wait.until(ExpectedConditions.elementToBeClickable(dropArrow));
		dropArrow.click();
		// List<WebElement> options = driver.findElements(By.xpath(
		// "//div[@id='ctl00_m_featureProductVersionFilter_cb_DropDown']//div[@class='rcbScroll
		// rcbWidth']/ul/li"));
		// System.out.println(options.size());
		Thread.sleep(2200);
		WebElement product = driver.findElement(By.xpath("//li[contains(text(),'v4.2')]"));
		Actions action = new Actions(driver);
		action.moveToElement(product);
		action.click().build().perform();
		Thread.sleep(2200);
		WebElement featureDropArrow = driver.findElement(By.xpath("//a[@id='ctl00_m_featureComboTree_Combo_Arrow']"));
		featureDropArrow.click();
		Thread.sleep(1000);
		WebElement featureExpand = driver.findElement(By.xpath("//span[contains(text(),'Anchor')]"));
		featureExpand.click();

		WebElement featureCheckBox = driver.findElement(By.xpath("//span[contains(text(),'HW')]/../input"));
		Thread.sleep(1000);
		featureCheckBox.click();

		WebElement primaryClick = driver.findElement(By.xpath("//label[contains(text(),'Primary Strategy')]"));
		primaryClick.click();
		WebElement primaryStrategy = driver.findElement(By.xpath("(//span[contains(text(),'Select')])[1]"));
		Thread.sleep(1000);
		primaryStrategy.click();
		Thread.sleep(1000);
		WebElement functionalTesting = driver
				.findElement(By.xpath("//span[text()='Functional Testing']/preceding::span[1]"));
		Thread.sleep(1000);
		functionalTesting.click();
		Thread.sleep(1000);
		WebElement coreFunctionalities = driver.findElement(By.xpath("//span[text()='Core Functionalities']"));
		Thread.sleep(1000);
		coreFunctionalities.click();
		Thread.sleep(1000);
		primaryClick.click();

		WebElement approved = driver.findElement(By.xpath("//input[@id='ctl00_m_approved']"));
		approved.click();
		// product.click();

		WebElement manualOnly = driver.findElement(By.xpath("//input[@id='ctl00_m_manualOnly']"));
		manualOnly.click();

	}
}
