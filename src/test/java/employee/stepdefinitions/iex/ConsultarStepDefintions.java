package employee.stepdefinitions.iex;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeAPIStepDefintions {


    @When("I request all the information of the employees")
    public void I_request_all_the_information_of_the_employees(id, employee_name, employee_salary, employee_age, profile_image) {
        when().get("status": "success")
              .then().statusCode(200);
    }

    @Then("I should see all the information requested")
    public void I_should_see_all_the_information_requested() {
        Double id = then().extract().response().as(Double.class);
        String employee_name = then().extract().response().as(String.class);
        String employee_salary = then().extract().response().as(String.class);
        Double employee_age = then().extract().response().as(Double.class);
        Picture employee_image = then().extract().response().as(Picture.class);
        Serenity.recordReportData().withTitle("Information"));

        assertThat(Information);
    }
}
