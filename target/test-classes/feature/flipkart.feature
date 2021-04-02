
@flipkart @ecom
Feature: flipkart ecom site
  
  Background:
  Given user launches the browser

  @datatc01 
  Scenario: to login and check the price of mobilephone
    When user close the login popup and clicks login 
    When user enters username and password and clicks login
    |userName|jegan.sivaraman@gmail.com|
    |Password|8970740907|
    And user search mobiles in search tab and clicks search
    And user selects the first link in new tab 
    And user prints the price and mobile name in excel
    
    
  