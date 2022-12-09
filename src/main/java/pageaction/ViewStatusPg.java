package pageaction;

import factory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

import java.util.concurrent.TimeUnit;

public class ViewStatusPg {

    Logger log = Logger.getLogger(ViewStatusPg.class);

    WebDriver driver;

    /* initializing the page objects */
    public ViewStatusPg(WebDriver rDriver) {
        driver = rDriver;
    }

    /* it's finding menu element in eform Application */
    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;

    /* it's finding view status option element in eform Application */
    @FindBy(xpath = "//a[@id='AdminReportsComponent']")
    WebElement ViewStatusBtn;

    /* it's finding eform text box element in eform Application */
    @FindBy(xpath = "/html/body/app-root/app-admin-reports/div/div/div/div/div[2]/div/input")
    WebElement eform;

    /* it's finding down arrow button element in eform Application */
    @FindBy(xpath = "//button[@id='btn']")
    WebElement downArrow;

    /* it's finding verify text element in eform Application */
    @FindBy(xpath = "//div[@class='card-body']//div[1]//div[3]//b[1]")
    WebElement VerifyApprovedStatus;

    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtn;


    /* This method is used for click on menu button */
    public void Clickmenu() {
        CommonActions.clickingOnWebElement(menu, 3);
    }

    /* This method is used to select view status  */
    public void ClickViewStatusBtn() {

        CommonActions.clickingOnWebElement(ViewStatusBtn, 3);
    }

    /* This method is used for enter the eform number in text box */
    public void EnterEformNO() {
        eform.sendKeys("325582");
    }

    /* This method is used for click submit button*/
    public void ClickSubmitBtn() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CommonActions.clickingOnWebElement(submitBtn, 3);
        CommonActions.clickingOnWebElement(downArrow, 3);
    }

    public void VerifyStatus() {
        String verifyViewStatus = VerifyApprovedStatus.getText();
        log.info(verifyViewStatus);
        if (verifyViewStatus.equals("Approved on")) {
            log.info("Eform status :" + "EForm request is Approved");
        } else {
            log.info("Eform status :" + "EForm request is not yet Approved");
        }
    }
}
