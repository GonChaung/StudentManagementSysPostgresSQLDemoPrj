package Dao;

import Model.Course;
import Utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MajorDao {
    Connection con = DatabaseUtil.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<Course> getCoursesByMajor(int majorId) {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses WHERE major_id = ?";
        try{
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, majorId);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
