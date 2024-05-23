package PrepareData;

import Dao.DepartmentDao;
import Dao.StudentDao;
import Model.Department;
import Model.Student;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDataPrepare {
    BufferedReader br = DataUtil.br;
    private DepartmentDao departmentDao;
    private StudentDao studentDao;
    public StudentDataPrepare() {
     this.departmentDao=new DepartmentDao();
        this.studentDao = new StudentDao();

    }

    public Student prepareStudentForRegistration() throws IOException, SQLException {
        Student student = new Student();
        System.out.println("Name : " ) ;
        student.setName(br.readLine());
        System.out.println("Phone : ");
        student.setPhone(br.readLine());
        System.out.println("Email : ");
        student.setEmail(br.readLine());
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
    public Student prepareStudentForSearch() throws IOException, SQLException {
        Student student = new Student();
        System.out.println("Type student ID : ");
        student.setId(Integer.parseInt(br.readLine()));
        Student searchStudent = this.studentDao.searchStudent(student);
        if(searchStudent != null) {
            System.out.println("student ID :" + searchStudent.getId());
            System.out.println("student Name :" + searchStudent.getName());
            System.out.println("student Email :" + searchStudent.getEmail());
            System.out.println("student Phone :" + searchStudent.getPhone());
            System.out.println("student Department : " + searchStudent.getDepartment().getName());
        }else System.out.println("There is no student with ID " + student.getId());
        return student;
    }
    public Student prepareStudentForUpdate() throws IOException {
        Student student = new Student();
        System.out.println("Type student ID : ");
        student.setId(Integer.parseInt(br.readLine()));
        System.out.println("Type student name : ");
        student.setName( br.readLine());
        System.out.println("Type student phone : ");
        student.setPhone( br.readLine());
        System.out.println("Type student email : ");
        student.setEmail(br.readLine());
        System.out.println("Type student department : ");
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
                    "/ email " + student.getEmail());
        }
    }
}
