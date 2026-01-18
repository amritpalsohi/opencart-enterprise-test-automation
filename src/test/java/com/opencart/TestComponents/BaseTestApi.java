package com.opencart.TestComponents;

import com.opencart.Spec.RequestSpecFactory;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class BaseTestApi {

    @Before
    public void setup(){

        RestAssured.requestSpecification =
                RequestSpecFactory.getRequestSpecification();

    }

}
