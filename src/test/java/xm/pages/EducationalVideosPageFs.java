package xm.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Profile("chromeFullScreen")
public class EducationalVideosPageFs extends EducationalVideosPage {

    @Autowired
    public EducationalVideosPageFs(WebDriver driver) {
        super(driver);
    }

    @Override
    public void showIntoTheMarketPanel() {
        if (Objects.equals(intoTheMarketsPanel.getAttribute("aria-expanded"), "false")) {
            intoTheMarketsPanel.click();
        }
    }
}
