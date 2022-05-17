Feature: User Account
  Scenario: Admin can login to application

    Given Admin is in landing page
    When  he login as valid admin to the application
    Then  he should see the dashboard
    Then  admin should logout