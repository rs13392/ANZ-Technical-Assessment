package Managers;

import PageObjects.CalculatorPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private CalculatorPage calculatorPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //General If...Else
    public CalculatorPage getCalculatorPage() {

        if (calculatorPage == null) {
            calculatorPage = new CalculatorPage(webDriver);
        }
        return calculatorPage;
    }

}
