package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.EducationalVideosPage;

public class EducationalVideosPageSteps implements En {
    @Autowired
    private EducationalVideosPage educationalVideosPage;

    public EducationalVideosPageSteps(EducationalVideosPage educationalVideosPage) {
        this.educationalVideosPage = educationalVideosPage;

        When("^I show \"Into The Markets\" panel$", educationalVideosPage::showIntoTheMarketPanel);

        When("I choose following video lesson {string}", educationalVideosPage::chooseVideoLessonWithName);

        Then("I can play chosen video for {string} seconds", (String timeToBeElapsed) -> {
            educationalVideosPage.playChosenVideo();
            educationalVideosPage.waitUntilVideoPlaysForSpecifiedTime(timeToBeElapsed);
        });
    }
}
