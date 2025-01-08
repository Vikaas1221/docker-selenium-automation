package com.vikasjangra.pages.flightreservation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage
{
    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightsSearchPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightsButton));
        return this.searchFlightsButton.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers)
    {
        Select passengers = new Select(this.passengersSelect);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlights()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView();", this.searchFlightsButton);
        executor.executeScript("arguments[0].click();", this.searchFlightsButton);
    }
}
