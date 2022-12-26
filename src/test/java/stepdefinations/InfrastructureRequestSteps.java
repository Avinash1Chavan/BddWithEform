package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageaction.InfrastructureRequestPage;
import pageobject.Pages;

public class InfrastructureRequestSteps {

    Logger log = Logger.getLogger(InfrastructureRequestSteps.class);
    public InfrastructureRequestSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    @Given("user is on infrastructure request page")
    public void userIsOnInfrastructureRequestPage() throws InterruptedException {
        page.infrastructureRequestPage().clickMenu();
        log.info("successfully clicked hamburger menu option");
        page.infrastructureRequestPage().clickInfrastructureRequestBtn();
        log.info("");
    }

    @And("user select project and enter Requirement Details")
    public void userSelectProjectAndEnterRequirementDetails() throws InterruptedException {
        page.infrastructureRequestPage().enterProjectName();
        log.info("successfully automated Requester Details on infrastructure request page");
        page.infrastructureRequestPage().enterRequirementDetails();
        log.info("successfully automated Requirement  Details on infrastructure request page");
    }

    @And("user enter User Details")
    public void userEnterUserDetails() throws InterruptedException {
        page.infrastructureRequestPage().enterUserDetail();
        log.info("successfully automated User Details on self on infrastructure request page");
    }

    @And("user enter Remarks")
    public void userEnterRemarks() throws InterruptedException {
        page.infrastructureRequestPage().enterRemark();
        log.info("successfully entered Remark on infrastructure request page");
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException {
        page.infrastructureRequestPage().clickSubmitBtn();
        log.info("successfully submitted  submit eform button on infrastructure request page");
    }

    @Then("user gets eform number")
    public void userGetsEformNumber() {
    }
}
