package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotUtil {

    public static void takeScreenshot() {
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.FILE),
                    new File(String.format("target/screen%s.png", LocalDateTime.now().toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
