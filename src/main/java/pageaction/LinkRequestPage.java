package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonActions;

import java.util.List;

public class LinkRequestPage {

    WebDriver driver;

    /* initializing the page objects */
    public LinkRequestPage(WebDriver rDriver) {
        driver = rDriver;
    }

    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;

    /* it's finding view status option element in eform Application */
    @FindBy(xpath = "(//p[normalize-space()='Link Request Form(LRF)'])[1]")
    WebElement linkRequestBtn;

    /* it's finding eform text box element in eform Application */
    @FindBy(xpath = "//select[@id='projectName']")
    WebElement projectName;

    @FindBy(xpath = "//input[@id='extension']")
    WebElement extensionNumber;

    @FindBy(xpath = "(//input[@class='form-control ng-touched ng-dirty ng-valid'])[1]")
    WebElement oldEform;

    @FindBy(xpath = "//div[2]//select[1]")
    WebElement location;

    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//select[@id='allocationType']")
    WebElement systemAllocation;

    @FindBy(xpath = "//input[@id='hostName']")
    WebElement hostName;

    @FindBy(xpath = "//input[@id='ipAddress']")
    WebElement IpAddress;

    @FindBy(xpath = "//div[2]//select[1]")
    WebElement linkLoactionFrom;

    @FindBy(xpath = "//div[2]//select[1]")
    WebElement linkLocationTo;

    @FindBy(xpath = "(//div)[61]")
    List<WebElement> paidBy;

    @FindBy(xpath = "(//div)[65]")
    List<WebElement> selectOne;

    @FindBy(xpath = "//textarea[@id='userRemark']")
    WebElement remark;

    @FindBy(xpath = "//button[normalize-space()='Submit eForm']")
    WebElement submitBtn;

    /* This method is used for click on menu button */
    public void clickMenu() throws InterruptedException {
        CommonActions.clickingOnWebElement(menu,4);
    }


    /* This method is used to select view status  */
    public void clickLinkRequestBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(linkRequestBtn, 3);
    }

    /* This method is used for enter the eform number in text box */
    public void enterProjectName() throws InterruptedException {
        CommonActions.selectDropDownValue(projectName,"value","AS_BFSI");
    }

    public void enterLocationDetails() throws InterruptedException {
        CommonActions.sendKeysWebElement(extensionNumber,"0000");
        CommonActions.selectDropDownValue(location,"index","1");
        CommonActions.sendKeysWebElement(extensionNumber,"PO1284784747");
        CommonActions.sendKeysWebElement(extensionNumber,"192.168.9.0");

    }

    public void enterLinkDetail() throws InterruptedException {
        CommonActions.selectDropDownValue(linkLoactionFrom,"index","1");
        CommonActions.selectDropDownValue(linkLocationTo,"index","1");
        CommonActions.selectRadioButtonValue(paidBy,"Client");
        CommonActions.selectRadioButtonValue(selectOne,"Yes");
    }

    public void enterRemark() throws InterruptedException {
        CommonActions.sendKeysWebElement(remark,"for project purpose");
    }


    /* This method is used for click submit button*/
    public void clickSubmitBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(submitBtn, 3);
    }
}
