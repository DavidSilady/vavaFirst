package model;

import model.interfaces.Listable;

import java.util.ArrayList;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        this.customers = new ArrayList<>();
        this.productTypes = new ArrayList<>();
        this.invoices = new ArrayList<>();
    };

    private ArrayList<Listable> customers;
    private ArrayList<Listable> productTypes;
    private ArrayList<Listable> invoices;
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

    public ArrayList<Listable> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Listable> customers) {
        this.customers = customers;
    }

    public ArrayList<Listable> getProducts() {
        return productTypes;
    }

    public void setProducts(ArrayList<Listable> productsInstances) {
        this.productTypes = productsInstances;
    }

    public ArrayList<Listable> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Listable> invoices) {
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
        for (Listable item : this.customers) {
            Customer customer = (Customer) item;
            if (customer.getUsername().equals(newCustomer.getUsername())) {
                return false;
            }
        }
        addCustomer(newCustomer);
        return true;
    }

    public Boolean verifyLogin(String username, String password) {
        for (Listable item : this.customers) {
            Customer customer = (Customer) item;
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                this.activeUser = customer;
                return true;
            }
        }
        return false;
    }

    public void deleteProduct(ProductType productType) {
        this.productTypes.remove(productType);
    }

    public void addProductType(ProductType productType) {
        this.productTypes.add(productType);
    }
}
