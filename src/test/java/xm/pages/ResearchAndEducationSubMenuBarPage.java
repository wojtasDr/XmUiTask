package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import xm.utils.ActionUtils;

public abstract class ResearchAndEducationSubMenuBarPage extends BaseTestPage {
    @FindBy(css = ".menu-tutorials > a[href$='educational-videos']")
    private WebElement educationalVideosLink;

    @Autowired
    ActionUtils actionUtils;

    @Autowired
    public ResearchAndEducationSubMenuBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openEconomicCalendarLink();

    public abstract void openEducationalVideosLink();

    public void goToLink(String linkName) {
        switch (linkName) {
            case "Economic Calendar" -> openEconomicCalendarLink();
            case "Educational Videos" -> openEducationalVideosLink();
            default -> throw new IllegalStateException(String.format("Invalid link name was given: %s", linkName));
        }
    }
}
