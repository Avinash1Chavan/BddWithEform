package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//run class with testNg
@RunWith(Cucumber.class)
@CucumberOptions(
<<<<<<< HEAD
        features = {"src/test/resources/features/EndToEndEcommerce.feature"},
        glue = {"stepdefinations"},
=======
        //features = {"src/test/resources/features"},
        features = {"src/test/resources/features/HrmPim.feature"},
        //features = {"src/test/resources/features/Snapdeal.feature"},
        //features = {"src/test/resources/features/eformstatus.feature"},

        //features = {"src/test/resources/features/eformrequest.feature"},

        glue = {"apphooks", "stepdefinations"},
>>>>>>> 117b99956c06877af29f0e6b17142ab03aa9cd08
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
/*This class is used to achieve parallel execution */
public class Runner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
