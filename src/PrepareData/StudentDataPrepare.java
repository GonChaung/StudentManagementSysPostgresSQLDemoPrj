package PrepareData;

import Dao.DepartmentDao;
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

    public StudentDataPrepare() {
     this.departmentDao=new DepartmentDao();

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
