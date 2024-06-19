package Dao;

import Utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentCoursesDao {
    Connection con = DatabaseUtil.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public void addStudentCourses(int student_id, List<Integer> course_ids) throws SQLException {
        String query = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?)";
        try {
            pstmt = con.prepareStatement(query);
            for (int course_id : course_ids) {
                pstmt.setInt(1, student_id);
                pstmt.setInt(2, course_id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
