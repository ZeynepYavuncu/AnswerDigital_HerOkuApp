@UI
Feature: Answer Digital Automation Task

  Background:
    Given the user is on the main url

@login
  Scenario Outline: Login with username and password
    When the user clicks on "Form Authentication" button
    And the user enters "<username>" and "<password>" credentials and login
    Then verify that "<warningMessage>" msg appeared
    Examples:
      | username        | password             | warningMessage                 |
      | tomsmith        | invalidPassword      | Your password is invalid!      |
      | invalidUserName | SuperSecretPassword! | Your username is invalid!      |
      | tomsmith        | SuperSecretPassword! | You logged into a secure area! |

@scroll
  Scenario: Scroll down twice and scroll up
    When the user clicks on "Infinite Scroll" button
    And the user scroll down twice
    And the user scroll up to the top of the page
    Then verify that Infinite Scroll text displayed


@keys
  Scenario Outline: Click on 4 keys and verify the text displayed
    When the user clicks on "Key Presses" button
    And the user enters "<keys>" below
    Then verify that the text is displayed after every "<keys>" press
    Examples:
      | keys       |
      | BACK_SPACE |
      | TAB        |
      | CONTROL    |
      | SPACE      |



