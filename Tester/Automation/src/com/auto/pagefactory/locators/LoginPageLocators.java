package com.auto.pagefactory.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	@FindBy(id = "username")
	public WebElement userName;

	@FindBy(name = "pwd")
	public WebElement passWord;

	@FindBy(id = "loginButton")
	public WebElement loginBtn;

	@FindBy(xpath = "//span[contains(text(),'invalid')]")
	public WebElement errMsg;
}
