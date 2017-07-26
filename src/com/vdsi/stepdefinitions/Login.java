package com.vdsi.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vdsi.zaps.SimpleExample;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;
	@Given("^the user is in home page$")
	public void the_user_is_in_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver = Hooks.driver;
	   driver.get("http://demo.testfire.net/");
	}

	@When("^the user navigates to the Login Page$")
	public void the_user_navigates_to_the_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("ONLINE BANKING LOGIN"));
	}

	@Then("^the security scan should run$")
	public void the_security_scan_should_run() throws Throwable {
		SimpleExample.main();
	    Thread.sleep(20000);
	}
}
