package Controller;

import Model.Person;
import PrepareData.DepartmentDataPrepare;
import Service.DepartmentService;
import Utils.DataUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
    private DepartmentService departmentService;
    private DepartmentDataPrepare departmentDataPrepare;

    public DepartmentController() {
        this.departmentService = new DepartmentService();
        this.departmentDataPrepare = new DepartmentDataPrepare();
    }


    public void department() throws IOException, SQLException {
        System.out.println(" What do you want to do ?");
        System.out.println(" 1 = Search All by ID ");
        int choice = Integer.parseInt(DataUtil.br.readLine());
        switch (choice) {
            case 1:
                List<Person> persons = departmentService.getAllPerson();
                this.departmentDataPrepare.displayPersonFromDeparments(persons);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
