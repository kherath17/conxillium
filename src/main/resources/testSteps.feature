@master
Feature: User Access and Functionality Check
  Scenario: Check user can login
    Given User direct to login Page
    When User able to see page title "Address Manager"
    Then User enter username
    Then User enter password
    Then User Click on login
    Then User able to see loggedIn Page


  Scenario:Check user can filter existing users by button or table header
    Given User in the loggedIn Page
    Then User filter by button with Full Name
    Then User filter by table header

 Scenario Outline:Check User can add new records and Filter
   Given User in the loggedIn Page
   When User click on Add New button navigates to detail enter page
   Then User enter "<Fname>" and "<Age>" and "<Address>" and "<BirthdayM>" and "<BirthY>" and "<BirthDate>" and "<Country>" and "<Expertise>" and "<Gender>"
   Then User click on Submit
   Then Check "<Fname>" added

   Examples:
     |Fname|Age|Address|BirthdayM|BirthY|BirthDate|Country|Expertise|Gender|
     |KasunNew|27|Kandy,Sri Lanka|October|1994|11|Sri Lanka|JAVA|MALE|

  Scenario Outline:Check User can add new records and Refresh Filter
    Given User in the loggedIn Page
    When User click on Add New button navigates to detail enter page
    Then User enter "<Fname>" and "<Age>" and "<Address>" and "<BirthdayM>" and "<BirthY>" and "<BirthDate>" and "<Country>" and "<Expertise>" and "<Gender>"
    Then User click on Submit
    Then User refresh page and Check "<Fname>" added


    Examples:
      |Fname|Age|Address|BirthdayM|BirthY|BirthDate|Country|Expertise|Gender|
      |KasunNew|27|Kandy,Sri Lanka|October|1994|11|Sri Lanka|JAVA|MALE|



  Scenario Outline:Check User can clear form data
    Given User in the loggedIn Page
    When User click on Add New button navigates to detail enter page
    Then User enter "<Fname>" and "<Age>" and "<Address>" and "<BirthdayM>" and "<BirthY>" and "<BirthDate>" and "<Country>" and "<Expertise>" and "<Gender>"
    Then User click on Reset and check fields are cleared

    Examples:
      |Fname|Age|Address|BirthdayM|BirthY|BirthDate|Country|Expertise|Gender|
      |KasunNew|27|Kandy,Sri Lanka|October|1994|11|Sri Lanka|JAVA|MALE|

  Scenario Outline:Check User cannot add new records without address
    Given User enter "<Fname>" and "<Age>" and "<EmptyAddress>" and "<BirthdayM>" and "<BirthY>" and "<BirthDate>" and "<Country>" and "<Expertise>" and "<Gender>"
    Then User click on Submit
    Then User remains on the same page

    Examples:
      |Fname|Age|EmptyAddress|BirthdayM|BirthY|BirthDate|Country|Expertise|Gender|
      |KasunNotAdded|27||October|1994|11|Sri Lanka|JAVA|MALE|





