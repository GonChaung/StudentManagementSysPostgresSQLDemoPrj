package Service;

import Dao.StudentDao;
import Model.Student;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.sql.*;
import java.util.List;

public class StudentService {
    BufferedReader br = DataUtil.br;
    private StudentDao studentDao;
    public StudentService() {
     this.studentDao = new StudentDao();
    }
    public Student searchStudent(Student student){
        Student searchStudent = this.studentDao.searchStudent(student);
        return searchStudent;
    }
    public void insertStudent(Student student) {
        Student insertedStudent = this.studentDao.insertStudent(student);
        if(insertedStudent != null) {
            System.out.println(" New Student Added Successfully");
        }
    }
    public void deleteStudent(Student student) {
        Student deletedStudent = this.studentDao.deleteStudent(student);
        if(deletedStudent != null) {
            System.out.println(" Student " + student.getId() + " deleted successfully");
        }else System.out.println("There is no student with ID " + student.getId());
    }
    public List<Student> getAllStudents() throws SQLException {
       List<Student> students = this.studentDao.getAllStudents();
       return students;
    }
    public void updateStudent(Student student)  {
        Student updatedStudent=this.studentDao.studentUpdate(student);
        if(updatedStudent!=null){
                System.out.println(" Student " + updatedStudent.getName() + '(' + updatedStudent.getId() + ')' + " updated successfully");
        }
    }
}
