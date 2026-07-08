import dataprovider.CustomerDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddCustomerPage;
import pageobjects.CustomerFlowPages;
import pageobjects.CustomersPage;
import pageobjects.DashboardPage;

import java.time.Duration;

public class Customers extends BaseTest {
    private CustomerFlowPages navigateToAddCustomerPage(String branch, String branchUserName, String branchPassword) {
        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        CustomersPage customers = new CustomersPage(driver);
        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);

        dashboard.setCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Customers - '" + branch + "' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Customers - '" + branch + "' Branch - SmartBank LoanApp");
        customers.setAddCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Add Customer - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Add Customer - SmartBank LoanApp");

        return new CustomerFlowPages(customers, addCustomer);
    }
    @Test(priority = 1, dataProvider = "createCustomerWithValidCredentials", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerPositive(String branch, String branchUserName, String branchPassword, String accountNumber, String title, String firstName, String lastName, String address, String city, String province, String postalCode, String phone, String email) {
        CustomerFlowPages pages = navigateToAddCustomerPage(branch, branchUserName, branchPassword);
        CustomersPage customers = pages.customers;
        AddCustomerPage addCustomer = pages.addCustomer;
        helper.waitUntilClickable(driver, By.id("data.account"));
        addCustomer.setAccountNumber(accountNumber);
        if (!title.isEmpty()) addCustomer.selectTitle(title);
        addCustomer.setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setStreetField(address)
                .setCityField(city);
        if (!province.isEmpty()) addCustomer.setProvinceDropDown(province);
        addCustomer.setPostalCode(postalCode)
                .setPhoneField(phone)
                .setEmailField(email)
                .setSaveButton();
        helper.waitForTitle(driver, "Customers - '" + branch + "' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Customers - '" + branch + "' Branch - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.xpath("//span[contains(text(),'Account #')]"));
        boolean ret = customers.pageContainsText(accountNumber);
        Assert.assertTrue(ret, "The account#: " + accountNumber + " does not exist");
        helper.waitUntilClickable(driver, By.xpath("//button[@aria-label='User menu']"));
        customers.setProfileIconButton();
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        customers.setLogOutButton();
    }

    @Test(priority = 2, dataProvider = "createCustomerWithInvalidCredentials", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerNegative(String branch, String branchUserName, String branchPassword, String warning, String accountNumber, String title, String firstName, String lastName, String address, String city, String province, String postalCode, String phone, String email) {
        CustomerFlowPages pages = navigateToAddCustomerPage(branch, branchUserName, branchPassword);
        CustomersPage customers = pages.customers;
        AddCustomerPage addCustomer = pages.addCustomer;
        helper.waitUntilClickable(driver, By.id("data.account"));
        addCustomer.setAccountNumber(accountNumber);
        if (!title.isEmpty()) addCustomer.selectTitle(title);
        addCustomer.setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setStreetField(address)
                .setCityField(city);
        if (!province.isEmpty()) addCustomer.setProvinceDropDown(province);
        addCustomer.setPostalCode(postalCode)
                .setPhoneField(phone)
                .setEmailField(email)
                .setSaveButton();
        Assert.assertEquals(addCustomer.getFieldErrorMessage(), warning, "The warning message: " + warning + " was not displayed on the page.");
        addCustomer.setCancelButton();
        helper.waitUntilClickable(driver, By.xpath("//button[@aria-label='User menu']"));
        customers.setProfileIconButton();
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        customers.setLogOutButton();
    }

    @Test(priority = 3, dataProvider = "fieldMaxLength", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerWithMaxLength(String branch, String branchUserName, String branchPassword, String fieldName, String value, int number) {
        CustomerFlowPages pages = navigateToAddCustomerPage(branch, branchUserName, branchPassword);
        AddCustomerPage addCustomer = pages.addCustomer;
        helper.waitUntilClickable(driver, By.id("data.first_name"));
        addCustomer.setFieldValue(fieldName, value);

        Assert.assertEquals(addCustomer.getFieldLength(fieldName).length(), number, "The length of the field is > 16");
    }
}
