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

  Scenario Outline: When it's not github link, then change it to bing
    Given I read the "D:/Java/crawler/crawer-demo/awesome-java.md"
    When I ask whether it contains "<link>"
    Then I get the answer "<answer>"

    Examples:
    | link | answer |
    | https://www.bing.com/search?q=site%3Agithub.com+Apache+Flink | yes|
    | https://www.bing.com/search?q=site%3Agithub.com+Apache+Spark | yes|
    | https://www.bing.com/search?q=site%3Agithub.com+Zulu+OpenJDK+9 | yes|
    | https://logging.apache.org/log4j  | no |