package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ActionMethods;

public abstract class AbstractPage {
    protected DriverManager driverManager;
    protected ActionMethods actions;

    public AbstractPage(WebDriver driver) {
        this.driverManager = new DriverManager(driver);
        this.actions = new ActionMethods(this.driverManager.getDriverWait());
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driverManager.getDriver().get(url);
    }
}
