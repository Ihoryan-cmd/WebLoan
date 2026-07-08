import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddUserPage;
import pageobjects.DashboardPage;
import pageobjects.UserFlowPages;
import pageobjects.UsersPage;
import java.time.Duration;

public class Users extends BaseTest {
    private UserFlowPages navigateToAddUserPage(String branch, String branchUserName, String branchPassword) {
        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        UsersPage users = new UsersPage(driver);
        AddUserPage addUser = new AddUserPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);

        dashboard.setUsersButton();
        Assert.assertEquals(driver.getTitle(), "Users - '" + branch + "' Branch - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Add User']"));
        users.setAddUserButton();
        Assert.assertEquals(driver.getTitle(), "Add User - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.id("data.username"));

        return new UserFlowPages(users, addUser);
    }
    @Test(dataProvider = "createUserWithValidCredentials", dataProviderClass = UserDataProvider.class)
    public void addUserValidCredentials(String branch, String branchUserName, String branchPassword, String userName, String password, String firstName, String lastName, String companyName, String phoneName, String emailName, String roleDropDownField) {

        UserFlowPages pages = navigateToAddUserPage(branch, branchUserName, branchPassword);
        AddUserPage addUser = pages.addUser;
        UsersPage users = pages.users;

        addUser.setUsernameField(userName);
        addUser.setPasswordField(password);
        addUser.setFirstNameField(firstName);
        addUser.setLastNameField(lastName);
        addUser.setCompanyNameField(companyName);
        addUser.setPhoneField(phoneName);
        addUser.setEmailField(emailName);
        if (!roleDropDownField.isEmpty()) addUser.setRoleDropDown(roleDropDownField);
        addUser.setSaveButton();
        helper.waitForTitle(driver, "Add User - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Add User - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.xpath("//span[@class='text-sm font-semibold text-gray-950 dark:text-white'][normalize-space()='Username']"));
        boolean isUserExist = users.pageContainsText(userName);
        Assert.assertTrue(isUserExist, "The user: " + userName + "was not found");
        users.setProfileIconButton();
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        users.setLogOutButton();
    }

    @Test(dataProvider = "createUserWithEmptyFields", dataProviderClass = UserDataProvider.class)
    public void createUserWithEmptyFields(String branch, String branchUserName, String branchPassword, String userName, String password, String warningMessage, String firstName, String lastName, String companyName, String phoneName, String emailName, String roleDropDownField) {
        UserFlowPages pages = navigateToAddUserPage(branch, branchUserName, branchPassword);
        AddUserPage addUser = pages.addUser;
        UsersPage users = pages.users;

        addUser.setUsernameField(userName);
        addUser.setPasswordField(password);
        addUser.setFirstNameField(firstName);
        addUser.setLastNameField(lastName);
        addUser.setCompanyNameField(companyName);
        addUser.setPhoneField(phoneName);
        addUser.setEmailField(emailName);
        if (!roleDropDownField.isEmpty()) addUser.setRoleDropDown(roleDropDownField);
        addUser.setSaveButton();
        Assert.assertEquals(addUser.getFieldErrorMessage(), warningMessage, "The expected warning message was not found on the page");
        addUser.setCancelButton();
        helper.waitForTitle(driver, "Users - '" + branch + "' Branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "Users - '" + branch + "' Branch - SmartBank LoanApp");
        users.setProfileIconButton();
        helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Log out']"));
        users.setLogOutButton();
    }

    @Test(dataProvider = "fieldsMaxLength", dataProviderClass = UserDataProvider.class)
    public void createUserWithMaxLength(String branch, String branchUserName, String branchPassword, String fieldName, String value, int number) {
        UserFlowPages pages = navigateToAddUserPage(branch, branchUserName, branchPassword);
        AddUserPage addUser = pages.addUser;
        UsersPage users = pages.users;
        addUser.setFieldValue(fieldName, value);
        Assert.assertEquals(addUser.getFieldValue(fieldName).length(), number, "The length of the field is >16");
    }
}

