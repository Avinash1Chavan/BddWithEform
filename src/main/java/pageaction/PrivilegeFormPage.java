package pageaction;

import factory.DriverFactory;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;
import utils.JsonRead;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PrivilegeFormPage {

    Logger log = Logger.getLogger(PrivilegeFormPage.class);
    WebDriver driver;

    /* initializing the page objects */
    public PrivilegeFormPage(WebDriver rDriver) {
        driver = rDriver;

        PageFactory.initElements(rDriver, this);
    }

    /* it's finding menu element in eform Application */
    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;

    /* it's finding request type element in eform Application */
    @FindBy(xpath = "//a[@id='PrivilegeRequestFormComponent']")
    WebElement type;

    /* it's finding project name element in eform Application */
    @FindBy(xpath = "//select[@id='projectName']")
    WebElement projectname;

    /* it's finding asset type element in eform Application */
    @FindBy(xpath = "//select[@id='assetType']")
    WebElement assetType;

    /* it's finding asset number element in eform Application */
    @FindBy(xpath = "//select[@id='assetNumber']")
    WebElement assetNumber;

    /* it's finding asset number element in eform Application */
    @FindBy(xpath = "//input[@id='assetno']")
    WebElement assetNo;

    /* it's finding extension number element in eform Application */
    @FindBy(xpath = "//input[@id='extension']")
    WebElement extensionNumber;

    /* it's finding location element in eform Application */
    @FindBy(xpath = "//select[@id='location']")
    WebElement location;

    /* it's finding desk number element in eform Application */
    @FindBy(xpath = "//input[@id='deskNumber']")
    WebElement deskNumber;

    /* it's finding required date element in eform Application */
    @FindBy(xpath = "//input[@id='requiredDate']")
    WebElement requiredDate;

    /* it's finding revoke date element in eform Application */
    @FindBy(xpath = "//input[@id='revokeDate']")
    WebElement revokeDate;

    /* it's finding hostname element in eform Application */
    @FindBy(xpath = "//input[@id='hostName']")
    WebElement hostname;

    /* it's finding remark element in eform Application */
    @FindBy(xpath = "//textarea[@id='remarks']")
    WebElement remark;

    /* it's finding checkbox element in eform Application */
    @FindBy(xpath = "//input[@id='iAccept']")
    WebElement checkbox;

    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//button[normalize-space()='Submit eForm']")
    WebElement submitbtn;

    /* This method is used to click menu and select request type */
    public void clickOnMenu() {
        CommonActions.clickingOnWebElement(menu, 2);
        CommonActions.clickingOnWebElement(type, 2);
    }

    /* This method is used to select respective project name and fill required details */
    public void enterRequireDetails() throws InterruptedException, IOException, ParseException {
        String projectName = "";
        String AssetType = "";
        String AssetNumber = "";
        String AssetNo = "";
        String ScrollDown = "";
        String ExtensionNumber = "";
        String Location = "";
        String DeskNumber = "";
        String Hostname = "";
        String Remark = "";

        JSONArray usersList = JsonRead.jsonRead();
        log.info("Users List-> " + usersList); //This prints the entire json file
        for (int i = 0; i < usersList.size(); i++) {
            JSONObject users = (JSONObject) usersList.get(i);
            log.info("Users -> " + users);//This prints every block - one json object
            JSONObject user = (JSONObject) users.get("users");
            log.info("User -> " + user); //This prints each data in the block
            projectName = (String) user.get("project");
            AssetType = (String) user.get("assettype");
            AssetNumber = (String) user.get("assetnumber");
            AssetNo = (String) user.get("assetno");
            ScrollDown = (String) user.get("scrolldown");
            ExtensionNumber = (String) user.get("extensionnumber");
            Location = (String) user.get("location");
            DeskNumber = (String) user.get("desknumber");
            Hostname = (String) user.get("hostname");
            Remark = (String) user.get("remark");


        }
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CommonActions.selectDropDownValue(projectname, "value", projectName);
        CommonActions.selectDropDownValue(assetType, "value", AssetType);
        CommonActions.selectDropDownValue(assetNumber, "value", AssetNumber);
        CommonActions.sendKeysWebElement(assetNo, AssetNo);
        CommonActions.sendKeysWebElement(extensionNumber, ExtensionNumber);
        CommonActions.scrollDown(ScrollDown);
        CommonActions.selectDropDownValue(location, "value", Location);
        CommonActions.sendKeysWebElement(deskNumber, DeskNumber);
        CommonActions.sendKeysWebElement(hostname, Hostname);
        CommonActions.sendKeysWebElement(remark, Remark);
        CommonActions.scrollDown(ScrollDown);
    }

    /* This method is used to accept the terms and conditions before submitting request */
    public void clickOnCheckBox() {
        CommonActions.clickingOnWebElement(checkbox, 2);
    }

    /* This method is used to click on submit button */
    public void clickOnSubmitbtn() {
        CommonActions.clickingOnWebElement(submitbtn, 2);
    }

}