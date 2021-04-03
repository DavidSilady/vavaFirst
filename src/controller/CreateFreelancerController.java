package controller;

import controller.abstracts.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Context;
import model.enums.FreelancerTypes;
import model.users.Administrator;
import model.users.Freelancer;
import model.users.Programmer;
import model.users.SecuritySpecialist;

import java.util.ArrayList;

public class CreateFreelancerController extends Controller {

    public interface FunctionalHandler { void execute() throws Exception; }

    private FunctionalHandler onCreate = () -> {};

    @FXML
    private TextField priceField;

    @FXML
    private TextField experienceField;

    @FXML
    private TextField educationField;

    @FXML
    private TextField certificateField;

    @FXML
    private ComboBox<String> certificateComboBox;

    @FXML
    private ComboBox<FreelancerTypes> professionComboBox;

    @FXML
    private TextField programmerLanguageField;

    @FXML
    private TextField adminTypeField;

    @FXML
    private TextField adminPlatformField;

    @FXML
    private TextField nameField;

    @FXML
    private CheckBox securityAuditorCheckbox;

    private ObservableList<String> certificates;

    public void setOnCreate(FunctionalHandler callback) {
        this.onCreate = callback;
    }

    public void init() throws Exception {
        certificates = FXCollections.observableArrayList();
        professionComboBox.setItems(FXCollections.observableArrayList(FreelancerTypes.ADMINISTRATOR, FreelancerTypes.PROGRAMMER, FreelancerTypes.SECURITY_SPECIALIST));
    }

    @FXML
    void addCertificate(ActionEvent event) {
        String certificateText = certificateField.getText();
        certificates.add(certificateText);
        certificateComboBox.setItems(certificates);
    }

    @FXML
    void createEntity(ActionEvent event) throws Exception {
        Freelancer freelancer = null;
        if (professionComboBox.getValue() == FreelancerTypes.ADMINISTRATOR) {
            freelancer = createAdmin();
        } else if (professionComboBox.getValue() == FreelancerTypes.PROGRAMMER) {
            freelancer = createProgrammer();
        } else if (professionComboBox.getValue() == FreelancerTypes.SECURITY_SPECIALIST) {
            freelancer = createSecurity();
        }
        if (freelancer != null) {
            Context.getInstance().addFreelancer(freelancer);
            onCreate.execute();
            ((Stage) professionComboBox.getScene().getWindow()).close();
        }
    }

    private Freelancer createSecurity() {
        try {
            return new SecuritySpecialist(
                    nameField.getText(),
                    Float.parseFloat(priceField.getText()),
                    Float.parseFloat(experienceField.getText()),
                    educationField.getText(),
                    new ArrayList<>(certificates),
                    securityAuditorCheckbox.isSelected()
            );
        } catch (Exception e) {
            return null;
        }
    }

    private Freelancer createProgrammer() {
        try {
            return new Programmer(
                    nameField.getText(),
                    Float.parseFloat(priceField.getText()),
                    Float.parseFloat(experienceField.getText()),
                    educationField.getText(),
                    new ArrayList<>(certificates),
                    programmerLanguageField.getText()
            );
        } catch (Exception e) {
            return null;
        }

    }

    private Freelancer createAdmin() {
        try {
            return new Administrator(
                    nameField.getText(),
                    Float.parseFloat(priceField.getText()),
                    Float.parseFloat(experienceField.getText()),
                    educationField.getText(),
                    new ArrayList<>(certificates),
                    adminTypeField.getText(),
                    adminPlatformField.getText()
            );
        } catch (Exception e) {
            return null;
        }

    }

    private void resetProfessionVisibility() {
        programmerLanguageField.setVisible(false);
        adminPlatformField.setVisible(false);
        adminTypeField.setVisible(false);
        securityAuditorCheckbox.setVisible(false);
    }

    @FXML
    void handleProfessionChange(ActionEvent event) {
        resetProfessionVisibility();
        if (professionComboBox.getValue() == FreelancerTypes.ADMINISTRATOR) {
            adminPlatformField.setVisible(true);
            adminTypeField.setVisible(true);
        } else if (professionComboBox.getValue() == FreelancerTypes.PROGRAMMER) {
            programmerLanguageField.setVisible(true);
        } else if (professionComboBox.getValue() == FreelancerTypes.SECURITY_SPECIALIST) {
            securityAuditorCheckbox.setVisible(true);
        }
    }

}
