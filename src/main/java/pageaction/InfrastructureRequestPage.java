package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonActions;

import java.util.List;

public class InfrastructureRequestPage {

    WebDriver driver;

    /* initializing the page objects */
    public InfrastructureRequestPage(WebDriver rDriver) {
        driver = rDriver;
    }

    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;

    /* it's finding view status option element in eform Application */
    @FindBy(xpath = "//p[normalize-space()='Infrastructure Request']")
    WebElement infrastructureRequestBtn;

    /* it's finding eform text box element in eform Application */
    @FindBy(xpath = "//select[@id='projectName']")
    WebElement projectName;

    @FindBy(xpath = "//select[@id='requestType']")
    WebElement requestType;

    @FindBy(xpath = "//select[@id='systemType']")
    WebElement systemType;

    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//select[@id='allocationType']")
    WebElement systemAllocation;

    @FindBy(xpath = "//select[@id='quantity']")
    WebElement quantityRequired;

    @FindBy(xpath = "//select[@id='infraName']")
    WebElement infraStructureAllocation;

    @FindBy(xpath = "//input[@id='requiredDate_infra']")
    WebElement requiredDate;

    @FindBy(xpath = "(//input[@id='radioSystem1'])[1]")
    WebElement user;

    @FindBy(xpath = "//select[@id='assetNumber']")
    WebElement assetNumber;

    @FindBy(xpath = "(//input[@id='cc-name'])[1]")
    WebElement deskNumber;

    @FindBy(xpath = "(//input[@id='cc-name'])[2]")
    WebElement extensionNumber;

    @FindBy(xpath = "//select[@id='associateStatus']")
    WebElement associateStatus;

    @FindBy(xpath = "//select[@id='baseLocation']")
    WebElement baseLocation;

    @FindBy(xpath = "//select[@id='location']")
    WebElement location;

    @FindBy(xpath = "//textarea[@id='userRemark']")
    WebElement remark;

    @FindBy(xpath = "//button[normalize-space()='Submit eForm']")
    WebElement submitEForm;

    /* This method is used for click on menu button */
    public void clickMenu() throws InterruptedException {
        CommonActions.clickingOnWebElement(menu, 5);
    }


    /* This method is used to select view status  */
    public void clickInfrastructureRequestBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(infrastructureRequestBtn, 3);
    }

    /* This method is used for enter the eform number in text box */
    public void enterProjectName() throws InterruptedException {
        CommonActions.selectDropDownValue(projectName,"value","AS_BFSI");
    }

    public void enterRequirementDetails() throws InterruptedException {
        CommonActions.scrollDown("window.scrollBy(0, 150)");
        CommonActions.selectDropDownValue(requestType,"index","1");
        CommonActions.selectDropDownValue(systemType,"index","1");
        CommonActions.selectDropDownValue(systemAllocation,"index","1");
        CommonActions.selectDropDownValue(quantityRequired,"value","1");
        CommonActions.selectDropDownValue(infraStructureAllocation,"index","1");
        //CommonActions.clickingOnWebElement(requiredDate, 3);

    }

    public void enterUserDetail() throws InterruptedException {
        CommonActions.scrollDown("window.scrollBy(0, 430)");
        CommonActions.clickingOnWebElement(user,3);
        //CommonActions.selectDropDownValue(assetNumber,"index","2");
        CommonActions.sendKeysWebElement(deskNumber,"00");
        CommonActions.sendKeysWebElement(extensionNumber,"0000");
        CommonActions.selectDropDownValue(associateStatus,"index","1");
        CommonActions.selectDropDownValue(baseLocation,"index","1");
        CommonActions.selectDropDownValue(location,"index","0");

    }

    public void enterRemark() throws InterruptedException {
        CommonActions.sendKeysWebElement(remark,"for project purpose");
    }


    /* This method is used for click submit button*/
    public void clickSubmitBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(submitEForm, 3);
    }
}

