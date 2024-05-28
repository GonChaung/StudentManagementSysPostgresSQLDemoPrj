package Service.Impl;

import Dao.TeacherDao;
import Model.Teacher;
import Service.TeacherService;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    BufferedReader br = DataUtil.br;
    private TeacherDao teacherDao;

    public TeacherServiceImpl() {
        this.teacherDao = new TeacherDao();
    }

    public Teacher insert(Teacher teacher) {
        Teacher insert = this.teacherDao.insert(teacher);
        return insert;
    }

    public Teacher update(Teacher teacher) {
        Teacher update = this.teacherDao.update(teacher);
        return update;
    }

    public Teacher delete(Teacher teacher) {
        Teacher delete = this.teacherDao.delete(teacher.getId(),teacher);
        return delete;
    }

    public Teacher search (Teacher teacher) {
        Teacher found = this.teacherDao.search(teacher.getId());
        return found;
    }

    public List<Teacher> getAllTeacher() throws SQLException {
        List<Teacher> teachers = this.teacherDao.getAll();
        return teachers;
    }

    public List<Teacher> searchTeacherByDepartment(int departmentId) throws SQLException {
        return this.teacherDao.getObjectById(departmentId);
    }
}
