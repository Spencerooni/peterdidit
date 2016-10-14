package persistance;

import DomainClasses.Employee;
import DomainClasses.EmployeePay;
import DomainClasses.SalesEmployee;
import exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import DomainClasses.Bu;

import javax.xml.transform.Result;

/**
 * Created by conort on 13/10/2016.
 */
public class EmployeeManager {


    public List<Employee> getAllEmployees() throws ConnectionException {
        Connection conn = ConnectionManager.getConnection();
        String expression = String.format("SELECT employee_id,first_name,last_name, address_1, address_2,city,postcode," +
                "national_insurance, bank_account, salary,bu.name FROM employee join emp_bu on (employee.employee_id = " +
                "emp_bu.emp_id) join bu on (bu.bu_id = emp_bu.bu_id);");
        List<Employee> employeeList = new ArrayList();
        try {
            PreparedStatement pStatement = conn.prepareStatement(expression);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getDouble(10), rs.getString(11)));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return employeeList;
    }

    public List<EmployeePay> getFinalSalary() throws ConnectionException, SQLException {

        Connection conn = ConnectionManager.getConnection();
        String expression = String.format("SELECT CONCAT(first_name,' ', last_name) as 'Employee Name', CONCAT('£',CAST((IFNULL((sales.commission_rate * sales.total_sales),0) + salary) as DECIMAL(11,2))) as 'Final Salary'from employee left outer JOIN sales on  employee.employee_id = sales.sales_id;");
        List<EmployeePay> salaryList = new ArrayList();
        try {
            PreparedStatement pStatement = conn.prepareStatement(expression);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                salaryList.add(new EmployeePay(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return salaryList;

    }

    public void addSalesEmployee(SalesEmployee employee, Bu bu) throws  ConnectionException, SQLException {

        long key = addEmployee(employee, bu);
        Connection conn = ConnectionManager.getConnection();
        String expression = String.format("INSERT INTO sales (sales_id, commission_rate, total_sales) VALUES (?,?,?);");
        PreparedStatement pStatement = conn.prepareStatement(expression);
        pStatement.setLong(1,key);
        pStatement.setFloat(2,employee.getCommission_rate());
        pStatement.setDouble(3,employee.getTotal_sales());
        pStatement.execute();

    }

    public long addEmployee(Employee employee, Bu bu) throws ConnectionException, SQLException {
        Connection conn = ConnectionManager.getConnection();

        long key = 0;
        String expression = String.format("INSERT INTO employee (first_name, last_name, address_1, address_2, city, " +
                "postcode, national_insurance, bank_account, salary) VALUES (?,?,?,?,?,?,?,?,?);");
        PreparedStatement pStatement = conn.prepareStatement(expression, PreparedStatement.RETURN_GENERATED_KEYS);
        pStatement.setString(1,employee.getFirst_name());
        pStatement.setString(2,employee.getLast_name());
        pStatement.setString(3,employee.getAddress_1());
        pStatement.setString(4,employee.getAddress_2());
        pStatement.setString(5,employee.getCity());
        pStatement.setString(6,employee.getPostcode());
        pStatement.setString(7,employee.getNational_insurance());
        pStatement.setString(8,employee.getBank_account());
        pStatement.setDouble(9,employee.getSalary());
        pStatement.executeUpdate();
        ResultSet rs = pStatement.getGeneratedKeys();

        if (rs != null && rs.next()) {
            key = rs.getLong(1);
        }

        EmployeeBUManager employeeBUManager = new EmployeeBUManager();
        employeeBUManager.addEmpBU(key, bu.getBu_id());


        return key;

    }

}
