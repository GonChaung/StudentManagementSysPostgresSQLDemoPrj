package PrepareData;

import Dao.EmployeeDao;
import Dao.EmployeeTypeDao;
import Model.Employee;
import Model.EmployeeType;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDataPrepare {
    BufferedReader br = DataUtil.br;
    private EmployeeTypeDao employeeTypeDao;

    public EmployeeDataPrepare() {
        this.employeeTypeDao = new EmployeeTypeDao();
    }

    public Employee prepareEmployeeForRegisteration() throws IOException, SQLException {
        Employee employee = new Employee();
        System.out.println("Name : ");
        employee.setName(br.readLine());
        System.out.println("Phone : ");
        employee.setPhone(br.readLine());
        System.out.println(" Select employeeType : ");
        for(EmployeeType employeeType : this.employeeTypeDao.getAllEmployeeTypeID()){
            System.out.println("ID : " + employeeType.getId() + " Name : " + employeeType.getName());
        }
        System.out.println(" Enter Employee ID : ");
        EmployeeType employeeType = new EmployeeType();
        employeeType.setId(Integer.parseInt(br.readLine()));
        employee.setEmployeeTypeID(employeeType);
        System.out.println("Salary : ");
        employee.setSalary(Long.parseLong(br.readLine()));
        return employee;
    }

    public Employee prepareEmployeeUpdate() throws IOException, SQLException {
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setId(Integer.parseInt(br.readLine()));
        System.out.println("Type employee name : ");
        employee.setName(br.readLine());
        System.out.println("Type employee phone : ");
        employee.setPhone(br.readLine());
        System.out.println(" Select employeeType : ");
        for(EmployeeType employeeType : this.employeeTypeDao.getAllEmployeeTypeID()){
            System.out.println("ID : " + employeeType.getId() + " Name : " + employeeType.getName());
        }
        System.out.println(" Enter Employee ID : ");
        EmployeeType employeeType = new EmployeeType();
        employeeType.setId(Integer.parseInt(br.readLine()));
        employee.setEmployeeTypeID(employeeType);
        System.out.println("Type employee salary : ");
        employee.setSalary(Long.parseLong(br.readLine()));
        return employee;
    }

    public void displayEmployee(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("employee id " + employee.getId() +
                    "/ name " + employee.getName() +
                    "/ phone " + employee.getPhone() +
                    "/ serviceID " + employee.getEmployeeType().getName() +
                    "/ salary " + employee.getSalary());
        }
    }

    public Employee prepareEmployeeForSearch() throws IOException{
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setId(Integer.parseInt(br.readLine()));
        return employee;
    }

    public Employee prepareEmployeeForDelete() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type your employee id : ");
        employee.setId(Integer.parseInt(br.readLine()));
        return employee;
    }
}
