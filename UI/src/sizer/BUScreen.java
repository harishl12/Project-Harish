package sizer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BUScreen {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Files//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get(
				"https://vmaxperf.isus.emc.com/allflashconfigurations/projects/127747/scenarios/716118/configurations/resize/sizingrequests/1754681/model/450/configrank/0/subrank/0?tab=0");
		driver.manage().window().maximize();
		WebElement ele = driver
				.findElement(By.cssSelector("div.ciSpinnerPan  div.ps-scrollbar-y-rail > div.ps-scrollbar-y"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(ele, 0, 500).build().perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(4000);
//		driver.quit();

	}
}
