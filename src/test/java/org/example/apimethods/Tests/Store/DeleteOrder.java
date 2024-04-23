package org.example.apimethods.Tests.Store;

import com.thoughtworks.gauge.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.example.apimethods.TestData.TestDataStore;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteOrder extends BaseUrlPetstore {
    @Step("Delete Order")
    public void deleteOrder () {
        specPetstore.pathParams("pp1","store","pp2","order","pp3",CreateOrder.id);

        Response response = given().spec(specPetstore)
                .when()
                .delete("/{pp1}/{pp2}/{pp3}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(200, responseJsonpath.getInt("code"));
        assertEquals(Integer.toString(CreateOrder.id), responseJsonpath.getString("message"));

    }
}
