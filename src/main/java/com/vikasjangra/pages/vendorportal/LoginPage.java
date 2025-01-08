package com.vikasjangra.pages.vendorportal;

import com.vikasjangra.pages.flightreservation.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class LoginPage extends AbstractPage
{
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        return this.loginButton.isDisplayed();
    }

    public void login(String username, String password)
    {
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    public void goTo(String url)
    {
        try {
            this.driver.get(url);
            System.out.println("Driver is not null");
        }catch (NullPointerException exception)
        {
            System.out.println("Driver is null");
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }

    }



}
