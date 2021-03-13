package model;

import java.util.ArrayList;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.invoices = new ArrayList<>();
    };

    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Invoice> invoices;
    private Customer activeUser;

    public static void debug(String output) {
        if (DEBUG) {
            System.out.println(output);
        }
        System.out.println("DEBUG ///");
    }

    public Customer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Customer activeUser) {
        this.activeUser = activeUser;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }



    public Boolean verifyLogin(String username, String password) {
        for (Customer customer : this.customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
