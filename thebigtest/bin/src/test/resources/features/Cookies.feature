@story
Feature: Cookies Policy acknowledgement 

As a user, I want be notified about the cookies policy, so that I can read and accept the cookies policy. 

Background:
Given no acceptance of non functional cookies by user

Scenario: Anonymous user gets notified about the cookies policy.
When user navigates to homepage
Then user should see a notification text as follow
"""
Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. 
Klik op Accepteer cookies voor een soepel werkende website. 
Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor Meer informatie.
"""
And user is shown a linktext for navigation to the cookies policy document
And user is shown a button for acceptance of the non functional cookies 

Scenario: Anonymous user navigates to the cookies policy document
When user clicks on linktext Meer informatie
Then cookies policy file is downloaded 

Scenario: Anonymous user accepts cookies
When user clicks on the button Accepteer cookies
Then homepage is available





 
