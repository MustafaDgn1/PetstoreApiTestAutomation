package org.example.apimethods.Tests.Store;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.example.apimethods.TestData.TestDataStore;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetOrder extends BaseUrlPetstore {
    @Step("Get Order")
    public void getOrder() {
        specPetstore.pathParams("pp1", "store", "pp2", "order","pp3",CreateOrder.id);

        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when()
                .get("/{pp1}/{pp2}/{pp3}");


        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataStore.StoreRequestBody().getInt("id"), responseJsonpath.getInt("id"));
        assertEquals(TestDataStore.StoreRequestBody().getInt("petId"), responseJsonpath.getInt("petId"));
        assertEquals(TestDataStore.StoreRequestBody().getInt("quantity"), responseJsonpath.getInt("quantity"));
        assertEquals(TestDataStore.StoreRequestBody().getString("status"), responseJsonpath.getString("status"));
        assertEquals(TestDataStore.StoreRequestBody().getBoolean("complete"), responseJsonpath.getBoolean("complete"));
    }
}
