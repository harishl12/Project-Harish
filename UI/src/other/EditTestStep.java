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
		driver.get("http://catprd.corp.emc.com/Tests/EditTPs.aspx?id=164784");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement add = driver
				.findElement(By.xpath("//div[@id='ctl00_m_testPoints_i0_testStepspAdd']//img[@class='add-but']"));
		Thread.sleep(3000);
		WebElement testName = driver.findElement(By.xpath("//input[@id='ctl00_m_testPoints_i0_testSteps_i0_name']"));
		testName.clear();
		testName.sendKeys("name");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement e : frames)
			System.out.println(e.getText());

		WebElement editDesc = driver
				.findElement(By.xpath("//div[@id = 'ctl00_m_testPoints_i0_testSteps_i0']/div[2]/div[1]"));
		editDesc.click();
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ctl00_m_stepDescription_contentIframe']"));
//		WebElement iframe = driver.findElement(By.xpath("//html//body"));
		driver.switchTo().frame(iframe);
		WebElement editDescCentre = driver.findElement(By.xpath("//body"));
		editDescCentre.sendKeys("Hi");
		driver.switchTo().defaultContent();
		WebElement saveStep = driver.findElement(By.xpath("//span[@id='ctl00_ButtonPanel']/a[text()='Save']"));
//		iframe.sendKeys("fdr");
		saveStep.click();
	}

}
