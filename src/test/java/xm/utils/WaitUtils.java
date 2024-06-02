package xm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class WaitUtils {

    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method waits until given element has expected text
     *
     * @param timeout      wait timeout in seconds
     * @param element      web element to be examined
     * @param expectedText text to be present in given web element
     */
    public void waitUntilElementHasText(int timeout, WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    /**
     * This method is stops the program execution for given period of time
     *
     * @param millis      sleep time in millis
     */
    public void sleepMs(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
