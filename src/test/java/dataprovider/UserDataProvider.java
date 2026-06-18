package dataprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
    @DataProvider(name = "createUserWithValidCredentials")
    public static Object[][] createUserValid(){

        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "ho2ryan21", "itovt0912", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "r", "12345678", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "user16characters", "sixteencharact16", "ThirtyTwoAlphabeticCharFirstName", "ThirtyTwoAlphabeticCharFirstName", "ThirtyTwoAlphabeticCharFirstName", "6010054568", "thirtytwocharacters32@charac.com", "Branch Admin"},
        };
    }
    @DataProvider(name = "createUserWithEmptyFields")
    public static Object[][] createUserWithEmpty(){
        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "", "", "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']", "The 'Username' field is required."},
                {"Halifax", "admin", "itovt0719", "", "itovt0912", "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']", "The 'Username' field is required."},
                {"Halifax", "admin", "itovt0719", "admin2432", "", "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']", "The 'Password' field is required."},
                {"Halifax", "admin", "itovt0719", "ho2ryan21", "itovt0912", "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']", "The username already exists."},
                {"Halifax", "admin", "itovt0719", "ho2ryan21", "itovt0912", "//p[@class='fi-fo-field-wrp-error-message text-sm text-danger-600 dark:text-danger-400']", "The 'Password' must be at least 8 characters."}
        };
    }
}

