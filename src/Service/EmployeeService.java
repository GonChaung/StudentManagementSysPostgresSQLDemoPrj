package Service;

import Dao.EmployeeDao;
import Model.Employee;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    BufferedReader br = DataUtil.br;
    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }

    public void searchEmployee(Employee employee) throws IOException {
        Employee searchEmployee = this.employeeDao.searchEmployee(employee);
        if (searchEmployee != null) {
            System.out.println("employee ID :" + searchEmployee.getId());
            System.out.println("employee Name :" + searchEmployee.getName());
            System.out.println("employee Phone :" + searchEmployee.getPhone());
            System.out.println("employee Department : " + searchEmployee.getEmployeeType().getName());
            System.out.println("employee Salary : " + searchEmployee.getSalary());
        } else {
            System.out.println("There is no employee with ID " + employee.getId());
        }
    }

    public void insertEmployee(Employee employee) throws IOException, SQLException {
        Employee insertedEmployee = this.employeeDao.insertEmployee(employee);
        if (insertedEmployee != null) {
            System.out.println("New Employee Added Successfully");
        }
    }

    public void deleteEmployee(Employee employee) throws IOException {
        Employee deletedEmployee = this.employeeDao.deleteEmployee(employee);
        if (deletedEmployee != null) {
            System.out.println("Employee " + employee.getId() + " deleted successfully");
        } else {
            System.out.println("There is no employee with ID " + employee.getId());
        }
    }

    public void updateEmployee(Employee employee) throws IOException {
        Employee updatedEmployee = this.employeeDao.employeeUpdate(employee);
        if (updatedEmployee != null) {
            System.out.println("Employee " + updatedEmployee.getName() + '(' + updatedEmployee.getId() + ')' + " updated successfully");
        }
    }

    public List<Employee> getAllEmployees() throws SQLException, IOException {
        return this.employeeDao.getAllEmployees();
    }
}
