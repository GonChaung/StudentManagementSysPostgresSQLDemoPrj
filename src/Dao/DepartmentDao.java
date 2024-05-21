package Dao;

import Model.Department;
import Model.Student;
import Utils.DatabaseUtil;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    Connection con = DatabaseUtil.getConnection();
    public Department insertDepartment(Department department){
        String insertSQL = "INSERT INTO departments VALUES(?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)){
            pstmt.setString(1, department.getName());
            pstmt.setString(2, department.getDescription());
            pstmt.setString(3, department.getAddress());
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected>0){
                return department;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Department searchDepartmentById(int departmentId){
        Department department = null;
        String searchSQL = "SELECT  * FROM departments WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, departmentId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setAddress(rs.getString("address"));
                return department;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String searchSQL = "SELECT * FROM departments";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while(rs.next()){
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setName(rs.getString("name"));
            department.setDescription(rs.getString("description"));
            department.setAddress(rs.getString("address"));
            departments.add(department);
        }
        return departments;
    }
}
