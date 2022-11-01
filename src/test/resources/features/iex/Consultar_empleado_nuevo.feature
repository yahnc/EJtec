Feature: Consultar Empleado Nuevo

  Information about the new employee.

  Scenario: View the new employee

  Observe the employee ID, Salary, Age, Name and profile picture

    Given I am an admin
    When I request all the information of the employees
    Then I should see all the information requested