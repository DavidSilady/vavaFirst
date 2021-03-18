package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.AppState;
import model.ProductType;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class ProductsPaneController extends Controller {

    @FXML
    private Button newProductButton;

    @FXML
    private AnchorPane dynamicPane;

    private ListingContainerController listingContainerController;

    @FXML
    void createNewProduct(ActionEvent event) throws Exception {
        AppState.getInstance().addProductType(new ProductType());
        updateListingContainer();
    }

    public void init() throws Exception {
        setupListingContainer();
    }

    private void setupListingContainer() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(dynamicPane, "listingContainer");
        this.listingContainerController = fxmlLoader.getController();

        listingContainerController.setParameters(1110, 530);

        ArrayList<Listable> productTypes = AppState.getInstance().getProducts();
        listingContainerController.populate(productTypes, "");
    }

    private void updateListingContainer() throws Exception {
        ArrayList<Listable> productTypes = AppState.getInstance().getProducts();
        listingContainerController.update(productTypes);
    }
}
