package persistance;

import DomainClasses.Employee;
import exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by conort on 13/10/2016.
 */
public class EmployeeManager {

    private final String userName = "root";
    private final String password = "password";
    private final String serverName = "127.0.0.1";
    private final String portNumber = "3306";

    public EmployeeManager() {
    }

    public Connection getConnection() throws ConnectionException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://" +
                            this.serverName +
                            ":" + this.portNumber + "/kainos?useSSL=false",
                    connectionProps);
        } catch (SQLException sqlEx) {
            throw new ConnectionException("Unable to connect to the database");
        }
    }

    public List<Employee> getAllEmployees() throws ConnectionException {
        Connection conn = getConnection();
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

    public long addEmployee(Employee employee) throws ConnectionException, SQLException {
        Connection conn = getConnection();

        long key = 0;
        String expression = String.format("INSERT INTO employee (first_name, last_name, address_1, address_2, city, " +
                "postcode, national_insurance, bank_account, salary) VALUES (?,?,?,?,?,?,?,?,?);");
        PreparedStatement pStatement = conn.prepareStatement(expression, PreparedStatement.RETURN_GENERATED_KEYS);
        pStatement.setString(0,employee.getFirst_name());
        pStatement.setString(1,employee.getLast_name());
        pStatement.setString(2,employee.getAddress_1());
        pStatement.setString(3,employee.getAddress_2());
        pStatement.setString(4,employee.getCity());
        pStatement.setString(5,employee.getPostcode());
        pStatement.setString(6,employee.getNational_insurance());
        pStatement.setString(7,employee.getBank_account());
        pStatement.setDouble(8,employee.getSalary());
        pStatement.executeQuery();
        ResultSet rs = pStatement.getGeneratedKeys();

        if (rs != null && rs.next()) {
            key = rs.getLong(1);
        }
        return key;
    }

}
