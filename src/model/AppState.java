package model;

import model.interfaces.Listable;

import java.util.ArrayList;

public class AppState {
    private static AppState instance = null;
    private static final Boolean DEBUG = true;
    private AppState() {
        this.customers = new ArrayList<>();
    };

    private ArrayList<Listable> customers;

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


}
