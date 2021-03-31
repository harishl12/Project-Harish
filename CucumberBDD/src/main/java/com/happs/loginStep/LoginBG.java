package com.happs.loginStep;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginBG {
	@Given("Navigate to Facebook.com")
	public void navigate_to_facebook_com() {
		System.out.println("Navigation success");

	}

	@Given("validate Homepage")
	public void validate_homepage() {
		System.out.println("Home page success");
	}

	@When("user entered valid {string}")
	public void user_entered_valid(String string) {
		System.out.println("username success");
	}

	@Then("Login is successful")
	public void login_is_successful() {
		System.out.println("Login success");
	}

	@When("user entered invalid {string}")
	public void user_entered_invalid(String string) {
		System.out.println("invalid success");
	}

	@Then("Login is failed")
	public void login_is_failed() {
		System.out.println("Login failed");

	}

}
