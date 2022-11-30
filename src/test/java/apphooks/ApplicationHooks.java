package apphooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.CommonActions;
import utils.ConfigReader;

import java.util.Properties;

public class ApplicationHooks extends CommonActions {
    public ConfigReader configReader;
    Properties prop;
    private DriverFactory driverFactory;
    //private WebDriver driver;

    /* This method is used for load the property */
    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    /* This method is used for launching browser */
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driverFactory.init_driver(browserName);

    }

    /* This method is used for closing browser */
    @After(order = 0)
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
    }

    /* This method is used for taking screenshot */
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}
