package model.users;

import java.util.ArrayList;

public class Programmer extends Freelancer{
    private String type;

    public Programmer(String name, float pricePerDay, float experienceInMonths, String mostRelevantEducation, ArrayList<String> certificates, String type) {
        super(name, pricePerDay, experienceInMonths, mostRelevantEducation, certificates);
        this.type = type;
    }

    public Programmer() {super();}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
