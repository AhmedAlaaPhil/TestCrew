Feature: Plan Price Feature
  In order to subscribe to STC TV
  As a valid customer from KSA KW or BH
  I want to check the plans currency in my country currency and preferred language



  @PricePlansAr @test @smoke
  Scenario Outline: check price and currency in Arabic

    Given I Navigate to STC Tv Website
    When  I select <country>
    And   I set <language>
    Then  I should see country name in the selected language
    And   I Should see lite plan price in country currency and selected language
    And   I Should see classic plan price in country currency and selected language
    And   I Should see permium plan price in country currency and selected language

    Examples:
      | country | language  |
      | "KSA"   | "Arabic" |
      | "KW"    | "Arabic" |
      | "BH"    | "Arabic" |