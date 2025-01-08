package com.vikasjangra.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;


public class FlightConfirmationPage extends AbstractPage
{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
    private
    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(1)")
    WebElement flightConfirmationElement;

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2) .fw-bold")
    private WebElement totalPriceElement;

    public FlightConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationElement));
        return this.flightConfirmationElement.isDisplayed();
    }

    public String getPrice()
    {
        String confirmation = this.flightConfirmationElement.getText();
        String price  = this.totalPriceElement.getText();
        log.info("Flight confirmation# : {}",confirmation);
        log.info("Total price : {}",price);
        return price;
    }
}
