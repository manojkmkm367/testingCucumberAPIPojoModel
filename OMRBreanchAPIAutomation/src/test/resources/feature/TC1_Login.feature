Feature: Login module API automation
Scenario: get User logtoken from login endpoint

Given User add header
When User add basic authentication for login
And User send "POST" request for login endpoint
Then User verify the status code is 200
Then User verify the login response body firstname present as "Tharun" and get the logtoken saved



