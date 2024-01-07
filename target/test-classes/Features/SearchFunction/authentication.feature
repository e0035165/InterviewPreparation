@Simple_Authentication
Feature: Check google authentication

	@EmailandUsernameAuthentication
	Scenario: Check whether simple user is able to llogin
		Given I go to the Google Homepage
		When I click on "Sign in" button
		Then I enter email "cegmaster95@gmail.com" in email entrybox
		Then I enter password "Ganesha@1995g" in password entrybox
		
		
		