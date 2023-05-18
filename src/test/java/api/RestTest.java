package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

class RestTest {

  @Test
  void simpleCall(){
    var response = when().get("http://localhost:4002/users")
        .then().extract().response();
    System.out.println("response = " + response.asPrettyString());
  }
}
