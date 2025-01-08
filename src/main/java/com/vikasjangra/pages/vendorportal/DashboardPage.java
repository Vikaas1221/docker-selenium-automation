package com.vikasjangra.pages.vendorportal;

import com.vikasjangra.pages.flightreservation.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends AbstractPage
{

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePictureElement;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;

    public DashboardPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningElement));
        return this.monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarning()
    {
        return this.monthlyEarningElement.getText();
    }
    public String getAnnualEarning()
    {
        return this.annualEarningElement.getText();
    }
    public String getProfitEarning()
    {
        return this.profitMarginElement.getText();
    }
    public String getAvailableInventory()
    {
        return this.availableInventoryElement.getText();
    }
    public void searchOrderHistoryBy(String keyword)
    {
        this.searchInput.sendKeys(keyword);
    }
    public int getSearchResultsCount()
    {
        String resultsText = this.searchResultsCountElement.getText();
        String[] arr  = resultsText.split(" ");
        return Integer.parseInt(arr[5]);
    }
    public void logout()
    {
        this.userProfilePictureElement.click();
        this.logoutLink.click();
        this.modalLogoutButton.click();
    }

}
