Feature: Add Tariff Plan in demo site
    Background:
    And    User click on add tariff plan button
    
   Scenario: Add Customer with hard coded data
    
     
     When   Users enters all the fields
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
   
Scenario: Add Customer with hard coded data
     
     When   User enters all the fields with two dimensional list
     |249|450|250|75|2|4|1|
     |249|451|251|76|3|5|2|
     |249|452|252|77|4|6|3|
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
  
 
Scenario: Add Customer with hard coded data
     
     When   User enters all the fields with two dimension map
     |Ren|Loc|Int|Msg|LocRs|IntRs|MsgRs|
     |239|420|260|69|1|2|1|
     |238|421|261|68|2|4|2|
     |259|428|263|67|2|5|2|
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
Scenario Outline: Title of your scenario outline
     
     When   Users enters all the fields "<Ren>","<Loc>","<Int>","<Msg>","<LocRs>","<IntRs>","<MsgRs>"
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not

    Examples: 
     |Ren|Loc|Int|Msg|LocRs|IntRs|MsgRs|
     |239|420|260|69|1|2|1|
     |238|421|261|68|2|4|2|
     |259|428|263|67|2|5|2|