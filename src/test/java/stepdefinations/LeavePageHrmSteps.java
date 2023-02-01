package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Pages;

public class LeavePageHrmSteps {
    public LeavePageHrmSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    @Given("user is on leave page")
    public void userIsOnLeavePage() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @When("user click on apply button")
    public void userClickOnApplyButton() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @And("user enter leave details")
    public void userEnterLeaveDetails() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @And("user click on apply for leave button")
    public void userClickOnApplyForLeaveButton() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @And("user click on my leave button")
    public void userClickOnMyLeaveButton() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @And("user enter require details")
    public void userEnterRequireDetails() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }

    @Then("user verify leave status")
    public void userVerifyLeaveStatus() throws InterruptedException {
        page.leavePageForHrm().clickMenu();
    }
}
