package pages;

import utils.CommonActions;

public class PrivilegeFormPage extends CommonActions {


//    /*initializing the page objects*/
//    public EformDetails() {
//        PageFactory.initElements(driver, this);
//    }
//
//    /* it's finding menu element in eform Application */
//    @FindBy(xpath = "//div[@class='noti__item js-item-menu']//img")
//    WebElement menu;
//
//    /* it's finding request type element in eform Application */
//    @FindBy(xpath = "//a[@id='PrivilegeRequestFormComponent']")
//    WebElement type;
//
//    /* it's finding project name element in eform Application */
//    @FindBy(xpath = "//select[@id='projectName']")
//    WebElement projectname;
//
//    /* it's finding asset type element in eform Application */
//    @FindBy(xpath = "//select[@id='assetType']")
//    WebElement assetType;
//
//    /* it's finding asset number element in eform Application */
//    @FindBy(xpath = "//select[@id='assetNumber']")
//    WebElement assetNumber;
//
//    /* it's finding asset number element in eform Application */
//    @FindBy(xpath = "//input[@id='assetno']")
//    WebElement assetNo;
//
//    /* it's finding extension number element in eform Application */
//    @FindBy(xpath = "//input[@id='extension']")
//    WebElement extensionNumber;
//
//    /* it's finding location element in eform Application */
//    @FindBy(xpath = "//select[@id='location']")
//    WebElement location;
//
//    /* it's finding desk number element in eform Application */
//    @FindBy(xpath = "//input[@id='deskNumber']")
//    WebElement deskNumber;
//
//    /* it's finding required date element in eform Application */
//    @FindBy(xpath = "//input[@id='requiredDate']")
//    WebElement requiredDate;
//
//    /* it's finding revoke date element in eform Application */
//    @FindBy(xpath = "//input[@id='revokeDate']")
//    WebElement revokeDate;
//
//    /* it's finding hostname element in eform Application */
//    @FindBy(xpath = "//input[@id='hostName']")
//    WebElement hostname;
//
//    /* it's finding remark element in eform Application */
//    @FindBy(xpath = "//textarea[@id='remarks']")
//    WebElement remark;
//
//    /* it's finding checkbox element in eform Application */
//    @FindBy(xpath = "//input[@id='iAccept']")
//    WebElement checkbox;
//
//    /* it's finding submit button element in eform Application */
//    @FindBy(xpath = "//button[normalize-space()='Submit eForm']")
//    WebElement submitbtn;
//
//    /* This method is used to click menu and select request type */
//    public void clickOnMenu() {
//        clickingOnWebElement(menu, 2);
//        clickingOnWebElement(type, 2);
//    }
//
//    /* This method is used to select respective project name  */
//    public void selectProjectName() throws InterruptedException, IOException, ParseException {
//        String projectName = "";
//        String AssetType = "";
//        String AssetNumber ="";
//        String AssetNo ="";
//        String ScrollDown ="";
//        String ExtensionNumber ="";
//        String Location ="";
//        String DeskNumber ="";
//        String Hostname ="";
//        String Remark ="";
//
//        JSONArray usersList= JsonRead.JsonRead(System.getProperty("user.dir") + "/src/main/java/utils/Data.json");
//        System.out.println("Users List-> " + usersList); //This prints the entire json file
//        for (int i = 0; i < usersList.size(); i++) {
//            JSONObject users = (JSONObject) usersList.get(i);
//            System.out.println("Users -> " + users);//This prints every block - one json object
//            JSONObject user = (JSONObject) users.get("users");
//            System.out.println("User -> " + user); //This prints each data in the block
//            projectName = (String) user.get("project");
//            AssetType = (String) user.get("assettype");
//            AssetNumber = (String) user.get("assetnumber");
//            AssetNo = (String) user.get("assetno");
//            ScrollDown = (String) user.get("scrolldown");
//            ExtensionNumber = (String) user.get("extensionnumber");
//            Location = (String) user.get("location");
//            DeskNumber = (String) user.get("desknumber");
//            Hostname = (String) user.get("hostname");
//            Remark = (String) user.get("remark");
//
//
//        }
//        Thread.sleep(3000);
//        selectDropDownValue(projectname, "value", projectName);
//        Thread.sleep(3000);
//        selectDropDownValue(assetType, "value", AssetType);
//        Thread.sleep(3000);
//        selectDropDownValue(assetNumber, "value", AssetNumber);
//        sendKeysWebElement(assetNo, AssetNo);
//        sendKeysWebElement(extensionNumber, ExtensionNumber);
//        scrollDown(ScrollDown);
//        Thread.sleep(3000);
//        selectDropDownValue(location, "value", Location);
//        Thread.sleep(3000);
//        sendKeysWebElement(deskNumber, DeskNumber);
//        Thread.sleep(3000);
//        sendKeysWebElement(hostname, Hostname);
//        Thread.sleep(3000);
//        sendKeysWebElement(remark, Remark);
//        Thread.sleep(3000);
//        scrollDown(ScrollDown);
//    }
//
//    /* This method is used to accept the terms and conditions before submitting request */
//    public void clickOnCheckBox() {
//        clickingOnWebElement(checkbox, 2);
//    }
//
//    /* This method is used to click on submit button */
//    public void clickOnSubmitbtn() {
//        clickingOnWebElement(submitbtn, 2);
//    }

}
