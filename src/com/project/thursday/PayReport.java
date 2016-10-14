package com.project.thursday;

import DomainClasses.Employee;
import DomainClasses.EmployeePay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import persistance.EmployeeManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by conort on 14/10/2016.
 */
public class PayReport implements Initializable {
    public TableView tableView;
    public TableColumn nameColumn;
    public TableColumn employeePay;
    public Button exitButton;

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
            createAlert("Salary Error", ex.getMessage());
        }
    }

    public void cancel(ActionEvent actionEvent) {
        close();
    }

    public void close() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public static void createAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
