package model;

import model.interfaces.Listable;

import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Listable {
    private Date creationDate;
    private Customer customer;
    private ArrayList<Listable> productsInstances;

    public Invoice(Date creationDate, Customer customer, ArrayList<Listable> productsInstances) {
        this.creationDate = creationDate;
        this.customer = customer;
        this.productsInstances = productsInstances;
    }

    public Invoice() {
        creationDate = new Date();
        productsInstances = new ArrayList<>();
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

    public ArrayList<Listable> getProducts() {
        return productsInstances;
    }

    public void setProducts(ArrayList<Listable> productsInstances) {
        this.productsInstances = productsInstances;
    }

    public void addProductsInstance(ProductsInstance productsInstance) {
        this.productsInstances.add(productsInstance);
    }
}
