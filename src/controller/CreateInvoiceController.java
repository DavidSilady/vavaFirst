package controller;

import controller.abstracts.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.AppState;
import model.Invoice;
import model.ProductType;
import model.ProductsInstance;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;


public class CreateInvoiceController extends Controller {

    public Button addToInvoiceButton;

    public interface FunctionalHandler { void execute() throws Exception; }

    private FunctionalHandler onExit = () -> {};

    private Invoice invoice;

    private ListingContainerController listingContainerController;

    @Override
    public void init() throws Exception {
        invoice = new Invoice();
        setupProductsComboBox();
        setupAmountField();
        setupListingContainer();
    }

    private void setupListingContainer() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(productListingPane, "listingContainer");
        this.listingContainerController = fxmlLoader.getController();

        listingContainerController.setParameters(525, 215);

        ArrayList<Listable> productTypes = invoice.getProducts();
        listingContainerController.populate(productTypes, "simpleProductInstanceListing");
    }

    private void updateListingContainer() throws Exception {
        ArrayList<Listable> productTypes = invoice.getProducts();
        listingContainerController.update(productTypes);
    }

    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> cast(ArrayList list) {
        return list;
    }

    private void setupProductsComboBox() {
        ArrayList<Listable> productTypes = AppState.getInstance().getActiveUser().getProducts();
        productsDropdown.setConverter(new StringConverter<ProductType>() {
            @Override
            public String toString(ProductType object) {
                return object.getName();
            }
            @Override
            public ProductType fromString(String string) {
                return null;
            }
        });
        productsDropdown.setItems(FXCollections.observableArrayList(
                cast(productTypes)
        ));
    }

    private void setupAmountField() {
        amountField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    amountField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (amountField.getText().matches("^0.*")) {
                    amountField.setText("");
                }
            }
        });
    }

    @FXML
    private Button createButton;

    @FXML
    private AnchorPane productListingPane;

    @FXML
    private ComboBox<ProductType> productsDropdown;

    @FXML
    private TextField amountField;

    private boolean isValidInput() {
        return productsDropdown.getValue() != null && !amountField.getText().equals("");
    }

    @FXML
    void handleAddProduct(ActionEvent event) throws Exception {
        if (isValidInput()) {
            invoice.addProductsInstance(
                    new ProductsInstance(
                            productsDropdown.getValue(),
                            Integer.parseInt(amountField.getText())
                    )
            );
            updateListingContainer();
        }
    }

    @FXML
    void createAndExit(ActionEvent event) throws Exception {
        AppState.getInstance().getActiveUser().addInvoice(new Invoice());
        onExit.execute();
        ((Stage) createButton.getScene().getWindow()).close();
    }

    protected void setOnExit(FunctionalHandler handler) {
        this.onExit = handler;
    }
}
