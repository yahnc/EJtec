Feature: Eliminar Empleados

  Delete all the information about the current employee.

  Scenario: Delete the employee

  Delete the employee ID, Salary, Age, Name and profile picture

    Given I am an admin
    When I Delete all the information of the employee
    Then I should see all the information deleted