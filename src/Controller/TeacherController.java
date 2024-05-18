package Controller;

import Service.TeacherService;
import java.io.IOException;
import java.sql.SQLException;
import static Utils.DataUtil.br;

public class TeacherController {
    private TeacherService teacherService;

    public TeacherController() {
        this.teacherService = new TeacherService();
    }

    public void teacherRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Teacher : ");
        System.out.println("2. Update Teacher : ");
        System.out.println("3. Delete Teacher : ");
        System.out.println("4. Search Teacher : ");
        System.out.println("5. GetAll Teacher : ");
        System.out.println();
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1: this.teacherService.insertTeacher();
            break;
            case 2: this.teacherService.updateTeacher();
            break;
            case 3: this.teacherService.deleteTeacher();
            break;
            case 4: this.teacherService.searchTeacher();
            break;
            case 5: this.teacherService.getAllTeacher();
            break;
        }
    }
}
