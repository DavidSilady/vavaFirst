package model;

import model.interfaces.Listable;

public class ProductsInstance implements Listable {
    private String name;
    private String description;
    private float price;
    private int amount;

    public ProductsInstance(String name, String description, float price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public ProductsInstance(ProductType productType, int amount) {
        this.name = productType.getName();
        this.description = productType.getDescription();
        this.price = productType.getPrice();
        this.amount = amount;
    }

    public ProductsInstance(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
