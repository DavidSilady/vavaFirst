package model;

import model.interfaces.Listable;

import java.awt.*;

public class ProductType implements Listable {
    private String name;
    private String description;
    private float price;

    public ProductType(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductType() {
    }

    public ProductsInstance generateInstances(int amount) {
        return new ProductsInstance(
                this.name,
                this.description,
                this.price,
                amount
        );
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
}
