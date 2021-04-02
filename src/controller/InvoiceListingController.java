package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.old.Invoice;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class InvoiceListingController extends Controller implements ListablePaneController {

    @FXML
    private AnchorPane productListingPane;

    @FXML
    private Label creationDateLabel;

    @FXML
    private Label ownerNameLabel;

    private ListingContainerController listingContainerController;

    private Invoice invoice;

    @Override
    public void fillData(Listable item, ListingContainerController parentContainer) {
        this.invoice = (Invoice) item;
        creationDateLabel.setText(invoice.getCreationDate().toString());
        ownerNameLabel.setText(invoice.getCustomer().getName());
        try {
            setupListingContainer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupListingContainer() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(productListingPane, "listingContainer");
        this.listingContainerController = fxmlLoader.getController();

        listingContainerController.setParameters(525, 125);

        ArrayList<Listable> productTypes = invoice.getProducts();
        listingContainerController.populate(productTypes, "simpleProductInstanceListing");
    }

    private void updateListingContainer() throws Exception {
        ArrayList<Listable> productTypes = invoice.getProducts();
        listingContainerController.update(productTypes);
    }
}
