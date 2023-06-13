package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    static WebDriver launchDriver() {
        return ChromeLauncher.createDriver();
    }
}
