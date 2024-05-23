package Controller;

import Model.Student;
import PrepareData.StudentDataPrepare;
import Service.StudentService;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private StudentService studentService;
    private StudentDataPrepare studentDataPrepare;

    public StudentController() {
        this.studentService = new StudentService();
        this.studentDataPrepare = new StudentDataPrepare();
    }

    public void studentRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Get all student data");
        System.out.println("5. Update Student Data");
        System.out.println();

        int choice = Integer.parseInt(DataUtil.br.readLine());

        switch (choice) {
            case 1:
                Student studentRegistration = this.studentDataPrepare.prepareStudentForRegistration();
                this.studentService.insertStudent(studentRegistration);
                break;

            case 2:
                Student studentSearch = this.studentDataPrepare.prepareStudentForSearch();
                this.studentService.searchStudent(studentSearch);
                break;

            case 3:
                Student studentDelete = this.studentDataPrepare.prepareStudentForDelete();
                this.studentService.deleteStudent(studentDelete);
                break;

            case 4:
                List<Student> students=this.studentService.getAllStudents();
                this.studentDataPrepare.displayStudents(students);
                break;

            case 5:
                Student studentUpdate = this.studentDataPrepare.prepareStudentForUpdate();
                this.studentService.updateStudent(studentUpdate);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
