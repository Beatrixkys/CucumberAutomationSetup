package steps;

import static org.junit.Assert.assertEquals;

import configs.APIConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.APIHandler;

public class GenericSteps {
    
    private APIHandler apiHandler = new APIHandler();
    
    @Given("the API endpoint is {string}")
    public void the_api_endpoint_is(String endpoint) {
        apiHandler.setEndpointPath(APIConfig.BASE_URL + endpoint);
    }

    @Given("the request body is:")
    public void the_request_body_is(String requestBody) {
        apiHandler.setRequestBody(requestBody);
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        apiHandler.sendGetRequest();
    }

    @When("I send a POST request")
    public void i_send_a_post_request() {
        apiHandler.sendPostRequest();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertEquals(statusCode, apiHandler.getStatusCode());
    }
}
