package Dao;

import Model.EmployeeType;
import Utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTypeDao {
    Connection con = DatabaseUtil.getConnection();

    public EmployeeType insertService(EmployeeType employeeType){
        String insertSQL = "INSERT INTO employee_types VALUES(?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)){
            pstmt.setString(1, employeeType.getName());
            pstmt.setString(2, employeeType.getName());
            pstmt.setString(3, employeeType.getAddress());
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected>0){
                return employeeType;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeType searchEmployeeTypeByID(int serviceId){
        EmployeeType employeeType = null;
        String searchSQL = "SELECT  * FROM employee_types WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, serviceId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                employeeType = new EmployeeType();
                employeeType.setId(rs.getInt("id"));
                employeeType.setName(rs.getString("name"));
                employeeType.setAddress(rs.getString("address"));
                return employeeType;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeeType> getAllEmployeeTypeID() throws SQLException {
        List<EmployeeType> employeeTypes = new ArrayList<>();
        String searchSQL = "SELECT * FROM employee_types";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while(rs.next()){
            EmployeeType employeeType = new EmployeeType();
            employeeType.setId(rs.getInt("id"));
            employeeType.setName(rs.getString("name"));
            employeeType.setAddress(rs.getString("address"));
            employeeTypes.add(employeeType);
        }
        return employeeTypes;
    }
}
