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

    public void insertTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Name: ");
        teacher.setTeacher_name(br.readLine());
        System.out.println("Enter Teacher Department: ");
        teacher.setTeacher_department(br.readLine());
        System.out.println("Enter Teacher Course: ");
        teacher.setTeacher_course(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setTeacher_salary(Long.parseLong(br.readLine())); // Changed to Long.parseLong()
        System.out.println("Enter Teacher Email: ");
        teacher.setTeacher_email(br.readLine());

        Teacher insertedTeacher = this.teacherDao.insertTeacher(teacher);
        if (insertedTeacher != null) {
            System.out.println("Teacher added successfully.");
        } else {
            System.out.println("Failed to add teacher.");
        }
    }

    public void updateTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher ID: ");
        teacher.setTeacher_id(Integer.parseInt(br.readLine()));
        System.out.println("Enter Teacher Name: ");
        teacher.setTeacher_name(br.readLine());
        System.out.println("Enter Teacher Department: ");
        teacher.setTeacher_department(br.readLine());
        System.out.println("Enter Teacher Course: ");
        teacher.setTeacher_course(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setTeacher_salary(Long.parseLong(br.readLine())); // Changed to Long.parseLong()
        System.out.println("Enter Teacher Email: ");
        teacher.setTeacher_email(br.readLine());

        Teacher updatedTeacher = this.teacherDao.updateTeacher(teacher);
        if (updatedTeacher != null) {
            System.out.println(teacher.getTeacher_name() + " Teacher updated successfully.");
        } else {
            System.out.println("Failed to update teacher data.");
        }
    }

    public void deleteTeacher() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher ID: ");
        teacher.setTeacher_id(Integer.parseInt(br.readLine()));

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
        teacher.setTeacher_id(Integer.parseInt(br.readLine()));

        Teacher foundTeacher = this.teacherDao.searchTeacher(teacher);
        if (foundTeacher != null) {
            System.out.println("Teacher found successfully.");
            System.out.println("Teacher ID: " + foundTeacher.getTeacher_id());
            System.out.println("Teacher Name: " + foundTeacher.getTeacher_name());
            System.out.println("Teacher Department: " + foundTeacher.getTeacher_department());
            System.out.println("Teacher Course: " + foundTeacher.getTeacher_course());
            System.out.println("Teacher Salary: " + foundTeacher.getTeacher_salary());
            System.out.println("Teacher Email: " + foundTeacher.getTeacher_email());
        } else {
            System.out.println("Failed to find teacher.");
        }
    }

    public void getAllTeacher() throws SQLException {
        List<Teacher> teachers = this.teacherDao.getAllTeacher();
        for (Teacher teacher : teachers) {
            System.out.println("Teacher ID: " + teacher.getTeacher_id() +
                    ", Teacher Name: " + teacher.getTeacher_name() +
                    ", Teacher Department: " + teacher.getTeacher_department() +
                    ", Teacher Course: " + teacher.getTeacher_course() +
                    ", Teacher Salary: " + teacher.getTeacher_salary() +
                    ", Teacher Email: " + teacher.getTeacher_email());
        }
    }
}
