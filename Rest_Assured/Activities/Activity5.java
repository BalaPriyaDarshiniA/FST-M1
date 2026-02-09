package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.core.model.RequestResponsePact;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "PetStoreProvider", port = "8080")
public class Activity5 {

    // Create Pact contract
    @au.com.dius.pact.consumer.junit5.Pact(consumer = "PetStoreConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {

        PactDslJsonBody responseBody = new PactDslJsonBody()
                .integerType("id", 9999)
                .stringType("name", "Buddy")
                .stringType("status", "available");

        return builder
                .given("Pet exists")
                .uponReceiving("A request to get pet details")
                    .path("/v2/pet/9999")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(responseBody)
                .toPact();
    }

    // Test using the Pact mock server
    @Test
    @PactTestFor(pactMethod = "createPact")
    public void testGetPet(MockServer mockServer) {

        given()
            .baseUri(mockServer.getUrl())
        .when()
            .get("/v2/pet/9999")
        .then()
            .statusCode(200)
            .body("id", equalTo(9999))
            .body("name", equalTo("Buddy"))
            .body("status", equalTo("available"));
    }
}
