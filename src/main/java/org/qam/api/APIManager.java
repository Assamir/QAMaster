package org.qam.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.qam.conf.TestContext;

public class APIManager {
    TestContext testContext;

    RequestSpecification requestSpecification;

    public APIManager(TestContext testContext, RequestSpecification requestSpecification) {
        this.testContext = testContext;
        this.requestSpecification  =requestSpecification;
    }

    public Response getPlanets(){
//        return testContext.getPageManager().login();
        return null;
    }
}
