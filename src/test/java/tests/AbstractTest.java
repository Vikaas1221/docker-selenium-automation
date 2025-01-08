package tests;

import com.vikasjangra.pages.vendorportal.DashboardPage;
import com.vikasjangra.pages.vendorportal.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.Config;
import util.Constants;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest
{
    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);
    @BeforeSuite
    public void loadConfigs()
    {
        Config.initialize();
    }

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        log.info("Grid enabled value from config: {}",Config.get(Constants.GRID_ENABLED));
        log.info("Is Grid enabled? {}",Boolean.getBoolean(Config.get(Constants.GRID_ENABLED)));
        if(Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)))
        {
            log.info("In remote driver");
            this.driver = getRemoteDriver();
        }
        else
        {
            log.info("In local driver");
            this.driver = getLocalDriver();
        }
        driver.manage().window().maximize();

    }
    public WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities=new ChromeOptions();
        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER)))
        {
            capabilities=new FirefoxOptions();
        }
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        // In properties file we have http:%s/wd/hub   --> With String.format we are replacing %s with localhost
        String url = String.format(urlFormat,hubHost);
        log.info("Grid url: {}",url);
        return new RemoteWebDriver(new URL(url),capabilities);
    }
    private WebDriver getLocalDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    @AfterTest
    public void quitDriver()
    {
        this.driver.quit();
    }


}
