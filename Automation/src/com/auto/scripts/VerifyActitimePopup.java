package com.auto.scripts;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.auto.common.BasePage;
import com.auto.pagefactory.pages.EnterTimeTrackPage;
import com.auto.pagefactory.pages.LoginPage;

public class VerifyActitimePopup extends BasePage {

	public VerifyActitimePopup() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testVerifyActitimePopup() throws Exception {
		String userName = "admin";
		String passWord = "manager";

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickLogin();

		EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		ett.clickHelp();
		ett.clickAboutActitimePopup();
		ett.verifyAboutActitimePopup();
		ett.closeAboutActitimePopup();
		ett.clickLogout();
	}

}
