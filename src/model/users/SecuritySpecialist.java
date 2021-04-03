package model.users;


import java.util.ArrayList;

public class SecuritySpecialist extends Freelancer {
    private Boolean isNbuAuditor;

    public SecuritySpecialist(String name, float pricePerDay, float experienceInMonths, String mostRelevantEducation, ArrayList<String> certificates, Boolean isNbuAuditor) {
        super(name, pricePerDay, experienceInMonths, mostRelevantEducation, certificates);
        this.isNbuAuditor = isNbuAuditor;
    }

    public SecuritySpecialist() {super();}

    public Boolean isNbuAuditor() {
        return isNbuAuditor;
    }

    public void setNbuAuditor(Boolean nbuAuditor) {
        isNbuAuditor = nbuAuditor;
    }
}
