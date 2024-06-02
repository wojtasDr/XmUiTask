package xm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EconomicCalendarPage extends BaseTestPage {
    @FindBy(css = "mat-slider[role='slider'].mat-slider")
    private WebElement calendarSlider;

    @FindBy(css = "iframe[title='iframe']")
    protected WebElement calendarIframe;

    @FindBy(css = ".tc-economic-calendar-item-header > span.tc-economic-calendar-item-header-left-title")
    private WebElement actualDate;

    @Autowired
    public EconomicCalendarPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void setSliderTo(String label);

    public void setToday() {
        driver.switchTo().frame(calendarIframe);
        calendarSlider.sendKeys(Keys.HOME);
        calendarSlider.sendKeys(Keys.ARROW_RIGHT);
        driver.switchTo().defaultContent();
    }

    public void setTomorrow() {
        driver.switchTo().frame(calendarIframe);
        calendarSlider.sendKeys(Keys.HOME);
        calendarSlider.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);
        driver.switchTo().defaultContent();
    }

    public void setNextWeek() {
        driver.switchTo().frame(calendarIframe);
        calendarSlider.sendKeys(Keys.HOME);
        calendarSlider.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);
        driver.switchTo().defaultContent();
    }

    public String getActualDate() {
        driver.switchTo().frame(calendarIframe);
        String actualDateString = actualDate.getText().trim();
        driver.switchTo().defaultContent();
        return actualDateString;
    }
}
