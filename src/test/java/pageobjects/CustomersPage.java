package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage(WebDriver driver){
     PageFactory.initElements(driver, this);
    }

    // Locators
    // Add User Button.
    @FindBy(xpath = "//span[normalize-space()='Add Customer']")
    private WebElement addCustomersButton;
    // Profile icon button.
    @FindBy(how = How.XPATH, using = "//div[@class='fi-avatar bg-cover bg-center h-9 w-9 fi-user-avatar rounded-full']")
    private WebElement profileIconButton;
    // Log Out button.
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Log out']")
    private WebElement logOutButton;

    // Methods
    // Add Customer button.
        public CustomersPage setAddCustomersButton(){
        addCustomersButton.click();
        return this;
        }
        // Profile icon
        public CustomersPage setProfileIconButton(WebDriver driver){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", profileIconButton);
            return this;
        }
        // Log Out button
        public CustomersPage setLogOutButton(){
            logOutButton.click();
            return this;
        }
    }

