package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import xm.utils.ActionUtils;

@Component
@Profile({"chromeFullScreen", "chromeMediumResolution"})
public class ResearchAndEducationSubMenuBarPageFsMr extends ResearchAndEducationSubMenuBarPage {
    @FindBy(css = ".menu-research > a[href$='economicCalendar']")
    private WebElement economicCalendarLink;

    @FindBy(css = ".menu-tutorials > a[href$='educational-videos']")
    private WebElement educationalVideosLink;

    @Autowired
    ActionUtils actionUtils;

    @Autowired
    public ResearchAndEducationSubMenuBarPageFsMr(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openEconomicCalendarLink() {
        actionUtils.scrollToElementJS(economicCalendarLink);
        economicCalendarLink.click();
    }

    @Override
    public void openEducationalVideosLink() {
        actionUtils.scrollToElementJS(educationalVideosLink);
        educationalVideosLink.click();
    }
}
