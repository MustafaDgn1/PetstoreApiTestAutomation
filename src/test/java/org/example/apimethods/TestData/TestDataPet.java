package org.example.apimethods.TestData;

import org.example.apimethods.Tests.Pet.CreatePet;
import org.json.JSONObject;

public class TestDataPet {

    public static int successfulQueryStatusCode = 200;

    public static JSONObject PetRequestBody() {
        JSONObject doggieInfo = new JSONObject();
        doggieInfo.put("id", 0);

        JSONObject category = new JSONObject();
        category.put("id", 0);
        category.put("name", "Coni");
        doggieInfo.put("category", category);

        doggieInfo.put("name", "cat");

        String[] photoUrls = {"string"};
        doggieInfo.put("photoUrls", photoUrls);

        JSONObject[] tags = {new JSONObject().put("id", 0).put("name", "string")};
        doggieInfo.put("tags", tags);

        doggieInfo.put("status", "available");

        return doggieInfo;
    }

    public static JSONObject PetUpdateRequestBody() {
        JSONObject doggieInfo = new JSONObject();
        doggieInfo.put("id", CreatePet.id);

        JSONObject category = new JSONObject();
        category.put("id", 0);
        category.put("name", "Karabas");
        doggieInfo.put("category", category);

        doggieInfo.put("name", "doggie");

        String[] photoUrls = {"string"};
        doggieInfo.put("photoUrls", photoUrls);

        JSONObject[] tags = {new JSONObject().put("id", 0).put("name", "string")};
        doggieInfo.put("tags", tags);

        doggieInfo.put("status", "available");

        return doggieInfo;
    }
}
