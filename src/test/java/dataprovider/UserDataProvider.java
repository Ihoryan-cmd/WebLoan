package dataprovider;

import common.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pageobjects.AddUserPage;

public class UserDataProvider {
    private static ConfigReader config = new ConfigReader();
    @DataProvider(name = "createUserWithValidCredentials")
    public static Object[][] createUserValid(){

        return new Object[][]{
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "ho2ryan21", "itovt0912", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "r", "12345678", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "user16characters", "sixteencharact16", "ThirtyTwoAlphabeticCharFirstName", "ThirtyTwoAlphabeticCharFirstName", "ThirtyTwoAlphabeticCharFirstName", "6010054568", "thirtytwocharacters32@charac.com", "Branch Admin"},
        };
    }
    @DataProvider(name = "createUserWithEmptyFields")
    public static Object[][] createUserWithEmpty(){
        return new Object[][]{
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "", "", "The 'Username' field is required.", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "", "itovt0912", "The 'Username' field is required.", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "admin2432", "", "The 'Password' field is required.", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "ho2ryan21", "itovt0912", "The username already exists.", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "horyan21", "itov", "The 'Password' must be at least 8 characters.", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "hryan21", "itovt0912", "The phone number must be in the (999)999-9999 format.", "", "", "", "123456789", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "ho2ryn21", "itovt0912", "The 'First Name' can only contain letters and spaces.", "f434+43", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "ho2ryn21", "itovt0912", "The 'Last Name' can only contain letters and spaces.", "", "f434+43", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "ho2ran21", "itovt0912", "The 'Email' field must be a valid email address.", "", "", "", "", "sample#sample.com", ""},
        };
    }
    @DataProvider(name = "fieldsMaxLength")
    public static Object[][] fieldsMaxLength(){
        return new Object[][]{
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "username", "admin123456789012", 16},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "password", "sixteencharact166", 16},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "firstname", "ThirtyTwoAlphabeticCharFirstNameX", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "lastname", "ThirtyTwoAlphabeticCharCompanyNameX", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "company", "ThirtyTwoAlphabeticCharFirstNameX", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "phone", "12345678910", 13},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "email", "thirtytw2ocharacters32@charac.com", 32},
        };

    }
}

