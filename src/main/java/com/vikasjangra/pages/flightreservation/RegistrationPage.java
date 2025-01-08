package com.vikasjangra.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class RegistrationPage extends AbstractPage
{
    //WebDriver driver;
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "street")
    private WebElement streetInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "zip")
    private WebElement zipInput;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.registerButton));
        return this.registerButton.isDisplayed();
    }

    public void goTo(String url)
    {
        try {
            this.driver.get(url);
        }catch (NullPointerException exception)
        {
            System.out.println("Driver is null");
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }

    }

    public void enterUserDetails(String firstName,String lastName)
    {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
    }
    public void enterUserCredentials(String email,String password)
    {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
    }

    public void enterAddress(String street,String city,String zip)
    {
        this.streetInput.sendKeys(street);
        this.cityInput.sendKeys(city);
        this.zipInput.sendKeys(zip);
    }
    public void register()
    {
        this.registerButton.click();
    }

}
