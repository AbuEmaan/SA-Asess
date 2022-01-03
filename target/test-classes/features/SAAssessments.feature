Feature: start Amazon

@SetUpColumns
Scenario: Set Columns
    Given User opens page
   When User typing a search query new
   #Then User clicks search button

@SetResults
Scenario: Set Data
        Given User opens page
        Then User startes the process of setting results
     #   When User typing a search query
      #  Then User clicks search button


@updatePassword
  Scenario: update password
    Given User opens page
    Then Update passwordsNew


  @testamaxon
  Scenario: update password
    Given User opens page amazon
   # Then Update passwordsNew