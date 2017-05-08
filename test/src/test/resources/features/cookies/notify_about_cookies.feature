@cookies
Feature: Cookies notification 

As a user, I want be notified about the cookies policy, 
so that I can accept or decline the cookies policy. 

Scenario: Anonymous user is shown a cookies page  
Given I am on WoningNet homepage
And I see a cookies notification
Then I should see a notification text
"""
Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. 
Klik op Accepteer cookies voor een soepel werkende website. 
Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor Meer informatie.
"""
And I should see a linktext for navigation to the cookies policy document
And I should see a button for acceptance of non functional cookies