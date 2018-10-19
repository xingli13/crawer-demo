Feature: Have I get all the info yet?
  We should know we get enough lines and infos

  Scenario: We can normally read the file
    Given I open the "D:/Java/crawler/crawer-demo/awesome-java.md"
    When I ask what's in first line
    Then I should be told "Projects"

  Scenario: We can get lines we want
    Given I read the "D:/Java/crawler/crawer-demo/awesome-java.md"
    When I ask how many lines valid
    Then I should be told 625