@cookie
Feature: Accept non functional cookies 

As a user, I want to accept non functional cookies. So that i can use the WoningNet website
with non functional cookies


Scenario: Anonymous user accept cookies
Given I am on WoningNet homepage
And I see a cookies notification
When I click on the button Accepteer cookies
Then I am on WoningNet homepage 
And non functional cookies are accepted