package Model;

public class Employee extends Person {
    public long salary;
    public String department;
    public Employee() {
    }

    public Employee(int id, String name, String age, String gender, String phone, String email, long salary, String department) {
        super(id, name, age, gender, phone, email);
        this.salary = salary;
        this.department = department;
    }


    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
