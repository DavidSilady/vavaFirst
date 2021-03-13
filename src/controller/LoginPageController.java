package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.AppState;
import model.Customer;

public class LoginPageController {

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
    void onLogin(ActionEvent event) {
        if (AppState.getInstance().verifyLogin(
                loginUsernameField.getText(),
                loginPasswordField.getText()
        )) {
            AppState.debug("Logged in.");
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

