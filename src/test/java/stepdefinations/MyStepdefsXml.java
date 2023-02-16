package stepdefinations;

import API_Resources.APIResources;
import API_Resources.util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.formula.functions.T;
import pojo.LoginForEcommerceXmlBind;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class MyStepdefsXml extends util {
    RequestSpecification request;
    Response response;
    LoginForEcommerceXmlBind login;
    static String token;
    static String userId;
    static String productId;
    static String orderNumber;

    @Override
    public RequestSpecification requestSpecificationForXML() throws IOException {
        return super.requestSpecificationForXML();
    }
    @Given("Body payload  with the credentials {string} and {string}")
    public void bodyPayloadWithTheCredentialsAnd(String userEmail, String userPassword) throws IOException, JAXBException {
        login = new LoginForEcommerceXmlBind(userEmail,userPassword);
        String marshal = marshal(login);
        System.out.println(userEmail+"->"+userPassword);
        //String xmlPayload = GenerateStringFromResource("C:\\Users\\SK66921\\Documents\\Git\\BddWithEform\\convertjson.xml");
        request = given().urlEncodingEnabled(false).spec(requestSpecificationForXML())
                .body(marshal);
    }

    @When("user calls the required resource {string} with {string} method")
    public void userCallsTheRequiredResourceWithMethod(String resource, String methodName) {
        System.out.println(APIResources.valueOf(resource).getResource() + "->" + methodName);
        if (methodName.equalsIgnoreCase("POST")) {
            response = request.when().post(APIResources.valueOf(resource).getResource());
        } else if (methodName.equalsIgnoreCase("GET")) {
            response = request.when().get(APIResources.valueOf(resource).getResource());
        } else {
            response = request.when().delete(APIResources.valueOf(resource).getResource());
        }
    }

    @Then("the API call will be success with status code {int}")
    public void theAPICallWillBeSuccessWithStatusCode(int statusCode) throws JAXBException {
        LoginForEcommerceXmlBind loginResponse = unmarshal1(LoginForEcommerceXmlBind.class, response.asString());
       // assertEquals(response.getStatusCode(), statusCode);
        assertEquals(loginResponse.getUserEmail(), equalTo(login.getUserEmail()));
        assertEquals(loginResponse.getUserPassword(), equalTo(login.getUserPassword()));
    }

    @Given("The authorization token is fetched with the given data {string}, {string}, {string}, {string},{string},{string}")
    public void theAuthorizationTokenIsFetchedWithTheGivenData(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {

    }

    @Then("the API call will be pass successfully with status code {int}")
    public void theAPICallWillBePassSuccessfullyWithStatusCode(int arg0) {

    }

    @And("The {string} will be rendered as the {string}")
    public void theWillBeRenderedAsThe(String arg0, String arg1) {

    }

    @Given("sending the placing order payload in xml with required properties")
    public void sendingThePlacingOrderPayloadInXmlWithRequiredProperties() {

    }

    @And("the orderNumber will be fetched")
    public void theOrderNumberWillBeFetched() {

    }

    @Given("Fetching the order details by sending orderNumber as the query parameter")
    public void fetchingTheOrderDetailsBySendingOrderNumberAsTheQueryParameter() {

    }

    @And("The message will displayed as {string}")
    public void theMessageWillDisplayedAs(String arg0) {

    }

    @Given("Fetching the productId that to be delete")
    public void fetchingTheProductIdThatToBeDelete() {

    }

    @And("The {string} should be {string}")
    public void theShouldBe(String arg0, String arg1) {
    }
}
