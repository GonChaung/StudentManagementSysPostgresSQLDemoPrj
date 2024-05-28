package Dao;

import Model.Employee;
import java.sql.*;

public class EmployeeDao extends GeneralDao<Employee> {
    private EmployeeTypeDao employeeTypeDao;
    public EmployeeDao() {
        this.employeeTypeDao = new EmployeeTypeDao();
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO employees (name, salary, phone, age, gender, type_id) VALUES (?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(Employee employee, PreparedStatement pstmt) {
        try{
            pstmt.setString(1, employee.getName());
            pstmt.setString(3, employee.getPhone());
            pstmt.setDouble(2, employee.getSalary());
            pstmt.setString(4, employee.getAge());
            pstmt.setString(5, employee.getGender());
            pstmt.setInt(6, employee.getEmployeeType().getId());
            return pstmt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE employees SET name = ?, phone = ?, type_id = ?, salary = ?, age = ?, gender = ? WHERE id = ?";
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(Employee employee, PreparedStatement pstmt) {
        try{
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPhone());
            System.out.println(employee.getEmployeeType().getId());
            pstmt.setInt(3, employee.getEmployeeType().getId());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setString(5,employee.getAge());
            pstmt.setString(6, employee.getGender());
            pstmt.setInt(7, employee.getId());
            return pstmt;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getSearchQuery() {
        return "SELECT * FROM employees WHERE id = ?";
    }

    @Override
    public Employee mapResultSetToGenericType(ResultSet rs) {
        try{
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setPhone(rs.getString("phone"));
            employee.setEmployeeTypeID(this.employeeTypeDao.searchEmployeeTypeByID(rs.getInt("type_id")));
            employee.setSalary(rs.getLong("salary"));
            employee.setAge(rs.getString("age"));
            employee.setGender(rs.getString("gender"));
            return employee;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM employees WHERE id = ?";
    }

    @Override
    public Employee deleteObj(Employee employee) throws SQLException {
        return employee;
    }

    @Override
    public String getAllQuery() {
        return "SELECT * FROM employees";
    }

    @Override
    public String getSearchByIdQuery() {
        return "SELECT * FROM employees WHERE type_id = ?";
    }
}
