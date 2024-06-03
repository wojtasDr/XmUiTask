package xm.validators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CommonValidators {

    @Value("${xm.home.page.url}")
    private String xmHomePageUrl;

    private final WebDriver driver;

    public CommonValidators(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method waits until browser current url matches given url pattern
     *
     * @param expectedEndpointUrl url endpoint
     */
    public void checkCurrentUrl(String expectedEndpointUrl) {
        String expectedUrl = String.format("%s%s", xmHomePageUrl, expectedEndpointUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlMatches(expectedUrl));
    }
}
