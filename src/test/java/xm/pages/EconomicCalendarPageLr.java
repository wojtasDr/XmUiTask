package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import xm.utils.ActionUtils;

@Component
@Profile("chromeLowResolution")
public class EconomicCalendarPageLr extends EconomicCalendarPage {

    @FindBy(css = ".tc-calendar-button")
    private WebElement showCalendarSliderButton;

    @Autowired
    private ActionUtils actionUtils;

    @Autowired
    public EconomicCalendarPageLr(WebDriver driver) {
        super(driver);
    }

    public void showCalendarSlider() {
        driver.switchTo().frame(calendarIframe);
        actionUtils.scrollToElementJS(showCalendarSliderButton);
        if (!showCalendarSliderButton.getAttribute("class").contains("tc-highlight-header-icon")) {
            showCalendarSliderButton.click();
        }
        driver.switchTo().defaultContent();
    }

    @Override
    public void setSliderTo(String label) {
        showCalendarSlider();
        switch (label) {
            case "Today" -> setToday();
            case "Tomorrow" -> setTomorrow();
            case "Next Week" -> setNextWeek();
            default -> throw new IllegalStateException(String.format("Invalid label was given: %s", label));
        }
    }
}
