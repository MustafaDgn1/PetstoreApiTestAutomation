package org.example.apimethods.BaseUrl;

import com.thoughtworks.gauge.BeforeStep;
import io.restassured.specification.RequestSpecification;

public class BaseUrlPetstore {

    protected static RequestSpecification specPetstore;

    @BeforeStep
    public void setUp () {
        specPetstore = BaseUrlFactory.setUp();

    }
}
