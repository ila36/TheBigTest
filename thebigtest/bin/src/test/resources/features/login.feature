Feature: User login 

As a user I should be able to login when the registration number and password are correct.

As a user I should be navigated to the Search page when login is succesfull.

As a user I should be shown an error message when the registration number or the password are incorrect.

@login
Scenario: Anonymous user is shown a login page and enters invalid registration number for login
Given user is on homepage
And user clicks on the login button from the welcome box
When user enters invalid registration number 
Then user should see an error message