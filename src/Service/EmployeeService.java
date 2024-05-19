package Service;

import Dao.EmployeeDao;
import Model.Employee;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class EmployeeService {
    BufferedReader br = DataUtil.br;
    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }

    public void searchEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setId(Integer.parseInt(br.readLine()));
        Employee searchEmployee = this.employeeDao.searchEmployee(employee);
        if (searchEmployee != null) {
            System.out.println("employee ID :" + searchEmployee.getId());
            System.out.println("employee Name :" + searchEmployee.getName());
            System.out.println("employee Phone :" + searchEmployee.getPhone());
            System.out.println("employee Department : " + searchEmployee.getDepartment());
            System.out.println("employee Salary : " + searchEmployee.getSalary());
        } else {
            System.out.println("There is no employee with ID " + employee.getId());
        }
    }

    public void insertEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Name : ");
        employee.setName(br.readLine());
        System.out.println("Phone : ");
        employee.setPhone(br.readLine());
        System.out.println("Department : ");
        employee.setDepartment(br.readLine());
        System.out.println("Salary : ");
        employee.setSalary(Long.parseLong(br.readLine()));
        Employee insertedEmployee = this.employeeDao.insertEmployee(employee);
        if (insertedEmployee != null) {
            System.out.println("New Employee Added Successfully");
        }
    }

    public void deleteEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type your employee id : ");
        employee.setId(Integer.parseInt(br.readLine()));
        Employee deletedEmployee = this.employeeDao.deleteEmployee(employee);
        if (deletedEmployee != null) {
            System.out.println("Employee " + employee.getId() + " deleted successfully");
        } else {
            System.out.println("There is no employee with ID " + employee.getId());
        }
    }

    public void getAllEmployees() throws SQLException, IOException {
        List<Employee> employees = this.employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println("employee id " + employee.getId() +
                    "/ name " + employee.getName() +
                    "/ phone " + employee.getPhone() +
                    "/ department " + employee.getDepartment() +
                    "/ salary " + employee.getSalary());
        }
    }

    public void updateEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setId(Integer.parseInt(br.readLine()));
        System.out.println("Type employee name : ");
        employee.setName(br.readLine());
        System.out.println("Type employee phone : ");
        employee.setPhone(br.readLine());
        System.out.println("Type employee department : ");
        employee.setDepartment(br.readLine());
        System.out.println("Type employee salary : ");
        employee.setSalary(Long.parseLong(br.readLine()));
        Employee updatedEmployee = this.employeeDao.employeeUpdate(employee);
        if (updatedEmployee != null) {
            System.out.println("Employee " + updatedEmployee.getName() + '(' + updatedEmployee.getId() + ')' + " updated successfully");
        }
    }
}
