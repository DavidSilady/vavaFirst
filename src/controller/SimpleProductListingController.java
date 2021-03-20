package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import model.ProductsInstance;
import model.interfaces.Listable;


public class SimpleProductListingController extends Controller implements ListablePaneController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label amountLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Text descriptionText;

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        ProductsInstance productsInstance = (ProductsInstance) listing;
        nameLabel.setText(productsInstance.getName());
        amountLabel.setText(Integer.toString(productsInstance.getAmount()));
        priceLabel.setText(Float.toString(productsInstance.getPrice()));
        descriptionText.setText(productsInstance.getDescription());
    }
}
