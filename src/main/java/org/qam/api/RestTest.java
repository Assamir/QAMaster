package org.qam.api;

import io.restassured.RestAssured;

public class RestTest {

  private void simpleCall(){
    var response = RestAssured.when().get("http://localhost:4002/users")
        .then().extract().response();
    System.out.println("response = " + response.asPrettyString());
  }
}
