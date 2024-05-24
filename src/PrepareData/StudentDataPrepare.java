package PrepareData;

import Dao.DepartmentDao;
import Model.Department;
import Model.Student;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDataPrepare extends PersonDataPrepare{
    BufferedReader br = DataUtil.br;
    private DepartmentDao departmentDao;

    public StudentDataPrepare() {
        this.departmentDao=new DepartmentDao();
    }

    public Student prepareStudentForRegistration() throws IOException, SQLException {

        Student student = new Student();
        student=(Student) preparePersonDataForRegistration(student);
        System.out.println("Select Department : ");
        for(Department department:this.departmentDao.getAllDepartments()){
            System.out.println("ID "+department.getId()+"::"+department.getName());
        }
        System.out.println("Enter Department ID: ");
        Department department = new Department();
        department.setId(Integer.parseInt(br.readLine()));
        student.setDepartment(department);
        return student;
    }
    public Student prepareStudentForSearch() throws IOException {
        Student student = new Student();
        System.out.println("Type student ID : ");
        student.setId(Integer.parseInt(br.readLine()));
        return student;
    }

    public void searchStudent(Student student) throws IOException {
        if(student != null) {
            System.out.println("student ID : " + student.getId());
            System.out.println("student Name : " + student.getName());
            System.out.println("student Email : " + student.getEmail());
            System.out.println("student Phone : " + student.getPhone());
            System.out.println("student Department : " + student.getDepartment().getName());
            System.out.println("student Age : " + student.getAge());
            System.out.println("student Gender : " + student.getGender());
        }else System.out.println("There is no student with ID " + student.getId());
    }
    public Student prepareStudentForUpdate() throws IOException, SQLException {
        Student student = new Student();
        student = (Student) preparePersonDataForUpdate(student);
        System.out.println("Select Department : ");
        for(Department department:this.departmentDao.getAllDepartments()){
            System.out.println("ID "+department.getId()+"::"+department.getName());
        }
        System.out.println("Enter Department ID: ");
        Department department = new Department();
        department.setId(Integer.parseInt(br.readLine()));
        student.setDepartment(department);
        return student;
    }

    public Student prepareStudentForDelete() throws IOException {
        Student student = new Student();
        System.out.println(" Type your student id : ");
        student.setId(Integer.parseInt(br.readLine()));
        return student;
    }
    public void displayStudents(List<Student> students) {
        for(Student student : students){
            System.out.println(" student id "+ student.getId() +
                    "/ name " + student.getName() +
                    "/ phone " + student.getPhone() +
                    "/ department " + student.getDepartment().getName() +
                    "/ email " + student.getEmail() +
                    "/ age " + student.getAge() +
                    "/ gender " + student.getGender()
            );

        }
    }
}
