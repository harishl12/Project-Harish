package com.auto.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.auto.common.WaitAndActions;
import com.auto.pagefactory.locators.EnterTimeTrackPageLocators;

public class EnterTimeTrackPage {

	EnterTimeTrackPageLocators ETTPL;
	WebDriverWait wait;

	public EnterTimeTrackPage(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, this);
		ETTPL = PageFactory.initElements(driver, EnterTimeTrackPageLocators.class);
		wait = new WebDriverWait(driver, 3);
	}

	public void clickLogout() {
		ETTPL.logOut.click();
	}

	public void clickHelp() {
		ETTPL.help.click();
	}

	public void clickAboutActitimePopup() {
		WaitAndActions.waitTillElementClickable(wait, ETTPL.aboutActiTime);
		ETTPL.aboutActiTime.click();
	}

	public void verifyAboutActitimePopup() throws InterruptedException {
		// WaitAndActions.waitTillElementClickable(wait, ETTPL.aboutActiTime);
		WaitAndActions.pause();
		Assert.assertEquals(ETTPL.productVersion.getText(), "actiTIME 2019.1 Pro");
	}

	public void closeAboutActitimePopup() {
		WaitAndActions.waitTillElementClickable(wait, ETTPL.closePopup);
		ETTPL.closePopup.click();
	}
}
