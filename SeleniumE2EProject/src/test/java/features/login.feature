Feature: Login in to OrangeHRM
  Scenario Outline: Positive test validate login
    Given Launch the browser
    When navigate to "https://freecrm.com/"
    Then click on login to navigate home page
    When user details entered with <username> and <password>
    Then Successful Login
    And Display element in home page

    Examples:
      | username           | password  |
      | test1234@gmail.com | password1 |
      | abc123@gmail.com   | password2 |

