Feature: FAQ Moudule Test

  Background:
    Given Admin is in landing page
    When  he login as valid admin to the application
    Then  he should see the dashboard
    When  he clicks on Faqlinks

  Scenario Outline: Create FAQ and check the records
    Then  Newlink will be displayed on that page
    When  he clicks on new link
    Then  he create the new FAQ with details  "<Faq Type>","<Question>","<Answer>"
    And   submit to create the FAQ
    Then  FAQ should be created
    And  he should clicks on Administer
    Then  admin should logout
    Examples:
      | Faq Type         | Question | Answer |
      | Doctor           | cdf      | ghi    |

    Scenario: Create FAQ without Question credentials
      Then  Newlink will be displayed on that page
      When  he clicks on new link
      Then  he create the new FAQ without the Question
      And   submit to create the FAQ
      Then  FAQ should  not be created
      Then  admin should logout


      Scenario:Delete FAQ
      Then  Action will be displayed on the page FAQ Page
      When  he clicks on Action
      Then  Edit and Delete will be displayed
      When  he clicks on Delete
       Then  he will see the message Are you sure to delete the item?
      When  he clicks on Submit
     Then  he will be able to see the message Delete succeeded!
     And   he will clicks on ok
     Then  admin should logout

    Scenario: Search by ID
      Then    he will clicks on Filter
      When    he will see the search form
      Then    he will put the ID number
      And     he will clicks on Search
      Then    he will get the result
      Then    admin should logout

  Scenario: Search by Question
    Then    he will clicks on Filter
    When    he will see the search form
    Then    he will put the Question
    And     he will clicks on Search
    Then    he will get the result
    Then    admin should logout

  Scenario: Search by Faq Type Id
    Then    he will clicks on Filter
    When    he will see the search form
    Then    he will put the Faq Type Id
    And     he will clicks on Search
    Then    he will get the result
    Then    admin should logout

  Scenario: Search by Status
    Then    he will clicks on Filter
    When    he will see the search form
    Then    he will put the Status
    And     he will clicks on Search
    Then    he will get the result
    Then    admin should logout

  Scenario: Search by Reset
    Then    he will clicks on Filter
    When    he will see the search form
    Then    he will put the ID number
    Then    he clicks on Reset
    And     admin should see the FAQ Page
    Then    admin should logout

  Scenario: Search by click on submit without any credentials
    Then    he will clicks on Filter
    When    he will see the search form
    Then    he clicks on Submit
    And     admin should see the FAQ Page
    Then    admin should logout

  Scenario: Clicks on Faq Types
    Then      he should clicks on Faq Types
    Then      he should be on Faq Types List Page
    When      he should clicks on Filter
    Then      he should be able to see the Faq Type List Form
    And       he should TypeName in TypeName box
    Then      he should clicks on Search











