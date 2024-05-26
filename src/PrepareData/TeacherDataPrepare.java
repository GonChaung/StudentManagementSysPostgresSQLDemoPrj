package PrepareData;

import Dao.DepartmentDao;
import Model.Department;
import Model.Teacher;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherDataPrepare extends PersonDataPrepare {
    BufferedReader br = DataUtil.br;
    private DepartmentDao departmentDao;

    public TeacherDataPrepare() {
        this.departmentDao = new DepartmentDao();
    }

    public Teacher prepareTeacherForSearch() throws IOException{
        Teacher teacher = new Teacher();
        System.out.println("Type Teacher ID : ");
        teacher.setId(Integer.parseInt(br.readLine()));
        return teacher;
    }

    public void searchTeacher(Teacher teacher)  {
        if (teacher != null) {
            System.out.println("Teacher found successfully.");
            System.out.println("Teacher ID: " + teacher.getId());
            System.out.println("Teacher Name: " + teacher.getName());
            System.out.println("Teacher Department: " + teacher.getDepartment().getName());
            System.out.println("Teacher Course: " + teacher.getCourse());
            System.out.println("Teacher Salary: " + teacher.getSalary());
            System.out.println("Teacher Email: " + teacher.getEmail());
        } else {
            System.out.println("Failed to find teacher.");
        }
    }

    public void displayTeacherByDepartment(List<Teacher> teachers, int departmentId) {
        if(teachers.isEmpty()) {
            System.out.println("No teacher found for department id " + departmentId);
        }else{
            System.out.println("Teachers for department id " + departmentId + "::");
            for (Teacher teacher : teachers) {
                System.out.println("Teacher ID: " + teacher.getId()+":: Name = " + teacher.getName());
            }
        }
    }

    public Teacher prepareTeacherForRegistration() throws IOException, SQLException {
        Teacher teacher = new Teacher();
        teacher = (Teacher) preparePersonDataForRegistration(teacher);
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
        return teacher;
    }

    public Teacher prepareTeacherForUpdate() throws IOException, SQLException {
        Teacher teacher = new Teacher();
        teacher = (Teacher) preparePersonDataForUpdate(teacher);
        System.out.println("Type teacher course : ");
        teacher.setCourse(br.readLine());
        System.out.println("Enter Teacher Salary: ");
        teacher.setSalary(Long.parseLong(br.readLine()));
        System.out.println("Select Department : ");
        for(Department department:this.departmentDao.getAllDepartments()){
            System.out.println("ID"+department.getId()+"::"+department.getName());
        }
        System.out.println("Enter Teacher Department: ");
        Department department = new Department();
        department.setId(Integer.parseInt(br.readLine()));
        teacher.setDepartment(department);;
        return teacher;
    }

    public void displayTeachers(List<Teacher> teachers) {
        for(Teacher teacher : teachers){
            System.out.println(" teacher id "+ teacher.getId() +
                    "/ name " + teacher.getName() +
                    "/ phone " + teacher.getPhone() +
                    "/ department " + teacher.getDepartment().getName() +
                    "/ email " + teacher.getEmail() +
                    "/ salary " + teacher.getSalary() +
                    "/ course " + teacher.getCourse() +
                    "/ age " + teacher.getAge() +
                    "/ gender " + teacher.getGender());
        }
    }

    public Teacher prepareTeacherForDelete() throws IOException, SQLException {
        Teacher teacher = new Teacher();
        teacher = (Teacher) preparePersonDataForDelete(teacher);
        return teacher;
    }
}
