package controller;

import controller.abstracts.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;
import model.Context;
import model.Contract;
import model.users.Company;
import model.users.Freelancer;

import java.util.ArrayList;

public class CreateContractController extends Controller {

    public interface FunctionalHandler { void execute() throws Exception; }

    private FunctionalHandler onCreate = () -> {};
    public void setOnCreate(FunctionalHandler callback) {
        onCreate = callback;
    }

    @FXML
    private ComboBox<Company> companyComboBox;

    @FXML
    private ComboBox<Freelancer> contractorsComboBox;

    @FXML
    private ComboBox<Freelancer> freelancersComboBox;

    @FXML
    private Button createButton;

    public void init() throws Exception {
        contractors = new ArrayList<>();
        setupComboBoxViews();
        companyComboBox.setItems(FXCollections.observableArrayList(
                Context.getInstance().getCompanies()
        ));
        setupFreelancers();
    }

    private void setupFreelancers() {
        ArrayList<Freelancer> freelancers = Context.getInstance().getFreelancers();
        ObservableList<Freelancer> observableFreelancers = FXCollections.observableArrayList();
        for (Freelancer freelancer : freelancers) {
            if (! freelancer.isContracted()) {
                observableFreelancers.add(freelancer);
            }
        }
        freelancersComboBox.setItems(observableFreelancers);
    }

    private void setupComboBoxViews() {
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
        freelancersComboBox.setConverter(new StringConverter<Freelancer>() {
            @Override
            public String toString(Freelancer object) {
                return object.getName();
            }
            @Override
            public Freelancer fromString(String string) {
                return null;
            }
        });
        companyComboBox.setConverter(new StringConverter<Company>() {
            @Override
            public String toString(Company object) {
                return object.getName();
            }
            @Override
            public Company fromString(String string) {
                return null;
            }
        });
    }

    ArrayList<Freelancer> contractors;

    @FXML
    void addContractor(ActionEvent event) {
        Freelancer selectedFreelancer = freelancersComboBox.getValue();
        if (selectedFreelancer != null) {
            contractors.add(selectedFreelancer);
            contractorsComboBox.setItems(FXCollections.observableArrayList(contractors));
        }
    }

    private Boolean isValidInput() {
        if (companyComboBox.getValue() == null) {
            return false;
        }
        if (contractors.size() == 0) {
            return false;
        }
        return true;
    }

    @FXML
    void createEntity(ActionEvent event) throws Exception {
        if (isValidInput()) {
            Company company = companyComboBox.getValue();
            Contract contract = new Contract(company, contractors);
            Context.getInstance().addContract(
                    contract
            );
            company.addContract(contract);
            for (Freelancer freelancer : contractors) {
                freelancer.setContract(contract);
            }

            onCreate.execute();
            ((Stage) createButton.getScene().getWindow()).close();
        }
    }

}
