package Dao;

import Model.Employee;
import Utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    Connection con = DatabaseUtil.getConnection();

    public Employee employeeUpdate(Employee employee) {
        String updateSQL = "UPDATE employees SET name = ?, phone = ?, department = ?, salary = ?, age = ?, gender = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPhone());
            pstmt.setString(3, employee.getDepartment());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setString(5,employee.getAge());
            pstmt.setString(6, employee.getGender());
            pstmt.setInt(7, employee.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return employee;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee insertEmployee(Employee employee) {
        String insertSQL = "INSERT INTO employees (name, phone, department, salary,age,gender) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPhone());
            pstmt.setString(3, employee.getDepartment());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setString(5, employee.getAge());
            pstmt.setString(6, employee.getGender());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return employee;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee searchEmployee(Employee employee) {
        String searchSQL = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(searchSQL)) {
            pstmt.setInt(1, employee.getId());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setDepartment(rs.getString("department"));
                    employee.setSalary(rs.getLong("salary"));
                    employee.setAge(rs.getString("age"));
                    employee.setGender(rs.getString("gender"));
                    return employee;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee deleteEmployee(Employee employee) {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, employee.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return employee;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String searchSQL = "SELECT * FROM employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setPhone(rs.getString("phone"));
            employee.setDepartment(rs.getString("department"));
            employee.setSalary(rs.getLong("salary"));
            employee.setAge(rs.getString("age"));
            employee.setGender(rs.getString("gender"));
            employees.add(employee);
        }
        return employees;
    }
}
