package Controller;
import Service.StudentService;
import Utils.DataUtil;
import java.io.IOException;
import java.sql.SQLException;
public class StudentController {
    private StudentService studentService;
    public StudentController() {
        this.studentService = new StudentService();
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
        switch(choice){
            case 1: this.studentService.insertStudent();
                break;
            case 2: this.studentService.searchStudent();
                break;
            case 3: this.studentService.deleteStudent();
                break;
            case 4: this.studentService.getAllStudents();
                break;
            case 5: this.studentService.updateStudent();
                break;
        }
    }
}
