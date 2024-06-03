package xm.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import xm.validators.CommonValidators;

public class CommonSteps implements En {
    private final CommonValidators commonValidators;

    @Autowired
    public CommonSteps(CommonValidators commonValidators) {
        this.commonValidators = commonValidators;

        Then("I am redirected to {string} url", commonValidators::checkCurrentUrl);
    }
}
