package Dao;

import Model.Department;
import Model.Teacher;

import java.sql.*;


public class TeacherDao extends GeneralDao<Teacher> {
    private DepartmentDao departmentDao;

    public TeacherDao() {
        this.departmentDao = new DepartmentDao();
    }


    @Override
    public String getInsertQuery() {
        return "INSERT INTO teachers (name,department_id,course,salary,email,age,gender) VALUES(?,?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(Teacher teacher, PreparedStatement pstmt) {
        try{pstmt.setString(1, teacher.getName());
        pstmt.setInt(2, teacher.getDepartment().getId());
        pstmt.setString(3, teacher.getCourse());
        pstmt.setLong(4, teacher.getSalary());
        pstmt.setString(5, teacher.getEmail());
        pstmt.setString(6, teacher.getAge());
        pstmt.setString(7, teacher.getGender());
        return pstmt;}
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE teachers SET name = ?,department_id = ?,course = ?,salary = ?,email = ?,age = ?, gender = ? WHERE id = ?";
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(Teacher teacher, PreparedStatement pstmt) {
        try{
            pstmt.setString(1, teacher.getName());
            pstmt.setInt(2, teacher.getDepartment().getId());
            pstmt.setString(3, teacher.getCourse());
            pstmt.setLong(4, teacher.getSalary());
            pstmt.setString(5, teacher.getEmail());
            pstmt.setString(6, teacher.getAge());
            pstmt.setString(7, teacher.getGender());
            pstmt.setInt(8, teacher.getId());
            return pstmt;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getSearchQuery() {
        return "SELECT * FROM teachers WHERE id = ?";
    }

    @Override
    public Teacher mapResultSetToGenericType(ResultSet rs) {
        try{
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            Department department = this.departmentDao.searchDepartmentById(rs.getInt("department_id"));
            teacher.setDepartment(department);
            teacher.setCourse(rs.getString("course"));
            teacher.setSalary(rs.getLong("salary"));
            teacher.setEmail(rs.getString("email"));
            teacher.setAge(rs.getString("age"));
            teacher.setGender(rs.getString("gender"));
            return teacher;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM teachers WHERE id = ?";
    }

    @Override
    public Teacher deleteObj(Teacher teacher) throws SQLException {
        return teacher;
    }

    @Override
    public String getAllQuery() {
        return "SELECT * FROM teachers";
    }

    @Override
    public String getSearchByIdQuery() {
        return "SELECT * FROM teachers WHERE department_id = ?";
    }
}
