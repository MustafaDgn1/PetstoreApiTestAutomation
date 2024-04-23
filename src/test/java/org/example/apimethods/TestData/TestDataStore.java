package org.example.apimethods.TestData;

import org.json.JSONObject;

public class TestDataStore {
    public static JSONObject StoreRequestBody() {

        JSONObject storeInfo = new JSONObject();
        storeInfo.put("id", 8);
        storeInfo.put("petId", 40);
        storeInfo.put("quantity", 50);
        storeInfo.put("shipDate", "2024-04-24");
        storeInfo.put("status", "placed");
        storeInfo.put("complete", true);

        return storeInfo;
    }
}
