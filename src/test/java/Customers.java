import dataprovider.CustomerDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddCustomerPage;
import pageobjects.CustomersPage;
import pageobjects.DashboardPage;

import java.time.Duration;

public class Customers extends BaseTest {
    @Test(dataProvider = "Create Customer", dataProviderClass = CustomerDataProvider.class)
    public void addCustomer(String branch, String branchUserName, String branchPassword, String accountNumber, String firstName, String lastName, String warning){
    Login login = new Login(driver);
    DashboardPage dashboard = new DashboardPage(driver);
    CustomersPage customers = new CustomersPage(driver);
    AddCustomerPage addCustomer = new AddCustomerPage(driver);
    login.lmsLogin(branch, branchUserName, branchPassword);

    dashboard.setCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Customers - 'Halifax' Branch - SmartBank LoanApp");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        helper.verifyPageTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
    customers.setAddCustomersButton();
    Assert.assertEquals(driver.getTitle(), "Add Customer - SmartBank LoanApp");
    helper.verifyPageTitle(driver, "Add Customer - SmartBank LoanApp");
    helper.waitUntilClickable(driver, By.id("data.account"));
    addCustomer.setAccountNumber(accountNumber);
    addCustomer.setFirstNameField(firstName);
    addCustomer.setLastNameField(lastName);
    addCustomer.setSaveButton();

    if(!warning.isEmpty()){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\"" + warning + "\")]")));
        helper.verifyPageTitle(driver, "Add Customer - SmartBank LoanApp");
        WebElement body = driver.findElement(By.tagName("body"));
        boolean ret = body.getText().contains(warning);
        Assert.assertTrue(ret, "The warning message is: '" + warning + "'");
        addCustomer.setCancelButton();
    } else {
        helper.waitForTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
        WebElement body = driver.findElement(By.tagName("body"));
        boolean pet = body.getText().contains(accountNumber);
        Assert.assertTrue(pet, "The account number: '" + accountNumber + "' was not found on the page");
    }
    helper.waitUntilClickable(driver, By.xpath("//button[@aria-label='User menu']"));
    customers.setProfileIconButton(driver);
    customers.setLogOutButton();

}
}
