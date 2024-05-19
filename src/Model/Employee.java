package Model;

public class Employee {
    public int id;
    public String name;
    public String department;
    public long salary;
    public String phone;

    public Employee(int id, String name, String department, long salary, String phone) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.phone = phone;
    }

    public Employee() {
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
