package Model;

public class Employee extends Person {
    public long salary;
    public EmployeeType employeeType;
    public Employee() {
    }

    public Employee(int id, String name, String age, String gender, String phone, String email, long salary, EmployeeType employeeType) {
        super(id, name, age, gender, phone, email);
        this.salary = salary;
        this.employeeType= employeeType;
    }


    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeTypeID(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
