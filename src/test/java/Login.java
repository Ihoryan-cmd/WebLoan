import common.ConfigReader;
import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class Login{
    private WebDriver driver;
    private ConfigReader config = new ConfigReader();

    public Login(WebDriver driver) {

        this.driver = driver;
    }
    public void lmsLogin(String branch, String branchUserName, String branchPassword) {

        LoanAppHelper helper = new LoanAppHelper();
        LoginPage login = new LoginPage(driver);
        driver.get(config.getProperty("url"));
        System.out.println(driver.getTitle());
        helper.verifyPageTitle(driver,"Login - SmartBank LoanApp");
        login.setBranchName(branch);
        login.setBranchUsername(branchUserName);
        login.setBranchPassword(branchPassword);
        login.setSignInButton();
        helper.waitForTitle(driver, "SmartBank Dashboard - '" + branch + "' branch - SmartBank LoanApp");
        helper.verifyPageTitle(driver, "SmartBank Dashboard - '" + branch + "' branch - SmartBank LoanApp");
    }

}

