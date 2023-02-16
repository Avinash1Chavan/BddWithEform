package pageaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonActions;
import java.util.List;

import static utils.CommonActions.clickingOnWebElement;
import static utils.CommonActions.sendKeysAndClearClick;

public class SnapdealScenarios  {
    WebDriver driver;
    @FindBy(xpath = "//div[@id='add-cart-button-id123']") //failed one
    WebElement clickAddtoCart;

    @FindBy(xpath = "//div[@class='remove-item-div']")
    WebElement removeCart;


    @FindBy(xpath = "//div[@class='empty-cart-wrapper']/div[1]/h3")
    WebElement VerifyRemoveCart;

    @FindBy(xpath = "//p[@class='product-title']")
    List<WebElement> Saveitemname;

    @FindBy(xpath = "//span[@class='lfloat product-price']")
    List<WebElement> Saveitemprice;

    @FindBy(css = "input#inputValEnter.col-xs-20.searchformInput.keyword")
    WebElement itemSearch;

    @FindBy(css = "span.searchTextSpan")
    WebElement SearchButton;

    @FindBy(xpath = "//p[@class='product-title']")
    List<WebElement> Item;

    @FindBy(xpath = "//input[@name='fromVal']")
    WebElement clickFristPrice;

    @FindBy(xpath = "//input[@name='toVal']")
    WebElement clickLastPrice;

    @FindBy(xpath = "//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")
    WebElement clickGoButton;

    @FindBy(xpath = "//div[@class='sorting-sec animBounce']/div[@class='sort-drop clearfix']")
    WebElement clickSortby;

    @FindBy(xpath = "//div[@class='sorting-sec animBounce']/ul[@style='z-index: 17;']/li[@data-sorttype='plrty']")
    WebElement popularity;

    @FindBy(xpath = "//div[@class='col-xs-15 btn-container']/div")
    WebElement clickViewCart;

    @FindBy(xpath = "//div[@class='cart-heading clearfix']/h3")
    WebElement VerifyShoppingCart;

    @FindBy(xpath = "//div[@class='search-result-txt-section  marT12']/span[@style='color: #212121; font-weight: normal']")
    WebElement SearchResult;


    /* initializing the page objects */
    public SnapdealScenarios(WebDriver rDriver) {
        driver = rDriver;
    }

    public void SelectAddtoCart() {
        clickingOnWebElement(clickAddtoCart, 2);
    }

    public void clickRemoveCart() {
        clickingOnWebElement(removeCart, 2);
    }

    public WebElement verifyremoveCart() {
        return VerifyRemoveCart;
    }

    public List<WebElement> getitemname() {
        return Saveitemname;
    }

    public List<WebElement> getitemprice() {
        return Saveitemprice;
    }



    public WebElement enterItemInSearch() {
        return itemSearch;
    }

    public void ClickSearchButton() {
        clickingOnWebElement(SearchButton, 5);
    }

    public void clickOnFristIteam() {
        List<WebElement> ClickFristItem = Item;
        for (int i = 1; i <= 1; i++) {
            ClickFristItem.get(i).click();
        }
    }

    public void clickFristPriceRange() {
        sendKeysAndClearClick(clickFristPrice, "700");
    }

    public void clickLastPriceRange() {
        sendKeysAndClearClick(clickLastPrice, "3000");
    }

    public void clickonGOButton() {
        clickingOnWebElement(clickGoButton, 2);
    }

    public void ClickonSortby() {
        clickingOnWebElement(clickSortby, 5);
    }

    public void clickpopularity() {
        clickingOnWebElement(popularity, 5);
    }

    public void clickonviewCart() {
        clickingOnWebElement(clickViewCart, 8);
    }

    public WebElement ChecktheAddCartIteamRnot() {
        return VerifyShoppingCart;
    }

    public WebElement VerifysearchCriteria() {
        return SearchResult;
    }

}

