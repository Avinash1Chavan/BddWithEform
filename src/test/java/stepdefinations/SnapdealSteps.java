package stepdefinations;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import pageobject.Pages;
import utils.CommonActions;

import java.util.concurrent.TimeUnit;

public class SnapdealSteps {
    Logger log = Logger.getLogger(SnapdealSteps.class);
    public SnapdealSteps(Pages page) {
        this.page = page;
    }
    private Pages page;



    @Given ("user navigates to Snapdeal Application")
    public void user_Navigates_To_Website_Snapdeal() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("https://www.snapdeal.com/");
        log.info("successfully launched snapdeal ecommerce application");
    }

    @When("user enter product name on search field")
    public void userSearchWithProduct() throws InterruptedException {
        page.SnapdealScenarios().enterItemInSearch().sendKeys("Bluetooth Headphone");
        page.SnapdealScenarios().ClickSearchButton();
        log.info("successfully searched with Bluetooth Headphone on search field");
    }

    @And("User verified search result")
    public void userVerifySearchResult() throws InterruptedException {
        String actualString = page.SnapdealScenarios().VerifysearchCriteria().getText();
        System.out.println(actualString);
        Assert.assertTrue(actualString.contains("We've got"));
        log.info("successfully verified search result");
    }

    @Then("User Select Sorted with Popularity")
    public void userSelectPopularity() throws InterruptedException {
        page.SnapdealScenarios().ClickonSortby();
        Thread.sleep(2000);
        page.SnapdealScenarios().clickpopularity();
        log.info("successfully Sorted with Popularity");
    }

    @And ("Selected Range 700 to 3000")
    public void userSelectRange() throws InterruptedException {
        page.SnapdealScenarios().clickFristPriceRange();
        Thread.sleep(2000);
        page.SnapdealScenarios().clickLastPriceRange();
        Thread.sleep(2000);
        page.SnapdealScenarios().clickonGOButton();
        log.info("successfully Selected Range 700 to 3000");
        Thread.sleep(5000);
    }

    @Then("user clicked on First Item")
    public void userclickFirstItem() throws InterruptedException {
        page.SnapdealScenarios().clickOnFristIteam();
        log.info("successfully clicked frist item");
    }


    @Then ("moved to another tab")
    public void userMovedToAnotherTab() throws Exception {
        CommonActions.windowHandler();
        log.info("successfully moved to another tab");
    }

    @And ("clicked the AddToCart button")
    public void userClickAddCart() throws InterruptedException {
        page.SnapdealScenarios().SelectAddtoCart();
        log.info("successfully clicked the AddToCart");
        page.SnapdealScenarios().clickonviewCart();
        Thread.sleep(2000);
    }

    @And ("verified remove cart item")
    public void userVerifyRemoveItem() throws InterruptedException {
        page.SnapdealScenarios().clickRemoveCart();
        Thread.sleep(2000);
        String verifedremovecart = page.SnapdealScenarios().verifyremoveCart().getText();
        System.out.println(verifedremovecart);
        Assert.assertEquals(verifedremovecart, "Shopping Cart is empty!");
        log.info("successfully verified remove cart item");
    }


}
