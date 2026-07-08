package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private final WebDriver driver;
    // Locators
    // Branch field.
    @FindBy(id = "data.branch")
    private WebElement branchName;
    // Username field.
    @FindBy(id = "data.username")
    private WebElement branchUsername;
    // Password field.
    @FindBy(id = "data.password")
    private WebElement branchPassword;
    // Remember me checkbox.
    @FindBy(xpath = "//input[@id='data.remember']")
    private WebElement rememberMeButton;
    //Sign In button.
    @FindBy(xpath = "//span[@class='fi-btn-label']")
    private WebElement signInButton;

    // Methods
    // Enter Branch.
    public LoginPage setBranchName(String branch){
        branchName.sendKeys(branch);
        return this;
    }
    // Enter Username.
    public LoginPage setBranchUsername(String branchUserName) {
        branchUsername.sendKeys(branchUserName);
        return this;
    }
    // Enter Password.
    public LoginPage setBranchPassword(String branchPassword){
        this.branchPassword.sendKeys(branchPassword);
        return this;
    }
    // Click remember me button.
    public LoginPage setRememberMeButton(){
        rememberMeButton.click();
        return this;
    }
    // Click Sign In button.
    public LoginPage setSignInButton(){
        signInButton.click();
        return this;
    }

    public String getFieldValidationMessage(By locator) {
        return driver.findElement(locator).getAttribute("validationMessage");
    }

    public String getWarningMessage(By locator) {
        return driver.findElement(locator).getText();
    }
}
