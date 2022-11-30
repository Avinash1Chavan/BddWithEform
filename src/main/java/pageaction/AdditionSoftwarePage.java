package pageaction;

import factory.DriverFactory;
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

public class AdditionSoftwarePage {

    WebDriver driver;

    /* initializing the page objects */
    public AdditionSoftwarePage(WebDriver rDriver) {
        driver = rDriver;

        PageFactory.initElements(rDriver, this);
    }

    /* it's finding menu element in eform Application */
    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;

    /* it's finding request type element in eform Application */
    @FindBy(xpath = "//a[@id='AdditionalSoftwareFormComponent']")
    WebElement type;

    /* it's finding project name element in eform Application */
    @FindBy(xpath = "//select[@id='projectName']")
    WebElement projectname;

    /* it's finding asset type element in eform Application */
    @FindBy(xpath = "//input[@formcontrolname='ipAddress']")
    WebElement ipAddress;

    /* it's finding asset number element in eform Application */
    @FindBy(xpath = "//select[@id='assetNumber']")
    WebElement assetNumber;

    /* it's finding licence type element in eform Application */
    @FindBy(xpath = "//select[@formcontrolname='licenseType']")
    WebElement licenseType;

    /* it's finding  commercial element in eform Application */
    @FindBy(xpath = "//select[@formcontrolname='commercial']")
    WebElement freeware;

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
    @FindBy(xpath = "//input[@formcontrolname='productDetails']")
    WebElement productName;

    /* it's finding hostname element in eform Application */
    @FindBy(xpath = "//input[@formcontrolname='hostName']")
    WebElement hostname;

    /* it's finding remark element in eform Application */
    @FindBy(xpath = "//textarea[@id='remarks']")
    WebElement remark;

    /* it's finding checkbox element in eform Application */
    @FindBy(xpath = "//input[@id='checkInternalPurpose']")
    WebElement internalProject;

    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//a[@class='au-btn--submit ml-4 btnToScroll ng-star-inserted']")
    WebElement submitbtn;

    /* it's finding terms and conditions element in eform Application */
    @FindBy(xpath = "//a[normalize-space()='Terms & Conditions']")
    WebElement tndc;

    /* it's finding checkbox element in eform Application */
    @FindBy(xpath = "//div[@id='okBtn']//input[@placeholder='Please enter details']")
    WebElement checkbox;

    /* it's finding ok button element in eform Application */
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okbtn;

    /* This method is used to click menu and select request type */
    public void clickOnMenu() {
        CommonActions.clickingOnWebElement(menu, 5);
        CommonActions.clickingOnWebElement(type, 5);
    }

    /* This method is used to select respective project name and fill remaining details */
    public void enterRequireDetails() throws InterruptedException, IOException, ParseException {
        String projectName = "";
        String ProductDetails = "";
        String AssetNumber = "";
        String AssetNo = "";
        String ScrollDown = "";
        String ExtensionNumber = "";
        String Location = "";
        String DeskNumber = "";
        String Hostname = "";
        String RequireDate = "";
        String LicenseType = "";
        String Commercial = "";
        String IpAddress = "";
        String Value = "";
        String Index = "";

        JSONArray usersList = JsonRead.jsonRead(); //This stores the entire json file
        for (int i = 0; i < usersList.size(); i++) {
            JSONObject users = (JSONObject) usersList.get(i); //This stores every block - one json object
            JSONObject user = (JSONObject) users.get("users"); //This stores each data in the block
            projectName = (String) user.get("project");
            ProductDetails = (String) user.get("productdetails");
            AssetNumber = (String) user.get("assetnumber");
            AssetNo = (String) user.get("assetno");
            ScrollDown = (String) user.get("scrolldown");
            ExtensionNumber = (String) user.get("extensionnumber");
            Location = (String) user.get("location");
            DeskNumber = (String) user.get("desknumber");
            Hostname = (String) user.get("hostname");
            RequireDate = (String) user.get("requiredate");
            LicenseType = (String) user.get("licenseType");
            Commercial = (String) user.get("commercial");
            IpAddress = (String) user.get("ipAddress");
            Value = (String) user.get("value");
            Index = (String) user.get("index");

        }
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CommonActions.selectDropDownValue(projectname, Value, projectName);
        CommonActions.scrollDown(ScrollDown);
        CommonActions.sendKeysWebElement(extensionNumber, ExtensionNumber);
        CommonActions.selectDropDownValue(location, Value, Location);
        CommonActions.selectDropDownValue(assetNumber, Value, AssetNumber);
        CommonActions.sendKeysWebElement(assetNo, AssetNo);
        CommonActions.sendKeysWebElement(deskNumber, DeskNumber);
        CommonActions.sendKeysWebElement(ipAddress, IpAddress);
        CommonActions.sendKeysWebElement(hostname, Hostname);
        CommonActions.scrollDown(ScrollDown);
        CommonActions.clickingOnWebElement(internalProject, 3);
        CommonActions.selectDropDownValue(licenseType, Index, LicenseType);
        CommonActions.selectDropDownValue(freeware, Index, Commercial);
        Thread.sleep(3000);
        //requiredDate.sendKeys(RequireDate);
        CommonActions.sendKeysWebElement(productName, ProductDetails);
    }

    /* This method is used to accept terms and conditions */
    public void acceptTndC() throws InterruptedException {
        CommonActions.clickingOnWebElement(tndc, 3);
        Thread.sleep(3000);
        CommonActions.clickingOnWebElement(checkbox, 5);
        CommonActions.clickingOnWebElement(okbtn, 3);
    }

    /* This method is used to fill remark details */
    public void enterRemark() throws IOException, ParseException, InterruptedException {
        String Remark = "";
        String ScrollDown = "";
        JSONArray usersList = JsonRead.jsonRead(); //This stores the entire json file
        for (int i = 0; i < usersList.size(); i++) {
            JSONObject users = (JSONObject) usersList.get(i); //This stores every block - one json object
            JSONObject user = (JSONObject) users.get("users"); //This stores each data in the block
            Remark = (String) user.get("remark");
            ScrollDown = (String) user.get("scrolldown");
        }
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CommonActions.sendKeysWebElement(remark, Remark);
        CommonActions.scrollDown(ScrollDown);

    }

    /* This method is used to click on submit button */
    public void clickOnSubmitbtn() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CommonActions.clickingOnWebElement(submitbtn, 2);
    }


}
