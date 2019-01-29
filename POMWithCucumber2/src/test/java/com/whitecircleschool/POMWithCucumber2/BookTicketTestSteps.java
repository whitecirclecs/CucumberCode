package com.whitecircleschool.POMWithCucumber2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookTicketTestSteps {
	private WebDriver driver;
	private Login lp;
	private FlightFinder ff;
	private SelectFlight sf;
	private BookAFlight bf;
	private FlightConfirmation fc;

	@Given("^the user has logged in successfully in the application$")
	public void the_user_has_logged_in_successfully_in_the_application() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		lp = new Login(driver);
		lp.applicationLogin("mercury", "mercury");
	}

	@When("^he select flight details from Flight Finder Page$")
	public void he_select_flight_details_from_Flight_Finder_Page() throws Throwable {
		ff = new FlightFinder(driver);
		ff.findFlights();
	}

	@When("^he select return and departure flight from Select Flight Page$")
	public void he_select_return_and_departure_flight_from_Select_Flight_Page() throws Throwable {
		sf = new SelectFlight(driver);
		sf.flightSelection();
	}

	@When("^he enters the mandatory details on Book A Flight Page$")
	public void he_enters_the_mandatory_details_on_Book_A_Flight_Page() throws Throwable {
		bf = new BookAFlight(driver);
		bf.flightBooking("Deepinder", "Bhatti", "11122233444");
	}

	@Then("^he must be able to book the ticket successfully$")
	public void he_must_be_able_to_book_the_ticket_successfully() throws Throwable {
		fc = new FlightConfirmation(driver);
		String expectedMessage = "Your itinerary has been booked!";
		String actualMessage = fc.getSuccessMessage().getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		driver.close();
	}

}
