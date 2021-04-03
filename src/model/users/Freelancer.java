package model.users;

import model.Context;
import model.Contract;
import model.interfaces.Listable;

import java.util.ArrayList;

public abstract class Freelancer implements Listable {
    private String name;

    private float pricePerDay;
    private float experienceInMonths;
    private String mostRelevantEducation;
    private ArrayList<String> certificates;
    private Contract contract;

    public Freelancer(float pricePerDay, float experienceInMonths, String mostRelevantEducation, ArrayList<String> certificates) {
        this.pricePerDay = pricePerDay;
        this.experienceInMonths = experienceInMonths;
        this.mostRelevantEducation = mostRelevantEducation;
        this.certificates = certificates;
    }

    public Freelancer(String name, float pricePerDay, float experienceInMonths, String mostRelevantEducation, ArrayList<String> certificates) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.experienceInMonths = experienceInMonths;
        this.mostRelevantEducation = mostRelevantEducation;
        this.certificates = certificates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Freelancer() {}

    public Boolean isContracted() {
        return ! (contract == null);
    }

    public void quitContract() {
        contract.removeEmployee(this);
        contract = null;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getExperienceInMonths() {
        return experienceInMonths;
    }

    public void setExperienceInMonths(float experienceInMonths) {
        this.experienceInMonths = experienceInMonths;
    }

    public String getMostRelevantEducation() {
        return mostRelevantEducation;
    }

    public void setMostRelevantEducation(String mostRelevantEducation) {
        this.mostRelevantEducation = mostRelevantEducation;
    }

    public ArrayList<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<String> certificates) {
        this.certificates = certificates;
    }
}
