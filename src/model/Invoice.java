package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private Date creationDate;
    private Customer customer;
    private ArrayList<Product> products;

    public Invoice(Date creationDate, Customer customer, ArrayList<Product> products) {
        this.creationDate = creationDate;
        this.customer = customer;
        this.products = products;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
