package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Context;
import model.old.ProductType;
import model.interfaces.Listable;

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

    private ListingContainerController parentContainerController;

    private boolean isValidInput() {
        if (!priceField.getText().matches("^[0-9]*\\.?[0-9]*$")) {
            return false;
        }
        return true;
    }

    @Override
    public void fillData(Listable item, ListingContainerController parentContainerController) {
        this.parentContainerController = parentContainerController;
        productType = (ProductType) item;
        fillOutTextFields();
    }

    private void fillOutTextFields() {
        nameField.setText(productType.getName());
        priceField.setText(Float.toString(productType.getPrice()));
        descriptionArea.setText(productType.getDescription());
    }

    @FXML
    public void updateProduct(ActionEvent actionEvent) {
        if (isValidInput()) {
            productType.setDescription(descriptionArea.getText());
            productType.setName(nameField.getText());
            productType.setPrice(Float.parseFloat(priceField.getText()));
        }
        fillOutTextFields();
    }

    @FXML
    public void deleteProduct(ActionEvent actionEvent) throws Exception {
        Context context = Context.getInstance();
        context.getActiveUser().deleteProduct(productType);
        parentContainerController.update(context.getActiveUser().getProducts());
    }
}
