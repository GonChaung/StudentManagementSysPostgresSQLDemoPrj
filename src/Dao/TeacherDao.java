package Dao;

import Model.Teacher;
import Utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDao {
    Connection con = DatabaseUtil.getConnection();
    public Teacher insertTeacher(Teacher teacher) {
        String insertSQL = "INSERT INTO teachers (name,department,course,salary,email) VALUES(?,?,?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
            pstmt.setString(1, teacher.getTeacher_name());
            pstmt.setString(2, teacher.getTeacher_department());
            pstmt.setString(3, teacher.getTeacher_course());
            pstmt.setDouble(4, teacher.getTeacher_salary());
            pstmt.setString(5, teacher.getTeacher_email());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return teacher;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
