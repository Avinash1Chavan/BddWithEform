package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageaction.LinkRequestPage;
import pageobject.Pages;

public class LinkRequestSteps {

    public LinkRequestSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    @Given("user is on link request form page")
    public void userIsOnLinkRequestFormPage() throws InterruptedException {
        page.linkRequestPage().clickMenu();
        page.linkRequestPage().clickLinkRequestBtn();
    }

    @And("user select project name")
    public void userSelectProjectName() throws InterruptedException {
        page.linkRequestPage().enterProjectName();
    }

    @And("user enter location Details")
    public void userEnterLocationDetails() throws InterruptedException {
        page.linkRequestPage().enterLocationDetails();
    }

    @And("user enter link Details")
    public void userEnterLinkDetails() throws InterruptedException {
        page.linkRequestPage().enterLinkDetail();
    }

    @And("user enter remarks")
    public void userEnterRemarks() throws InterruptedException {
        page.linkRequestPage().enterRemark();
    }

    @And("User click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        page.linkRequestPage().clickSubmitBtn();
    }

    @Then("user get eform number")
    public void userGetEformNumber() {

    }

}
