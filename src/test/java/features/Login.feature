Feature: Login Feature
  Background:
    Given User is on Login page

  @login
  Scenario: Try to Login with invalid password
    When user enter username "01811111111" and password "pass"
    And user click on the login button
    Then user must see the error title "rror" and massage "Incorrect username or password."
    But user shouldn't see the account page title "Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"

  Scenario: Try to Login with invalid phone number
    When user enter username "0181111" and password "pass"
    And user click on the login button
    Then user must see the error title "Error" and massage "Please enter a valid phone number."
    But user shouldn't see the account page title "Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"

  Scenario Outline: Try to login with invalid credentials
    When user enter <username> and <password>
    And user click on the login button
    Then user must see the <error_title> and <massage>
    But user shouldn't see the account <page_title>
    Examples:
    |username        |password|error_title |massage                             |page_title                                                                                     |
    |"01811111111"   |"pass"  |"Error"     |"Incorrect username or password."   |"Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"|
    |"01888888888888"|"pass"  |"Error"     |"Please enter a valid phone number."|"Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"|
    |"018666"        |"pass"  |"Error"     |"Please enter a valid phone number."|"Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"|
    |"0189999999999" |"pass"  |"Error"     |"Please enter a valid phone number."|"Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp;"|

  Scenario: Test DataTable
    Given We are testing how to use data table
      |"Hello"|
      |"Hi"   |
      |"Good" |
      |"Best" |
