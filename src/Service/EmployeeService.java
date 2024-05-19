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
        employee.setEmployee_id(Integer.parseInt(br.readLine()));
        Employee searchEmployee = this.employeeDao.searchEmployee(employee);
        if (searchEmployee != null) {
            System.out.println("employee ID :" + searchEmployee.getEmployee_id());
            System.out.println("employee Name :" + searchEmployee.getEmployee_name());
            System.out.println("employee Phone :" + searchEmployee.getEmployee_phone());
            System.out.println("employee Department : " + searchEmployee.getEmployee_department());
            System.out.println("employee Salary : " + searchEmployee.getEmployee_salary());
        } else {
            System.out.println("There is no employee with ID " + employee.getEmployee_id());
        }
    }

    public void insertEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Name : ");
        employee.setEmployee_name(br.readLine());
        System.out.println("Phone : ");
        employee.setEmployee_phone(br.readLine());
        System.out.println("Department : ");
        employee.setEmployee_department(br.readLine());
        System.out.println("Salary : ");
        employee.setEmployee_salary(Long.parseLong(br.readLine()));
        Employee insertedEmployee = this.employeeDao.insertEmployee(employee);
        if (insertedEmployee != null) {
            System.out.println("New Employee Added Successfully");
        }
    }

    public void deleteEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type your employee id : ");
        employee.setEmployee_id(Integer.parseInt(br.readLine()));
        Employee deletedEmployee = this.employeeDao.deleteEmployee(employee);
        if (deletedEmployee != null) {
            System.out.println("Employee " + employee.getEmployee_id() + " deleted successfully");
        } else {
            System.out.println("There is no employee with ID " + employee.getEmployee_id());
        }
    }

    public void getAllEmployees() throws SQLException, IOException {
        List<Employee> employees = this.employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println("employee id " + employee.getEmployee_id() +
                    "/ name " + employee.getEmployee_name() +
                    "/ phone " + employee.getEmployee_phone() +
                    "/ department " + employee.getEmployee_department() +
                    "/ salary " + employee.getEmployee_salary());
        }
    }

    public void updateEmployee() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setEmployee_id(Integer.parseInt(br.readLine()));
        System.out.println("Type employee name : ");
        employee.setEmployee_name(br.readLine());
        System.out.println("Type employee phone : ");
        employee.setEmployee_phone(br.readLine());
        System.out.println("Type employee department : ");
        employee.setEmployee_department(br.readLine());
        System.out.println("Type employee salary : ");
        employee.setEmployee_salary(Long.parseLong(br.readLine()));
        Employee updatedEmployee = this.employeeDao.employeeUpdate(employee);
        if (updatedEmployee != null) {
            System.out.println("Employee " + updatedEmployee.getEmployee_name() + '(' + updatedEmployee.getEmployee_id() + ')' + " updated successfully");
        }
    }
}
