package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("chromeLowResolution")
public class MenuBarPageLr extends MenuBarPage {

    @FindBy(css = "button.toggleLeftNav")
    private WebElement hamburgerMenuButton;

    @FindBy(css = "[href='#researchMenu']")
    private WebElement researchAndEducationLink;

    @Autowired
    public MenuBarPageLr(WebDriver driver) {
        super(driver);
    }

    public void openResearchAndEducationLink() {
        hamburgerMenuButton.click();
        researchAndEducationLink.click();
    }
}
