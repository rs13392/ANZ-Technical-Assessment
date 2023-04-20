Feature: As an user of Home loan calculator, calculate the eligible amount based on the inputs provided by the user.

  @smoke
  Scenario: Validate home loan calculator page is displayed
    Given Open Home loan calculator Page

  @regression
  Scenario: Validate the Estimated amount could borrow based on the input provided in the Form
    Given Open Home loan calculator Page
    When user selects Application type "SINGLE"
    And Number of dependants "0"
    And Property Type you would like to by as "Home To Live In"
    And Your Annual income (Before tax) "$80000"
    And Your annual Other Income "$10000"
    And Your Monthly Leaving Expenses "$500"
    And Current home loan monthly repayment "$0"
    And Other loan monthly repayments "$0"
    And Total credit card limits "$10000"
    Then Verify - We estimate you could borrow: "$428,000"
  ## Adding the Startover Step in the same scenaro, to avoid launching a new Browser Session.
    When user clicks on start over
    Then Verify - We estimate you could borrow: "$0"
    When Your Monthly Leaving Expenses "$1"
    Then Verify the Message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."


###### Also adding a separate scenario to validate the usecase when startover button is clicked
  @regression
  Scenario: Validate the Estimated amount could borrow based on the input provided in the Form
    Given Open Home loan calculator Page
    When user clicks on start over
    Then Verify - We estimate you could borrow: "$0"

###### Also adding a separate scenario to validate the usecase when the monthly leaving expenses is $1
  @regression
  Scenario: Validate the Estimated amount could borrow based on the input provided in the Form
    Given Open Home loan calculator Page
    When Your Monthly Leaving Expenses "$1"
    Then Verify the Message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."



