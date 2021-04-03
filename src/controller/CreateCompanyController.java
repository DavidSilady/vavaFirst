package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @FXML
    void createEntity(ActionEvent event) throws Exception {
        onCreate.execute();
        ((Stage) createButton.getScene().getWindow()).close();
    }

    @FXML
    void selectLogo(ActionEvent event) {

    }

}
