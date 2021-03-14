package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private Date creationDate;
    private Customer customer;
    private ArrayList<ProductsInstance> productsInstances;

    public Invoice(Date creationDate, Customer customer, ArrayList<ProductsInstance> productsInstances) {
        this.creationDate = creationDate;
        this.customer = customer;
        this.productsInstances = productsInstances;
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

    public ArrayList<ProductsInstance> getProducts() {
        return productsInstances;
    }

    public void setProducts(ArrayList<ProductsInstance> productsInstances) {
        this.productsInstances = productsInstances;
    }
}
