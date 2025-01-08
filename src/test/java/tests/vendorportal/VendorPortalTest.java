package tests.vendorportal;

import com.vikasjangra.pages.vendorportal.DashboardPage;
import com.vikasjangra.pages.vendorportal.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.AbstractTest;
import tests.vendorportal.model.VendorPortalTestData;
import util.JsonUtil;

public class VendorPortalTest extends AbstractTest
{
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath)
    {
        loginPage =new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath);

    }
    @Test
    public void loginTest()
    {

        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.getUsername(),testData.getPassword());
    }
    @Test(enabled = true, dependsOnMethods = "loginTest")
    public void dashboardTest()
    {
        Assert.assertTrue(dashboardPage.isAt());

        //finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarning(),testData.getMonthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(),testData.getAnnualEarning());
        Assert.assertEquals(dashboardPage.getProfitEarning(),testData.getProfitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(),testData.getAvailableInventory());

        // order history search
        dashboardPage.searchOrderHistoryBy(testData.getSearchKeyword());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(),testData.getSearchResultsCount());

        // logout
        dashboardPage.logout();

    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest()
    {
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isAt());
    }

}
