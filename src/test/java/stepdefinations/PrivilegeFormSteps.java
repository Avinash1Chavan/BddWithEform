package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import pageobject.Pages;

import java.io.IOException;

public class PrivilegeFormSteps {

    public PrivilegeFormSteps(Pages page) {
        this.page = page;
    }

    private Pages page;
    Logger log = Logger.getLogger(PrivilegeFormSteps.class);

    /* TC_04 , TC_05 :Select Privilege request */
    @Given("user is on Privilege request page")
    public void userIsOnPrivilegeRequestPage() {
        page.privilegeFormPage().clickOnMenu();
    }

    /* TC_03 :This method is used to enter require details*/
    @When("user enter required detail")
    public void userEnterRequiredDetail() throws IOException, ParseException, InterruptedException {
        page.privilegeFormPage().enterRequireDetails();
    }

    /*TC_10 : This method is used for check box to accpet terms */
    @And("User accept terms and conditions")
    public void userAcceptTermsAndConditions() {
        page.privilegeFormPage().clickOnCheckBox();
    }



    @And("User Click Submit button")
    public void userClickSubmitButton() throws InterruptedException {
        page.privilegeFormPage().clickOnSubmitbtn();
    }

    @Then("User get eform number")
    public void userGetsEformNumber() {

    }
}
