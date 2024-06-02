package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.EconomicCalendarPage;
import xm.validators.EconomicCalendarPageValidators;

public class EconomicCalendarPageSteps implements En {
    @Autowired
    private EconomicCalendarPage economicCalendarPage;

    @Autowired
    private EconomicCalendarPageValidators economicCalendarPageValidators;

    public EconomicCalendarPageSteps(EconomicCalendarPage economicCalendarPage) {
        this.economicCalendarPage = economicCalendarPage;

        When("^I set \"(Today|Tomorrow|Next Week)\" on slider$", economicCalendarPage::setSliderTo);

        Then("^\"(Today|Tomorrow|Next Week)\" date is set correctly$", (String actualDateLabel) -> {
            String actualDateString = economicCalendarPage.getActualDate();
            economicCalendarPageValidators.checkIfActualDateIsSetCorrectly(actualDateString, actualDateLabel);
        });
    }

}
