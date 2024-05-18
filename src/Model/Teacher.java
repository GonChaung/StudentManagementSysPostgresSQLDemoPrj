package Model;

public class Teacher {
    public int teacher_id;
    public String teacher_name;
    public String teacher_department;
    public String teacher_course;
    public long teacher_salary;
    public String teacher_email;

    public Teacher() {
    }

    public Teacher(int teacher_id, String teacher_name, String teacher_department, String teacher_course, int teacher_salary, String teacher_email) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_department = teacher_department;
        this.teacher_course = teacher_course;
        this.teacher_salary = teacher_salary;
        this.teacher_email = teacher_email;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_department() {
        return teacher_department;
    }

    public void setTeacher_department(String teacher_department) {
        this.teacher_department = teacher_department;
    }

    public String getTeacher_course() {
        return teacher_course;
    }

    public void setTeacher_course(String teacher_course) {
        this.teacher_course = teacher_course;
    }

    public long getTeacher_salary() {
        return teacher_salary;
    }

    public void setTeacher_salary(long teacher_salary) {
        this.teacher_salary = teacher_salary;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }
}
