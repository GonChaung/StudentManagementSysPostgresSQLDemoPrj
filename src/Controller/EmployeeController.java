package Controller;

import Service.EmployeeService;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    public void employeeRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Employee");
        System.out.println("2. Search Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Get all employee data");
        System.out.println("5. Update Employee Data");
        System.out.println();
        int choice = Integer.parseInt(DataUtil.br.readLine());
        switch(choice) {
            case 1: this.employeeService.insertEmployee();
                break;
            case 2: this.employeeService.searchEmployee();
                break;
            case 3: this.employeeService.deleteEmployee();
                break;
            case 4: this.employeeService.getAllEmployees();
                break;
            case 5: this.employeeService.updateEmployee();
                break;
        }
    }
}
