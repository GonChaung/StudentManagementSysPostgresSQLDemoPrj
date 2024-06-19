package PrepareData;

import Dao.DepartmentDao;
import Dao.MajorDao;
import Dao.StudentCoursesDao;
import Model.Course;
import Model.Department;
import Model.Major;
import Model.Student;
import Service.Impl.StudentServiceImpl;
import Service.StudentService;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentDataPrepare extends PersonDataPrepare{
    BufferedReader br = DataUtil.br;
    private DepartmentDao departmentDao;
    private StudentService studentService;
    private MajorDao majorDao;
    private CourseDataPrepare courseDataPrepare;
    StudentCoursesDao studentCoursesDao;

    public StudentDataPrepare() {
        this.departmentDao=new DepartmentDao();
        this.studentService = new StudentServiceImpl();
        this.majorDao=new MajorDao();
        this.courseDataPrepare = new CourseDataPrepare();
        this.studentCoursesDao=new StudentCoursesDao();
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

    public Student prepareStudentForDelete() throws IOException, SQLException {
        Student student = new Student();
        student = (Student) preparePersonDataForDelete(student);
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

    public void displayStudentByDepartment(List<Student> students, int id) {
        if(students.isEmpty()){
            System.out.println("There is no student with ID " + id);
        }else{
            System.out.println("Student for Department ID " + id + ":");
            for(Student student : students){
                System.out.println("ID "+student.getId()+":: Name = "+student.getName());
            }
        }
    }

    public void prepareStudentCourseRegister() throws IOException, SQLException {
        System.out.println("Enter student ID:");
        int studentId = Integer.parseInt(br.readLine());
        Student student = (Student) studentService.search(new Student(studentId));
        if (student == null) {
            System.out.println("Invalid student ID. Please try again.");
        }
        Department department = student.getDepartment();
        System.out.println("Student's department: " + department.getName());
        List<Major> majors = departmentDao.getMajorsByDepartment(department.getId());
        System.out.println("Available majors in the department:");
        for (Major major : majors) {
            System.out.println("ID: " + major.getId() + ", Name: " + major.getName());
        }
        System.out.println("What major do you want to register?");
        int major = Integer.parseInt(br.readLine());
        List<Course> courses = majorDao.getCoursesByMajor(major);
        System.out.println("Available courses in the major: ");
        for (Course course : courses) {
            System.out.println("ID: " + course.getId() + ", Name: " + course.getName());
        }
        List<String> coursesDataPrepare = courseDataPrepare.courseDataPrepare();
        List<Integer> courseIds = coursesDataPrepare.stream().map(Integer::parseInt).toList();
        studentCoursesDao.addStudentCourses(studentId, courseIds);
        System.out.println("Student course registration successful.");
    }
}
