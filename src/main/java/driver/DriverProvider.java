package driver;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static WebDriver driver;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.launchDriver();
        }
        return driver;
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
