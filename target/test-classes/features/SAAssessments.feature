Feature: Setup Assessments

#Create the required Columns
  @SetCols
 Scenario Outline: Set Columns
    Given we open the "<ENV>" gibbon site
    Then we set up columns for the term "<TERM>"
    Examples:
    |TERM|ENV|
    |SUMMER TERM|Test|


#Set Comment Result Template for Assessments
  @SetResults
  Scenario Outline: Set Data
    Given we open the "<ENV>" gibbon site
    Then we set the results comment field for the term "<TERM>"
    Examples:
      |TERM|ENV|
      |SUMMER TERM|Test|


#Update all parent passwords
  @updatePassword
  Scenario Outline: update password
    Given we open the "<ENV>" gibbon site
    Then Update passwordsNew
    Examples:
      |ENV|
      |Test|

