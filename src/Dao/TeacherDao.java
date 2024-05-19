package Dao;

import Model.Teacher;
import Utils.DatabaseUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    Connection con = DatabaseUtil.getConnection();
    public Teacher insertTeacher(Teacher teacher) {
        String insertSQL = "INSERT INTO teachers (name,department,course,salary,email) VALUES(?,?,?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getDepartment());
            pstmt.setString(3, teacher.getCourse());
            pstmt.setLong(4, teacher.getSalary());
            pstmt.setString(5, teacher.getEmail());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher updateTeacher(Teacher teacher) {
        String updateSQL = "UPDATE teachers SET name = ?,department = ?,course = ?,salary = ?,email = ? WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(updateSQL)){
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getDepartment());
            pstmt.setString(3, teacher.getCourse());
            pstmt.setLong(4, teacher.getSalary());
            pstmt.setString(5, teacher.getEmail());
            pstmt.setInt(6, teacher.getId());
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
                    teacher.setDepartment(rs.getString("department"));
                    teacher.setCourse(rs.getString("course"));
                    teacher.setSalary(rs.getLong("salary"));
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
            teacher.setId(rs.getInt("teacher_id"));
            teacher.setName(rs.getString("name"));
            teacher.setDepartment(rs.getString("department"));
            teacher.setCourse(rs.getString("course"));
            teacher.setSalary(rs.getLong("salary"));
            teacher.setEmail(rs.getString("email"));
            teachers.add(teacher);
        }
        return teachers;
    }
}
