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

public class CreateUser extends BaseUrlPetstore {

    public static String userName;

    @Step("Create User")
    public void createUser() {
        specPetstore.pathParams("pp1", "user");

        JSONObject requestUserBody = TestDataUser.UserRequestBody();
        userName = requestUserBody.getString("username");


        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when().body(requestUserBody.toString())
                .post("/{pp1}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(200, responseJsonpath.getInt("code"));
    }
}
