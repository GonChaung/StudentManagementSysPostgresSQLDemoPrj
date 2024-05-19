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
        teacher.setName(br.readLine());
        System.out.println("Enter Teacher Department: ");
        teacher.setDepartment(br.readLine());
        System.out.println("Enter Teacher Course: ");
        teacher.setCourse(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setSalary(Long.parseLong(br.readLine())); // Changed to Long.parseLong()
        System.out.println("Enter Teacher Email: ");
        teacher.setEmail(br.readLine());

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
        teacher.setId(Integer.parseInt(br.readLine()));
        System.out.println("Enter Teacher Name: ");
        teacher.setName(br.readLine());
        System.out.println("Enter Teacher Department: ");
        teacher.setDepartment(br.readLine());
        System.out.println("Enter Teacher Course: ");
        teacher.setCourse(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setSalary(Long.parseLong(br.readLine())); // Changed to Long.parseLong()
        System.out.println("Enter Teacher Email: ");
        teacher.setEmail(br.readLine());

        Teacher updatedTeacher = this.teacherDao.updateTeacher(teacher);
        if (updatedTeacher != null) {
            System.out.println(teacher.getName() + " Teacher updated successfully.");
        } else {
            System.out.println("Failed to update teacher data.");
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

    public void getAllTeacher() throws SQLException {
        List<Teacher> teachers = this.teacherDao.getAllTeacher();
        for (Teacher teacher : teachers) {
            System.out.println("Teacher ID: " + teacher.getId() +
                    ", Teacher Name: " + teacher.getName() +
                    ", Teacher Department: " + teacher.getDepartment() +
                    ", Teacher Course: " + teacher.getCourse() +
                    ", Teacher Salary: " + teacher.getSalary() +
                    ", Teacher Email: " + teacher.getEmail());
        }
    }
}
