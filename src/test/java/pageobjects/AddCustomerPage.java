package pageobjects;

import common.LoanAppHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    private LoanAppHelper helper = new LoanAppHelper();
    private WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    // Account number
    @FindBy(id = "data.account")
    private WebElement accountNumber;
    // Title
    @FindBy(id = "data.title")
    private WebElement titleDropDown;
    // First Name field.
    @FindBy(id = "data.first_name")
    private WebElement firstNameField;
    // Last Name field
    @FindBy(id = "data.last_name")
    private WebElement lastNameField;
    // Street field.
    @FindBy(id = "data.street")
    private WebElement streetNameField;
    // City field.
    @FindBy(id = "data.city")
    private WebElement cityNameField;
    // Province dropdown
    @FindBy(id = "data.state")
    private WebElement provinceDropDown;
    // Postal Code field
    @FindBy(id = "data.zip")
    private WebElement postalCodeField;
    // Phone field
    @FindBy(id = "data.phone")
    private WebElement phoneField;
    // Email field.
    @FindBy(id = "data.email")
    private WebElement emailField;
    // Save button
    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement saveButton;
    // Cancel button.
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']")
    private WebElement errorMessage;

    // Methods
    // Account# field.
    public AddCustomerPage setAccountNumber(String accNumber) {
        accountNumber.sendKeys(accNumber);
        return this;
    }
    // Title DropDown
    public AddCustomerPage selectTitle(String title){
        Select dropdown = new Select(titleDropDown);
        dropdown.selectByVisibleText(title);
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
    // Street field.
    public AddCustomerPage setStreetField(String street){
        streetNameField.sendKeys(street);
        return this;
    }
    // City field
    public AddCustomerPage setCityField(String city){
        cityNameField.sendKeys(city);
        return this;
    }
    // Province dropdown.
    public AddCustomerPage setProvinceDropDown(String provinceDropdown){
        Select dropdown = new Select(provinceDropDown);
        dropdown.selectByVisibleText(provinceDropdown);
        return this;
    }
    // Postal Code field
    public AddCustomerPage setPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
        return this;

    }
    // Phone field.
    public AddCustomerPage setPhoneField(String phone){
        phoneField.sendKeys(phone);
        return this;
    }
    // Email field.
    public AddCustomerPage setEmailField(String email){
        emailField.sendKeys(email);
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
    public String getFieldErrorMessage() {
        helper.untilVisibleMethod(driver, errorMessage);
        return errorMessage.getText();
    }

    public AddCustomerPage setFieldValue(String fieldName, String value) {
        if (fieldName.equals("account")) {
            accountNumber.sendKeys(value);
        } else if (fieldName.equals("firstname")){
            firstNameField.sendKeys(value);
        } else if (fieldName.equals("lastname")){
            lastNameField.sendKeys(value);
        } else if (fieldName.equals("street")){
            streetNameField.sendKeys(value);
        } else if (fieldName.equals("city")){
            cityNameField.sendKeys(value);
        } else if (fieldName.equals("postalcode")){
            postalCodeField.sendKeys(value);
        } else if (fieldName.equals("phone")){
            phoneField.sendKeys(value);
        } else if (fieldName.equals("email")){
            emailField.sendKeys(value);
        }
        return this;
    }
    public String getFieldLength(String fieldName){
        if (fieldName.equals("account")){
            return accountNumber.getAttribute("value");
        } else if (fieldName.equals("firstname")){
            return firstNameField.getAttribute("value");
        } else if (fieldName.equals("lastname")){
            return lastNameField.getAttribute("value");
        } else if (fieldName.equals("street")){
            return streetNameField.getAttribute("value");
        } else if (fieldName.equals("city")){
            return cityNameField.getAttribute("value");
        } else if (fieldName.equals("postalcode")){
            return postalCodeField.getAttribute("value");
        } else if (fieldName.equals("phone")){
            return phoneField.getAttribute("value");
        } else if (fieldName.equals("email")){
            return emailField.getAttribute("value");
        }
        return "";
    }
}
