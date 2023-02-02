package pageaction;

import factory.DriverFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;
import utils.JsonRead;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;


public class PrivilegeFormPage {

    WebDriver driver;

    /* initializing the page objects */
    public PrivilegeFormPage(WebDriver rDriver) {
        driver = rDriver;
    }

    /* it's finding menu element in eform Application */
    @FindBy(xpath = "//div[@class='header-button eform-menu']//div[@class='noti-wrap']")
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
        CommonActions.clickingOnWebElement(menu, 3);
        CommonActions.clickingOnWebElement(type, 3);
    }

    /* This method is used to select respective project name and fill required details */
    public void enterRequireDetails() throws InterruptedException, IOException, ParseException {
        Object jsonObject = JsonRead.convertFileToJson();

       String projectName = JsonRead.getValue(jsonObject, "project");
       String AssetType = JsonRead.getValue(jsonObject, "assettype");
       String AssetNumber = JsonRead.getValue(jsonObject, "assetnumber");
       String AssetNo = JsonRead.getValue(jsonObject, "assetno");
       String ExtensionNumber = JsonRead.getValue(jsonObject, "extensionnumber");
       String Location = JsonRead.getValue(jsonObject, "location");
       String DeskNumber = JsonRead.getValue(jsonObject, "desknumber");
       String Hostname = JsonRead.getValue(jsonObject, "hostname");
       String Remark = JsonRead.getValue(jsonObject, "remark");


        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonActions.selectDropDownValue(projectname, "value", projectName);
        CommonActions.selectDropDownValue(assetType, "value", AssetType);
        CommonActions.selectDropDownValue(assetNumber, "value", AssetNumber);
        CommonActions.sendKeysWebElement(assetNo, AssetNo);
        CommonActions.sendKeysWebElement(extensionNumber, ExtensionNumber);
        CommonActions.scrollDown("window.scrollBy(0, 430)");
        CommonActions.selectDropDownValue(location, "value", Location);
        CommonActions.sendKeysWebElement(deskNumber, DeskNumber);
        CommonActions.sendKeysWebElement(hostname, Hostname);
        CommonActions.sendKeysWebElement(remark, Remark);
        CommonActions.scrollDown("window.scrollBy(0, 430)");
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
