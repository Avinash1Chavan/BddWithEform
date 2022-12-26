package pageaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonActions;

import java.io.IOException;

public class LoginForHrmPage   {
    WebDriver driver;
    @FindBy(css = "input[placeholder='Username']")
    WebElement uname;
    @FindBy(css = "input[placeholder='Password']")
    WebElement pword;
    @FindBy(css = "button[type='submit']")
    WebElement LogIn_Button;

    /* initializing the page objects */
    public LoginForHrmPage(WebDriver rDriver) {
        driver = rDriver;
    }

    public void  setLogindetail() throws IOException, InterruptedException {
        CommonActions.sendKeysWebElement(uname,"Admin");
        Thread.sleep(1000);
        CommonActions.sendKeysWebElement(pword,"admin123");
        CommonActions.clickingOnWebElement(LogIn_Button,1 );

    }

    public void  setLogindetailDb(String username, String password) throws IOException, InterruptedException {
        CommonActions.sendKeysWebElement(uname, username);
        CommonActions.sendKeysWebElement(pword,password);
        CommonActions.clickingOnWebElement(LogIn_Button,1 );

    }

}


