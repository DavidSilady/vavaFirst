package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import model.AppState;
import model.Customer;
import view.SceneManager;

public class LoginPageController extends Controller {

    @FXML
    private TextField loginUsernameField;

    @FXML
    private TextField regUsernameField;

    @FXML
    private TextField regFullNameField;

    @FXML
    private TextField regAddressField;

    @FXML
    private TextField regCityField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private TextField regZipField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    public void init() {
    }

    @FXML
    void onLogin(ActionEvent event) throws Exception {
        if (AppState.getInstance().verifyLogin(
                loginUsernameField.getText(),
                loginPasswordField.getText()
        )) {
            AppState.debug("Logged in.");
            SceneManager.switchScene(event, "mainPage");
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    void onRegister(ActionEvent event) {
        Customer customer = new Customer(
                regFullNameField.getText(),
                regCityField.getText(),
                regZipField.getText(),
                regAddressField.getText(),
                regPasswordField.getText(),
                regUsernameField.getText()
        );
        AppState.getInstance().addCustomer(customer);
        AppState.debug("User registered.");
    }

}

