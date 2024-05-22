package PrepareData;

import Model.Employee;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDataPrepare {
    BufferedReader br = DataUtil.br;

    public EmployeeDataPrepare() {
    }

    public Employee prepareEmployeeForRegisteration() throws IOException, SQLException {
        Employee employee = new Employee();
        System.out.println("Name : ");
        employee.setName(br.readLine());
        System.out.println("Phone : ");
        employee.setPhone(br.readLine());
        System.out.println("Department : ");
        employee.setDepartment(br.readLine());
        System.out.println("Salary : ");
        employee.setSalary(Long.parseLong(br.readLine()));
        return employee;
    }

    public Employee prepareEmployeeUpdate() throws IOException {
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
        return employee;
    }

    public void displayEmployee(List<Employee> employees) {
        for(Employee employee : employees){
            System.out.println(" employee id "+ employee.getId() +
                    "/ name " + employee.getName() +
                    "/ phone " + employee.getPhone() +
                    "/ department " + employee.getDepartment() +
                    "/ email " + employee.getEmail());
        }
    }
}
