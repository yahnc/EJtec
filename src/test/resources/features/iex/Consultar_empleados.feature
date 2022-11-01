Feature: Consultar Empleados

  Information about the current and historical employees.

  Scenario: View the employees

  Observe the employee ID, Salary, Age, Name and profile picture

    Given I am an admin
    When I request all the information of the employees
    Then I should see all the information requested