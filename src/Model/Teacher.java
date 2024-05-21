package Model;

public class Teacher extends Person{
    public Department department;
    public String course;
    public long salary;

    public Teacher() {
    }

    public Teacher(int id, String name, String age, String gender, String phone, String email, String course, long salary) {
        super(id, name, age, gender, phone, email);
        this.department = department;
        this.course = course;
        this.salary = salary;
    }


    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
