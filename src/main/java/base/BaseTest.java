package base;

import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import utils.PageContainer;

public class BaseTest {

    protected static PageContainer pageContainer;

    private static void initPageContainer(WebDriver driver) {
        pageContainer = new PageContainer(driver);
    }

    public static void initiateDriver() {
        WebDriver driver = DriverProvider.getDriver();
        initPageContainer(driver);
    }

    public static void closeDriver() {
        DriverProvider.teardown();
    }
}
