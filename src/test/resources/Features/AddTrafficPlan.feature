Feature: Add Tariff Plan in demo site
    
   Scenario: Add Customer with hard coded data
     Given  User launche demo telecom site
     And    User click on add tariff plan button
     When   Users enters all the fields
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
   
Scenario: Add Customer with hard coded data
     Given  User launche demo telecom site
     And    User click on add tariff plan button
     When   User enters all the fields with one dimensional list
     |249|450|250|75|2|4|1|
     |249|451|251|76|3|5|2|
     |249|452|252|77|4|6|3|
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
  
 
Scenario: Add Customer with hard coded data
     Given  User launche demo telecom site
     And    User click on add tariff plan button
     When   User enters all the fields with one dimension map
     |Ren|Loc|Int|Msg|LocRs|IntRs|MsgRs|
     |239|420|260|69|1|2|1|
     |238|421|261|68|2|4|2|
     |259|428|263|67|2|5|2|
     And    Users click on submit button 
     Then   Users should be displayed tariff plan  is added or not
