package xm.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MenuBarPage extends BaseTestPage {

    @Autowired
    public MenuBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openResearchAndEducationLink();

    public void goToLink(String linkName) {
        switch (linkName) {
            case "Research&Education" -> openResearchAndEducationLink();
            default -> throw new IllegalStateException(String.format("Invalid link name was given: %s", linkName));
        }
    }
}
