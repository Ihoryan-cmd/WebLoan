import dataprovider.LoanDataProvider;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobjects.AddLoanPage;
import pageobjects.DashboardPage;
import pageobjects.LoansPage;

public class Loans extends BaseTest {
    @Test(dataProvider = "CreateLoan", dataProviderClass = LoanDataProvider.class)
    public void AddLoanPage(String branch, String branchUserName, String branchPassword, String monthlyIncome, String monthlyDebt){

        Login login = new Login(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        LoansPage loans = new LoansPage(driver);
        AddLoanPage loan = new AddLoanPage(driver);
        login.lmsLogin(branch, branchUserName, branchPassword);
    // click Loans button
    dashboard.setLoansButton();
    loans.setAddLoanButton();
    loan.selectCustomer("alim desnak (Account# 3243232)");
    loan.enterMonthlyIncome(monthlyIncome);
    helper.sleep(500);
    loan.enterMonthlyDebt(monthlyDebt);
    helper.sleep(250);
    loan.selectTerms(5);
    loan.clickGetCentralBankRate();
    helper.waitUntilClickable(driver, By.xpath("//span[normalize-space()='Ok']"));
    loan.clickOkBankRate();
    helper.waitUntilClickable(driver,By.xpath("//span[normalize-space()='Save']"));
    loan.clickSave();
    }
}
