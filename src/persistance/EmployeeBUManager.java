package persistance;

import exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by peterbo on 14/10/2016.
 */
public class EmployeeBUManager {

    public boolean addEmpBU(long emp_id, int bu_id) throws ConnectionException, SQLException {

        Connection conn = ConnectionManager.getConnection();
        String expression = String.format("INSERT INTO emp_bu (emp_id, bu_id) VALUES (?,?);");
        PreparedStatement pStatement = conn.prepareStatement(expression);
        pStatement.setInt(1,(int) emp_id);
        pStatement.setInt(2,bu_id);
        pStatement.execute();
        return true;
    }

}
