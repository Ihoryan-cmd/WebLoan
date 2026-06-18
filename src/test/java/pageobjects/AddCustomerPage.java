package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    public AddCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Locators
    // Account number
    @FindBy(id = "data.account")
    private WebElement accountNumber;
    // First Name field.
    @FindBy(id = "data.first_name")
    private WebElement firstNameField;
    // Last Name field
    @FindBy(id = "data.last_name")
    private WebElement lastNameField;
    // Save button
    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement saveButton;
    // Cancel button.
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement cancelButton;

    // Methods
    // Account# field.
    public AddCustomerPage setAccountNumber(String accNumber) {
        accountNumber.sendKeys(accNumber);
        return this;
    }
    // First Name field.
    public AddCustomerPage setFirstNameField(String firstName){
        firstNameField.sendKeys(firstName);
        return this;
    }
    // Last name field.
    public AddCustomerPage setLastNameField(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }
    // Save button.
    public AddCustomerPage setSaveButton(){
        saveButton.click();
        return this;
    }
    // Cancel button
    public AddCustomerPage setCancelButton(){
        cancelButton.click();
        return this;
    }
}
