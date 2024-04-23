package org.example.apimethods.Tests.User;

import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import org.example.apimethods.TestData.TestDataPet;
import org.example.apimethods.TestData.TestDataUser;
import org.example.apimethods.Tests.Store.CreateOrder;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetUser extends BaseUrlPetstore {

    @Step("Get User")
    public void getUser() {
        specPetstore.pathParams("pp1", "user", "pp2", CreateUser.userName);

        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when()
                .get("/{pp1}/{pp2}");

        JsonPath responseJsonpath = response.jsonPath();

        assertEquals(TestDataPet.successfulQueryStatusCode, response.statusCode());
        assertEquals(TestDataUser.UserRequestBody().getString("username"), responseJsonpath.getString("username"));
        assertEquals(TestDataUser.UserRequestBody().getString("firstName"), responseJsonpath.getString("firstName"));
        assertEquals(TestDataUser.UserRequestBody().getString("lastName"), responseJsonpath.getString("lastName"));
        assertEquals(TestDataUser.UserRequestBody().getString("email"), responseJsonpath.getString("email"));
        assertEquals(TestDataUser.UserRequestBody().getString("password"), responseJsonpath.getString("password"));
        assertEquals(TestDataUser.UserRequestBody().getString("phone"), responseJsonpath.getString("phone"));
        assertEquals(TestDataUser.UserRequestBody().getInt("userStatus"), responseJsonpath.getInt("userStatus"));
    }
}
