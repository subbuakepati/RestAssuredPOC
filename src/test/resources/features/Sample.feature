Feature: This is to verify all territories of a country
  Scenario Outline: This is to verify territories of India
    Given I have rest api web service url with "<countryCode>"
    When I  call the rest api url
    Then I should be able to get all territories information for the requested country
    Examples:
    |countryCode |
    | IND |