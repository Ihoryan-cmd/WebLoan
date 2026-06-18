package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    @DataProvider(name = "Create Customer")
        public static Object[][] createCustomer(){

            return new Object[][]{
                    {"Halifax", "admin", "itovt0719", "3453453", "Boryan", "Vyacheslavovich", ""},
                    {"Halifax", "admin", "itovt0719", "", "Boryn", "Vyacheslavovih", "The 'Account #' field is required."},
                    {"Halifax", "admin", "itovt0719", "3653453", "", "Vyachslavovich", "The 'First Name' field is required."},
                    {"Halifax", "admin", "itovt0719", "3453153", "Boyan", "", "The 'Last Name' field is required."},
            };
    }
}
