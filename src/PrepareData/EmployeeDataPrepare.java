package PrepareData;

import Dao.EmployeeTypeDao;
import Model.Employee;
import Model.EmployeeType;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDataPrepare extends PersonDataPrepare{
    BufferedReader br = DataUtil.br;
    private EmployeeTypeDao employeeTypeDao;

    public EmployeeDataPrepare() {
        this.employeeTypeDao = new EmployeeTypeDao();
    }

    public Employee prepareEmployeeForRegisteration() throws IOException, SQLException {
        Employee employee = new Employee();
        employee = (Employee) preparePersonDataForRegistration(employee);
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
        employee = (Employee) preparePersonDataForUpdate(employee);
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
                    "/ salary " + employee.getSalary() +
                    "/ age " + employee.getAge() +
                    "/ gender " + employee.getGender());
        }
    }

    public Employee prepareEmployeeForSearch() throws IOException{
        Employee employee = new Employee();
        System.out.println("Type employee ID : ");
        employee.setId(Integer.parseInt(br.readLine()));
        return employee;
    }

    public void searchEmployee(Employee employee){
        if (employee != null) {
            System.out.println("employee ID :" + employee.getId());
            System.out.println("employee Name :" + employee.getName());
            System.out.println("employee Phone :" + employee.getPhone());
            System.out.println("employee Department : " + employee.getEmployeeType().getName());
            System.out.println("employee Salary : " + employee.getSalary());
        } else {
            System.out.println("There is no employee with ID " + employee.getId());
        }
    }

    public Employee prepareEmployeeForDelete() throws IOException {
        Employee employee = new Employee();
        System.out.println("Type your employee id : ");
        employee.setId(Integer.parseInt(br.readLine()));
        return employee;
    }
}
