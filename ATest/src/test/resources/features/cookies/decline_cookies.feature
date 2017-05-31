@cookies
Feature: Decline non functional cookies 

As a user, 
I want to decline non functional cookies, 
So that i can use the WoningNet website without non functional cookies


Scenario: User decline cookies
When I navigate to homepage 
Then I am shown a notification about cookies
When I choose to know more about cookies policy
And I choose to decline cookies
Then WoningNet homepage is enabled

@addCookiesToBrowser
Scenario: User already declined cookies in a previous visit and visits the site again.
When I navigate to homepage
Then WoningNet homepage is enabled 

