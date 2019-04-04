package com.auto.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.auto.common.BasePage;
import com.auto.pagefactory.locators.LoginPageLocators;

public class LoginPage {

	// LoginPageLocators LPL = PageFactory.initElements(BasePage.,
	// pageClassToProxy);
	LoginPageLocators LPL;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		LPL = PageFactory.initElements(driver, LoginPageLocators.class);
	}

	public void setUserName(String username) {
		LPL.userName.sendKeys(username);
	}

	public void setPassword(String password) {
		LPL.passWord.sendKeys(password);
	}

	public void clickLogin() {
		LPL.loginBtn.click();
	}

	public void verifyErrorMessage() {
		Assert.assertTrue(LPL.errMsg.isDisplayed());
	}

}
