package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Context;
import model.users.Company;

import java.io.File;

public class CreateCompanyController extends Controller {

    public interface FunctionalHandler { void execute() throws Exception; }

    private CreateFreelancerController.FunctionalHandler onCreate = () -> {};

    public void setOnCreate(CreateFreelancerController.FunctionalHandler callback) {
        this.onCreate = callback;
    }

    @FXML
    private TextField nameField;

    @FXML
    private TextField domainField;

    @FXML
    private TextField employeesField;

    @FXML
    private Button createButton;

    private String imageURL = "";

    private Boolean isValidInput() {
        Boolean output = true;
        if (nameField.getText().equals("")) {
            return false;
        }
        if (domainField.getText().equals("")) {
            return false;
        }
        if (imageURL.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(employeesField.getText());
        } catch (Exception e) {
            output = false;
        }
        return output;
    }

    @FXML
    void createEntity(ActionEvent event) throws Exception {
        if (isValidInput()) {
            Context.getInstance().addCompany(
                    new Company(
                            nameField.getText(),
                            domainField.getText(),
                            Integer.parseInt(employeesField.getText()),
                            new Image(imageURL)
                    )
            );
            onCreate.execute();
            ((Stage) createButton.getScene().getWindow()).close();
        }
    }

    @FXML
    void selectLogo(ActionEvent event) {
        Stage stage = (Stage) createButton.getScene().getWindow();
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            imageURL = file.toURI().toString();
        }
    }

}
