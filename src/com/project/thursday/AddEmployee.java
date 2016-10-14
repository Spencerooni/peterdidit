package com.project.thursday;

import DomainClasses.Bu;
import DomainClasses.Employee;
import DomainClasses.SalesEmployee;
import exceptions.ConnectionException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
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
    public RadioButton empRB;
    public RadioButton salesEmpRB;
    public TextField commText;
    public TextField totSalesText;
    public Label totSaleLabel;
    public Label comLabel;

    @FXML
    private Button addButton, cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            buCB.getItems().setAll(new DepartmentManager().getAllBU(false));
            buCB.getSelectionModel().select(0);
            ToggleGroup tg = new ToggleGroup();
            tg.getToggles().add(empRB);
            tg.getToggles().add(salesEmpRB);

            empRB.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    commText.setVisible(!isNowSelected);
                    comLabel.setVisible(!isNowSelected);
                    totSaleLabel.setVisible(!isNowSelected);
                    totSalesText.setVisible(!isNowSelected);
                }
            });
            empRB.setSelected(true);
        } catch (ConnectionException ex) {
            createAlert("Connection Error",ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            addEmployee();
            close();
        } catch (IllegalArgumentException argEx) {
            createAlert("Employee Details Error", argEx.getMessage());
            argEx.printStackTrace();
        } catch (ConnectionException ex) {
            createAlert("Connection Error", ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException sql) {
            createAlert("SQL Error",sql.getMessage());
            sql.printStackTrace();
        }
    }

    public void addEmployee() throws ConnectionException, SQLException, IllegalArgumentException{
        if(!salesEmpRB.isSelected()){
            Employee employee = new Employee();
            employee.setFirst_name(fNameText.getText());
            employee.setLast_name(lNameText.getText());
            employee.setAddress_1(add1Text.getText());
            employee.setAddress_2(add2Text.getText());
            employee.setCity(cityText.getText());
            employee.setPostcode(pcodeText.getText());
            employee.setNational_insurance(niText.getText());
            employee.setBank_account(accoutText.getText());
            employee.setSalary(salaryText.getText());
            new EmployeeManager().addEmployee(employee, buCB.getValue());
        } else {
            SalesEmployee employee = new SalesEmployee();
            employee.setFirst_name(fNameText.getText());
            employee.setLast_name(lNameText.getText());
            employee.setAddress_1(add1Text.getText());
            employee.setAddress_2(add2Text.getText());
            employee.setCity(cityText.getText());
            employee.setPostcode(pcodeText.getText());
            employee.setNational_insurance(niText.getText());
            employee.setBank_account(accoutText.getText());
            employee.setSalary(Double.valueOf((salaryText).getText()));
            employee.setCommission_rate(Float.valueOf(commText.getText()));
            employee.setTotal_sales(Double.valueOf(totSalesText.getText()));
            new EmployeeManager().addSalesEmployee(employee, buCB.getValue());
        }
    }

    public void createAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cancel(ActionEvent actionEvent) {
        close();
    }

    public void close() {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }
}
