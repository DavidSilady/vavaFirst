package model;

import java.util.ArrayList;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        this.customers = new ArrayList<>();
        this.productsInstances = new ArrayList<>();
        this.invoices = new ArrayList<>();
    };

    private ArrayList<Customer> customers;
    private ArrayList<ProductsInstance> productsInstances;
    private ArrayList<Invoice> invoices;
    private Customer activeUser;

    public static void debug(String output) {
        if (DEBUG) {
            System.out.println(output);
        }
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

    public ArrayList<ProductsInstance> getProducts() {
        return productsInstances;
    }

    public void setProducts(ArrayList<ProductsInstance> productsInstances) {
        this.productsInstances = productsInstances;
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

    private void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Boolean registerCustomer(Customer newCustomer) {
        for (Customer customer : this.customers) {
            if (customer.getUsername().equals(newCustomer.getUsername())) {
                return false;
            }
        }
        addCustomer(newCustomer);
        return true;
    }

    public Boolean verifyLogin(String username, String password) {
        for (Customer customer : this.customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                this.activeUser = customer;
                return true;
            }
        }
        return false;
    }
}
