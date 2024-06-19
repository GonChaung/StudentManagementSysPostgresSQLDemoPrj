package Dao;

import Model.*;
import Utils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    Connection con = DatabaseUtil.getConnection();
    PreparedStatement pstmt = null;
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
        String searchSQL = "SELECT * FROM departments WHERE id = ?";
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
    public List<Person> getAllPersonByDepartmentId() throws SQLException {
        List<Person> persons = new ArrayList<>();
        String searchSQL = "SELECT * FROM departments";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while(rs.next()){
            Person person = new Person();
            person.setId(rs.getInt("id "));
            person.setName(rs.getString("name "));
        }
        return persons;
    }
    public List<Major> getMajorsByDepartment(int departmentId) {
        List<Major> majors = new ArrayList<>();
        String query = "SELECT * FROM majors WHERE department_id = ?";
        try {
            con = DatabaseUtil.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, departmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Major major = new Major();
                    major.setId(rs.getInt("id"));
                    major.setName(rs.getString("name"));
                    major.setDepartmentid(rs.getInt("department_id"));
                    major.setCode(rs.getString("code"));
                    majors.add(major);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return majors;
    }
}
