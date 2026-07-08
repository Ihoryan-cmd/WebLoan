package pageobjects;

import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {

    private WebDriver driver;
    private LoanAppHelper helper = new LoanAppHelper();

    public AddUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(how = How.ID, using = "data.username")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "data.password")
    private WebElement passwordField;

    @FindBy(id = "data.first_name")
    private WebElement firstNameField;

    @FindBy(id = "data.last_name")
    private WebElement lastNameField;

    @FindBy(id = "data.company")
    private WebElement companyNameField;

    @FindBy(id = "data.phone")
    private WebElement phoneField;

    @FindBy(id = "data.email")
    private WebElement emailField;

    @FindBy(id = "data.role")
    private WebElement roleDropDown;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']")
    private WebElement errorMessage;


    // Methods
    public AddUserPage setUsernameField(String user) {
        usernameField.sendKeys(user);
        return this;
    }

    public AddUserPage setPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public AddUserPage setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }
    public AddUserPage setLastNameField(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }
    public AddUserPage setCompanyNameField(String companyName){
        companyNameField.sendKeys(companyName);
        return this;
    }
    public AddUserPage setPhoneField(String phoneName){
        phoneField.sendKeys(phoneName);
        return this;
    }
    public AddUserPage setEmailField(String emailName){
        emailField.sendKeys(emailName);
        return this;
    }
    public AddUserPage setRoleDropDown(String roleDropDownField){
        Select dropdown = new Select(roleDropDown);
            dropdown.selectByVisibleText(roleDropDownField);
            return this;
        }

    public AddUserPage setSaveButton() {
        saveButton.click();
        return this;
    }

    public AddUserPage setCancelButton() {
        cancelButton.click();
        return this;
    }
    public String getFieldErrorMessage() {
        helper.untilVisibleMethod(driver, errorMessage);
        return errorMessage.getText();
    }

    public AddUserPage setFieldValue(String fieldName, String value){
        if (fieldName.equals("username")){
            usernameField.sendKeys(value);
        } else if (fieldName.equals("password")){
            passwordField.sendKeys(value);
        } else if (fieldName.equals("firstname")){
            firstNameField.sendKeys(value);
        } else if (fieldName.equals("lastname")){
            lastNameField.sendKeys(value);
        } else if (fieldName.equals("company")){
            companyNameField.sendKeys(value);
        } else if (fieldName.equals("phone")){
            phoneField.sendKeys(value);
        } else if (fieldName.equals("email")){
            emailField.sendKeys(value);
        }
        return this;
    }

    public String getFieldValue(String fieldName){
        if (fieldName.equals("username")){
            return usernameField.getAttribute("value");
        } else if (fieldName.equals("password")){
            return passwordField.getAttribute("value");
        } else if (fieldName.equals("firstname")){
            return firstNameField.getAttribute("value");
        } else if (fieldName.equals("lastname")){
            return lastNameField.getAttribute("value");
        } else if (fieldName.equals("company")){
            return companyNameField.getAttribute("value");
        } else if (fieldName.equals("phone")){
            return phoneField.getAttribute("value");
        } else if (fieldName.equals("email")){
            return emailField.getAttribute("value");
        }
        return "";
    }
}
