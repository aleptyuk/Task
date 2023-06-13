package utils;

import org.openqa.selenium.WebDriver;
import pages.CitizenCNPPage;

public class PageContainer {
    private final CitizenCNPPage citizenCNPPage;

    public PageContainer(WebDriver driver) {
        citizenCNPPage = new CitizenCNPPage(driver);
    }

    public CitizenCNPPage citizenCNPPage() {
        return citizenCNPPage;
    }
}
