package com.auto.scripts;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.common.BasePage;
import com.auto.pagefactory.pages.EnterTimeTrackPage;
import com.auto.pagefactory.pages.LoginPage;

public class ValidLoginLogout extends BasePage {

	public ValidLoginLogout() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testValidLoginLogout() throws Exception {
		String userName = "admin";
		String passWord = "manager";

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickLogin();

		EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		ett.clickLogout();
		// Assert.assertTrue(false);
	}

	@Test
	public void testValidLoginLogoutTrainee() throws Exception {
		String userName = "trainee";
		String passWord = "trainee";

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickLogin();

		EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		ett.clickLogout();
	}

}
