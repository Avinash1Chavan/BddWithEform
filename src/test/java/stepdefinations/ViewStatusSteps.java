package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageobject.Pages;

public class ViewStatusSteps {
    Logger log = Logger.getLogger(ViewStatusSteps.class);
    public ViewStatusSteps(Pages page) {
        this.page = page;
    }

    private Pages page;

    /*-----------------------------------Test Scenario TS_02----------------------------------------*/
    /*TC_03, TC_04 :This method is click menu Hamburger  and view status option*/
    @When("user clicks on View Status button")
    public void userClicksOnViewStatusButton() throws InterruptedException {
        page.viewStatusPg().Clickmenu();
        log.info("successfully clicked hamburger menu option");
        page.viewStatusPg().ClickViewStatusBtn();
        log.info("successfully clicked view status button");
    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user fills E-formNo")
    public void userFillsEFormNoAs() throws InterruptedException {
        page.viewStatusPg().EnterEformNO();
        log.info("successfully entered eform number on view status page");
    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException {
        Thread.sleep(3000);
        page.viewStatusPg().ClickSubmitBtn();
        log.info("successfully clicked submit on viewStatus page");
    }

    /* TC_03 :This method is used to verify status of particular eform number */
    @And("verify status")
    public void verifyStatus() {
        page.viewStatusPg().VerifyStatus();
        log.info("successfully verified status of eform");
    }
}
