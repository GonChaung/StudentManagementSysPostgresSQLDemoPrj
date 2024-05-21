package Dao;

import Model.Department;
import Model.Teacher;
import Utils.DatabaseUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    Connection con = DatabaseUtil.getConnection();
    private DepartmentDao departmentDao;

    public TeacherDao() {
        this.departmentDao = new DepartmentDao();
    }

    public Teacher insertTeacher(Teacher teacher) {
        String insertSQL = "INSERT INTO teachers (name,department_id,course,salary,email,age,gender) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setInt(2, teacher.getDepartment().getId());
            pstmt.setString(3, teacher.getCourse());
            pstmt.setLong(4, teacher.getSalary());
            pstmt.setString(5, teacher.getEmail());
            pstmt.setString(6, teacher.getAge());
            pstmt.setString(7, teacher.getGender());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher updateTeacher(Teacher teacher) {
        String updateSQL = "UPDATE teachers SET name = ?,department_id = ?,course = ?,salary = ?,email = ?,age = ?, gender = ? WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(updateSQL)){
            pstmt.setString(1, teacher.getName());
            pstmt.setInt(2, teacher.getDepartment().getId());
            pstmt.setString(3, teacher.getCourse());
            pstmt.setLong(4, teacher.getSalary());
            pstmt.setString(5, teacher.getEmail());
            pstmt.setString(6, teacher.getAge());
            pstmt.setString(7, teacher.getGender());
            pstmt.setInt(8, teacher.getId());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher deleteTeacher(Teacher teacher){
        String deleteSQL = "DELETE FROM teachers WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(deleteSQL)){
            pstmt.setInt(1, teacher.getId());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher searchTeacher(Teacher teacher){
        String searchSQL = "SELECT * FROM teachers WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, teacher.getId());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    teacher.setId(rs.getInt("teacher_id"));
                    teacher.setName(rs.getString("name"));
                    teacher.setDepartment(this.departmentDao.searchDepartmentById(rs.getInt("department_id")));
                    teacher.setCourse(rs.getString("course"));
                    teacher.setSalary(rs.getLong("salary"));
                    teacher.setEmail(rs.getString("email"));
                    teacher.setAge(rs.getString("age"));
                    teacher.setGender(rs.getString("gender"));
                    return teacher;
                }
                else{
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Teacher> getAllTeacher() throws SQLException{
        List<Teacher> teachers = new ArrayList<>();
        String searchSQL = "SELECT * FROM teachers";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while(rs.next()){
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
            teachers.add(teacher);
        }
        return teachers;
    }
}
