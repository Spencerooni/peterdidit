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
        String expression = String.format("SELECT * FROM employee");
        List<Employee> employeeList = new ArrayList();
        try {
            PreparedStatement pStatement = conn.prepareStatement(expression);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getDouble(10)));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return employeeList;
    }

}