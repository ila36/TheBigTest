@story
Feature: Notify, read and accept the cookies policy 

As a user, I want be notified about the cookies policy, so that I can decide to accept or decline cookies. 

As a user, I should be able to accept cookies, so that I can use the website with cookies.


Scenario: Anonymous user gets notified about the cookies policy.
Given no existance of non functional woningnet cookies in browser   
When user navigates to homepage
Then user should see a notification about cookies policy
And user should see a link text to click on
And user should see a button to accept the cookies policy 

Scenario: Anonymous user is given cookies policy document to read
When user clicks on link text
Then cookies policy file is downloaded 

Scenario: Anonymous user accepts cookies
When user clicks on the accepteer cookies button
Then homepage is available





 
