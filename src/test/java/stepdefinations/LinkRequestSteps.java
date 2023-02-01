package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageaction.LinkRequestPage;
import pageobject.Pages;

public class LinkRequestSteps {

    Logger log = Logger.getLogger(LinkRequestSteps.class);
    public LinkRequestSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    @Given("user is on link request form page")
    public void userIsOnLinkRequestFormPage() throws InterruptedException {
        page.linkRequestPage().clickMenu();
        log.info("successfully clicked hamburger menu option");
        page.linkRequestPage().clickLinkRequestBtn();
        log.info("successfully clicked Link Request button On LinkRequest Page");
    }

    @And("user select project name")
    public void userSelectProjectName() throws InterruptedException {
        page.linkRequestPage().enterProjectName();
        log.info("successfully automated Requester Details On LinkRequest Page");
    }

    @And("user enter location Details")
    public void userEnterLocationDetails() throws InterruptedException {
        page.linkRequestPage().enterLocationDetails();
        log.info("successfully automated Location Details On LinkRequest Page");
    }

    @And("user enter link Details")
    public void userEnterLinkDetails() throws InterruptedException {
        page.linkRequestPage().enterLinkDetail();
        log.info("successfully automated Link Details On LinkRequest Page");
    }

    @And("user enter remarks")
    public void userEnterRemarks() throws InterruptedException {
        page.linkRequestPage().enterRemark();
        log.info("successfully entered Remark On LinkRequest Page");
    }

    @And("User click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        page.linkRequestPage().clickSubmitBtn();
        log.info("successfully clicked submit button on LinkRequest page On LinkRequest Page");
    }

    @Then("user get eform number")
    public void userGetEformNumber() {

    }

}
