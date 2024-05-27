package Dao;

import Model.Department;
import Model.Student;
import Utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends GeneralDao<Student>{
    Connection con = DatabaseUtil.getConnection();
    private DepartmentDao departmentDao;
    public StudentDao() {
       this.departmentDao=new DepartmentDao();
    }

    public Student deleteStudent(Student student) {
        String deleteSQL = "DELETE FROM students WHERE id = ?";
        PreparedStatement pstmt = null;
        try{
            pstmt= con.prepareStatement(deleteSQL);
            pstmt.setInt(1, student.getId());
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0){
                return student;
            }
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String searchSQL = "SELECT * FROM students";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(searchSQL);
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                Department department = this.departmentDao.searchDepartmentById(rs.getInt("department_id"));
                student.setDepartment(department);
                student.setAge(rs.getString("age"));
                student.setGender(rs.getString("gender"));
                students.add(student);
            }
        }catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(stmt != null) stmt.close();
                if(rs != null) rs.close();
                if(con != null) con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        return students;
    }

    public List<Student> getStudentByDepartment(int id) throws SQLException {
        List<Student> students = new ArrayList<>();
        Department department = departmentDao.searchDepartmentById(id);
        if (department == null) {
            return students;
        }
        String searchSQL = "SELECT * FROM students WHERE department_id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(searchSQL);
            pstmt.setInt(1, id);
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setEmail(rs.getString("email"));
                    student.setAge(rs.getString("age"));
                    student.setGender(rs.getString("gender"));
                    student.setDepartment(department);
                    students.add(student);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return students;
    }

    @Override
    public String getInsertQuerry() {
        return "INSERT INTO students (name, phone, email, department_id,age,gender) VALUES (?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(Student student,PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getPhone());
        pstmt.setString(3, student.getEmail());
        pstmt.setInt(4, student.getDepartment().getId());
        pstmt.setString(5, student.getAge());
        pstmt.setString(6, student.getGender());
        return pstmt;
    }

    @Override
    public String getUpdateQuerry() {
        return "UPDATE students SET name = ?, phone = ?, email = ?, department_id = ?, age = ?, gender = ? WHERE id = ?";
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(Student student, PreparedStatement pstmt) throws SQLException {
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
    public String getSearchQuerry() {
        return "SELECT * FROM students WHERE id = ?";
    }

    @Override
    public PreparedStatement prepareStatementForSearch(Student student, PreparedStatement pstmt, ResultSet rs) throws SQLException {
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setPhone(rs.getString("phone"));
        student.setEmail(rs.getString("email"));
        student.setDepartment(this.departmentDao.searchDepartmentById(rs.getInt("department_id")));
        student.setAge(rs.getString("age"));
        student.setGender(rs.getString("gender"));
        return pstmt;
    }


}
