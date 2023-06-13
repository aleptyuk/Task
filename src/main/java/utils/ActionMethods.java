package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionMethods {
    protected WebDriverWait wait;

    public ActionMethods(WebDriverWait wait) {
        this.wait = wait;
    }

    public void inputText(String value, WebElement element) {
        waitVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        waitVisibility(element);
        element.click();
    }

    public String getText(WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
