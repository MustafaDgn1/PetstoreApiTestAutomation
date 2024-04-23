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

public class CreatePet extends BaseUrlPetstore {

    public static String id;

    @Step("Create Pet")
    public void createPet() {
        specPetstore.pathParams("pp1", "pet");

        JSONObject requestOrderBody = TestDataPet.PetRequestBody();


        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when().body(requestOrderBody.toString())
                .post("/{pp1}");

        JsonPath responseJsonpath = response.jsonPath();
        id = responseJsonpath.getString("id");

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataPet.PetRequestBody().getString("name"), responseJsonpath.getString("name"));
        assertEquals(TestDataPet.PetRequestBody().getString("status"), responseJsonpath.getString("status"));
        assertEquals(TestDataPet.PetRequestBody().getJSONObject("category").getString("name"), responseJsonpath.getString("category.name"));
    }

}
