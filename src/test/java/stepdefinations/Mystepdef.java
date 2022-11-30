package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import pageobject.Pages;
import utils.ConfigReader;
import utils.ExcelReader;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Mystepdef {


    public Mystepdef(Pages page) {
        this.page = page;
    }

    private Pages page;
    Logger log = Logger.getLogger(Mystepdef.class);

    /*---------------------------Test Scenario TS_01 --------------------------------------------*/

    /* TC_02 :This method is used to navigate respective URL using getDriver() calling from DriverFactory
     method located into factoty package */
    @Given("user navigates to Website")
    public void user_Navigates_To_Website() throws InterruptedException {
        // getdriver method is called from Driverfactory class which is located in factory package*/
        log.info("****************************** Starting test cases execution  *****************************************");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("https://eformsnew.zensar.com/eformsDev/Login");
    }

    /* TC_03 :This method is used to enter required credentials */
    @When("user enters credential from credentialsheet")
    public void userEntersCredentialFromCredentialsheet() throws IOException, InterruptedException {
        String path = ConfigReader.getConfigValue("credentialSheet");
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(path, "Sheet1");

        String username = testData.get(0).get("Usename");
        log.info("uname--" + username);
        String pass = testData.get(0).get("Password");
        page.loginForEform().log_In(username, pass);
    }

    /* TC_03 :This method is used to Login using logINAndClosePopUp() defined in */
    @When("user clicks on Login button")
    public void user_Clicks_On_Login_Button() throws AWTException, InterruptedException {
        page.loginForEform().logInAndClosePopUp();
    }


    /* TC_04 , TC_05 :Select Privilege request */
    @Given("user is on Privilege request page")
    public void userIsOnPrivilegeRequestPage() {
        page.privilegeFormPage().clickOnMenu();
    }

    /*TC_05 : This method is used to select project name */
    /*TC_06 ,TC_07 : This method is used to fill required information of Location */
    /*TC_08 : This method is used to fill host details */
    /*TC_09 : This method is used to for remark */
    @When("user enter required detail to raise eform")
    public void userEnterRequiredDetailToRaiseEform() throws IOException, ParseException, InterruptedException {
        page.additionSoftwarePage().enterRequireDetails();
        page.additionSoftwarePage().acceptTndC();
        page.additionSoftwarePage().enterRemark();
    }

    /*TC_10 : This method is used for check box to accpet terms */
    @And("User accept terms and conditions")
    public void userAcceptTermsAndConditions() {
        page.privilegeFormPage().clickOnCheckBox();
    }

    /*TC_11 : This method is used to submit Eform*/
    @And("User Click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        page.additionSoftwarePage().clickOnSubmitbtn();
    }

    @And("User Click Submit button")
    public void userClickSubmitButton() throws InterruptedException {
        page.privilegeFormPage().clickOnSubmitbtn();
    }

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


    @Then("User gets eform number")
    public void userGetsEformNumber() {

    }

    /* TC_03 :This method is used to verify status of particular eform number */
    @And("verify status")
    public void verifyStatus() {
        page.viewStatusPg().VerifyStatus();
    }

    /* TC_03 :This method is used to click on menu button */
    @Given("user is on Additional software request page")
    public void userIsOnAdditionalSoftwareRequestPage() throws InterruptedException {
        page.additionSoftwarePage().clickOnMenu();
    }

    /* TC_03 :This method is used to enter require details*/
    @When("user enter required detail")
    public void userEnterRequiredDetail() throws IOException, ParseException, InterruptedException {
        page.privilegeFormPage().enterRequireDetails();
    }
}
