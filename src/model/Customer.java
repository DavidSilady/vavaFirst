package model;

import model.interfaces.Generable;
import model.interfaces.Listable;
import model.interfaces.Passable;
import org.json.JSONObject;

public class Customer implements Listable, Passable, Generable {
    private String name = "";
    private String city = "";
    private String zip = "";
    private String address = "";
    private String password = "";
    private String username = "";

    public Customer() { };

    public Customer(String name, String city, String zip, String address, String password, String username) {
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.address = address;
        this.password = password;
        this.username = username;
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
}