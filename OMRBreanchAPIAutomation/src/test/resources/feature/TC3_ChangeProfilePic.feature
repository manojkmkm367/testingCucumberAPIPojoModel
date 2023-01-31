Feature: Profile picture module API automation

  Scenario: Verify change Profile picture to the application through api
    Given User add header and bearer authentication for accessing profile picture endpoint
    When User add request body for changing Profile picture
    And User send a "POST" request for changeProfilePicture endpoint
    Then User verify the status code is 200
    And User verify the change Profile response message matches "Profile updated Successfully"
