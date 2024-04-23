package org.example.apimethods.Tests.Pet;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdatePet extends BaseUrlPetstore {
    @Step("Update Pet")
    public void updatePet() {
        specPetstore.pathParams("pp1", "pet");

        JSONObject requestUpdatePetBody = TestDataPet.PetUpdateRequestBody();


        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when().body(requestUpdatePetBody.toString())
                .put("/{pp1}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataPet.PetUpdateRequestBody().getString("name"), responseJsonpath.getString("name"));
        assertEquals(TestDataPet.PetUpdateRequestBody().getString("status"), responseJsonpath.getString("status"));
        assertEquals(TestDataPet.PetUpdateRequestBody().getJSONObject("category").getString("name"), responseJsonpath.getString("category.name"));

    }
}
