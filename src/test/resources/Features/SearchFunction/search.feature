
@GoogleAllTests
Feature: Google Tests
  I want to use this template for my feature file

  @SearchFunction
  Scenario Outline: Check whether google is able to search website
    Given I go to the Google Homepage
    And I search for "<value>"
    Then I should reach the google search page
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
    
    Examples:
    |value|
    |Table Tennis|
    |Badminton|
    |Java BDD|

    	
