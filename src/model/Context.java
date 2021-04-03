package model;

import model.interfaces.Listable;
import model.old.Customer;
import model.users.Company;
import model.users.Freelancer;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private static Context instance = null;
    private static final Boolean DEBUG = true;
    private Context() {
        this.freelancers = new ArrayList<>();
        this.companies = new ArrayList<>();
        this.contracts = new ArrayList<>();
    }

    private ArrayList<Freelancer> freelancers;
    private ArrayList<Company> companies;
    private ArrayList<Contract> contracts;

    private Company activeCompany;

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public ArrayList<Freelancer> getFreelancers() {
        return freelancers;
    }

    public ArrayList<Listable> getListableFreelancers() {
        return new ArrayList<>(freelancers);
    }

    public void setFreelancers(ArrayList<Freelancer> freelancers) {
        this.freelancers = freelancers;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public Company getActiveCompany() {
        return activeCompany;
    }

    public void setActiveCompany(Company activeCompany) {
        this.activeCompany = activeCompany;
    }

    public static void debug(String output) {
        if (DEBUG) {
            System.out.println(output);
        }
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public void addFreelancer(Freelancer freelancer) {
        freelancers.add(freelancer);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }
}
