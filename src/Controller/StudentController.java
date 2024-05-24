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
        Student student = null;
        switch (choice) {
            case 1:
                student = this.studentDataPrepare.prepareStudentForRegistration();
                this.studentService.insertStudent(student);
                break;

            case 2:
                student = this.studentDataPrepare.prepareStudentForSearch();
                student=this.studentService.searchStudent(student);
                this.studentDataPrepare.searchStudent(student);
                break;

            case 3:
                student = this.studentDataPrepare.prepareStudentForDelete();
                this.studentService.deleteStudent(student);
                break;

            case 4:
                List<Student> students=this.studentService.getAllStudents();
                this.studentDataPrepare.displayStudents(students);
                break;

            case 5:
                student = this.studentDataPrepare.prepareStudentForUpdate();
                this.studentService.updateStudent(student);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
