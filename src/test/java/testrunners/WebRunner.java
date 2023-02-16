package testrunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//run class with testNg
@RunWith(Cucumber.class)
@CucumberOptions(
        /* This feature and glue is for execution of Web Application */
        features = {"src/test/resources/WebFeatures"},
        glue = {"apphooks","stepdefinations"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        //tags = "@Common"

)
/*This class is used to achieve parallel execution */
public class WebRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
