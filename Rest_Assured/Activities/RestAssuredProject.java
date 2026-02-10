package actvities;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredProject {

    RequestSpecification requestSpec;
    int sshId;
    String accessToken = "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";



    @BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + accessToken)
                .addHeader("Accept", "application/vnd.github+json")
                .build();
    }
    @Test(priority = 1)
    public void addSSHKey() {

        String payload = """
            {
              "title" : "TestAPIKey001",
              "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFfXH4niTlkzTIsBpPQzHRcTtw3du2aS9F8L3bG8YGso azuread\balapriyadarshinia@LAPTOP-3EKMT69G"
            }
            """;
//
        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys")
                    .body(payload)
                .when()
                    .post();

        Assert.assertEquals(response.statusCode(), 201);

        sshId = response.jsonPath().getInt("id");
        System.out.println("Created SSH Key ID: " + sshId);
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys/{keyId}")
                    .pathParam("keyId", sshId)
                .when()
                    .get();

        Reporter.log(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                given()
                    .spec(requestSpec)
                    .basePath("/user/keys/{keyId}")
                    .pathParam("keyId", sshId)
                .when()
                    .delete();

        Assert.assertEquals(response.statusCode(), 204);
        System.out.println("SSH Key deleted successfully");
    }
}