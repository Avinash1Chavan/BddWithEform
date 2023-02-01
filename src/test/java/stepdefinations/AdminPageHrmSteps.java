package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobject.Pages;

public class AdminPageHrmSteps {

    public AdminPageHrmSteps(Pages page) {
        this.page = page;
    }

    private Pages page;
    @Given("user is on admin page")
    public void userIsOnAdminPage() throws InterruptedException {
        page.adminPageForHrm().clickMenu();
    }

    @When("user enter searching details")
    public void userEnterSearchingDetails() throws InterruptedException {
        page.adminPageForHrm().enterSearchDetails();
    }

    @And("user click on search button")
    public void userClickOnSearchButton() throws InterruptedException {
        page.adminPageForHrm().clickOnSearchBtn();
    }

    @And("user click on edit button")
    public void userClickOnEditButton() throws InterruptedException {
        page.adminPageForHrm().clickOnEditBtn();
    }

    @And("user edit admin details")
    public void userEditAdminDetails() throws InterruptedException {
        page.adminPageForHrm().editAdminDetails();
    }

    @And("user click on save button")
    public void userClickOnSaveButton() throws InterruptedException {
        page.adminPageForHrm().clickOnSaveBtn();
    }
}
