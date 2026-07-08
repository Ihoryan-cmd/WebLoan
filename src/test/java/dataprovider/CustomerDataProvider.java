package dataprovider;

import common.ConfigReader;
import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    private static ConfigReader config = new ConfigReader();
    @DataProvider(name = "createCustomerWithValidCredentials")
        public static Object[][] createCustomerWithValidCredentials(){
            return new Object[][]{
                    {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "3493453", "", "Boryanchik", "Vyacheslavvovich", "Lisova 18", "Toronto", "Ontario", "M6B 3y4", "2010054568", "sixteen@char.com"},
                    {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "1284567", "", "t", "t", "", "", "", "", "", ""},
                    {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "1224507", "Mr.", "qwertyuiopasdfgh", "qwertyuiopasdruh", "qweqweqweqwewqeqweqweqweqweqweqw", "qweqweqweqwewqeqweqweqweqweqweqw", "Ontario", "M6B 3y4", "`1234567899", "thirtytwocharacters32@charac.com"},
            };
    }
    @DataProvider(name = "createCustomerWithInvalidCredentials")
    public static Object[][] createCustomerWithInvalidCredentials(){
        return new Object[][]{
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Account #' field is required.", "", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'First Name' field is required.", "1234568", "", "", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Last Name' field is required.", "1234568", "", "Boryanchik", "", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Account #' already exists.", "3493453", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Account #' must be 7 digits long.", "54564", "", "Borygnchik", "Vyachesasvvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Account #' can only contain numbers.", "ghfghfg", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'First Name' can only contain letters and spaces.", "3493483", "", "Boryan44chik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Last Name' can only contain letters and spaces.", "1234987", "", "Boryanchik", "Vyache54slavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Account #' field is required.", "", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The phone number must be in the (999)999-9999 format.", "1452368", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "4534", ""},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "The 'Email' field must be a valid email address.", "1452368", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", "fgdfgdgf#grgr.h"},
        };
    }

    @DataProvider(name = "fieldMaxLength")
    public static Object[][] fieldMaxLength(){
        return new Object[][]{
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "account", "87543274", 7},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "firstname", "ihorthirtytwocharactersdsdsdsdsds ", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "lastname", "ihorthirtytwocharactersdsdsdsdsds", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "street", "lisovairtytwocharactersdsdsdsdsds", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "city", "torontortytwocharactersdsdsdsdsds", 32},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "postalcode", "87563432", 7},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "phone", "12345678910", 13},
                {config.getProperty("branch"), config.getProperty("username"), config.getProperty("password"), "email", "thirtytw2ocharacters32@charac.com", 32},



        };
        }
}
