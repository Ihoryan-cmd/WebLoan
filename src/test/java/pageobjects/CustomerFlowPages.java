package pageobjects;

public class CustomerFlowPages {
    public CustomersPage customers;
    public AddCustomerPage addCustomer;

    public CustomerFlowPages(CustomersPage customers, AddCustomerPage addCustomer) {
        this.customers = customers;
        this.addCustomer = addCustomer;
    }
}