Feature: Gorest application

  As a User I want to test Gorest Application

  Scenario Outline: CRUD Test
    Given URL is given
    When I create user with name"<name>"gender"<gender>"email"<email>"status"<status>"
    Then I verify that user is created with"<name>"
    And I update user with userId name"<name>" gender"<gender>"email"<email>"status"<status>"
    And I check user is updated successfully
    And I delete user with userId
    Then I verify that user is deleted successfully

    Examples:
      | name  | gender | email           | status |
      | Prites| male   | pritesh@gmail.com | active |

