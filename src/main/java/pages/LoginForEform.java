package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

public class LoginForEform extends CommonActions {

    /* it's finding username text box element in eform Application */
    @FindBy(xpath = "//input[@id='userName']")
    WebElement uname;
    /* it's finding password text box element in eform Application */
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement Pass_word;
    /* it's finding Log in button element in eform Application */
    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    WebElement submit;
    /* it is used to close the pop-up in eform Application */
    @FindBy(xpath = "//div[@class='modal-footer border-top-0']/child::button[1]")
    WebElement closeform;

    WebDriver driver;

    public LoginForEform(WebDriver rDriver)
    {
        driver=rDriver;

        PageFactory.initElements(rDriver, this);
    }

    /* This method is used to fill the credential  */
    public void log_In(String name, String password_name) throws InterruptedException {
        sendKeysWebElement(uname, name);
        Thread.sleep(1000);
        sendKeysWebElement(Pass_word, password_name);
    }

    /* This method is used for click on log in button close pop up window */
    public void logInAndClosePopUp() {
        clickingOnWebElement(submit, 3);
        clickingOnWebElement(closeform, 3);
    }


}