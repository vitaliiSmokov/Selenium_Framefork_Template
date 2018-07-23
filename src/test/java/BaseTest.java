/*
Created by vitaliismokov in 7/23/18
https://github.com/vitalik23
*/

import domain.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverUtil;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite()
    @Parameters({"browser"})
    public void setup(@Optional("CHROME") Browser browser) {
        if (browser != null) {
            switch (browser) {
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    DriverUtil.setDriver(new FirefoxDriver());
                    break;
                }
                case EDGE: {
                    WebDriverManager.edgedriver().setup();
                    DriverUtil.setDriver(new EdgeDriver());
                    break;
                }
                case IE: {
                    WebDriverManager.iedriver().setup();
                    DriverUtil.setDriver(new InternetExplorerDriver());
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    DriverUtil.setDriver(new ChromeDriver());
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Browser is not provided");
        }
        driver = DriverUtil.getDriver();
        driver.manage().window().maximize();
    }


    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
