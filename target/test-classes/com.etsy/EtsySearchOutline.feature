@outline
Feature: Etsy Search With Scenario Outline

  Background: Navigate
    Given the user navigates to "https://www.etsy.com"


  Scenario Outline: Etsy Search Validation
    When the user search with "<searchValue>"
    Then the user should see the title "<title>"
    Examples:
      | searchValue | title       |
      | hat         | Hat \| Etsy |
      | key         | Key \| Etsy |
      | pin         | Pin \| Etsy |


    # option + command + l --> orginize our files