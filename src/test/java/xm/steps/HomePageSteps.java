package xm.steps;

import io.cucumber.java8.En;
import xm.pages.HomePage;

public class HomePageSteps implements En {
    private HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;

        Given("^Home page is opened$", homePage::openHomePage);

        Given("^All cookies are accepted$", homePage::acceptAllCookies);
    }

}
