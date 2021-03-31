package com.happs.loginStep;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	@Before
	public void setup() {
		System.out.println("Browser launched");
	}

	@After
	public void cleanup() {
		System.out.println("Browser closed ");
	}

	@Given("Navigate to facebook.com")
	public void navigate_to_facebook_com() {
		System.out.println("Navigate is successful ");
	}

	@Given("input valid username as {string} and password as {string} in textbox")
	public void input_valid_username_as_and_password_as_in_textbox(String userName, String password) {
		System.out.println("Username is " + userName + " password is " + password);
	}

	@Given("user select the age category")
	public void user_select_the_age_category(DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		System.out.println("User age category is " + data.get(1).get("Age"));
		System.out.println("Location is " + data.get(1).get("Location"));
	}

	@Given("validate title of webpage")
	public void validate_title_of_webpage() {
		System.out.println("Title page is displayed");
	}

	@When("Click on login")
	public void click_on_login() {
		System.out.println("Clicked on login");
	}

	@Then("login {string} be successful")
	public void login_be_successful(String loginType) {
		System.out.println("Login type is " + loginType);
	}

	@Then("check the Titlepage with username as {string}")
	public void check_the_titlepage_with_username_as(String expectedUserName) {
		System.out.println("User name is " + expectedUserName);
	}

}
