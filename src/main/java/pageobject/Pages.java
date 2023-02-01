package pageobject;

import factory.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import pageaction.*;

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

    public InfrastructureRequestPage infrastructureRequestPage(){return load(InfrastructureRequestPage.class);}

    public LinkRequestPage linkRequestPage() {
        return load(LinkRequestPage.class);
    }
    public LoginForOrangeHrm loginForOrangeHrm() {
        return load(LoginForOrangeHrm.class);
    }
    public AdminPageForHrm adminPageForHrm() {return load(AdminPageForHrm.class);}
    public LeavePageForHrm leavePageForHrm() {return load(LeavePageForHrm.class);}

}
