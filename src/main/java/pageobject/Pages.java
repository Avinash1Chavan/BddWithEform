package pageobject;

import factory.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import pageaction.AdditionSoftwarePage;
import pageaction.LoginForEform;
import pageaction.PrivilegeFormPage;
import pageaction.ViewStatusPg;

public class Pages {


    /* dependency injection using picocontainer */
    private <T> T load(Class<T> pageClass) {
        return PageFactory.initElements(DriverFactory.getDriver(), pageClass);
    }

    public AdditionSoftwarePage additionSoftwarePage() {
        return load(AdditionSoftwarePage.class);
    }

    public LoginForEform loginForEform() {
        return load(LoginForEform.class);
    }

    public PrivilegeFormPage privilegeFormPage() {
        return load(PrivilegeFormPage.class);
    }

    public ViewStatusPg viewStatusPg() {
        return load(ViewStatusPg.class);
    }
}
