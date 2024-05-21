package Model;
public class Student extends Person {
    public Department department;
    public Student(){}

    public Student(int id, String name, String age, String gender, String phone, String email, Department department) {
        super(id, name, age, gender, phone, email);
        this.department = department;
    }
    public Department getDepartment() {
        return this.department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
