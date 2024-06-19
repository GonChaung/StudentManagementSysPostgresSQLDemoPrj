package Model;

public class Department {
    public int id;
    public String name;
    public String description;
    public String address;
    public int major_id;

    public Department(int id, String name, String description, String address, int major_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.major_id = major_id;
    }

    public Department() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }
}
