package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class DriverManager {
    private final WebDriver driver;
    private final WebDriverWait driverWait;

    public DriverManager(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
