package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import pageobject.Pages;

import java.io.IOException;

public class AdditionSoftwareSteps {
    Logger log = Logger.getLogger(AdditionSoftwareSteps.class);
    public AdditionSoftwareSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    /* TC_03 :This method is used to click on menu button */
    @Given("user is on Additional software request page")
    public void userIsOnAdditionalSoftwareRequestPage() throws InterruptedException {
        page.additionSoftwarePage().clickOnMenu();
        log.info("successfully clicked hamburger menu option");
    }

    /*TC_05 : This method is used to select project name */
    /*TC_06 ,TC_07 : This method is used to fill required information of Location */
    /*TC_08 : This method is used to fill host details */
    /*TC_09 : This method is used to for remark */
    @When("user enter required detail to raise eform")
    public void userEnterRequiredDetailToRaiseEform() throws IOException, ParseException, InterruptedException {
        page.additionSoftwarePage().enterRequireDetails();
        log.info("entered requirement details on AdditionSoftwareRequest page");
        page.additionSoftwarePage().acceptTndC();
        log.info("successfully checked accepted checkbox on AdditionSoftwareRequest page");
        page.additionSoftwarePage().enterRemark();
        log.info("successfully typed remark description on AdditionSoftwareRequest page");
    }

    /*TC_11 : This method is used to submit Eform*/
    @And("User Click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        page.additionSoftwarePage().clickOnSubmitbtn();
        log.info("successfully clicked submit button on AdditionSoftwareRequest page");
    }

    @Then("User gets eform number")
    public void userGetsEformNumber() {
    }

}
