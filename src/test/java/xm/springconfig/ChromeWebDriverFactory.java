package xm.springconfig;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.time.Duration;

@Configuration
public class ChromeWebDriverFactory {
    @Value("${chrome.driver.location}")
    private String chromeDriverLocation;

    @Value("${browser.medium.resolution.width}")
    private int mediumResolutionWidth;

    @Value("${browser.medium.resolution.height}")
    private int mediumResolutionHeight;

    @Value("${browser.low.resolution.width}")
    private int lowResolutionWidth;

    @Value("${browser.low.resolution.height}")
    private int lowResolutionHeight;

    @Bean
    @Profile("chromeFullScreen")
    public WebDriver getWebDriverFs() {
        WebDriver driver = setupDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Profile("chromeMediumResolution")
    public WebDriver getWebDriverMr() {
        WebDriver driver = setupDriver();
        driver.manage().window().setSize(new Dimension(mediumResolutionWidth, mediumResolutionHeight));
        return driver;
    }

    @Bean
    @Profile("chromeLowResolution")
    public WebDriver getWebDriverLr() {
        WebDriver driver = setupDriver();
        driver.manage().window().setSize(new Dimension(lowResolutionWidth, lowResolutionHeight));
        return driver;
    }

    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", new File(chromeDriverLocation).getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
