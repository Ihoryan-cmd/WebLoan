package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Locators
    // Users button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Users']")
    private WebElement usersButton;
    // Customers button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Customers']")
    private WebElement customersButton;
    // Loans button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Loans']")
    private WebElement loansButton;

    // Methods
    // Users button
    public DashboardPage setUsersButton(){
        usersButton.click();
        return this;
    }
    public DashboardPage setCustomersButton(){
        customersButton.click();
        return this;
    }
    public DashboardPage setLoansButton(){
        loansButton.click();
        return this;
    }
}
