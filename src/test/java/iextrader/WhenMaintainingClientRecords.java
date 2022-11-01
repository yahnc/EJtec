package employee;

import employee.model.Client;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.equalTo;

public class WhenMaintainingClientRecords {

    Client newClient;
    String clientId;

    @Before
    public void prepareTestData() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/1";

        // Given an existing client

        Client newClient = Client.Builder.aClient()
        .withemployee_name("Sarah-Jane SMith")
        .withemployee_salary("1200000")
        .withemployee_age("19")
        .withprofile_image("")
        .build();

        given().contentType("application/json")
                .and().body(newClient)
                .when().post("/client")
                .then().statusCode(200)
                .and().body("id", not(equalTo(0)));

        clientId = SerenityRest.lastResponse().jsonPath().getString("id");

    }
}

    @Test
    public void should_remove_client_from_the_registry() {

        // When I delete the client

        SerenityRest
                .given().pathParam("id", clientId)
                .when().delete("/client/{id}")
                .then().statusCode(204);

        // Then the client should no longer be found

        SerenityRest.given().pathParam("id",clientId)
                .when().get("/client/{id}")
                .then().statusCode(404);
    }
}
