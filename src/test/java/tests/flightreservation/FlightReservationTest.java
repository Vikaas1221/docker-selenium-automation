package tests.flightreservation;

import com.vikasjangra.pages.flightreservation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.AbstractTest;
import util.Config;
import util.Constants;


public class FlightReservationTest extends AbstractTest
{
    public Logger log = LoggerFactory.getLogger("FlightReservationTest");
    private String expectedPrice;
    private String noOfPassengers;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setParameters(String noOfPassengers,String expectedPrice)
    {
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void userRegistrationTest()
    {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCredentials("selenium@docker.com","docker");
        registrationPage.enterAddress("123 non main street","atlanta","3001");
        registrationPage.register();
    }
    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest()
    {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.goToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightsSearchTest()
    {
        FlightsSearchPage flightsSearchPage =new FlightsSearchPage(driver);
        Assert.assertTrue(flightsSearchPage.isAt());
        flightsSearchPage.selectPassengers(noOfPassengers);
        flightsSearchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightsSearchTest")
    public void flightSelectionTest()
    {
        FlightSelectionPage flightSelectionPage =new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());
        flightSelectionPage.selectFlights();
        flightSelectionPage.confirmFlights();
    }

    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightReservationConfirmationTest()
    {
        FlightConfirmationPage flightConfirmationPage =new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(),expectedPrice);
    }

}
