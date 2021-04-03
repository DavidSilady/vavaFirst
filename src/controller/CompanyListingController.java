package controller;

import controller.abstracts.Controller;
import controller.interfaces.ListablePaneController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.interfaces.Listable;
import model.users.Company;

import java.util.List;

public class CompanyListingController extends Controller implements ListablePaneController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label domainLabel;

    @FXML
    private Label employeesLabel;

    @FXML
    private ImageView logoImageView;

    private Company company;

    private ListingContainerController parentContainer;
    @Override
    public void fillData(Listable listing, ListingContainerController parentContainer) {
        this.company = (Company) listing;
        this.parentContainer = parentContainer;

        nameLabel.setText(company.getName());
        domainLabel.setText(company.getDomain());
        employeesLabel.setText(Integer.toString(company.getNumEmployees()));
        logoImageView.setImage(company.getLogo());
    }
}
