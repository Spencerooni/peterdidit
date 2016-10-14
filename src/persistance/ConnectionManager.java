package persistance;

import exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by conort on 13/10/2016.
 */
public class ConnectionManager {


    private static final String userName = "root";
    private static final String password = "password";
    private static final String serverName = "127.0.0.1";
    private static final String portNumber = "3306";


    public static Connection getConnection() throws ConnectionException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://" +
                            serverName +
                            ":" + portNumber + "/kainos?useSSL=false",
                    connectionProps);
        } catch (SQLException sqlEx) {
            throw new ConnectionException("Unable to connect to the database");
        }
    }
}
