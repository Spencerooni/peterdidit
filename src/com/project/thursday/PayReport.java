package com.project.thursday;

import DomainClasses.Employee;
import DomainClasses.EmployeePay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import persistance.EmployeeManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by conort on 14/10/2016.
 */
public class PayReport implements Initializable{
    public TableView tableView;
    public TableColumn nameColumn;
    public TableColumn employeePay;

    private ObservableList<EmployeePay> masterData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            nameColumn.setCellValueFactory(new PropertyValueFactory<EmployeePay, String>("employeeName"));
            employeePay.setCellValueFactory(new PropertyValueFactory<EmployeePay, String>("finalSalary"));
            masterData.addAll(new EmployeeManager().getFinalSalary());
            tableView.setItems(masterData);
        } catch (Exception ex) {
            ex.printStackTrace();
            AddEmployee.createAlert("Salary Error", ex.getMessage());
        }
    }
}
