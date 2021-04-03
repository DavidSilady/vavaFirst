package model;

import model.interfaces.Listable;
import model.users.Company;
import model.users.Freelancer;

import java.util.ArrayList;

public class Contract implements Listable {
    private Company company;
    private ArrayList<Freelancer> employees;

    public Contract(Company company, ArrayList<Freelancer> employees) {
        this.company = company;
        this.employees = employees;
    }

    public Contract() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Freelancer> getEmployees() {
        return employees;
    }

    public ArrayList<Listable> getListableEmployees() {
        return new ArrayList<>(employees);
    }

    public void setEmployeesFromListable(ArrayList<Listable> listableFreelancers) {
        ArrayList<Freelancer> converted = new ArrayList<>();
        for (Listable freelancer : listableFreelancers) {
            converted.add((Freelancer) freelancer);
        }
        this.employees = converted;
    }

    public void setEmployees(ArrayList<Freelancer> employees) {
        this.employees = employees;
    }

    public void removeEmployee(Freelancer freelancer) {
        employees.remove(freelancer);
    }

    public void nullify() {
        for (Freelancer employee : employees) {
            employee.quitContract();
        }
        company.removeContract(this);
        company = null;
        Context.getInstance().getContracts().remove(this);
    }
}
