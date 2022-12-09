package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageaction.InfrastructureRequestPage;
import pageobject.Pages;

public class InfrastructureRequestSteps {

    public InfrastructureRequestSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    @Given("user is on infrastructure request page")
    public void userIsOnInfrastructureRequestPage() throws InterruptedException {
        page.infrastructureRequestPage().clickMenu();
        page.infrastructureRequestPage().clickInfrastructureRequestBtn();
    }

    @And("user select project and enter Requirement Details")
    public void userSelectProjectAndEnterRequirementDetails() throws InterruptedException {
        page.infrastructureRequestPage().enterProjectName();
        page.infrastructureRequestPage().enterRequirementDetails();
    }

    @And("user enter User Details")
    public void userEnterUserDetails() throws InterruptedException {
        page.infrastructureRequestPage().enterUserDetail();
    }

    @And("user enter Remarks")
    public void userEnterRemarks() throws InterruptedException {
        page.infrastructureRequestPage().enterRemark();
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException {
        page.infrastructureRequestPage().clickSubmitBtn();
    }

    @Then("user gets eform number")
    public void userGetsEformNumber() {
    }
}
