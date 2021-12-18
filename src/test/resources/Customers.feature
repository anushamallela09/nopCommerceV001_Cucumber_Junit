Feature: Customers
  Background: Below are the common steps for each scenario
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    Then Page Title should be "Dashboard"

  @SmokeTest
  Scenario: Add a new Customer
    When User click on Customers main Menu and click on Customers sub menu
    Then click on Add new Customer Page and User can view Add customer page
    And Verify Success Message "The new customer has been added successfully."
    And close browser

#  @SmokeTest1
#    Scenario: Search Customer by using Email id
#      When User click on Customers main Menu and click on Customers sub menu in Dashboard Page
#      And Enter Customer Mail and click on search button
#      Then User should found email in Search table
#      And close browser




