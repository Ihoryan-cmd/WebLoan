package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "LoginWithValidCredentials")
    public static Object [][] validLogIn(){
        return new Object[][]{
                {"Halifax", "admin", "itovt0719"}
        };
    }
    @DataProvider(name = "LoginWithEmptyFields")
    public static Object[][] emptyLogIn(){
        return new Object[][]{
                {"", "", "", "data.branch", "Please fill out this field."},
                {"", "admin", "itovt0719", "data.branch", "Please fill out this field."},
                {"Halifax", "", "itovt0719", "data.username", "Please fill out this field."},
                {"Halifax", "admin", "", "data.password", "Please fill out this field."}
        };
    }
    @DataProvider(name = "LoginWithWrongCredentials")
    public static Object [][] wrongLogin(){
        return new Object[][]{
                {"Halifax213", "admin", "itovt0719", "//h3[normalize-space()='Branch does not exist']", "Branch does not exist"},
                {"Halifax", "admin123", "itovt0719", "//h3[normalize-space()='Invalid User Name or Password']", "Invalid User Name or Password"},
                {"Halifax", "admin", "itovt071923123", "//h3[normalize-space()='Invalid User Name or Password']", "Invalid User Name or Password"},

        };
    }
}
