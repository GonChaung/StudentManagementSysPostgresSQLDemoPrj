package Service;

import Dao.TeacherDao;
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

    public void deleteTeacher(Teacher teacher) throws IOException {
        Teacher deletedTeacher = this.teacherDao.deleteTeacher(teacher);
        if (deletedTeacher != null) {
            System.out.println("Teacher deleted successfully.");
        } else {
            System.out.println("Failed to delete teacher.");
        }
    }

    public Teacher searchTeacher(Teacher teacher) throws IOException {
        Teacher foundTeacher = this.teacherDao.searchTeacher(teacher);
        return foundTeacher;
    }

    public List<Teacher> getAllTeacher() throws SQLException, IOException {
        List<Teacher> teachers = this.teacherDao.getAllTeacher();
        return teachers;
    }
}
