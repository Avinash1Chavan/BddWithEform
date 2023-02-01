package pageaction;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

import java.time.Duration;

public class LeavePageForHrm {

    WebDriver driver;

    public LeavePageForHrm(WebDriver rDriver)
    {
        driver=rDriver;
    }


    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    WebElement leaveMenu;

    @FindBy(xpath = "(//a[normalize-space()='Apply'])[1]")
    WebElement applyButton;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement leaveType;

    @FindBy(xpath = "(//i)[9]")
    WebElement leaveFromDate;

    @FindBy(xpath = "(//i)[10]")
    WebElement leaveToDate;

    @FindBy(xpath = "(//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]")
    WebElement comments;

    @FindBy(xpath = "(//button[normalize-space()='Apply'])[1]")
    WebElement submitButton;

    @FindBy(xpath = "(//a[normalize-space()='My Leave'])[1]")
    WebElement myLeaveButton;

    @FindBy(xpath = "(//i)[9]")
    WebElement fromDate;

    @FindBy(xpath = "(//i)[10]")
    WebElement toDate;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement statusLeaveType;

    @FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@role='cell'])[7]")
    WebElement status;


    public void clickMenu() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonActions.clickingOnWebElement(leaveMenu,2);

    }

    public void clickApplyBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(applyButton,2);

    }

    public void enterLeaveDetails() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonActions.selectDropDownValue(leaveType,"index","2");
        CommonActions.clickingOnWebElement(leaveFromDate, 2);
        CommonActions.selectCalendar("14", "December", "2022");
        CommonActions.clickingOnWebElement(leaveToDate, 2);
        CommonActions.selectCalendar("20", "December", "2022");
        CommonActions.sendKeysWebElement(comments,"for health purpose");
    }

    public void clicksubmitBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(submitButton,2);

    }

    public void clickMyLeaveBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(myLeaveButton,2);

    }

    public void checkLeaveStatus() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonActions.clickingOnWebElement(fromDate, 2);
        CommonActions.selectCalendar("14", "December", "2022");
        CommonActions.clickingOnWebElement(toDate, 2);
        CommonActions.selectCalendar("20", "December", "2022");
        CommonActions.selectDropDownValue(statusLeaveType,"index","2");

    }

    public void clickSearchBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(searchButton,2);

    }

    public void verifyStatus() throws InterruptedException {
        status.getText();

    }
}
