Feature: OrangehrmPage Demo

  Background: Login to OrangehrmPage successfully
    Given Browser is launched and OrangehrmPage page is displayed
    When Enter the Login details  'Admin' and  'admin123'

#  Scenario Outline: Login to OrangehrmPage successfully
#    Given Browser is launched and OrangehrmPage page is displayed
#    When Enter the Login details  '<Username>' and  '<Password>'
#    Then Validate dashboard is available after successfull login
#
#    Examples:
#      |Username|Password|
#      | Admin   |admin123|

  Scenario Outline:click on Admin and validate records
    Then Validate dashboard is available after successfull login
    Given User should be able to click on Admin and navigate to Admin Page
    When Search '<UserRole>' from System users tab
    Then Validate '<NoOfrecords>' is fetched Successfully

    Examples:
      | UserRole |NoOfrecords|
      |  Admin   |(1) Record Found  |

  Scenario Outline:click on PIM and add the employee
    Given User should be able to click on PIM and navigate to PIM Page
    When Enter '<EmployeeName>' and '<EmployeeNumber>' in required fields
    Then click on save button

    Examples:
      | EmployeeName |EmployeeNumber|
      | Admin        |234536           |

  Scenario:click on directory and validate the employee
    Given User should be able to click on directory and navigate to directory Page
    When validate the employee odis adalwin is CTO
    Then Validate user is able to view the fetched employee