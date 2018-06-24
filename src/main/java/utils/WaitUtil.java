package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static utils.DriverUtil.getDriver;

public class WaitUtil {

    private static WebDriverWait wait = new WebDriverWait(
            getDriver(), 10);

    public static WebElement waitForVisibleElement(String locator) {
        return wait.until(
                visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static Boolean waitForInvisibilityOfElement(String locator) {
        return wait.until(
                invisibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static List<WebElement> waitForVisibleElements(String locator) {
        return wait.until(
                visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
    }

    public static void setImplicityWait(long time) {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((int) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
