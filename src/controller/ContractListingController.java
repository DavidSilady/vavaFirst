package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import model.Context;
import model.Contract;
import model.interfaces.Listable;
import model.users.Freelancer;
import view.SceneManager;

public class ContractListingController extends Controller implements ListablePaneController {

    @FXML
    private AnchorPane companyPane;

    @FXML
    private ComboBox<Freelancer> contractorsComboBox;

    @FXML
    void deleteContract(ActionEvent event) {

    }

    @FXML
    void removeSelected(ActionEvent event) {

    }

    Contract contract;

    ListingContainerController parentContainer;

    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        contract = (Contract) listing;
        this.parentContainer = parentContainer;

        try {
            FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(companyPane, "companyListing");
            CompanyListingController controller = fxmlLoader.getController();
            controller.fillData(contract.getCompany(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        contractorsComboBox.setConverter(new StringConverter<Freelancer>() {
            @Override
            public String toString(Freelancer object) {
                return object.getName();
            }
            @Override
            public Freelancer fromString(String string) {
                return null;
            }
        });
        ObservableList<Freelancer> freelancers = FXCollections.observableArrayList(Context.getInstance().getFreelancers());
        contractorsComboBox.setItems(freelancers);
    }
}
