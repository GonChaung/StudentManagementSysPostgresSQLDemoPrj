package Dao;

import Model.Student;
import Utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection con= DatabaseUtil.getConnection();
    public Student studentUpdate(Student student) {
        String updateSQL = "UPDATE students SET name = ?, phone = ?, email = ?, department = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getDepartment());
            pstmt.setInt(5, student.getId());
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
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getDepartment());
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                return student;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Student searchStudent(Student student) {
        String searchSQL = "SELECT * FROM students WHERE id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
            pstmt.setInt(1, student.getId());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setEmail(rs.getString("email"));
                    student.setDepartment(rs.getString("department"));
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
        String deleteSQL = "DELETE FROM students WHERE name = ? AND id = ?";
        try(PreparedStatement pstmt = con.prepareStatement(deleteSQL)){
            pstmt.setInt(2, student.getId());
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
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setPhone(rs.getString("phone"));
            student.setEmail(rs.getString("email"));
            student.setDepartment(rs.getString("department"));
            students.add(student);
        }
        return students;
    }
}
