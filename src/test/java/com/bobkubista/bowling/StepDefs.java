package com.bobkubista.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	private String today;
	private String actualAnswer;

	@Given("today is {word}")
	public void today_is(String day) {
		today = day;
	}

	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_Friday_yet() {
		actualAnswer = isItFriday(today);
	}

	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAnswer) {
		assertEquals(expectedAnswer, actualAnswer);
	}

	// Tutorial scaffolding; replace with bowling scenarios
	private static String isItFriday(String today) {
		return "Friday".equals(today) ? "TGIF" : "Nope";
	}
}
