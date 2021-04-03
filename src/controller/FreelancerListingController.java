package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.interfaces.Listable;
import model.users.Administrator;
import model.users.Freelancer;
import model.users.Programmer;
import model.users.SecuritySpecialist;

public class FreelancerListingController extends Controller implements ListablePaneController {

    @FXML
    public Label profession;

    @FXML
    private Label priceLabel;

    @FXML
    private Label experienceLabel;

    @FXML
    private Label educationLabel;

    @FXML
    private Label availableLabel;

    @FXML
    private ComboBox<String> certificatesComboBox;

    @FXML
    private Label adminType;

    @FXML
    private Label adminTypeLabel;

    @FXML
    private Label adminPlatform;

    @FXML
    private Label adminPlatformLabel;

    @FXML
    private Label programmerLanguage;

    @FXML
    private Label programmerLanguageLabel;

    @FXML
    private Label securityAuditor;

    @FXML
    private Label securityAuditorLabel;

    ListingContainerController parentContainer;

    Freelancer freelancer;

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.freelancer = (Freelancer) listing;
        this.parentContainer = parentContainer;
        fillGenericData();
        fillDataBasedOnClass();
    }

    private void fillDataBasedOnClass() {
        if (freelancer instanceof Programmer) {
            fillProgrammerData();
        } else if (freelancer instanceof Administrator) {
            fillAdministratorData();
        } else if (freelancer instanceof SecuritySpecialist) {
            fillSecuritySpecialistData();
        }
    }

    private void fillProgrammerData() {
        Programmer programmer = (Programmer) freelancer;
        programmerLanguageLabel.setVisible(true);
        programmerLanguage.setVisible(true);
        programmerLanguageLabel.setText(programmer.getType());

        profession.setText("PROGRAMMER");
    }

    private void fillAdministratorData() {
        Administrator administrator = (Administrator) freelancer;
        adminPlatform.setVisible(true);
        adminType.setVisible(true);
        adminPlatformLabel.setVisible(true);
        adminTypeLabel.setVisible(true);
        adminPlatformLabel.setText(administrator.getPreferredPlatform());
        adminTypeLabel.setText(administrator.getType());

        profession.setText("ADMINISTRATOR");
    }

    private void fillSecuritySpecialistData() {
        SecuritySpecialist securitySpecialist = (SecuritySpecialist) freelancer;
        securityAuditor.setVisible(true);
        securityAuditorLabel.setVisible(true);
        securityAuditorLabel.setText(Boolean.toString(securitySpecialist.isNbuAuditor()));

        profession.setText("SECURITY SPECIALIST");
    }

    private void fillGenericData() {
        priceLabel.setText(Float.toString(freelancer.getPricePerDay()));
        experienceLabel.setText(Float.toString(freelancer.getExperienceInMonths()));
        educationLabel.setText(freelancer.getMostRelevantEducation());
        availableLabel.setText(Boolean.toString(freelancer.isContracted()));

        ObservableList<String> certificates = FXCollections.observableArrayList(freelancer.getCertificates());
        certificatesComboBox.setItems(certificates);
    }
}
