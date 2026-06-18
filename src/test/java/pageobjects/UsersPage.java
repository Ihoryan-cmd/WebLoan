package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
    public UsersPage(WebDriver driver){
        PageFactory.initElements(driver, this  );
    }

    // Locators
    // Add User button.
    @FindBy(xpath = "//span[normalize-space()='Add User']")
    private WebElement addUserButton;
    // Profile icon.
    @FindBy(how = How.XPATH, using = "//div[@class='fi-avatar bg-cover bg-center h-9 w-9 fi-user-avatar rounded-full']")
    private WebElement profileIconButton;
    // Log Out button.
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Log out']")
    private WebElement logOutButton;

    // Methods
    // Add User button.
    public UsersPage setAddUserButton(){
        addUserButton.click();
        return this;
    }
    // Profile icon
    public UsersPage setProfileIconButton(WebDriver driver){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", profileIconButton);
        return this;
    }
    // Log Out button
    public UsersPage setLogOutButton(){
        logOutButton.click();
        return this;
    }
}
