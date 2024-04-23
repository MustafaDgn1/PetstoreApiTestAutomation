package org.example.apimethods.Tests.Pet;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPet extends BaseUrlPetstore {
    @Step("Get Pet")
    public void getPet() {
        specPetstore.pathParams("pp1", "pet", "pp2", CreatePet.id);

        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when()
                .get("/{pp1}/{pp2}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataPet.PetRequestBody().getString("name"), responseJsonpath.getString("name"));
        assertEquals(TestDataPet.PetRequestBody().getString("status"), responseJsonpath.getString("status"));
        assertEquals(TestDataPet.PetRequestBody().getJSONObject("category").getString("name"), responseJsonpath.getString("category.name"));

    }
}
