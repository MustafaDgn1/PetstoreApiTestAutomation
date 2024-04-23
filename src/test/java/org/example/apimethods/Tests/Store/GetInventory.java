package org.example.apimethods.Tests.Store;
import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.apimethods.BaseUrl.BaseUrlPetstore;
import static io.restassured.RestAssured.given;

public class GetInventory extends BaseUrlPetstore {
    @Step("Get Inventory")
    public void getInventory() {
        specPetstore.pathParams("pp1", "store", "pp2", "inventory");

        Response response = given().spec(specPetstore).contentType(ContentType.JSON)
                .when()
                .get("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
