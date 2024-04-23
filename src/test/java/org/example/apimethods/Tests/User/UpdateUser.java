package org.example.apimethods.Tests.User;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.example.apimethods.TestData.TestDataUser;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdateUser extends BaseUrlPetstore {

    @Step("Update User")
    public void updateDraft () {
        specPetstore.pathParams("pp1","user","pp2",CreateUser.userName);

        JSONObject requestUpdateUserBody = TestDataUser.UserUpdateRequestBody();



        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when().body(requestUpdateUserBody.toString())
                .put("/{pp1}/{pp2}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(200, responseJsonpath.getInt("code"));

    }
}
