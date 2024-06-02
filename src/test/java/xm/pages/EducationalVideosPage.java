package xm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import xm.utils.ActionUtils;
import xm.utils.WaitUtils;

import java.util.Objects;

public abstract class EducationalVideosPage extends BaseTestPage {
    @FindBy(css = "button[data-target='#js-collapse-trd-s1']")
    protected WebElement intoTheMarketsPanel;

    @FindBy(css = ".sproutvideo-player")
    protected WebElement videoPlayerIframe;

    @FindBy(css = "[aria-label='Video Player'] > .player-big-play-button")
    protected WebElement videoPlayerPlayButton;

    @FindBy(css = "[aria-label='Video Player'] .player-progress-time")
    private WebElement videoPlayerProgressBar;

    @FindBy(css = ".player-control-bar")
    private WebElement videoPlayerControlBar;

    protected By getVideoLessonLocator(String lessonName) {
        return By.xpath(String.format("//a[text()='%s ']", lessonName));
    }

    @Autowired
    public EducationalVideosPage(WebDriver driver) {
        this.driver = driver;
    }

    @Autowired
    WaitUtils waitUtils;

    @Autowired
    ActionUtils actionUtils;

    public void showIntoTheMarketPanel() {
        actionUtils.scrollToElementJS(intoTheMarketsPanel);
        if (Objects.equals(intoTheMarketsPanel.getAttribute("aria-expanded"), "false")) {
            intoTheMarketsPanel.click();
        }
    }

    public void chooseVideoLessonWithName(String lessonName) {
        driver.findElement(getVideoLessonLocator(lessonName)).click();
    }

    public void playChosenVideo() {
        driver.switchTo().frame(videoPlayerIframe);
        videoPlayerPlayButton.click();
        driver.switchTo().defaultContent();
    }

    public void waitUntilVideoPlaysForSpecifiedTime(String timeToBeElapsed) {
        driver.switchTo().frame(videoPlayerIframe);
        actionUtils.hoverElement(videoPlayerControlBar);
        waitUtils.waitUntilElementHasText(30, videoPlayerProgressBar, timeToBeElapsed);
        driver.switchTo().defaultContent();
    }
}
