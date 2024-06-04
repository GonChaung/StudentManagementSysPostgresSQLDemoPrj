package Service.Impl;

import Dao.StudentDao;
import Model.Student;
import Service.StudentService;
import java.sql.*;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl() {
     this.studentDao = new StudentDao();
    }
    public Student search(Student student){
        Student searchStudent = this.studentDao.search(student.getId());
        return searchStudent;
    }
    public Student insert(Student student) {
        Student insert = this.studentDao.insert(student);
        return insert;
    }
    public Student delete(Student student) {
        Student delete = this.studentDao.delete(student.getId(),student);
        return delete;
    }
    public List<Student> getAllStudents() throws SQLException {
       List<Student> students = this.studentDao.getAll();
       return students;
    }
    public Student update(Student student)  {
        Student update=this.studentDao.update(student);
        return update;
    }

    public List<Student> searchStudentByDepartment(int departmentId) throws SQLException {
        return this.studentDao.getObjectById(departmentId);
    }


}
