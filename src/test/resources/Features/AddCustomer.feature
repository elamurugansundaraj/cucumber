@regression 
Feature: Add Customer in demo site
Background: 
       And  User click on add customer button
  Scenario: Add Customer With hard coded datas
    
    
    When user enters all the fields
    And user click on submit button
    Then user should be displayed customer ID is generated or not
   
Scenario: Add Customer with hard coded datas
    
    
    When User enters all the fields with one dimensional 
    |ela|murugan|elamurugan@gmail.com|pudukkotai|8098708095|
    And User click on submit button 
    Then User should be displayed cutomer ID is generated or not
   
 Scenario: Add Customer with hard coded datas
    
    When User enters all the fields with one dimensional map 
    |Fname|praveen|
    |Lname|raj|
    |Email|raj1234@gmail.com|
    |Add|trichy|
    |Phone|45678908999|
    And User click on submit button 
    Then User should be displayed cutomer ID is generated or not
    
    Scenario Outline: Title of your scenario outline
   
    When User enters all the fields with Outline "<Fname>","<Lname>","<Email>","<Add>","<Phone>"
    And  User click on submit button 
    Then User should be displayed cutomer ID is generated or not
    
    Examples: 
     |Fname|Lname|Email|Add|Phone|
     |murali|vijay|murali@email.com|pudukkottai|62247852|