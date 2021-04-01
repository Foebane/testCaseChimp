Feature: Creating user at Mailchimp.com
To try and create a user at Mailchimp.com with both valid and invalid input.

Background:
Given I have opened "chrome" and navigated to https://login.mailchimp.com/signup/


Scenario Outline: Creating a user
Given I have input <email>
And I input <username> 
And I input <password>
When I press Sign Up
Then the correct <message> should be shown on the screen
Examples:
 |email|username|password|message|
 |     |        |        |       |
 |     |        |        |       |
 |     |        |        |       |
 |     |        |        |       |
