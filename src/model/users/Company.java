package model.users;

import javafx.scene.image.Image;
import model.Contract;
import model.interfaces.Listable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Company implements Listable {
    private String name;
    private String domain;
    private int numEmployees;
    private Image logo;
    private ArrayList<Contract> contracts;

    public Company(String name, String domain, int numEmployees, Image logo) {
        this.contracts = new ArrayList<>();
        this.name = name;
        this.domain = domain;
        this.numEmployees = numEmployees;
        this.logo = logo;
    }

    public Company() {
        this.contracts = new ArrayList<>();
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void removeContract(Contract contract) {
        contracts.remove(contract);
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }
}
