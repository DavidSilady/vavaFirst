package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.AppState;
import model.Customer;
import model.ProductType;
import model.interfaces.Listable;
import view.SceneManager;

public class ProductTypeEditListingController extends Controller implements ListablePaneController {
    @FXML
    public TextField nameField;
    @FXML
    public TextField priceField;
    @FXML
    public TextArea descriptionArea;
    @FXML
    public Button updateButton;
    @FXML
    public Button deleteButton;

    private ProductType productType;

    @Override
    public void fillData(Listable item, ListingContainerController parentContainer) {
        productType = (ProductType) item;
        nameField.setText(productType.getName());
        priceField.setText(Float.toString(productType.getPrice()));
        descriptionArea.setText(productType.getDescription());
    }

    @FXML
    public void updateProduct(ActionEvent actionEvent) {
        productType.setDescription(descriptionArea.getText());
        productType.setName(nameField.getText());
        productType.setPrice(Float.parseFloat(priceField.getText()));
    }

    @FXML
    public void deleteProduct(ActionEvent actionEvent) {
        AppState.getInstance().deleteProduct(productType);
    }
}
