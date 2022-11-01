Feature: Crear Empleados

  create all the information about the employee.

  Scenario: Create the employee

  Insert the employee ID, Salary, Age, Name and profile picture

    Given I am an admin
    When I create and register all the information of the employee
    Then The employee should be created