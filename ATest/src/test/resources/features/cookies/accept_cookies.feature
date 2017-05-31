@cookies
Feature: Accept non functional cookies 

As a user, 
I want to accept non functional cookies, 
So that i can use the WoningNet website with non functional cookies


Scenario: User accept cookies
When I navigate to homepage
Then I am shown a notification about cookies
When I accept cookies
Then WoningNet homepage is enabled

@addCookiesToBrowser
Scenario: User already accepted cookies in a previous visit and visits the site again
When I navigate to homepage
Then WoningNet homepage is enabled