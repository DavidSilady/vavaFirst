package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.AppState;
import model.Invoice;


public class CreateInvoiceController extends Controller {

    private interface MyFunctionalInterface { void execute() throws Exception; }

    private MyFunctionalInterface onExit = () -> {};

    @Override
    public void init() throws Exception {
//        AppState.getInstance().getActiveUser().addInvoice(new Invoice());
//        onExit.execute();
    }

    @FXML
    private Button createButton;

    @FXML
    void createAndExit(ActionEvent event) throws Exception {
        AppState.getInstance().getActiveUser().addInvoice(new Invoice());
        onExit.execute();
        ((Stage) createButton.getScene().getWindow()).close();
    }

    protected void setOnExit(MyFunctionalInterface handler) {
        this.onExit = handler;
    }
}
