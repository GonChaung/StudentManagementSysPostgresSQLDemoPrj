package PrepareData;

import Dao.DepartmentDao;
import Model.Department;
import Model.Student;
import Model.Teacher;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherDataPrepare {
    BufferedReader br = DataUtil.br;
    private DepartmentDao departmentDao;

    public TeacherDataPrepare() {
        this.departmentDao = new DepartmentDao();
    }

    public Teacher prepareTeacherForRegistration() throws IOException, SQLException {
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Name: ");
        teacher.setName(br.readLine());
        System.out.println("Select Department : ");
        for(Department department:this.departmentDao.getAllDepartments()){
            System.out.println("ID"+department.getId()+"::"+department.getName());
        }
        System.out.println("Enter Teacher Department: ");
        Department department = new Department();
        department.setId(Integer.parseInt(br.readLine()));
        teacher.setDepartment(department);
        System.out.println("Enter Teacher Course: ");
        teacher.setCourse(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setSalary(Long.parseLong(br.readLine()));
        System.out.println("Enter Teacher Email: ");
        teacher.setEmail(br.readLine());
        return teacher;
    }

    public Teacher prepareTeacherForUpdate() throws IOException {
        Teacher teacher = new Teacher();
        System.out.println("Type teacher ID : ");
        teacher.setId(Integer.parseInt(br.readLine()));
        System.out.println("Type teacher name : ");
        teacher.setName( br.readLine());
        System.out.println("Type teacher phone : ");
        teacher.setPhone( br.readLine());
        System.out.println("Type teacher email : ");
        teacher.setEmail(br.readLine());
        System.out.println("Type teacher department : ");
        Department department = new Department();
        department.setId(Integer.parseInt(br.readLine()));
        teacher.setDepartment(department);
        return teacher;
    }

    public void displayTeachers(List<Teacher> teachers) {
        for(Teacher teacher : teachers){
            System.out.println(" teacher id "+ teacher.getId() +
                    "/ name " + teacher.getName() +
                    "/ phone " + teacher.getPhone() +
                    "/ department " + teacher.getDepartment().getName() +
                    "/ email " + teacher.getEmail());
        }
    }
}
