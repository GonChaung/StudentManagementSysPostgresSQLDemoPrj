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
        student.setStudent_id(Integer.parseInt(br.readLine()));
        Student searchStudent = this.studentDao.searchStudent(student);
        if(searchStudent != null) {
            System.out.println("student ID :" + searchStudent.getStudent_id());
            System.out.println("student Name :" + searchStudent.getStudent_name());
            System.out.println("student Email :" + searchStudent.getStudent_email());
            System.out.println("student Phone :" + searchStudent.getStudent_phone());
            System.out.println("student Department : " + searchStudent.getStudent_department());
        }else System.out.println("There is no student with ID " + student.getStudent_id());
    }
    public void insertStudent() throws IOException {
        Student student = new Student();
        System.out.println("Name : " ) ;
        student.setStudent_name(br.readLine());
        System.out.println("Phone : ");
        student.setStudent_phone(br.readLine());
        System.out.println("Email : ");
        student.setStudent_email(br.readLine());
        System.out.println("Department : ");
        student.setStudent_department(br.readLine());
        Student insertedStudent = this.studentDao.insertStudent(student);
        if(insertedStudent != null) {
            System.out.println(" New Student Added Successfully");
        }
    }
    public void deleteStudent() throws IOException {
        Student student = new Student();
        System.out.println(" Type your student id : ");
        student.setStudent_id(Integer.parseInt(br.readLine()));
        Student deletedStudent = this.studentDao.deleteStudent(student);
        if(deletedStudent != null) {
            System.out.println(" Student " + student.getStudent_id() + " deleted successfully");
        }else System.out.println("There is no student with ID " + student.getStudent_id());
    }
    public void getAllStudents() throws SQLException, IOException {
       List<Student> students = this.studentDao.getAllStudents();
       for(Student student : students){
           System.out.println(" student id "+ student.getStudent_id() +
                   "/ name " + student.getStudent_name() +
                   "/ phone " + student.getStudent_phone() +
                   "/ department " + student.getStudent_department() +
                   "/ email " + student.getStudent_email());
       }
    }
    public void updateStudent() throws IOException {
        Student student = new Student();
        System.out.println("Type student ID : ");
        student.setStudent_id(Integer.parseInt(br.readLine()));
        System.out.println("Type student name : ");
        student.setStudent_name( br.readLine());
        System.out.println("Type student phone : ");
        student.setStudent_phone( br.readLine());
        System.out.println("Type student email : ");
        student.setStudent_email(br.readLine());
        System.out.println("Type student department : ");
        student.setStudent_department(br.readLine());
        Student updatedStudent=this.studentDao.studentUpdate(student);
        if(updatedStudent!=null){
                System.out.println(" Student " + updatedStudent.getStudent_name() + '(' + updatedStudent.getStudent_id() + ')' + " updated successfully");
        }
    }
}
