package dataprovider;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import pageobjects.AddUserPage;

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
                {"Halifax", "admin", "itovt0719", "", "", "The 'Username' field is required.", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "", "itovt0912", "The 'Username' field is required.", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "admin2432", "", "The 'Password' field is required.", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "ho2ryan21", "itovt0912", "The username already exists.", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "horyan21", "itov", "The 'Password' must be at least 8 characters.", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "hryan21", "itovt0912", "The phone number must be in the (999)999-9999 format.", "", "", "", "123456789", "", ""},
                {"Halifax", "admin", "itovt0719", "ho2ryn21", "itovt0912", "The 'First Name' can only contain letters and spaces.", "f434+43", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "ho2ryn21", "itovt0912", "The 'Last Name' can only contain letters and spaces.", "", "f434+43", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "ho2ran21", "itovt0912", "The 'Email' field must be a valid email address.", "", "", "", "", "sample#sample.com", ""},
        };
    }
    @DataProvider(name = "fieldsMaxLength")
    public static Object[][] fieldsMaxLength(){
        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "username", "admin123456789012", 16},
                {"Halifax", "admin", "itovt0719", "password", "sixteencharact166", 16},
                {"Halifax", "admin", "itovt0719", "firstname", "ThirtyTwoAlphabeticCharFirstNameX", 32},
                {"Halifax", "admin", "itovt0719", "lastname", "ThirtyTwoAlphabeticCharCompanyNameX", 32},
                {"Halifax", "admin", "itovt0719", "company", "ThirtyTwoAlphabeticCharFirstNameX", 32},
                {"Halifax", "admin", "itovt0719", "phone", "12345678910", 13},
                {"Halifax", "admin", "itovt0719", "email", "thirtytw2ocharacters32@charac.com", 32},
        };

    }
}

