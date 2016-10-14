package com.project.thursday;

import DomainClasses.Employee;
import exceptions.ConnectionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import persistance.DepartmentManager;
import persistance.EmployeeManager;
import DomainClasses.Bu;

import java.net.URL;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    @FXML
    public Button exitButton, addEmployeeButton;
    public Button payReportButton;
    @FXML
    private ComboBox<Bu> departmentCombo;

    @FXML
    public TableView tableView;
    public TableColumn<Employee, String> address_2Column;
    public TableColumn<Employee, String> cityColumn;
    public TableColumn<Employee, String> postcodeColumn;
    public TableColumn<Employee, String> niColumn;
    public TableColumn<Employee, String> bank_accColumn;
    public TableColumn<Employee, Double> salaryColumn;
    public TableColumn<Employee, String> buNameColumn;
    @FXML
    private TableColumn<Employee, String> firstNameColumn;
    @FXML
    private TableColumn<Employee, String> lastNameColumn;
    @FXML
    private TableColumn<Employee, String> address_1Column;

    private ObservableList<Employee> masterData = FXCollections.observableArrayList();
    private FilteredList<Employee> filteredData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
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


            masterData.addAll(new EmployeeManager().getAllEmployees());

           filteredData = new FilteredList<>(masterData, p -> true);


            departmentCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(employee -> {
                    if (!newValue.getName().equals("All")) {
                        if (newValue.getName().equals(employee.getBuName())) {
                            return true;
                        } else {
                            return false;
                        }
                    } else return true;
                });

            });
            tableView.setItems(filteredData);
            departmentCombo.getItems().setAll(new DepartmentManager().getAllBU(true));
            departmentCombo.getSelectionModel().select(0);
            payReportButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    payEmpReport();
                }
            });
        } catch (ConnectionException ex) {
            ex.printStackTrace();
        }
    }


    public void addEmployee() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add_employee.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.setTitle("Employee Management System");
        stage.setScene(new Scene(root, 500, 600));
        stage.showAndWait();
        updateTable();
    }

    public void updateTable(){
        try {
            for(Employee emp : new EmployeeManager().getAllEmployees()) {
                if(!masterData.contains(emp)) {
                    masterData.add(emp);
                }
            }
        } catch (Exception ex){
            AddEmployee.createAlert("Update Error",ex.getMessage());
        }
    }

    public void close() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void payEmpReport() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("salary_report.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Employee Management System");
                stage.setScene(new Scene(root, 500, 700));
                stage.showAndWait();
            } catch (Exception ex){
                ex.printStackTrace();
                AddEmployee.createAlert("Pay Error", ex.getMessage());
            }
        }

}
