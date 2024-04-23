package org.example.apimethods.BaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseUrlFactory {
    static RequestSpecification specPetstore;

    public static RequestSpecification  setUp () {
        specPetstore = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/")
                .build();
        return specPetstore;

    }
}
