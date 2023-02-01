package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageobject.Pages;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PimHrmSteps {
    Logger log = Logger.getLogger(PimHrmSteps.class);
    public PimHrmSteps(Pages page) {
        this.page = page;
    }

    private Pages page;


    @Given("user navigates to HrmWebsite")
    public void user_Navigates_To_Website_Hrm() throws InterruptedException, IOException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log.info("successfully launched hr resource application");
    }

    @When("user enters credential on Hrm Application and click login button")
    public void UserEnterCredentialForHrm() throws InterruptedException, IOException {
        page.LoginForHrmPage().setLogindetail();
        log.info("successfully entered credentials on hrm");
    }


    @Given("user clicking PIM On Orange HRM application")
    public void UserClickPimForHrm() throws InterruptedException {
        Thread.sleep(2000);
        page.AddEmployeeForHrmPage().clickPIM();
        Thread.sleep(2000);
        log.info("successfully clicked Pim header");
    }
    @Given("user clicking AddEmployee On Orange HRM application")
    public void UserClickAddEmpForHrm() throws InterruptedException {
        page.AddEmployeeForHrmPage().clickAddEmployee();
        Thread.sleep(2000);
        log.info("successfully clicked add employee tab");
    }

    @When("user entering Orange HRM application details as First Name,lastName, middleName and click save button")
    public void UserEnetrEmpDetailsForHrm() throws IOException, InterruptedException, AWTException {
        page.AddEmployeeForHrmPage().AddEmployeeActions();
        log.info("successfully filled employee details");
    }
    @And("user scrolled Orange HRM application")
    public void UserScrollOnHrm() throws InterruptedException {
        Thread.sleep(2000);
        page.AddEmployeeForHrmPage().scrool();
        Thread.sleep(2000);
        log.info("successfully scrolled on hrm");
    }
    @And ("user selecting dropdowns on Orange HRM application")
    public void UserSelectDropdownHrm() throws InterruptedException {
        page.AddEmployeeForHrmPage().dropdown();
        log.info("successfully selected dropdown fields");
    }
    @Then("User selected data on Hrm application")
    public void UserSelectData() throws InterruptedException {
        page.AddEmployeeForHrmPage().setData();
        log.info("successfully selected data on calendar tab");
    }
    @And  ("user Select Radio Button on Hrm")
    public void UserSelectRadioButton(){
        page.AddEmployeeForHrmPage().SelectRadioButton();
        log.info("successfully selected radio button");

    }
    @Then ("user Select Smoker checkbox on Hrm")
    public void UserSelectCheckBox(){
        page.AddEmployeeForHrmPage().SelectCheckboxAndSave();
        log.info("successfully selected checkbox");
    }

}
