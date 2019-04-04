package cat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;

	public BasePage() {
		// TODO Auto-generated constructor stub
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public static void editTextBox(WebElement we, String text) {
		we.sendKeys(text);
	}

	public static String getTextString(WebElement we) {
		return we.getText();
	}

	public static void moveToElement(WebDriver driver, WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
	}

	public static void moveAndClickOnElements(WebDriver driver, WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.click().build().perform();
	}

	public static void moveToElementAndClickElement(WebDriver driver, WebElement we, WebElement we1) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.moveToElement(we1);
		actions.click().build().perform();
	}

	public static void actionsSendKeys(WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.click().build().perform();
		actions.sendKeys(text).perform();
	}

	public static void selectDropdown(WebElement we, String text) {
		Select select = new Select(we);
		select.selectByVisibleText(text);
	}

}
