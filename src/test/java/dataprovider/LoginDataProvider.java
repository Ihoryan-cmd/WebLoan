package dataprovider;

import common.ConfigReader;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    private static ConfigReader config = new ConfigReader();
    @DataProvider(name = "LoginWithValidCredentials")
    public static Object [][] validLogIn(){
        return new Object[][]{
                {config.getProperty("branch"),
                 config.getProperty("username"),
                 config.getProperty("password")
                        }
        };
    }
    @DataProvider(name = "LoginWithEmptyFields")
    public static Object[][] emptyLogIn(){
        return new Object[][]{
                {"", "", "", "data.branch", "Please fill out this field."},
                {"", config.getProperty("username"), config.getProperty("password"), "data.branch", "Please fill out this field."},
                {config.getProperty("branch"), "", config.getProperty("password"), "data.username", "Please fill out this field."},
                {config.getProperty("branch"), config.getProperty("username"), "", "data.password", "Please fill out this field."}
        };
    }
    @DataProvider(name = "LoginWithWrongCredentials")
    public static Object [][] wrongLogin(){
        return new Object[][]{
                {"Halifax213", config.getProperty("username"), config.getProperty("password"), "//h3[normalize-space()='Branch does not exist']", "Branch does not exist"},
                {config.getProperty("branch"), "admin123", config.getProperty("password"), "//h3[normalize-space()='Invalid User Name or Password']", "Invalid User Name or Password"},
                {config.getProperty("branch"), config.getProperty("username"), "itovt071923123", "//h3[normalize-space()='Invalid User Name or Password']", "Invalid User Name or Password"},

        };
    }
}
