import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddUserPage;
import pageobjects.DashboardPage;
import pageobjects.UsersPage;
import java.time.Duration;

public class Users extends BaseTest {
//    @Test(dataProvider = "createUserWithValidCredentials", dataProviderClass = UserDataProvider.class)
//    public void addUserValidCredentials(String branch, String branchUserName, String branchPassword, String userName, String password, String firstName, String lastName, String companyName, String phoneName, String emailName, String roleDropDownField) {
//
//        Login login = new Login(driver);
//        DashboardPage dashboard = new DashboardPage(driver);
//        UsersPage users = new UsersPage(driver);
//        AddUserPage addUser = new AddUserPage(driver);
//        login.lmsLogin(branch, branchUserName, branchPassword);
//
//        dashboard.setUsersButton();
//        Assert.assertEquals(driver.getTitle(), "Users - 'Halifax' Branch - SmartBank LoanApp");
//        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Add User']"));
//        users.setAddUserButton();
//        Assert.assertEquals(driver.getTitle(), "Add User - SmartBank LoanApp");
//        helper.waitUntilClickable(driver, By.id("data.username"));
//        addUser.setUsernameField(userName);
//        addUser.setPasswordField(password);
//        addUser.setFirstNameField(firstName);
//        addUser.setLastNameField(lastName);
//        addUser.setCompanyNameField(companyName);
//        addUser.setPhoneField(phoneName);
//        addUser.setEmailField(emailName);
//        if (!roleDropDownField.isEmpty()) addUser.setRoleDropDown(roleDropDownField);
//        addUser.setSaveButton();
//        helper.waitForTitle(driver, "Add User - SmartBank LoanApp");
//        helper.verifyPageTitle(driver, "Add User - SmartBank LoanApp");
//        helper.waitUntilClickable(driver, By.xpath("//span[@class='text-sm font-semibold text-gray-950 dark:text-white'][normalize-space()='Username']"));
//        WebElement body = driver.findElement(By.tagName("body"));
//        boolean isUserExist = body.getText().contains(userName);
//        Assert.assertTrue(isUserExist, "The user: " + userName + "was not found");
//        users.setProfileIconButton(driver);
//        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
//        users.setLogOutButton();
//    }
//
//    @Test(dataProvider = "createUserWithEmptyFields", dataProviderClass = UserDataProvider.class)
//    public void createUserWithEmptyFields(String branch, String branchUserName, String branchPassword, String userName, String password, String warningMessage, String firstName, String lastName, String companyName, String phoneName, String emailName, String roleDropDownField) {
//        Login login = new Login(driver);
//        DashboardPage dashboard = new DashboardPage(driver);
//        UsersPage users = new UsersPage(driver);
//        AddUserPage addUser = new AddUserPage(driver);
//        login.lmsLogin(branch, branchUserName, branchPassword);
//
//        dashboard.setUsersButton();
//        Assert.assertEquals(driver.getTitle(), "Users - 'Halifax' Branch - SmartBank LoanApp");
//        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Add User']"));
//        users.setAddUserButton();
//        Assert.assertEquals(driver.getTitle(), "Add User - SmartBank LoanApp");
//        helper.waitUntilClickable(driver, By.id("data.username"));
//        addUser.setUsernameField(userName);
//        addUser.setPasswordField(password);
//        addUser.setFirstNameField(firstName);
//        addUser.setLastNameField(lastName);
//        addUser.setCompanyNameField(companyName);
//        addUser.setPhoneField(phoneName);
//        addUser.setEmailField(emailName);
//        if (!roleDropDownField.isEmpty()) addUser.setRoleDropDown(roleDropDownField);
//        addUser.setSaveButton();
//        Assert.assertEquals(addUser.getFieldErrorMessage(), warningMessage, "The expected warning message was not found on the page");
//        addUser.setCancelButton();
//        helper.waitForTitle(driver, "Users - 'Halifax' Branch - SmartBank LoanApp");
//        helper.verifyPageTitle(driver, "Users - 'Halifax' Branch - SmartBank LoanApp");
//        users.setProfileIconButton(driver);
//        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
//        users.setLogOutButton();
//    }

    @Test(dataProvider = "fieldsMaxLength", dataProviderClass = UserDataProvider.class)
    public void createUserWithMaxLength(String branch, String branchUserName, String branchPassword, String fieldName, String value, int number) {
        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        UsersPage users = new UsersPage(driver);
        AddUserPage addUser = new AddUserPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);

        dashboard.setUsersButton();
        Assert.assertEquals(driver.getTitle(), "Users - 'Halifax' Branch - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Add User']"));
        users.setAddUserButton();
        Assert.assertEquals(driver.getTitle(), "Add User - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.id("data.username"));
        addUser.setFieldValue(fieldName, value);
        Assert.assertEquals(addUser.getFieldValue(fieldName).length(), number, "The length of the field is >16");
    }
}

