package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageobject.Pages;

public class ViewStatusSteps {

    public ViewStatusSteps(Pages page) {
        this.page = page;
    }

    private Pages page;
    Logger log = Logger.getLogger(ViewStatusSteps.class);

    /*-----------------------------------Test Scenario TS_02----------------------------------------*/
    /*TC_03, TC_04 :This method is click menu Hamburger  and view status option*/
    @When("user clicks on View Status button")
    public void userClicksOnViewStatusButton() throws InterruptedException {
        page.viewStatusPg().Clickmenu();
        page.viewStatusPg().ClickViewStatusBtn();

    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user fills E-formNo")
    public void userFillsEFormNoAs() throws InterruptedException {
        page.viewStatusPg().EnterEformNO();
    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException {
        Thread.sleep(3000);
        page.viewStatusPg().ClickSubmitBtn();
    }



    /* TC_03 :This method is used to verify status of particular eform number */
    @And("verify status")
    public void verifyStatus() {
        page.viewStatusPg().VerifyStatus();
    }
}
