package pageobjects;

import org.openqa.selenium.UnpinnedScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoansPage {
    public LoansPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Locators
    // Add Loan button
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Add Loan']")
    private WebElement addLoanButton;
    // Profile icon.
    @FindBy(how = How.XPATH, using = "//div[@class='fi-avatar bg-cover bg-center h-9 w-9 fi-user-avatar rounded-full']")
    private WebElement profileIconButton;
    // Log Out button.
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Log out']")
    private WebElement logOutButton;

    // Methods
    // Add Loan button
    public LoansPage setAddLoanButton(){
        addLoanButton.click();
        return this;
    }
    // Profile icon
    public LoansPage setProfileIconButton(){
        profileIconButton.click();
        return this;
    }
    // Log Out button
    public LoansPage setLogOutButton(){
        logOutButton.click();
        return this;
    }
}
