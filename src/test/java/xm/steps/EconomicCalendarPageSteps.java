package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.EconomicCalendarPage;
import xm.validators.EconomicCalendarPageValidators;

public class EconomicCalendarPageSteps implements En {
    private final EconomicCalendarPage economicCalendarPage;
    private final EconomicCalendarPageValidators economicCalendarPageValidators;

    @Autowired
    public EconomicCalendarPageSteps(EconomicCalendarPage economicCalendarPage, EconomicCalendarPageValidators economicCalendarPageValidators) {
        this.economicCalendarPage = economicCalendarPage;
        this.economicCalendarPageValidators = economicCalendarPageValidators;

        When("^I set \"(Today|Tomorrow|Next Week)\" on slider$", economicCalendarPage::setSliderTo);

        Then("^\"(Today|Tomorrow|Next Week)\" date is set correctly$", (String actualDateLabel) -> {
            String actualDateString = economicCalendarPage.getActualDate();
            economicCalendarPageValidators.checkIfActualDateIsSetCorrectly(actualDateString, actualDateLabel);
        });
    }
}
