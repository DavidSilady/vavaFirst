package controller;

import controller.abstracts.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Context;
import model.interfaces.Listable;
import view.SceneManager;

import java.util.ArrayList;

public class MainPageController extends Controller {

    @FXML
    private AnchorPane freelancersPane;

    private ListingContainerController freelancersController;

    @FXML
    private AnchorPane companiesPane;

    private ListingContainerController companiesController;

    @FXML
    private AnchorPane contractsPane;

    private ListingContainerController contractsController;

    public void init() throws Exception {
        setupFreelancers();
        setupCompanies();
        setupContracts();
    }

    private void setupFreelancers() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(freelancersPane, "listingContainer");
        freelancersController = fxmlLoader.getController();

        ArrayList<Listable> freelancers = new ArrayList<>(Context.getInstance().getFreelancers());
        freelancersController.populate(freelancers, "freelancerListing");
    }

    private void setupCompanies() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(companiesPane, "listingContainer");
        companiesController = fxmlLoader.getController();

        ArrayList<Listable> companies = new ArrayList<>(Context.getInstance().getCompanies());
        companiesController.populate(companies, "TODO");
    }

    private void setupContracts() throws Exception {
        FXMLLoader fxmlLoader = SceneManager.switchDynamicPane(contractsPane, "listingContainer");
        contractsController = fxmlLoader.getController();

        ArrayList<Listable> contracts = new ArrayList<>(Context.getInstance().getContracts());
        contractsController.populate(contracts, "TODO");
    }

    private void updateContracts() throws Exception {
        ArrayList<Listable> contracts = new ArrayList<>(Context.getInstance().getContracts());
        contractsController.update(contracts);
    }

    private void updateCompanies() throws Exception {
        ArrayList<Listable> companies = new ArrayList<>(Context.getInstance().getCompanies());
        companiesController.update(companies);
    }

    private void updateFreelancers() throws Exception {
        ArrayList<Listable> freelancers = new ArrayList<>(Context.getInstance().getFreelancers());
        freelancersController.update(freelancers);
    }

    @FXML
    void addCompany(ActionEvent event) {

    }

    @FXML
    void addContract(ActionEvent event) {

    }

    @FXML
    void addFreelancer(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = SceneManager.newWindow("createFreelancer", 600, 274);
        CreateFreelancerController controller = fxmlLoader.getController();

        controller.setOnCreate(this::updateFreelancers);
    }
}
