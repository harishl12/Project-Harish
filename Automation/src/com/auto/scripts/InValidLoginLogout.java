package com.auto.scripts;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.auto.common.BasePage;
import com.auto.pagefactory.pages.EnterTimeTrackPage;
import com.auto.pagefactory.pages.LoginPage;

public class InValidLoginLogout extends BasePage {

	public InValidLoginLogout() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testInValidLoginLogout() {
		String userName = "admin1";
		String passWord = "manager2";

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickLogin();
		lp.verifyErrorMessage();

	}

}
