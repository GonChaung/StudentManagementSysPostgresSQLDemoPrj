package Model;

public class Course {
    public int id;
    public String name;
    public String code;
    public int major_id;

    public Course(){}

    public Course(int id, String name, String code, int major_id) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.major_id = major_id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }
}
