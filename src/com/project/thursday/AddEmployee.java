package com.project.thursday;

import DomainClasses.Bu;
import DomainClasses.Employee;
import exceptions.ConnectionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistance.DepartmentManager;
import persistance.EmployeeManager;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by conort on 13/10/2016.
 */
public class AddEmployee implements Initializable {

    public TextField fNameText;
    public TextField lNameText;
    public TextField add1Text;
    public TextField add2Text;
    public TextField cityText;
    public TextField pcodeText;
    public TextField niText;
    public TextField accoutText;
    public TextField salaryText;
    public ComboBox<Bu> buCB;

    @FXML
    private Button addButton, cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            buCB.getItems().setAll(new DepartmentManager().getAllBU(false));
            buCB.getSelectionModel().select(0);
        } catch (ConnectionException ex){
            ex.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            Employee employee = new Employee();
            new EmployeeManager().addEmployee(employee);
        } catch (IllegalArgumentException argEx) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee Details Error");
            alert.setContentText(argEx.getMessage());
        } catch (ConnectionException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setContentText(ex.getMessage());
        } catch (SQLException sql){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SQL Error");
            alert.setContentText(sql.getMessage());
        }
    }


}
