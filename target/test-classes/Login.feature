Feature: Login

  @regression
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    Then Page Title should be "Dashboard"
    When User click on Log out link
    Then User navigate to Login Page and Title should be "Your store. Login"
    And close browser

#  @SmokeTest1
#  Scenario Outline: Login Data Driven
#    Given User Launch Chrome browser
#    When User opens URL "http://admin-demo.nopcommerce.com/login"
#    And user enters Email as "<email>" and password as "<password>"
#    Then Page Title should be "Dashboard"
#    When User click on Log out link
#    Then User navigate to Login Page and Title should be "Your store. Login"
#    And close browser
#
#    Examples:
#    |email| |password|
#    |admin@yourstore.com| |admin|
#    |admin@yourstore.com| |admin|


