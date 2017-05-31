@login
Feature: User login 

As a user, I want to login, So that i can use the WoningNet website functionality

Scenario Outline: User with invalid registration number or password

Given I was on homepage
And I accepted cookies
And I entered incorrect "<registratienummer>" registratienummer "<password>" password
When I submit for login
Then I should get a validation error

Examples:
    | registratienummer | password |
    |	030141811		| password |