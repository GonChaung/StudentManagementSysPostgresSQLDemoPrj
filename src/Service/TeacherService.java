package Service;

import Dao.TeacherDao;
import Model.Teacher;
import Utils.DataUtil;
import java.io.BufferedReader;
import java.io.IOException;

public class TeacherService {
    BufferedReader br = DataUtil.br;
    private TeacherDao teacherDao;
    public TeacherService() {
        this.teacherDao = new TeacherDao();
    }
    public void insertTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println(" Enter Teacher Name : ");
        teacher.setTeacher_name(br.readLine());
        System.out.println(" Enter Teacher Department : ");
        teacher.setTeacher_department(br.readLine());
        System.out.println(" Enter Teacher Course : ");
        teacher.setTeacher_course(br.readLine());
        System.out.println(" Enter Teacher Salary : ");
        teacher.setTeacher_salary(Integer.parseInt(br.readLine()));
        System.out.println(" Enter Teacher Email : ");
        teacher.setTeacher_email(br.readLine());
        Teacher teacherDao = this.teacherDao.insertTeacher(teacher);
        if (teacherDao != null) {
            System.out.println(" Teacher added successfully");
        }

    }
    public void updateTeacher() throws IOException {

    }
    public void deleteTeacher() throws IOException {

    }
    public void searchTeacher() throws IOException {

    }
}
