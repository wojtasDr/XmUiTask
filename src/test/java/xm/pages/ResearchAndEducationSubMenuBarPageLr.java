package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import xm.utils.ActionUtils;
import xm.utils.WaitUtils;

@Component
@Profile("chromeLowResolution")
public class ResearchAndEducationSubMenuBarPageLr extends ResearchAndEducationSubMenuBarPage {
    @FindBy(css = "ul.navbar-nav__list > li > a[href$='economicCalendar']")
    private WebElement economicCalendarLink;

    @FindBy(css = "ul.navbar-nav__list > li > a[href$='educational-videos']")
    private WebElement educationalVideosLink;

    @Autowired
    ActionUtils actionUtils;

    @Autowired
    WaitUtils waitUtils;

    @Autowired
    public ResearchAndEducationSubMenuBarPageLr(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openEconomicCalendarLink() {
        actionUtils.scrollToElementJS(economicCalendarLink);
        waitUtils.sleepMs(1000);
        economicCalendarLink.click();
    }

    @Override
    public void openEducationalVideosLink() {
        actionUtils.scrollToElementJS(educationalVideosLink);
        waitUtils.sleepMs(1000);
        educationalVideosLink.click();
    }
}
