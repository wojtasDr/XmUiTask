package xm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public abstract class BaseTestPage {
    protected WebDriver driver;

    protected boolean isCookiesAccepted;

    @PostConstruct
    private void initWebElements() {
        PageFactory.initElements(driver, this);
    }
}
