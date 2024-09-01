package utils; 

import configs.APIConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIHandler {
    public String endpointPath;
    public static Response response;
    public String requestBody;
    public APIConfig baseAPI = new APIConfig(); 

    public APIHandler() {
        // Set the base URL in RestAssured
        RestAssured.baseURI = baseAPI.BASE_URL;
        System.out.println(RestAssured.baseURI);
    }

    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public void sendGetRequest() {
        response = RestAssured.get(endpointPath);
    }

    public void sendPostRequest() {
        response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .post(endpointPath);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody().asString();
    }


}
