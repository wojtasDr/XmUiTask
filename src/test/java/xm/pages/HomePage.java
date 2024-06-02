package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"chromeFullScreen", "chromeMediumResolution", "chromeLowResolution"})
public class HomePage extends BaseTestPage {
    @Value("${xm.home.page.url}")
    private String xmHomePageUrl;

    @FindBy(css = "button.gtm-acceptDefaultCookieFirstVisit")
    private WebElement acceptAllCookiesButton;

    @Autowired
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(xmHomePageUrl);
    }

    public void acceptAllCookies() {
        acceptAllCookiesButton.click();
    }
}
