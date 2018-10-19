package com.github.xingli13.func;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by xingli13 on 2018/10/19.
 */
public class BasicUrlsTest {
	int lines;

	@Given("^I read the \"([^\"]*)\"$")
	public void i_read_the(String arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		BasicUrls.getUrlsFromAwesome(arg1);
	}

	@When("^I ask how many lines valid$")
	public void i_ask_how_many_lines_valid() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		lines = BasicUrls.getUrlLines().size();
	}

	@Then("^I should be told (\\d+)$")
	public void i_should_be_told(int arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assertThat(lines).isEqualTo(arg1);
	}
}
