package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Context;
import model.old.Customer;
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

    @FXML Label regStatusLabel;

    public void init() { }

    @FXML
    void onLogin(ActionEvent event) throws Exception {
        if (Context.getInstance().verifyLogin(
                loginUsernameField.getText(),
                loginPasswordField.getText()
        )) {
            Context.debug("Logged in.");
            SceneManager.switchScene(event, "mainPage");
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    private boolean isValidInput() {
        if (
                regFullNameField.getText().equals("")
                || regCityField.getText().equals("")
                || regZipField.getText().equals("")
                || regAddressField.getText().equals("")
                || regPasswordField.getText().equals("")
        ) {
            return false;
        }
        return true;
    }

    @FXML
    void onRegister(ActionEvent event) {
        if (isValidInput()) {
            Customer customer = new Customer(
                    regFullNameField.getText(),
                    regCityField.getText(),
                    regZipField.getText(),
                    regAddressField.getText(),
                    regPasswordField.getText(),
                    regUsernameField.getText()
            );
            if (Context.getInstance().registerCustomer(customer)) {
                regStatusLabel.setText("Registration complete.");
                Context.debug("User registered.");
            } else {
                regStatusLabel.setText("Username already taken. Choose a different username.");
            }
        } else {
            regStatusLabel.setText("All fields are required.");
        }
    }
}

