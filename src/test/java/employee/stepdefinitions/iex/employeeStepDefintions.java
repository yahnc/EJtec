package employee.stepdefinitions.iex;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class EmployeeAPIStepDefintions {

    @Given("^I am an admin")
    public void i_am_an_admin() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }
}
