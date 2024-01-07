
@WhatsappFrontPageTest
Feature: Title of your feature
  I want to use this template for my feature file

  @Select_person
  Scenario: Title of your scenario
    Given I am in Whatsapp front page
    And I look for this person "Manjula India New"
    Then I click on "Manjula India New"
    
  @Registration_selection_of_language
  Scenario: Select registration language
  	Given I am in the Whatsapp Registration Page
  	And I choose "Arabic" language
  
  
  @Registration_test_process
  Scenario: Select registration language only
  	Given I am in the Whatsapp Registration Page
  	And I choose "English" language
  	When I get to the welcome page
  	Then I click on agree and continue
  	When I get to the phone number verification page
  	And I select country "Belarus"
  	
  @Registration_process
  Scenario: Select registration language
  	Given I am in the Whatsapp Registration Page
  	And I choose "English" language
  	When I get to the welcome page
  	Then I click on agree and continue
  	When I get to the phone number verification page
  	And I select country "India"
  	And I add in number "9677027499"
  	When I get the contact confirmation popup
  	When I come to the contact popup page
  	Then I select "continue"
  	Then I set access to contacts to "Allow"
  	Then I verify backup page
  	Then I click restore
  	When I enter "Raghuram India" in the name
  	Then I skip email addition
  	Given I am in Whatsapp front page
  	
  	

