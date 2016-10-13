package com.project.thursday;

import DomainClasses.Employee;
import exceptions.ConnectionException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import persistance.EmployeeManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button exitButton;

    @FXML
    public TableView tableView;
    public TableColumn<Employee, String> address_2Column;
    public TableColumn<Employee, String> cityColumn;
    public TableColumn<Employee, String> postcodeColumn;
    public TableColumn<Employee, String> niColumn;
    public TableColumn<Employee, String> bank_accColumn;
    public TableColumn<Employee, Double> salaryColumn;
    public TableColumn<Employee,String> buNameColumn;
    @FXML
    private TableColumn<Employee, String> firstNameColumn;
    @FXML
    private TableColumn<Employee, String> lastNameColumn;
    @FXML
    private TableColumn<Employee, String> address_1Column;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            System.out.println("initialising");
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("first_name"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("last_name"));
            address_1Column.setCellValueFactory(new PropertyValueFactory<Employee, String>("address_1"));
            address_2Column.setCellValueFactory(new PropertyValueFactory<Employee, String>("address_2"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("city"));
            postcodeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("postcode"));
            niColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("national_insurance"));
            bank_accColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("bank_account"));
            salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
            buNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("buName"));

            List<Employee> employees = new EmployeeManager().getAllEmployees();
            tableView.getItems().setAll(employees);
        } catch (ConnectionException ex) {
            ex.printStackTrace();
        }
    }

}
