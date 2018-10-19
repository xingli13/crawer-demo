package com.github.xingli13.func;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xingli13 on 2018/10/19.
 */
public class OpenFileTest {
	String line;
	File file;
	@Given("^I open the \"([^\"]*)\"$")
	public void i_open_the(String arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		file = new File(arg1);
		assertThat(file.length()).isGreaterThan(0);
	}

	@When("^I ask what's in first line$")
	public void i_ask_what_s_in_first_line() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		InputStreamReader in = new InputStreamReader(new FileInputStream(file));
		BufferedReader reader = new BufferedReader(in);
		line = reader.readLine();
		reader.close();
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assertThat(line).contains(arg1);
	}
}