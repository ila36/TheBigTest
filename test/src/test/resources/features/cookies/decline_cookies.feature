@cookies
Feature: Decline non functional cookies 

As a user, I want to decline non functional cookies. So that i can use the WoningNet website
without non functional cookies

Background: 
Given I am on WoningNet homepage
And I see a cookies notification
And I click on Meer informatie linktext

Scenario: Anonymous user navigates to the cookies policy page
Then I am on cookies policy page

Scenario: Anonymous user decline the cookies policy
And I am on cookies policy page
When I click on Nee linktext
Then I am on WoningNet homepage
And non functional cookies are declined



 
