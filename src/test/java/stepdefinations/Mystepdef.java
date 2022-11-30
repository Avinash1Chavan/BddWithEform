package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.*;
import utils.CommonActions;
import utils.ConfigReader;
import utils.ExcelReader;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Mystepdef extends CommonActions {

    PrivilegeFormPage pf = new PrivilegeFormPage(DriverFactory.getDriver());
    AdditionSoftwarePage as = new AdditionSoftwarePage(DriverFactory.getDriver());
    ViewStatusPg vsp = new ViewStatusPg(DriverFactory.getDriver());
    LoginForEform loginForEform = new LoginForEform(DriverFactory.getDriver());
    public LoginForEformWithDB lb = new LoginForEformWithDB(DriverFactory.getDriver());

    /*---------------------------Test Scenario TS_01 --------------------------------------------*/

    /* TC_02 :This method is used to navigate respective URL using getDriver() calling from DriverFactory
     method located into factoty package */
    @Given("user navigates to Website")
    public void user_Navigates_To_Website() throws InterruptedException {
         // getdriver method is called from Driverfactory class which is located in factory package*/
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("https://eformsnew.zensar.com/eformsDev/Login");
    }

    /*TC_03 :This method is used to login using valid credential fetching from Excel utility.Excel Utility placed under utils package inside ExcelReader file
     */
//    @When("user fills credential  from given sheetname {string} and rownumber {int}")
//    public void user_Fills_The_Form_From_Given_Sheetname_And_RowNumber(String sheetName, Integer rowNumber) throws IOException, InterruptedException {
//        ExcelReader reader = new ExcelReader();
//        List<Map<String, String>> testData =
//                reader.getData("src/main/java/utils/Data.xlsx", sheetName);
//
//        String username = testData.get(rowNumber).get("Usename");
//        System.out.println("uname--" + username);
//        String pass = testData.get(rowNumber).get("Password");
//        loginForEform.log_In(username, pass);
//
//    }

    /* TC_03 :This method is used to Login using logINAndClosePopUp() defined in */
    @When("user clicks on Login button")
    public void user_Clicks_On_Login_Button() throws AWTException, InterruptedException {
        loginForEform.logInAndClosePopUp();
    }

    /* TC_04 , TC_05 :Select Privilege request */
    @Given("user is on Privilege request page")
    public void userIsOnPrivilegeRequestPage() {
        pf.clickOnMenu();
    }

    /*TC_05 : This method is used to select project name */
    /*TC_06 ,TC_07 : This method is used to fill required information of Location */
    /*TC_08 : This method is used to fill host details */
    /*TC_09 : This method is used to for remark */
    @When("user enter required detail to raise eform")
    public void userEnterRequiredDetailToRaiseEform() throws IOException, ParseException, InterruptedException {
        as.selectProjectName();
        as.acceptTndC();
        as.enterRemark();
    }

    /*TC_10 : This method is used for check box to accpet terms */
    @And("User accept terms and conditions")
    public void userAcceptTermsAndConditions() {
        pf.clickOnCheckBox();
    }

    /*TC_11 : This method is used to submit Eform*/
    @And("User Click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        as.clickOnSubmitbtn();
    }

    @And("User Click Submit button")
    public void userClickSubmitButton() throws InterruptedException {
        pf.clickOnSubmitbtn();
    }

    /*-----------------------------------Test Scenario TS_02----------------------------------------*/
    /*TC_03, TC_04 :This method is click menu Hamburger  and view status option*/
    @When("user clicks on View Status button")
    public void userClicksOnViewStatusButton() throws InterruptedException {
        vsp.Clickmenu();
        vsp.ClickViewStatusBtn();

    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user fills E-formNo")
    public void userFillsEFormNoAs() throws InterruptedException {
        vsp.EnterEformNO();
    }

    /*TC_11 : This method is used to enter Eform number*/
    @And("user clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException {
        Thread.sleep(3000);
        vsp.ClickSubmitBtn();
    }


    @Then("User gets eform number")
    public void userGetsEformNumber() {

    }

    @And("verify status")
    public void verifyStatus() {
        vsp.VerifyStatus();
    }

    @Given("user is on Additional software request page")
    public void userIsOnAdditionalSoftwareRequestPage() throws InterruptedException {
        as.clickOnMenu();
    }

    @When("user enters credential from credentialsheet")
    public void userEntersCredentialFromCredentialsheet() throws IOException, InterruptedException {
        String path = ConfigReader.getConfigValue("credentialSheet");
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(path, "Sheet1");

        String username = testData.get(0).get("Usename");
        System.out.println("uname--" + username);
        String pass = testData.get(0).get("Password");
        loginForEform.log_In(username, pass);
    }

    @When("user enters credential from Db")
    public void userEntersCredentialFromDb() throws Exception {
        lb.logIn();
        lb.logInAndClosePopUp();
    }

    @When("user enter required detail")
    public void userEnterRequiredDetail() throws IOException, ParseException, InterruptedException {
        pf.selectProjectName();
    }
}
