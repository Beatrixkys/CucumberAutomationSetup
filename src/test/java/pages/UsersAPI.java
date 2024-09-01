package pages;


import java.util.Map;

import configs.APIConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIHandler; 


public class UsersAPI {

    public boolean responseContainsUserWithStreetAndCity(String expectedStreet, String expectedCity) {
        Response response = APIHandler.response; 
        Map<?, ?> address = response.jsonPath().getMap("address");
        String street = (String) address.get("street");
        String city = (String) address.get("city");
        return expectedStreet.equals(street) && expectedCity.equals(city);
    }
}
