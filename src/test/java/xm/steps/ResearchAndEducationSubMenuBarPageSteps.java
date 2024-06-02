package xm.steps;

import io.cucumber.java8.En;
import xm.pages.ResearchAndEducationSubMenuBarPage;

public class ResearchAndEducationSubMenuBarPageSteps implements En {
    private ResearchAndEducationSubMenuBarPage researchAndEducationSubMenuBarPage;

    public ResearchAndEducationSubMenuBarPageSteps(ResearchAndEducationSubMenuBarPage researchAndEducationSubMenuBarPage) {
        this.researchAndEducationSubMenuBarPage = researchAndEducationSubMenuBarPage;

        When("^I click \"(Economic Calendar|Educational Videos)\" link in \"Research&Education\" submenu$", researchAndEducationSubMenuBarPage::goToLink);
    }
}
