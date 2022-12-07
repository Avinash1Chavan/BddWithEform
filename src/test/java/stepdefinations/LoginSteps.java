package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import pageobject.Pages;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.XmlReader;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    public LoginSteps(Pages page) {
        this.page = page;
    }

    private Pages page;
    Logger log = Logger.getLogger(LoginSteps.class);

    /*---------------------------Test Scenario TS_01 --------------------------------------------*/

    /* TC_02 :This method is used to navigate respective URL using getDriver() calling from DriverFactory
     method located into factoty package */
    @Given("user navigates to Website")
    public void user_Navigates_To_Website() throws InterruptedException, IOException, ParseException, ParserConfigurationException, SAXException {
        // getdriver method is called from Driverfactory class which is located in factory package*/
        log.info("****************************** Starting test cases execution  *****************************************");
        XmlReader.XmlReader();
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
}
