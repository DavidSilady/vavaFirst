package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.AppState;
import model.Invoice;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class InvoicesPaneController extends Controller {

    @FXML
    private AnchorPane dynamicPane;

    @FXML
    private Button createInvoiceButton;

    private ListingContainerController listingContainerController;

    @FXML
    void createInvoice(ActionEvent event) throws Exception {
        openInvoiceCreationWindow();
        updateListingContainer();
    }

    @Override
    public void init() throws Exception {
        setupListingContainer();
        updateListingContainer();
    }

    private void openInvoiceCreationWindow() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.newWindow("createInvoice", 400, 400);
        CreateInvoiceController controller = fxmlLoader.getController();;
        controller.setOnExit(this::updateListingContainer);
    }

    private void setupListingContainer() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "listingContainer");
        this.listingContainerController = fxmlLoader.getController();

        listingContainerController.setParameters(1110, 530);

        ArrayList<Listable> invoices = AppState.getInstance().getActiveUser().getInvoices();
        listingContainerController.populate(invoices, "invoiceListing");
    }

    private void updateListingContainer() throws Exception {
        ArrayList<Listable> invoices = AppState.getInstance().getActiveUser().getInvoices();
        listingContainerController.update(invoices);
    }
}
