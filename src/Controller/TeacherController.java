package Controller;

import Model.Teacher;
import PrepareData.TeacherDataPrepare;
import Service.Impl.TeacherServiceImpl;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherController {
    private TeacherServiceImpl teacherService;
    private TeacherDataPrepare teacherDataPrepare;

    public TeacherController() {
      this.teacherService = new TeacherServiceImpl();
      this.teacherDataPrepare = new TeacherDataPrepare();
    }

    public void teacherRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Teacher");
        System.out.println("2. Search Teacher");
        System.out.println("3. Delete Teacher");
        System.out.println("4. Get all Teachers data");
        System.out.println("5. Update Teacher Data");
        System.out.println();

        int choice = Integer.parseInt(DataUtil.br.readLine());
        Teacher teacher = null;
        switch (choice) {
            case 1:
                teacher = this.teacherDataPrepare.prepareTeacherForRegistration();
                this.teacherService.insert(teacher);
                if(teacher != null) {
                    System.out.println(" New Student Added Successfully");
                }
                break;

            case 2:
                teacher = this.teacherDataPrepare.prepareTeacherForSearch();
                teacher = this.teacherService.search(teacher);
                this.teacherDataPrepare.searchTeacher(teacher);
                break;

            case 3:
                teacher = this.teacherDataPrepare.prepareTeacherForDelete();
                this.teacherService.delete(teacher);
                if (teacher != null) {
                    System.out.println("Teacher deleted successfully.");
                } else {
                    System.out.println("Failed to delete teacher.");
                }
                break;

            case 4:
                List<Teacher> teachers=this.teacherService.getAllTeacher();
                this.teacherDataPrepare.displayTeachers(teachers);
                break;

            case 5:
                teacher = this.teacherDataPrepare.prepareTeacherForUpdate();
                this.teacherService.update(teacher);
                if(teacher !=null){
                    System.out.println(" Student " + teacher .getName() + '(' + teacher .getId() + ')' + " updated successfully");
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
