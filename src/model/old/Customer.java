package model.old;

import javafx.util.Pair;
import model.interfaces.*;
import org.json.JSONObject;

import java.util.ArrayList;

public class Customer implements Listable, Passable, Generable, Formable {
    private String name = "";
    private String city = "";
    private String zip = "";
    private String address = "";
    private String password = "";
    private String username = "";

    private ArrayList<Listable> productTypes;
    private ArrayList<Listable> invoices;

    public Customer() { };

    public Customer(String name, String city, String zip, String address, String password, String username) {
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.address = address;
        this.password = password;
        this.username = username;
        this.productTypes = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setJSData(JSONObject data) {
        this.address = data.getString("address");
        this.city = data.getString("city");
        this.zip = data.getString("zip");
        this.name = data.getString("name");
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

    public void deleteProduct(ProductType productType) {
        this.productTypes.remove(productType);
    }

    public void addProductType(ProductType productType) {
        this.productTypes.add(productType);
    }

    public void addInvoice(Invoice invoice) { this.invoices.add(invoice); }

    private Boolean isGay;

    @Override
    public <T extends Comparable<T>> void setProperties(ArrayList<T> properties) {
        int i = 0;
        this.name = (String) properties.get(i++);
        this.city = (String) properties.get(i++);
        this.zip = (String) properties.get(i++);
        this.address = (String) properties.get(i++);
        this.password = (String) properties.get(i++);
        this.username = (String) properties.get(i++);
        this.isGay = (Boolean) properties.get(i);
    }

    @Override
    public ArrayList<Pair<FormableTypes, String>> getPropertyPairs() {
        ArrayList<Pair<FormableTypes, String>> list = new ArrayList<>();
        list.add(new Pair<>(FormableTypes.STRING, "name"));
        list.add(new Pair<>(FormableTypes.STRING, "city"));
        list.add(new Pair<>(FormableTypes.STRING, "zip"));
        list.add(new Pair<>(FormableTypes.STRING, "address"));
        list.add(new Pair<>(FormableTypes.STRING, "password"));
        list.add(new Pair<>(FormableTypes.STRING, "username"));
        return list;
    }
}
