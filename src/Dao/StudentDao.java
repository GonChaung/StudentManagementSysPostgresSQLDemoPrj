package Dao;

import Model.Student;
import Utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection con= DatabaseUtil.getConnection();
    public Student studentUpdate(Student student) {
        String updateSQL = "UPDATE students SET name = ?, phone = ?, email = ?, department = ? WHERE student_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
            pstmt.setString(1, student.getStudent_name());
            pstmt.setString(2, student.getStudent_phone());
            pstmt.setString(3, student.getStudent_email());
            pstmt.setString(4, student.getStudent_department());
            pstmt.setInt(5, student.getStudent_id());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return student;
            } else return null;
//            System.out.println(" Failed to update student.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Student insertStudent(Student student) {
        String insertSQL = "INSERT INTO students (name, phone, email, department) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)){
            pstmt.setString(1, student.getStudent_name());
            pstmt.setString(2, student.getStudent_phone());
            pstmt.setString(3, student.getStudent_email());
            pstmt.setString(4, student.getStudent_department());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return student;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Student searchStudent(Student student) {
        String searchSQL = "SELECT * FROM students WHERE student_id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, student.getStudent_id());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    student.setStudent_id(rs.getInt("student_id"));
                    student.setStudent_name(rs.getString("name"));
                    student.setStudent_phone(rs.getString("phone"));
                    student.setStudent_email(rs.getString("email"));
                    student.setStudent_department(rs.getString("department"));
                    return student;
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
    public Student deleteStudent(Student student) {
        String deleteSQL = "DELETE FROM students WHERE name = ? AND student_id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(deleteSQL)){
            pstmt.setInt(2, student.getStudent_id());
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0){
                return student;
                //System.out.println(" Student " + student.getStudent_id() + " deleted successfully");
            }
            else return null; //System.out.println(" Failed to delete student.");
    } catch (SQLException e) {
            throw new RuntimeException(e);}
    }
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String searchSQL = "SELECT * FROM students";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(searchSQL);
        while(rs.next()){
            Student student = new Student();
            student.setStudent_id(rs.getInt("student_id"));
            student.setStudent_name(rs.getString("name"));
            student.setStudent_phone(rs.getString("phone"));
            student.setStudent_email(rs.getString("email"));
            student.setStudent_department(rs.getString("department"));
            students.add(student);
        }
        return students;
    }
}
