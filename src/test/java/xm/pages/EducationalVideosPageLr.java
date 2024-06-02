package xm.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("chromeLowResolution")
public class EducationalVideosPageLr extends EducationalVideosPage {



    @Autowired
    public EducationalVideosPageLr(WebDriver driver) {
        super(driver);
    }

    @Override
    public void playChosenVideo() {
        driver.switchTo().frame(videoPlayerIframe);
        waitUtils.sleepMs(500);
        actionUtils.scrollToElementJS(videoPlayerPlayButton);

        videoPlayerPlayButton.click();
        driver.switchTo().defaultContent();
    }
}
