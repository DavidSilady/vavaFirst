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

public class ProfilePaneController extends Controller {
    @FXML
    private TextField regUsernameField;

    @FXML
    private TextField regFullNameField;

    @FXML
    private TextField regAddressField;

    @FXML
    private TextField regCityField;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private TextField regZipField;

    @FXML
    private Button updateButton;

    @FXML
    private PasswordField regPasswordField1;

    @FXML
    private Button updateButton1;

    @FXML
    private Label passwordStatusLabel;

    @FXML
    private Label profileStatusLabel;

    @FXML
    void handlePasswordUpdate(ActionEvent event) {
        String password = regPasswordField.getText();
        String passwordConfirmation = regPasswordField1.getText();
        if (password.equals(passwordConfirmation) && ! password.equals("")) {
            Context.getInstance().getActiveUser().setPassword(password);
            passwordStatusLabel.setText("Password changed.");
        } else {
            passwordStatusLabel.setText("Passwords did not match.");
        }
    }

    @FXML
    void handleProfileUpdate(ActionEvent event) {
        if (isValidInput()) {
            Customer user = Context.getInstance().getActiveUser();
            user.setAddress(regAddressField.getText());
            user.setCity(regCityField.getText());
            user.setUsername(regUsernameField.getText());
            user.setName(regFullNameField.getText());
            user.setZip(regZipField.getText());
        }
    }

    private boolean isValidInput() {
        if (
                regFullNameField.getText().equals("")
                        || regCityField.getText().equals("")
                        || regZipField.getText().equals("")
                        || regAddressField.getText().equals("")
        ) {
            return false;
        }
        return true;
    }

    public void init() throws Exception {
        Customer user = Context.getInstance().getActiveUser();
        regAddressField.setText(user.getAddress());
        regCityField.setText(user.getCity());
        regZipField.setText(user.getZip());
        regFullNameField.setText(user.getName());
        regUsernameField.setText(user.getUsername());
    }
}
