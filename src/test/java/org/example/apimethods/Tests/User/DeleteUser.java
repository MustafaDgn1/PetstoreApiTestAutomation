package org.example.apimethods.Tests.User;

import com.thoughtworks.gauge.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteUser extends BaseUrlPetstore {
    @Step("Delete User")
    public void deleteUser () {
        specPetstore.pathParams("pp1","user","pp2",CreateUser.userName);

        Response response = given().spec(specPetstore)
                .when()
                .delete("/{pp1}/{pp2}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(200, responseJsonpath.getInt("code"));
        assertEquals(CreateUser.userName,responseJsonpath.getString("message"));

    }
}
