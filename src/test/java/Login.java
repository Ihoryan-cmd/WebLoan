import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class Login{
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public void lmsLogin(String branch, String branchUserName, String branchPassword) {

        LoanAppHelper helper = new LoanAppHelper();
        LoginPage login = new LoginPage(driver);
        driver.get("https://qa.hitekschool.com/lms/3108/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        helper.verifyPageTitle(driver,"Login - SmartBank LoanApp");
        login.setBranchName(branch);
        login.setBranchUsername(branchUserName);
        login.setBranchPassword(branchPassword);
        login.setSignInButton();
        helper.waitForTitle(driver, "SmartBank Dashboard - 'Halifax' branch - SmartBank LoanApp");
        System.out.println(driver.getTitle());
        helper.verifyPageTitle(driver, "SmartBank Dashboard - '" + branch + "' branch - SmartBank LoanApp");
    }

}

