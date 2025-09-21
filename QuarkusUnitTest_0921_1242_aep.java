// 代码生成时间: 2025-09-21 12:42:07
package com.example.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class QuarkusUnitTest {

    // Test for a simple GET endpoint
    @Test
    public void testHelloEndpoint() {
        // Given
        String expectedResponse = "hello";

        // When
        String response = given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        // Then
        assert response.equals(expectedResponse);
    }

    // Additional test methods can be added here
}

// HelloResource.java
/**
 * HelloResource.java
 * 
 * A simple REST resource class using Quarkus framework.
 */

package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
