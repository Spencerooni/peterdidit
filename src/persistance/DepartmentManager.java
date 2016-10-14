package persistance;

import DomainClasses.Bu;
import DomainClasses.Employee;
import exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by conort on 13/10/2016.
 */
public class DepartmentManager {

    public List<Bu> getAllBU(boolean addAllValue) throws ConnectionException {
        Connection conn = ConnectionManager.getConnection();
        String expression = String.format("SELECT bu_id,name,directorid FROM bu;");
        List<Bu> buList = new ArrayList();
        try {
            Bu bu = new Bu();
            if(addAllValue) {
                bu.setName("All");
                buList.add(bu);
            }
            PreparedStatement pStatement = conn.prepareStatement(expression);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                bu = new Bu();
                bu.setBu_id(rs.getInt(1));
                bu.setName(rs.getString(2));
                bu.setDirector_id(rs.getInt(3));
                buList.add(bu);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return buList;
    }

}