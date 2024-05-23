package Controller;

import Model.Employee;
import Model.Student;
import PrepareData.EmployeeDataPrepare;
import PrepareData.StudentDataPrepare;
import Service.EmployeeService;
import Service.StudentService;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeDataPrepare employeeDataPrepare;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.employeeDataPrepare = new EmployeeDataPrepare();
    }

    public void employeeRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Employee : ");
        System.out.println("2. Search Employee : ");
        System.out.println("3. Delete Employee : ");
        System.out.println("4. Get all employee data");
        System.out.println("5. Update employee Data");
        System.out.println();

        int choice = Integer.parseInt(DataUtil.br.readLine());

        switch (choice) {
            case 1:
                Employee employeeRegistration = this.employeeDataPrepare.prepareEmployeeForRegisteration();
                this.employeeService.insertEmployee(employeeRegistration);
                break;

            case 2:
                this.employeeService.searchEmployee();
                break;

            case 3:
                this.employeeService.deleteEmployee();
                break;

            case 4:
                List<Employee> employees = this.employeeService.getAllEmployees();
                this.employeeDataPrepare.displayEmployee(employees);
                break;

            case 5:
                Employee employeeUpdate = this.employeeDataPrepare.prepareEmployeeUpdate();
                this.employeeService.updateEmployee(employeeUpdate);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
