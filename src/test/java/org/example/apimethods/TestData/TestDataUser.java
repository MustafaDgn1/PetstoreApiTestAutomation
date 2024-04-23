package org.example.apimethods.TestData;


import org.json.JSONObject;

public class TestDataUser {

    public static JSONObject UserRequestBody() {

        JSONObject userInfo = new JSONObject();
        userInfo.put("id", 0);
        userInfo.put("username", "MustafaDogan");
        userInfo.put("firstName", "Mustafa");
        userInfo.put("lastName", "Dogan");
        userInfo.put("email", "dogan.mustafa.3737@gmail.com");
        userInfo.put("password", "Deneme1234");
        userInfo.put("phone", "555555555");
        userInfo.put("userStatus", 0);

        return userInfo;
    }

    public static JSONObject UserUpdateRequestBody() {

        JSONObject userInfo = new JSONObject();
        userInfo.put("id", 0);
        userInfo.put("username", "AhmetDogan");
        userInfo.put("firstName", "Ahmet");
        userInfo.put("lastName", "Dogan");
        userInfo.put("email", "dogan.ahmet.3737@gmail.com");
        userInfo.put("password", "Deneme1234");
        userInfo.put("phone", "555555555");
        userInfo.put("userStatus", 0);

        return userInfo;
    }


}
