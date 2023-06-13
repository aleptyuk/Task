package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitizenCNPPage extends AbstractPage {

    @FindBy(css = ".inputbox")
    WebElement fieldCNPNumber;

    @FindBy(css = "input[type='submit']")
    WebElement checkValidationButton;

    @FindBy(xpath = "//p[contains(text(),'Valid CNP numbers added')]")
    WebElement informationAboutAddedValidCNPNumbers;

    @FindBy(xpath = "//font[contains(text(),'YOU HAVE DONE IT')]")
    WebElement messageAboutSuccessfulResult;

    @FindBy(xpath = "//h1[contains(text(),'Testing Challenge')]")
    WebElement pageTitle;

    public CitizenCNPPage(WebDriver driver) {
        super(driver);
    }

    public void inputValueInField(String value) {
        actions.inputText(value, fieldCNPNumber);
    }

    public void clickFieldCNPNumber() {
        actions.click(fieldCNPNumber);
    }

    public void clickCheckValidity() {
        actions.click(checkValidationButton);
    }

    public String getInformationAboutAddedValidCNPNumbers() {
        return actions.getText(informationAboutAddedValidCNPNumbers);
    }

    public String getInformationAboutSuccessfulResult() {
        return actions.getText(messageAboutSuccessfulResult);
    }

    public String getPageTitle() {
        return actions.getText(pageTitle);
    }

}