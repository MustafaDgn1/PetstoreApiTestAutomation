package org.example.apimethods.Tests.Store;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.example.apimethods.TestData.TestDataStore;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class CreateOrder extends BaseUrlPetstore {

    public static int id;

    @Step("Create Order")
    public void createOrder() {
        specPetstore.pathParams("pp1", "store", "pp2", "order");

        JSONObject requestOrderBody = TestDataStore.StoreRequestBody();
        id = requestOrderBody.getInt("id");


        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when().body(requestOrderBody.toString())
                .post("/{pp1}/{pp2}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataStore.StoreRequestBody().getInt("id"), responseJsonpath.getInt("id"));
        assertEquals(TestDataStore.StoreRequestBody().getInt("petId"), responseJsonpath.getInt("petId"));
        assertEquals(TestDataStore.StoreRequestBody().getInt("quantity"), responseJsonpath.getInt("quantity"));
        assertEquals(TestDataStore.StoreRequestBody().getString("status"), responseJsonpath.getString("status"));
        assertEquals(TestDataStore.StoreRequestBody().getBoolean("complete"), responseJsonpath.getBoolean("complete"));
    }
}
