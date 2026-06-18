package pageobjects;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddLoanPage {
    public AddLoanPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Locators
    // Select Customer
    @FindBy(how = How.ID, using = "data.customer_id")
    private  WebElement selectCustomer;
    // Monthly Income field
    @FindBy(how = How.ID, using = "data.customer_monthly_income")
    private WebElement mIncomeField;
    // Monthly Debt field
    @FindBy(how = How.ID, using = "data.customer_monthly_debt")
    private WebElement mDebtField;
    // Term Years
    // 2
    @FindBy(how = How.XPATH, using = "//input[@id='data.customer_loan_term_years-2']")
    private WebElement termsYears2;
    // 3
    @FindBy(how = How.XPATH, using = "//input[@id='data.customer_loan_term_years-3']")
    private WebElement termsYears3;
    // 5
    @FindBy(how = How.XPATH, using = "//input[@id='data.customer_loan_term_years-5']")
    private WebElement termsYears5;
    // 10
    @FindBy(how = How.XPATH, using = "//input[@id='data.customer_loan_term_years-10']")
    private WebElement termsYears10;
    // 15
    @FindBy(how = How.XPATH, using = "//input[@id='data.customer_loan_term_years-15']")
    private WebElement termsYears15;
    // Returned Customer checkbox
    @FindBy(how = How.ID, using = "data.customer_returned")
    private WebElement returnedCustomerCheckbox;
    // Get central bank rate button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Get Central Bank Rate']")
    private WebElement getCentralBankRate;
    // Cancel button inside bank rate
    @FindBy(how = How.XPATH, using = "//button[@type='button']//span[@class='fi-btn-label'][normalize-space()='Cancel']")
    private WebElement cancelBankButton;
    // Ok button inside bank rate
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Ok']")
    private  WebElement okBankButton;
    // Letter
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Preview Prequalification Letter']")
    private WebElement letterButton;
    // Open PDF button.
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Open PDF Letter']")
    private WebElement OpenPdfButton;
    // Cancel inside letter.
    @FindBy(how = How.XPATH, using = "//button[contains(@type,'button')]//span[contains(@class,'fi-btn-label')][normalize-space()='Cancel']")
    private WebElement cancelLetterButton;
    // Save button inside letter.
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'fi-btn-label')][normalize-space()='Save'])[2]")
    private WebElement saveLetterButton;
    // Save button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Save']")
    private WebElement saveButton;
    // Cancel button
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement cancelButton;

    // Methods
    // Customer dropdown
    public AddLoanPage selectCustomer(String customerName) {
        Select dropdown = new Select(selectCustomer);
        dropdown.selectByVisibleText(customerName);
        return this;
    }

    // Monthly income
    public AddLoanPage enterMonthlyIncome(String monthlyIncome) {
        mIncomeField.clear();
        mIncomeField.sendKeys(monthlyIncome);
        return this;
    }

    // Monthly debt
    public AddLoanPage enterMonthlyDebt( String monthlyDebt) {
        mIncomeField.clear();
        mDebtField.sendKeys(monthlyDebt);
        return this;
    }

    // Term years
    public AddLoanPage selectTerms(int years){
        switch (years){
            case 2:
                termsYears2.click();
                break;
            case 3:
                termsYears3.click();
                break;
            case 5:
                termsYears5.click();
                break;
            case 10:
                termsYears10.click();
                break;
            case 15:
                termsYears15.click();
                break;

        }
        return this;

    }
    // Returned customer
    public AddLoanPage clickReturnedCustomer() {
        returnedCustomerCheckbox.click();
        return this;
    }

    // Central bank rate
    public AddLoanPage clickGetCentralBankRate() {
        getCentralBankRate.click();
        return this;
    }

    public AddLoanPage clickCancelBankRate() {
        cancelBankButton.click();
        return this;
    }

    public AddLoanPage clickOkBankRate() {
        okBankButton.click();
        return this;
    }

    // Letter
    public AddLoanPage clickPreviewLetter() {
        letterButton.click();
        return this;
    }

    public AddLoanPage clickOpenPdfLetter() {
        OpenPdfButton.click();
        return this;
    }

    public AddLoanPage clickCancelLetter() {
        cancelLetterButton.click();
        return this;
    }

    public AddLoanPage clickSaveLetter() {
        saveLetterButton.click();
        return this;
    }

    // Main buttons
    public AddLoanPage clickSave() {
        saveButton.click();
        return this;
    }

    public AddLoanPage clickCancel() {
        cancelButton.click();
        return this;
    }

}
