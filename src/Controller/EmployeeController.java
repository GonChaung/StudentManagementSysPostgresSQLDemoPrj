package Controller;

import Model.Employee;
import PrepareData.EmployeeDataPrepare;
import Service.Impl.EmployeeServiceImpl;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeServiceImpl employeeService;
    private EmployeeDataPrepare employeeDataPrepare;

    public EmployeeController() {
        this.employeeService = new EmployeeServiceImpl();
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
        Employee employee = null;
        switch (choice) {
            case 1:
                employee = this.employeeDataPrepare.prepareEmployeeForRegisteration();
                this.employeeService.insert(employee);
                if (employee != null) {
                    System.out.println("New Employee Added Successfully");
                }
                break;

            case 2:
                employee = this.employeeDataPrepare.prepareEmployeeForSearch();
                employee = this.employeeService.search(employee);
                this.employeeDataPrepare.searchEmployee(employee);
                break;

            case 3:
                employee = this.employeeDataPrepare.prepareEmployeeForDelete();
                this.employeeService.delete(employee);
                if (employee != null) {
                    System.out.println("Employee " + employee.getId() + " deleted successfully");
                } else {
                    System.out.println("There is no employee with ID " + employee.getId());
                }
                break;

            case 4:
                List<Employee> employees = this.employeeService.getAllEmployees();
                this.employeeDataPrepare.displayEmployee(employees);
                break;

            case 5:
                employee = this.employeeDataPrepare.prepareEmployeeUpdate();
                this.employeeService.update(employee);
                if (employee != null) {
                    System.out.println("Employee " + employee.getName() + '(' + employee.getId() + ')' + " updated successfully");
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
