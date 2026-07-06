package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    @DataProvider(name = "createCustomerWithValidCredentials")
        public static Object[][] createCustomerWithValidCredentials(){
            return new Object[][]{
                    {"Halifax", "admin", "itovt0719", "3493453", "", "Boryanchik", "Vyacheslavvovich", "Lisova 18", "Toronto", "Ontario", "M6B 3y4", "2010054568", "sixteen@char.com"},
                    {"Halifax", "admin", "itovt0719", "1284567", "", "t", "t", "", "", "", "", "", ""},
                    {"Halifax", "admin", "itovt0719", "1224507", "Mr.", "qwertyuiopasdfgh", "qwertyuiopasdruh", "qweqweqweqwewqeqweqweqweqweqweqw", "qweqweqweqwewqeqweqweqweqweqweqw", "Ontario", "M6B 3y4", "`1234567899", "thirtytwocharacters32@charac.com"},
            };
    }
    @DataProvider(name = "createCustomerWithInvalidCredentials")
    public static Object[][] createCustomerWithInvalidCredentials(){
        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "The 'Account #' field is required.", "", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'First Name' field is required.", "1234568", "", "", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Last Name' field is required.", "1234568", "", "Boryanchik", "", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Account #' already exists.", "3493453", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Account #' must be 7 digits long.", "54564", "", "Borygnchik", "Vyachesasvvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Account #' can only contain numbers.", "ghfghfg", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'First Name' can only contain letters and spaces.", "3493483", "", "Boryan44chik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Last Name' can only contain letters and spaces.", "1234987", "", "Boryanchik", "Vyache54slavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The 'Account #' field is required.", "", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", ""},
                {"Halifax", "admin", "itovt0719", "The phone number must be in the (999)999-9999 format.", "1452368", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "4534", ""},
                {"Halifax", "admin", "itovt0719", "The 'Email' field must be a valid email address.", "1452368", "", "Boryanchik", "Vyacheslavvovich", "", "", "", "", "", "fgdfgdgf#grgr.h"},
        };
    }

    @DataProvider(name = "fieldMaxLength")
    public static Object[][] fieldMaxLength(){
        return new Object[][]{
                {"Halifax", "admin", "itovt0719", "account", "87543274", 7},
                {"Halifax", "admin", "itovt0719", "firstname", "ihorthirtytwocharactersdsdsdsdsds ", 32},
                {"Halifax", "admin", "itovt0719", "lastname", "ihorthirtytwocharactersdsdsdsdsds", 32},
                {"Halifax", "admin", "itovt0719", "street", "lisovairtytwocharactersdsdsdsdsds", 32},
                {"Halifax", "admin", "itovt0719", "city", "torontortytwocharactersdsdsdsdsds", 32},
                {"Halifax", "admin", "itovt0719", "postalcode", "87563432", 7},
                {"Halifax", "admin", "itovt0719", "phone", "12345678910", 13},
                {"Halifax", "admin", "itovt0719", "email", "thirtytw2ocharacters32@charac.com", 32},



        };
        }
}
