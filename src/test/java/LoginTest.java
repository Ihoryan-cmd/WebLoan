import dataprovider.LoginDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{
    @Test(dataProvider = "LoginWithValidCredentials", dataProviderClass = LoginDataProvider.class)
    public void loginValidCredentials(String branchName, String branchUsername, String branchPassword){
        LoginPage login = new LoginPage(driver);
        driver.get("https://qa.hitekschool.com/lms/3108/login");
        helper.verifyPageTitle(driver, "Login - SmartBank LoanApp");
        helper.waitUntilClickable(driver, By.id("data.branch"));
        login.setBranchName(branchName);
        login.setBranchUsername(branchUsername);
        login.setBranchPassword(branchPassword);
        login.setRememberMeButton();
        login.setSignInButton();
        helper.waitForTitle(driver, "SmartBank Dashboard - '" + branchName + "' branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "SmartBank Dashboard - '" + branchName + "' branch - SmartBank LoanApp");
    }
    @Test(dataProvider = "LoginWithEmptyFields", dataProviderClass = LoginDataProvider.class)
    public void loginEmptyCredentials(String branchName, String branchUsername, String branchPassword, String fieldId, String expectedMessage){
        LoginPage login = new LoginPage(driver);
        driver.get("https://qa.hitekschool.com/lms/3108/login");
        helper.verifyPageTitle(driver, "Login - SmartBank LoanApp");
        login.setBranchName(branchName);
        login.setBranchUsername(branchUsername);
        login.setBranchPassword(branchPassword);
        login.setSignInButton();
        WebElement field = driver.findElement(By.id(fieldId));
        String actualMessage = field.getAttribute("validationMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message mismatch for field: " + fieldId);
    }

    @Test(dataProvider = "LoginWithWrongCredentials", dataProviderClass = LoginDataProvider.class)
    public void loginWithWrongCredentials(String branchName, String branchUsername, String branchPassword, String fieldXpath, String expectedMessage){
        LoginPage login = new LoginPage(driver);
        driver.get("https://qa.hitekschool.com/lms/3108/login");
        helper.verifyPageTitle(driver, "Login - SmartBank LoanApp");
        login.setBranchName(branchName);
        login.setBranchUsername(branchUsername);
        login.setBranchPassword(branchPassword);
        login.setSignInButton();
        helper.untilVisible(driver, By.xpath(fieldXpath));
        WebElement warningMessage = driver.findElement(By.xpath(fieldXpath));
        Assert.assertEquals(warningMessage.getText(), expectedMessage);
    }
}

