@story
Feature: Cookies Policy acknowledgement 

As a user, I want be notified about the cookies policy, so that I can read and accept the cookies policy. 

Background:
Given user is on homepage 
And user did not accept non-functional cookies

Scenario: Anonymous is shown the cookies policy.
Then user should see a notification text
"""
Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. 
Klik op Accepteer cookies voor een soepel werkende website. 
Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor Meer informatie.
"""
And user is shown a linktext for navigation to the cookies policy document
And user is shown a button for acceptance of the non-functional cookies 

Scenario: Anonymous user navigates to the cookies policy document
When user clicks on linktext Meer informatie
Then cookies policy file is downloaded 

Scenario: Anonymous user accepts cookies
When user clicks on the button Accepteer cookies
Then WoningNet website functionality is available





 
