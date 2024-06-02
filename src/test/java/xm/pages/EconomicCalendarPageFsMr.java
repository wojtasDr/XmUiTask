package xm.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"chromeFullScreen", "chromeMediumResolution"})
public class EconomicCalendarPageFsMr extends EconomicCalendarPage {
    @Autowired
    public EconomicCalendarPageFsMr(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setSliderTo(String label) {
        switch (label) {
            case "Today" -> setToday();
            case "Tomorrow" -> setTomorrow();
            case "Next Week" -> setNextWeek();
            default -> throw new IllegalStateException(String.format("Invalid label was given: %s", label));
        }
    }
}
