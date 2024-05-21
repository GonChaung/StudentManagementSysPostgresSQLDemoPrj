package Service;

import Dao.TeacherDao;
import Model.Student;
import Model.Teacher;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherService {
    BufferedReader br = DataUtil.br;
    private TeacherDao teacherDao;

    public TeacherService() {
        this.teacherDao = new TeacherDao();
    }

    public void insertTeacher(Teacher teacher) throws IOException {
        Teacher insertedStudent = this.teacherDao.insertTeacher(teacher);
        if(insertedStudent != null) {
            System.out.println(" New Student Added Successfully");
        }
    }

    public void updateTeacher(Teacher teacher) throws IOException {
        Teacher updatedTeacher = this.teacherDao.updateTeacher(teacher);
        if(updatedTeacher!=null){
            System.out.println(" Student " + updatedTeacher.getName() + '(' + updatedTeacher.getId() + ')' + " updated successfully");
        }
    }

    public void deleteTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher ID: ");
        teacher.setId(Integer.parseInt(br.readLine()));
        Teacher deletedTeacher = this.teacherDao.deleteTeacher(teacher);
        if (deletedTeacher != null) {
            System.out.println("Teacher deleted successfully.");
        } else {
            System.out.println("Failed to delete teacher.");
        }
    }

    public void searchTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher ID: ");
        teacher.setId(Integer.parseInt(br.readLine()));

        Teacher foundTeacher = this.teacherDao.searchTeacher(teacher);
        if (foundTeacher != null) {
            System.out.println("Teacher found successfully.");
            System.out.println("Teacher ID: " + foundTeacher.getId());
            System.out.println("Teacher Name: " + foundTeacher.getName());
            System.out.println("Teacher Department: " + foundTeacher.getDepartment());
            System.out.println("Teacher Course: " + foundTeacher.getCourse());
            System.out.println("Teacher Salary: " + foundTeacher.getSalary());
            System.out.println("Teacher Email: " + foundTeacher.getEmail());
        } else {
            System.out.println("Failed to find teacher.");
        }
    }

    public List<Teacher> getAllTeacher() throws SQLException, IOException {
        List<Teacher> teachers = this.teacherDao.getAllTeacher();
        return teachers;
    }
}
