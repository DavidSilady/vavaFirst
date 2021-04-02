package model.users;

import java.util.ArrayList;

public class Administrator extends Freelancer {
    private String type;
    private String preferredPlatform;

    public Administrator(float pricePerDay, float experienceInMonths, String mostRelevantEducation, ArrayList<String> certificates, String type, String preferredPlatform) {
        super(pricePerDay, experienceInMonths, mostRelevantEducation, certificates);
        this.type = type;
        this.preferredPlatform = preferredPlatform;
    }

    public Administrator() {super();}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPreferredPlatform() {
        return preferredPlatform;
    }

    public void setPreferredPlatform(String preferredPlatform) {
        this.preferredPlatform = preferredPlatform;
    }
}
