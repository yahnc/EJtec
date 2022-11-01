package employee;

import employee.model.Client;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenRegisteringANewClient {

    @Before
    public void setBaseURL() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
    }

    @Test
    public void each_new_client_should_be_given_a_unique_id() {

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

        String clientId = SerenityRest.lastResponse().jsonPath().getString("id");

        given().pathParam("id", clientId)
                .when().get("/client/{id}")
                .then().statusCode(200)
                .and().body("employee_name",equalTo("Sarah-Jane Smith"))
                .and().body("employee_salary",equalTo("1200000"))
                .and().body("employee_age",equalTo("19"))
                .and().body("profile_image",equalTo(""));
    }
}
