package Dao;

import Model.Student;
import java.sql.*;

public class StudentDao extends GeneralDao<Student>{
    private DepartmentDao departmentDao;
    public StudentDao() {
       this.departmentDao=new DepartmentDao();
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO students (name, phone, email, department_id,age,gender) VALUES (?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(Student student,PreparedStatement pstmt) throws SQLException{
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getEmail());
            pstmt.setInt(4, student.getDepartment().getId());
            pstmt.setString(5, student.getAge());
            pstmt.setString(6, student.getGender());
            return pstmt;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE students SET name = ?, phone = ?, email = ?, department_id = ?, age = ?, gender = ? WHERE id = ?";
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(Student student, PreparedStatement pstmt) throws SQLException{
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getDepartment().getId()+"");
            pstmt.setString(5, student.getAge());
            pstmt.setString(6, student.getGender());
            pstmt.setInt(7, student.getId());
            return pstmt;
    }

    @Override
    public String getSearchQuery() {
        return "SELECT * FROM students WHERE id = ?";
    }

    @Override
    public Student mapResultSetToGenericType(ResultSet rs) {
        try{
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setPhone(rs.getString("phone"));
            student.setEmail(rs.getString("email"));
            student.setDepartment(this.departmentDao.searchDepartmentById(rs.getInt("department_id")));
            student.setAge(rs.getString("age"));
            student.setGender(rs.getString("gender"));
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM students WHERE id = ?";
    }

    @Override
    public Student deleteObj(Student student) throws SQLException {
        return student;
    }

    @Override
    public String getAllQuery() {
        return "SELECT * FROM students";
    }

    @Override
    public String getSearchByIdQuery() {
        return "SELECT * FROM students WHERE department_id = ?";
    }
}
