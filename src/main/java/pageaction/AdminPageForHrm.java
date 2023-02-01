package pageaction;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

import java.time.Duration;

public class AdminPageForHrm {

    WebDriver driver;

    public AdminPageForHrm(WebDriver rDriver)
    {
        driver=rDriver;
    }


    @FindBy(xpath = "(//span[normalize-space()='Admin'])[1]")
    WebElement adminMenu;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement username;

    @FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    WebElement editButton;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement editUserRole;



    @FindBy(xpath = "(//button[normalize-space()='Apply'])[1]")
    WebElement submitButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement editEmployeeName;

    @FindBy(xpath = "//input[@autocomplete='off']")
    WebElement editUsername;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;


    public void clickMenu() throws InterruptedException {
        CommonActions.clickingOnWebElement(adminMenu,3);
    }

    public void enterSearchDetails() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonActions.sendKeysWebElement(username,"Anthony.Nolan");

    }

    public void clickOnSearchBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(searchButton,2);
    }

    public void clickOnEditBtn() throws InterruptedException {

        CommonActions.clickingOnWebElement(editButton,3);
    }

    public void editAdminDetails() throws InterruptedException {
        CommonActions.sendKeysWebElement(editEmployeeName,"Avinash Chavan");
        CommonActions.sendKeysWebElement(editUsername,"Avinash.Chavan");
    }

    public void clickOnSaveBtn() throws InterruptedException {
        CommonActions.clickingOnWebElement(saveButton,2);
    }
}
