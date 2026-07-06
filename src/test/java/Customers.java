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
    @Test(priority = 1, dataProvider = "createCustomerWithValidCredentials", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerPositive(String branch, String branchUserName, String branchPassword, String accountNumber, String title, String firstName, String lastName, String address, String city, String province, String postalCode, String phone, String email) {
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
        helper.waitForTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.xpath("//span[contains(text(),'Account #')]"));
        WebElement body = driver.findElement(By.tagName("body"));
        boolean ret = body.getText().contains(accountNumber);
        Assert.assertTrue(ret, "The account#: " + accountNumber + " does not exist");
        helper.waitUntilClickable(driver, By.xpath("//button[@aria-label='User menu']"));
        customers.setProfileIconButton(driver);
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        customers.setLogOutButton();
    }

    @Test(priority = 2, dataProvider = "createCustomerWithInvalidCredentials", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerNegative(String branch, String branchUserName, String branchPassword, String warning, String accountNumber, String title, String firstName, String lastName, String address, String city, String province, String postalCode, String phone, String email) {
        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        CustomersPage customers = new CustomersPage(driver);
        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);
        dashboard.setCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Customers - 'Halifax' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
        customers.setAddCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Add Customer - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Add Customer - SmartBank LoanApp");
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
        helper.untilVisible(driver, By.xpath("//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']"));
        WebElement warningM = driver.findElement(By.xpath("//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']"));
        helper.untilVisibleMethod(driver, warningM);
        Assert.assertEquals(warningM.getText(), warning, "Thw warning message: " + warning + " was not displayed don the page.");
        addCustomer.setCancelButton();
        helper.waitUntilClickable(driver, By.xpath("//button[@aria-label='User menu']"));
        customers.setProfileIconButton(driver);
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        customers.setLogOutButton();
    }

    @Test(priority = 3, dataProvider = "fieldMaxLength", dataProviderClass = CustomerDataProvider.class)
    public void createCustomerWithMaxLength(String branch, String branchUserName, String branchPassword, String fieldName, String value, int number) {
        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        CustomersPage customers = new CustomersPage(driver);
        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);
        dashboard.setCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Customers - 'Halifax' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Customers - 'Halifax' Branch - SmartBank LoanApp");
        customers.setAddCustomersButton();
        Assert.assertEquals(driver.getTitle(), "Add Customer - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Add Customer - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.id("data.first_name"));
        addCustomer.setFieldValue(fieldName, value);

        Assert.assertEquals(addCustomer.getFieldLength(fieldName).length(), number, "The length of the field is > 16");
    }
}
