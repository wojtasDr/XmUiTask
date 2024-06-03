package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.HomePage;
import xm.validators.CommonValidators;

public class HomePageSteps implements En {

    @Autowired
    private final HomePage homePage;

    @Autowired
    private CommonValidators commonValidators;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;

        Given("^Home page is opened$", () -> {
            homePage.openHomePage();
            commonValidators.checkCurrentUrl("/");
            homePage.acceptAllCookiesIfNecessary();
        });
    }
}
