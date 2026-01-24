package com.opencart.Spec;

import com.opencart.Config.ReqResConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class RequestSpecFactory {

    public static RequestSpecification getRequestSpecification(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("x-api-key", "reqres_d5e3d2f145cf451ba36262eefe456895");
        headers.put("User-Agent", "PostmanRuntime/7.32.3");

        return new RequestSpecBuilder()
                .setBaseUri(ReqResConfig.Base_URL)
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .build();
    }
}
