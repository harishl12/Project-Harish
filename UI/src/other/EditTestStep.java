package other;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EditTestStep {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://catprd.corp.emc.com/Tests/EditTPs.aspx?id=152119");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement add = driver
				.findElement(By.xpath("//div[@id='ctl00_m_testPoints_i0_testStepspAdd']//img[@class='add-but']"));
		add.click();
		// List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		// System.out.println(iframes.size());
		// for (WebElement we : iframes)
		// System.out.println(we.getAttribute("id"));
		Thread.sleep(3000);
		WebElement testName = driver.findElement(By.xpath("//input[@id='ctl00_m_testPoints_i0_testSteps_i0_name']"));
		testName.sendKeys("name");

		// WebElement descriptionArea = driver.findElement(By.xpath(
		// "//div[@id='ctl00_m_testPoints_i0_testSteps_i0']//div[@onclick='stepDescriptionClicked(this);']"));
		// descriptionArea.sendKeys("nch");
		/*
		 * WebElement frame = driver.findElement(By.xpath(
		 * "//iframe[@id='ctl00_m_stepDescription_contentIframe']"));
		 */
		Actions action = new Actions(driver);
		// driver.switchTo().frame(frame);

		// JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);

		//
		// WebElement descriptionArea = driver.findElement(
		// By.xpath("//div[@id='ctl00_m_testPoints_i0_testSteps_i0_descriptionArea']//div[@class='contents']"));
		// WebElement descriptionArea = driver.findElement(
		// By.xpath("//div[@id='ctl00_m_testPoints_i0_testSteps_i0_descriptionArea']//div[@class='contents']"));
		// myExecutor.executeScript("arguments[0].value='Harry';", descriptionArea);
		// Thread.sleep(3000);
		// descriptionArea.click();
		// descriptionArea.sendKeys("sdsd");
		// System.out.println(descriptionArea.getText());
		// descriptionArea.click();
		// descriptionArea.sendKeys("123");
		//
		// // WebElement frame =
		// //
		// driver.findElement(By.xpath("//iframe[@id='ctl00_m_stepDescription_contentIframe']"));
		//
		// // driver.findElement(By.xpath("//html//body")).sendKeys("Hi");
		// // .findElement(By.xpath()).sendKeys("Hello");
		// Thread.sleep(2000);
		// //div[@id = 'ctl00_m_testPoints_i0_testSteps_i0']/div[2]/div[1]
		// WebElement text =
		// driver.findElement(By.id("ctl00_m_testPoints_i0_testSteps_i0_Label4"));
		driver.findElement(By.xpath("//div[@id = 'ctl00_m_testPoints_i0_testSteps_i0']/div[2]/div[1]")).click();
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='ctl00_m_stepDescription_contentIframe']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		// frame.sendKeys("Hi");
		action.click().build().perform();
		action.sendKeys("steps").perform();

		driver.switchTo().defaultContent();

		WebElement save = driver.findElement(By.xpath("//span[@id='ctl00_ButtonPanel']/a[text()='Save']"));
		save.click();

		// action.sendKeys("test").perform();
		// action.doubleClick()
	}

}
