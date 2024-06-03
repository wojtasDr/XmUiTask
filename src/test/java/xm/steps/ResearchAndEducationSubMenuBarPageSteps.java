package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.ResearchAndEducationSubMenuBarPage;

public class ResearchAndEducationSubMenuBarPageSteps implements En {
    private final ResearchAndEducationSubMenuBarPage researchAndEducationSubMenuBarPage;

    @Autowired
    public ResearchAndEducationSubMenuBarPageSteps(ResearchAndEducationSubMenuBarPage researchAndEducationSubMenuBarPage) {
        this.researchAndEducationSubMenuBarPage = researchAndEducationSubMenuBarPage;

        When("^I click \"(Economic Calendar|Educational Videos)\" link in \"Research&Education\" submenu$", researchAndEducationSubMenuBarPage::goToLink);
    }
}
