package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForOrangeHrm {
    WebDriver driver;

    public LoginForOrangeHrm(WebDriver rDriver)
    {
        driver=rDriver;
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;

    @FindBy(xpath="//input[@name='password']")
    WebElement pass_text;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginBtn;


//    @FindBy(linkText = "Logout")
//    WebElement logout;


    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd){
        pass_text.sendKeys(pwd);
    }



    public void clickOnLoginButton()
    {
        LoginBtn.click();
    }
}
