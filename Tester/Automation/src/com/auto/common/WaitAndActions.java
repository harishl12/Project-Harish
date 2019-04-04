package com.auto.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAndActions {
	public static void waitTillElementClickable(WebDriverWait wait, WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public static void pause() throws InterruptedException {
		Thread.sleep(2000);
	}
}
