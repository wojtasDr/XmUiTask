package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"chromeFullScreen", "chromeMediumResolution"})
public class MenuBarPageFsMr extends MenuBarPage {

    @FindBy(css = ".main_nav_research > a")
    private WebElement researchAndEducationLink;

    @Autowired
    public MenuBarPageFsMr(WebDriver driver) {
        super(driver);
    }

    public void openResearchAndEducationLink() {
        researchAndEducationLink.click();
    }
}
