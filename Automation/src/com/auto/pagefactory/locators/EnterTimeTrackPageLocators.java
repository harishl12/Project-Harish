package com.auto.pagefactory.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterTimeTrackPageLocators {

	@FindBy(id = "logoutLink")
	public WebElement logOut;

	@FindBy(xpath = "//div[@class='popup_menu_icon support_icon']")
	public WebElement help;

	@FindBy(xpath = "//a[contains(text(),'About your actiTIME')]")
	public WebElement aboutActiTime;

	@FindBy(xpath = "//span[@class='productVersion']")
	public WebElement productVersion;

	@FindBy(xpath = "//div[@id='aboutPopupCloseButtonId']")
	public WebElement closePopup;

}
