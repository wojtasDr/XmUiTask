package xm.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class ActionUtils {

    private final WebDriver driver;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method hovers over given web element
     *
     * @param element web element to be hovered
     */
    public void hoverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method scrolls to give element. JavaScriptExecutor is used.
     *
     * @param element web element to be scrolled to
     */
    public void scrollToElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
