package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {

    WebDriver webDriver;

    public CalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }
    public enum ApplicationType {
        SINGLE("Single"),
        JOINT("Joint");
        private String value;

        ApplicationType(String value){
            this.value = value;
        }
    }

    public enum TypeOfProperty {
        HOME_TO_LIVE_IN("Home to live in"),
        RESIDENTIAL_INVESTMENT("Residential investment");
        public String value;

        TypeOfProperty(String value){
            this.value = value;
        }
    }

    @FindBy(xpath = "//img[@alt='ANZ logo']")
    private WebElement anzLogo;

    @FindBy(xpath ="//ul[@class='breadcrumb__list']")
    private WebElement breadCrumbsForCalculator;

    @FindBy(xpath ="//label[@for='application_type_single']//ancestor::li[@class='selected']")
    private WebElement applicationTypeSingle;

    @FindBy(xpath ="//*[text()='How much could I borrow?']")
    private WebElement homeLoanEstimateCalculatorPage;

    @FindBy(xpath ="//*[@title='Number of dependants']")
    private WebElement noOfDependent;

    @FindBy(xpath ="//*[contains(text(),'Home to live in')]//input")
    public WebElement homeToLiveInPropertyType;

    @FindBy(xpath ="//*[contains(text(),'Residential investment')]//input")
    public WebElement residentialInvestmentPropertyType;

    @FindBy(xpath ="//input[@aria-describedby='q2q1i1 q2q1i2']")
    public WebElement annualIncome;

    @FindBy(xpath ="//input[@aria-describedby='q2q2i1 q2q2i2']")
    public WebElement otherIncome;

    @FindBy(xpath ="//input[@aria-describedby='q3q1i1 q3q1i2']")
    public WebElement monthlyExpenses;

    @FindBy(xpath ="//input[@aria-describedby='q3q2i1 q3q2i2']")
    public WebElement monthlyRepayment;

    @FindBy(xpath ="//input[@aria-describedby='q3q4i1 q3q4i2']")
    public WebElement otherRepayments;

    @FindBy(xpath ="//input[@aria-describedby='q3q5i1']")
    public WebElement creditCardLimit;

    @FindBy(xpath ="//button[contains(text(),'Work out how much I could borrow')]")
    public WebElement howMuchCouldIBorrow;

    @FindBy(xpath ="//span[@class='borrow__result__text__amount homeloan__borrow__text']")
    public WebElement estimatedValue;

    @FindBy(xpath ="//button[@class='start-over']")
    public WebElement startOver;

    @FindBy(xpath ="//*[local-name() = 'div']//div[@class='borrow__error__text']")
    public WebElement messageInEligible;

    @FindBy(xpath ="//*[local-name() = 'div']//div[@class='borrow__error__text']/b")
    public WebElement customerCareNumber;

    public void selectDependentsByVisibleText(String numberOfdependents){
        Select objSelect =new Select(noOfDependent);
        objSelect.selectByVisibleText(numberOfdependents);
    }

    public boolean defaultANZLogoDisplayed() {
        anzLogo.isDisplayed();
        return true;
    }

    public boolean homeLoanBreadCrumbs() {
        breadCrumbsForCalculator.isDisplayed();
        return true;
    }

    public boolean checkForTheEstimatePriceDisplayed() {
            Wait.untilElementIsVisible(webDriver, estimatedValue, 30L);
            Wait.untilAjaxCallIsDone(webDriver,30L);
            estimatedValue.isDisplayed();
            return true;
    }
}
