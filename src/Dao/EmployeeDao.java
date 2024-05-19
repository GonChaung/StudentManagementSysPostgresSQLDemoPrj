package Dao;

import Model.Employee;
import Utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    Connection con = DatabaseUtil.getConnection();

    public Employee employeeUpdate(Employee employee) {
        String updateSQL = "UPDATE employees SET name = ?, phone = ?, department = ?, salary = ? WHERE employee_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
            pstmt.setString(1, employee.getEmployee_name());
            pstmt.setString(2, employee.getEmployee_phone());
            pstmt.setString(3, employee.getEmployee_department());
            pstmt.setDouble(4, employee.getEmployee_salary());
            pstmt.setInt(5, employee.getEmployee_id());
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
        String insertSQL = "INSERT INTO employees (name, phone, department, salary) VALUES (?,?,?,?)";
        try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.setString(1, employee.getEmployee_name());
            pstmt.setString(2, employee.getEmployee_phone());
            pstmt.setString(3, employee.getEmployee_department());
            pstmt.setDouble(4, employee.getEmployee_salary());
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
        String searchSQL = "SELECT * FROM employees WHERE employee_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(searchSQL)) {
            pstmt.setInt(1, employee.getEmployee_id());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee.setEmployee_id(rs.getInt("employee_id"));
                    employee.setEmployee_name(rs.getString("name"));
                    employee.setEmployee_phone(rs.getString("phone"));
                    employee.setEmployee_department(rs.getString("department"));
                    employee.setEmployee_salary(rs.getLong("salary"));
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
        String deleteSQL = "DELETE FROM employees WHERE employee_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, employee.getEmployee_id());
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
            employee.setEmployee_id(rs.getInt("employee_id"));
            employee.setEmployee_name(rs.getString("name"));
            employee.setEmployee_phone(rs.getString("phone"));
            employee.setEmployee_department(rs.getString("department"));
            employee.setEmployee_salary(rs.getLong("salary"));
            employees.add(employee);
        }
        return employees;
    }
}
