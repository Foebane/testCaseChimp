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
 |email         |username             |password     |message            |
 | "validEmail" | "validUserName"     | "P@ssW0rd"  | "Check your email"|
 | "validEmail" | "tooManyCharacters" | "P@ssW0rd"  | "Enter a value less than 100 characters long"|
 | "validEmail" | "userNameTaken"     | "P@ssW0rd"  | "user with this username already exists. Maybe it's your evil twin. Spooky."|
 | "noEmail"    | "validUserName"     | "P@ssW0rd"  | "Please enter a value"|
