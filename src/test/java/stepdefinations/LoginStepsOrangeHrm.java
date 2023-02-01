package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageobject.Pages;

public class LoginStepsOrangeHrm {

    public LoginStepsOrangeHrm(Pages page) {
        this.page = page;
    }

    private Pages page;

    Logger log = Logger.getLogger(LoginStepsOrangeHrm.class);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com");
    }

    @When("user fills the username as {string} and password as {string}")
    public void userFillsTheUsernameAsAndPasswordAs(String uname, String pass) throws InterruptedException {
        page.loginForOrangeHrm().enterUsername(uname);
        page.loginForOrangeHrm().enterPassword(pass);
    }

    @And("Click on Login Button")
    public void clickOnLoginButton() {
        page.loginForOrangeHrm().clickOnLoginButton();
    }

    @Then("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        page.loginForOrangeHrm().getLoginPageTitle();
    }
}
