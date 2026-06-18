package dataprovider;

import org.testng.annotations.DataProvider;

public class LoanDataProvider {
    @DataProvider (name = "CreateLoan")
    public static Object[][] createLoan(){

        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "5000", "250"}
        };
    }
}
