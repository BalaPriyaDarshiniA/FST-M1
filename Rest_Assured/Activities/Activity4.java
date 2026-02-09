
package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Activity4 {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {

        // Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON)
                .build();

        // Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test(priority = 1)
    public void addNewPetUsingSpec() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 88445);
        requestBody.put("name", "Max");
        requestBody.put("status", "available");

        given()
                .spec(requestSpec)
                .body(requestBody)
        .when()
                .post()
        .then()
                .spec(responseSpec)
                .body("id", equalTo(88445))
                .body("name", equalTo("Max"))
                .body("status", equalTo("available"));
    }

    @Test(priority = 2)
    public void getPetUsingSpec() {

        given()
                .spec(requestSpec)
                .pathParam("petId", 88445)
        .when()
                .get("/{petId}")
        .then()
                .spec(responseSpec)
                .body("id", equalTo(88445))
                .body("name", equalTo("Max"))
                .body("status", equalTo("available"));
    }

    @Test(priority = 3)
    public void deletePetUsingSpec() {

        given()
                .spec(requestSpec)
                .pathParam("petId", 88445)
        .when()
                .delete("/{petId}")
        .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo("88445"));
    }
}
