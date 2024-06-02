package xm.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("chromeMediumResolution")
public class EducationalVideosPageMr extends EducationalVideosPage {

    @Autowired
    public EducationalVideosPageMr(WebDriver driver) {
        super(driver);
    }
}
