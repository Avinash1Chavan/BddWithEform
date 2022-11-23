package pages;

import factory.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

import java.util.concurrent.TimeUnit;

public class ViewStatusPg extends CommonActions {

    /* it's finding menu element in eform Application */
    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
    WebElement menu;
    /* it's finding view status option element in eform Application */
    @FindBy(xpath = "//a[@id='AdminReportsComponent']")
    WebElement ViewStatusBtn;
    /* it's finding eform text box element in eform Application */
    @FindBy(xpath = "/html/body/app-root/app-admin-reports/div/div/div/div/div[2]/div/input")
    WebElement eform;
    @FindBy(xpath = "//button[@id='btn']")
    WebElement downArrow;
    @FindBy(xpath = "//div[@class='card-body']//div[1]//div[3]//b[1]")
    WebElement VerifyApprovedStatus;
    /* it's finding submit button element in eform Application */
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtn;

    WebDriver driver;

    public ViewStatusPg(WebDriver rDriver)
    {
        driver=rDriver;

        PageFactory.initElements(rDriver, this);
    }

    /* This method is used for click on menu button */
    public void Clickmenu() throws InterruptedException {
        Thread.sleep(3000);
        clickingOnWebElement(menu, 3);
    }

    /* This method is used to select view status  */
    public void ClickViewStatusBtn() throws InterruptedException {

        clickingOnWebElement(ViewStatusBtn, 3);
    }

    /* This method is used for enter the eform number in text box */
    public void EnterEformNO() throws InterruptedException {
        eform.sendKeys("325582");
    }

    /* This method is used for click submit button*/
    public void ClickSubmitBtn() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        clickingOnWebElement(submitBtn, 3);
        clickingOnWebElement(downArrow, 3);
    }

    public void VerifyStatus() {
        String verifyViewStatus = VerifyApprovedStatus.getText();
        System.out.println(verifyViewStatus);
        if (verifyViewStatus.equals("Approved on")) {
            System.out.println("Eform status :" + "EForm request is Approved");
        } else {
            System.out.println("Eform status :" + "EForm request is not yet Approved");
        }
    }
}
