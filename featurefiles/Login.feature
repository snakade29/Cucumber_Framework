Feature: Login Feature for INeuron admin section

  @Smoke
  Scenario: User is able to login with valid credentials
    Given User is able to open the application
    And User is able to land on home page with all elements
    When User enter username  "ineuron@ineuron.ai"
    And enter password "ineuron"
    And click on login button
    Then User should be able to login

    
  