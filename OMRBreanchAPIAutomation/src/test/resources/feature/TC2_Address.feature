Feature: Address module API automation

  Scenario Outline: 
    Verify add new address to the application through api

    Given User add header and bearer authentication for accessing address endpoint
    When User add request body for new address "<first_name>" , "<last_name>" , "<mobile>" , "<apartment>" , "<state>" , "<city>" , "<country>" , "<zipcode>" , "<address>" and "<address_type>"
    And User send a "POST" request for addUserAddress endpoint
    Then User verify the status code is 200
    And User verify the add new address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment          | state | city | country | zipcode | address | address_type |
      | Raj        | Kumar     | 9977556666 | AyyasamyAppartment |     4 |    5 |       6 |  600333 | Navalur | Home         |

  Scenario Outline: 
    Verify update address to the application through api

    Given User add header and bearer authentication for accessing address endpoint
    When User update request body for existing address "<address_id>" , "<first_name>" , "<last_name>" , "<mobile>" , "<apartment>" , "<state>" , "<city>" , "<country>" , "<zipcode>" , "<address>" and "<address_type>"
    And User send a "PUT" request for updateUserAddress endpoint
    Then User verify the status code is 200
    And User verify the update address response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name | last_name | mobile     | apartment          | state | city | country | zipcode | address | address_type |
      |      24497 | Vikram        | Kumar     | 9977556666 | AyyasamyAppartment |     4 |    5 |       6 |  600333 | Navalur | Home         |

  Scenario Outline: 
    Verify get address from the application through api

    Given User add header and bearer authentication for accessing address endpoint
    When User send a "GET" request for getUserAddress endpoint
    Then User verify the status code is 200
    And User verify the get address response message matches "OK"

  Scenario Outline: 
      Verify delete address from the application through api

    Given User add header and bearer authentication for accessing address endpoint
    When User delete request body for existing address
    And User send a "DELETE" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    And User verify the delete address response message matches "Address deleted successfully"
