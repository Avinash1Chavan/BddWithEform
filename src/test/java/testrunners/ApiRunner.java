package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//run class with testNg
@RunWith(Cucumber.class)
@CucumberOptions(
        /* This feature and glue is for execution of API */
        features = {"src/test/resources/ApiFeatures"},
        glue = {"stepdefinations"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@LoginForEcommerceXml"
)
/*This class is used to achieve parallel execution */
public class ApiRunner extends AbstractTestNGCucumberTests {

}
