package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.pages.HomePage;
import xm.validators.CommonValidators;

public class HomePageSteps implements En {
    private final HomePage homePage;
    private final CommonValidators commonValidators;

    @Autowired
    public HomePageSteps(HomePage homePage, CommonValidators commonValidators) {
        this.homePage = homePage;
        this.commonValidators = commonValidators;

        Given("^Home page is opened$", () -> {
            homePage.openHomePage();
            commonValidators.checkCurrentUrl("/");
            homePage.acceptAllCookiesIfNecessary();
        });
    }
}
