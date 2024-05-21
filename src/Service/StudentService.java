package Service;

import Dao.StudentDao;
import Model.Student;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class StudentService {
    BufferedReader br = DataUtil.br;
    private StudentDao studentDao;
    public StudentService() {
     this.studentDao = new StudentDao();
    }
    public void searchStudent( ) throws IOException {
        Student student = new Student();
        System.out.println("Type student ID : ");
        student.setId(Integer.parseInt(br.readLine()));
        Student searchStudent = this.studentDao.searchStudent(student);
        if(searchStudent != null) {
            System.out.println("student ID :" + searchStudent.getId());
            System.out.println("student Name :" + searchStudent.getName());
            System.out.println("student Email :" + searchStudent.getEmail());
            System.out.println("student Phone :" + searchStudent.getPhone());
            System.out.println("student Department : " + searchStudent.getDepartment());
        }else System.out.println("There is no student with ID " + student.getId());
    }
    public void insertStudent(Student student) throws IOException {
        Student insertedStudent = this.studentDao.insertStudent(student);
        if(insertedStudent != null) {
            System.out.println(" New Student Added Successfully");
        }
    }
    public void deleteStudent() throws IOException {
        Student student = new Student();
        System.out.println(" Type your student id : ");
        student.setId(Integer.parseInt(br.readLine()));
        Student deletedStudent = this.studentDao.deleteStudent(student);
        if(deletedStudent != null) {
            System.out.println(" Student " + student.getId() + " deleted successfully");
        }else System.out.println("There is no student with ID " + student.getId());
    }
    public List<Student> getAllStudents() throws SQLException, IOException {
       List<Student> students = this.studentDao.getAllStudents();
       return students;
    }
    public void updateStudent(Student student) throws IOException {
        Student updatedStudent=this.studentDao.studentUpdate(student);
        if(updatedStudent!=null){
                System.out.println(" Student " + updatedStudent.getName() + '(' + updatedStudent.getId() + ')' + " updated successfully");
        }
    }
}
