package StepDefinitions;

import PageObjects.CalculatorPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CalculatorSteps {

    TestContext testContext;
    CalculatorPage calculatorPage;

    public CalculatorSteps(TestContext context) {
        testContext = context;
        calculatorPage = testContext.getPageObjectManager().getCalculatorPage();

    }
    @Given("Open Home loan calculator Page")
    public void login_to_homeloan_calculator_page() {
        calculatorPage.defaultANZLogoDisplayed();
        calculatorPage.homeLoanBreadCrumbs();
    }
    @When("user selects Application type {string}")
    public void user_selects_application_type(String applicationType) {
        System.out.println(CalculatorPage.ApplicationType.SINGLE.toString());
        if(applicationType.toUpperCase().equalsIgnoreCase(CalculatorPage.ApplicationType.SINGLE.toString())){

        }
    }

    @And("Number of dependants {string}")
    public void numberOfDependants(String dependents) {
        calculatorPage.selectDependentsByVisibleText(dependents);
    }

    @And("Property Type you would like to by as {string}")
    public void propertyTypeYouWouldLikeToByAs(String typeOfProperty) throws InterruptedException {
        if(typeOfProperty.equalsIgnoreCase(CalculatorPage.TypeOfProperty.HOME_TO_LIVE_IN.value))
            calculatorPage.homeToLiveInPropertyType.click();
        else if(typeOfProperty.equalsIgnoreCase(CalculatorPage.TypeOfProperty.RESIDENTIAL_INVESTMENT.value))
            calculatorPage.residentialInvestmentPropertyType.click();

    }

    @And("Your Annual income \\(Before tax) {string}")
    public void yourAnnualIncomeBeforeTax(String annaulIncome) {
        calculatorPage.annualIncome.sendKeys(annaulIncome);
    }

    @And("Your annual Other Income {string}")
    public void yourAnnualOtherIncome(String otherIncome) {
        calculatorPage.otherIncome.sendKeys(otherIncome);
    }

    @And("Your Monthly Leaving Expenses {string}")
    public void yourMonthlyLeavingExpenses(String monthlyExpenses)  {
        calculatorPage.monthlyExpenses.sendKeys(monthlyExpenses);

    }

    @And("Current home loan monthly repayment {string}")
    public void currentHomeLoanMonthlyRepayment(String monthlyRepayment) throws InterruptedException {
        calculatorPage.monthlyRepayment.sendKeys(monthlyRepayment);
    }

    @And("Other loan monthly repayments {string}")
    public void otherLoanMonthlyRepayments(String otherRepayment) {
        calculatorPage.otherRepayments.sendKeys(otherRepayment);
    }

    @And("Total credit card limits {string}")
    public void totalCreditCardLimits(String creditCardLimit) {
        calculatorPage.creditCardLimit.sendKeys(creditCardLimit);
    }

    @Then("Verify - We estimate you could borrow: {string}")
    public void verifyWeEstimateYouCouldBorrow(String expectedEstimatePrice) throws InterruptedException {
        calculatorPage.howMuchCouldIBorrow.click();
        calculatorPage.checkForTheEstimatePriceDisplayed();
        Thread.sleep(5000);
        String actualEstimatedPrice = calculatorPage.estimatedValue.getText();
        Assert.assertEquals(actualEstimatedPrice,expectedEstimatePrice);
    }

    @When("user clicks on start over")
    public void userClicksOnStartOver() {
        calculatorPage.startOver.click();
    }

    @Then("Verify the Message {string}")
    public void verifyTheMessage(String message) throws InterruptedException {
        calculatorPage.howMuchCouldIBorrow.click();
        Thread.sleep(2000);
        Assert.assertTrue(message.contains(calculatorPage.messageInEligible.getText()));
        Assert.assertTrue(message.contains(calculatorPage.customerCareNumber.getText()));

    }
}
