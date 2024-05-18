package Dao;

import Model.Student;
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
            pstmt.setString(1, teacher.getTeacher_name());
            pstmt.setString(2, teacher.getTeacher_department());
            pstmt.setString(3, teacher.getTeacher_course());
            pstmt.setLong(4, teacher.getTeacher_salary());
            pstmt.setString(5, teacher.getTeacher_email());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher updateTeacher(Teacher teacher) {
        String updateSQL = "UPDATE teachers SET name = ?,department = ?,course = ?,salary = ?,email = ? WHERE teacher_id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(updateSQL)){
            pstmt.setString(1, teacher.getTeacher_name());
            pstmt.setString(2, teacher.getTeacher_department());
            pstmt.setString(3, teacher.getTeacher_course());
            pstmt.setLong(4, teacher.getTeacher_salary());
            pstmt.setString(5, teacher.getTeacher_email());
            pstmt.setInt(6, teacher.getTeacher_id());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher deleteTeacher(Teacher teacher){
        String deleteSQL = "DELETE FROM teachers WHERE teacher_id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(deleteSQL)){
            pstmt.setInt(1, teacher.getTeacher_id());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Teacher searchTeacher(Teacher teacher){
        String searchSQL = "SELECT * FROM teachers WHERE teacher_id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, teacher.getTeacher_id());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    teacher.setTeacher_id(rs.getInt("teacher_id"));
                    teacher.setTeacher_name(rs.getString("name"));
                    teacher.setTeacher_department(rs.getString("department"));
                    teacher.setTeacher_course(rs.getString("course"));
                    teacher.setTeacher_salary(rs.getLong("salary"));
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
            teacher.setTeacher_id(rs.getInt("teacher_id"));
            teacher.setTeacher_name(rs.getString("name"));
            teacher.setTeacher_department(rs.getString("department"));
            teacher.setTeacher_course(rs.getString("course"));
            teacher.setTeacher_salary(rs.getLong("salary"));
            teacher.setTeacher_email(rs.getString("email"));
            teachers.add(teacher);
        }
        return teachers;
    }
}
