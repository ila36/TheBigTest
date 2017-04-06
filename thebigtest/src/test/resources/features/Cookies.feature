Feature: Notify, accept or decline cookies 

As a user, I want be notified about the cookies policy, so that I can decide to accept or decline cookies. 

As a user, I should be able to accept cookies, so that I can use the website with cookies

As a user, I should be able to decline cookies, so that I can use the website without cookies

@cookie
Scenario: Anonymous user gets notified about the cookies policy and is given the choice to accept or decline the cookies policy
Given user navigates to homepage
And cookies not present in current browser
Then user should see a notification about cookies policy
And user should see a hyperlink to decline the cookies policy
And user should see a button to accept the cookies policy 

@cookie
Scenario: Anonymous user accepts cookies
Given cookies policy presented
When user clicks on the accepteer cookies button
Then cookies present in current browser 
