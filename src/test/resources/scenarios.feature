Feature: Are the application up ?
  Just a simple test to know if the application is up

  Scenario: Are the application up ?
    Given an call to url up
    When receive http status OK
    Then should get correct response