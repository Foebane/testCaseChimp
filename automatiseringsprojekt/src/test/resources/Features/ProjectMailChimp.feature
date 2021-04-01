Feature: Creating user at Mailchimp.com
To try and create a user at Mailchimp.com with both valid and invalid input.

Background:
Given I have opened "chrome" , navigated to https://login.mailchimp.com/signup/ and accepted cookies


Scenario Outline: Creating a user
Given I have input <email>
And I input <username> 
And I also input <password>
When I press Sign Up
Then the correct <message> should be shown on the screen
Examples:
 |email                             |username                          |password          |message|
 | "Greek001pantsonfire@mymail.com"    | "GreekGuyWit001hPantsOnFire"        | "12As!wrT"       | "Check your email"      |
 
