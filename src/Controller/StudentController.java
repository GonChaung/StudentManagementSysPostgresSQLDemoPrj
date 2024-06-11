package Controller;

import Model.Department;
import Model.Major;
import Model.Student;
import PrepareData.StudentDataPrepare;
import Service.Impl.StudentServiceImpl;
import Utils.DataUtil;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import java.util.List;

public class StudentController {
    private StudentServiceImpl studentService;
    private StudentDataPrepare studentDataPrepare;

    public StudentController() {
        this.studentService = new StudentServiceImpl();
        this.studentDataPrepare = new StudentDataPrepare();
    }

    public void studentRegister() throws SQLException, IOException {
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Get all student data");
        System.out.println("5. Update Student Data");
        System.out.println("6. Search Student by department");
        System.out.println("7. Course Registration");
        System.out.println();

        int choice = Integer.parseInt(DataUtil.br.readLine());
        Student student = null;
        switch (choice) {
            case 1:
                student = this.studentDataPrepare.prepareStudentForRegistration();
                this.studentService.insert(student);
                if(student != null) {
                    System.out.println(" New Student Added Successfully");
                }
                break;

            case 2:
                student = this.studentDataPrepare.prepareStudentForSearch();
                student=this.studentService.search(student);
                this.studentDataPrepare.searchStudent(student);
                break;

            case 3:
                student = this.studentDataPrepare.prepareStudentForDelete();
                this.studentService.delete(student);
                if(student != null) {
                    System.out.println(" Student " + student.getId() + " deleted successfully");
                }else System.out.println("There is no student with ID " + student.getId());
                break;

            case 4:
                List<Student> students=this.studentService.getAllStudents();
                this.studentDataPrepare.displayStudents(students);
                break;

            case 5:
                student = this.studentDataPrepare.prepareStudentForUpdate();
                this.studentService.update(student);
                if(student!=null){
                    System.out.println(" Student " + student.getName() + '(' + student.getId() + ')' + " updated successfully");
                }
                break;
            case 6:
                System.out.println("Enter Department ID: ");
                int departmentId = Integer.parseInt(DataUtil.br.readLine());
                List<Student> studentsByDepartment = this.studentService.searchStudentByDepartment(departmentId);
                this.studentDataPrepare.displayStudentByDepartment(studentsByDepartment, departmentId);
                break;
            case 7:
                this.studentDataPrepare.prepareStudentCourseRegister();
        }
    }
}
