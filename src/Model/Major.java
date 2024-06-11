package Model;

public class Major {
    public int id;
    public String name;
    public String code;
    public int departmentid;

    public Major () {
    }

    public Major (int id, String name, String code, int departmentid) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.departmentid = departmentid;
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

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
}
