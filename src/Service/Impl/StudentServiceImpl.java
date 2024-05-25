package Service.Impl;

import Dao.StudentDao;
import Model.Department;
import Model.Student;
import Service.StudentService;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.sql.*;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    BufferedReader br = DataUtil.br;
    private StudentDao studentDao;
    public StudentServiceImpl() {
     this.studentDao = new StudentDao();
    }
    public Student search(Student student){
        Student searchStudent = this.studentDao.searchStudent(student);
        return searchStudent;
    }
    public Student insert(Student student) {
        Student insert = this.studentDao.insertStudent(student);
        return insert;
    }
    public Student delete(Student student) {
        Student delete = this.studentDao.deleteStudent(student);
        return delete;
    }
    public List<Student> getAllStudents() throws SQLException {
       List<Student> students = this.studentDao.getAllStudents();
       return students;
    }
    public Student update(Student student)  {
        Student update=this.studentDao.studentUpdate(student);
        return update;
    }

    public List<Student> searchStudentByDepartment(int department) throws SQLException {
        return this.studentDao.getStudentByDepartment(department);
    }

}
