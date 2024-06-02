package xm.steps;

import io.cucumber.java8.En;
import xm.pages.MenuBarPage;

public class MenuBarPageSteps implements En {
    private MenuBarPage menuBarPage;

    public MenuBarPageSteps(MenuBarPage menuBarPage) {
        this.menuBarPage = menuBarPage;

        When("^I click \"(Research&Education)\" main menu link$", menuBarPage::goToLink);
    }
}
