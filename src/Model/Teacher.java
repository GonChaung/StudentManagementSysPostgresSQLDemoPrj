package Model;

public class Teacher {
    public int id;
    public String name;
    public String department;
    public String course;
    public long salary;
    public String email;

    public Teacher() {
    }

    public Teacher(int id, String name, String department, String course, int salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.course = course;
        this.salary = salary;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
