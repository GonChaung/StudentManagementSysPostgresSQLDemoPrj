package Model;

public class Employee {
    public int employee_id;
    public String employee_name;
    public String employee_department;
    public long employee_salary;
    public String employee_phone;

    public Employee(int employee_id, String employee_name, String employee_department, long employee_salary, String employee_phone) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_department = employee_department;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
    }

    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_department() {
        return employee_department;
    }

    public void setEmployee_department(String employee_department) {
        this.employee_department = employee_department;
    }

    public long getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(long employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }
}
