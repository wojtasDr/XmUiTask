package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.MenuBarPage;

public class MenuBarPageSteps implements En {
    private final MenuBarPage menuBarPage;

    @Autowired
    public MenuBarPageSteps(MenuBarPage menuBarPage) {
        this.menuBarPage = menuBarPage;

        When("^I click \"(Research&Education)\" main menu link$", menuBarPage::goToLink);
    }
}
