Feature: Data Driven Feature
  Verify Sample Data through on-demand and example keyword

  Scenario Outline: Navigate to UltimateQa HomePage For Data Driven testing For 'https://ultimateqa.com/automation'
    Given user go to 'https://ultimateqa.com/automation' UltimateQa HomePage
    When user navigates to Forms Page
    And user enters <Name> and <Message>
    Then Verify success message

    Examples:
      | Name | Message  |
      | JD   | TESTING1 |
      #| JDD  | TESTING2 |