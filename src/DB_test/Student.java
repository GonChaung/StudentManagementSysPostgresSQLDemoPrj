package DB_test;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.BufferedReader;
public class Student {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "0000";
        System.out.println("What do you want to do?");
        System.out.println("1. Insert Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Get all student data");
        System.out.println("5. Update Student Data");
        System.out.println();
        int choice = Integer.parseInt(br.readLine());
        switch(choice){
            case 1: insertStudent(url, username, password, br);
            break;
            case 2: searchStudent(url, username, password, br);
            break;
            case 3: deleteStudent(url, username, password, br);
            break;
            case 4: getAllStudents(url, username, password);
            break;
            case 5: updateStudent(url, username, password, br);
            break;
        }
    }
    private static void searchStudent(String url, String username, String password, BufferedReader br) throws SQLException, IOException {
        String searchSQL = "SELECT * FROM students WHERE student_id = ?";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println("Type student ID : ");
            int studentId = Integer.parseInt(br.readLine());
            try(PreparedStatement pstmt = con.prepareStatement(searchSQL)){
                pstmt.setInt(1, studentId);
                try(ResultSet rs = pstmt.executeQuery()){
                    if(rs.next()){
                        System.out.println("Student ID : " + rs.getInt("student_id"));
                        System.out.println("Name : " + rs.getString("name"));
                        System.out.println("Phone : " + rs.getString("phone"));
                        System.out.println("Email : " + rs.getString("email"));
                        System.out.println("Department : " + rs.getString("department"));
                    }
                    else{
                        System.out.println("No Name Found");
                    }
                }
            }
        }
    }
    private static void insertStudent(String url, String username, String password, BufferedReader br) throws SQLException, IOException {
        String insertSQL = "INSERT INTO students (name, phone, email, department) VALUES (?,?,?,?)";
        System.out.println("Name : " ) ;
        String name = br.readLine();
        System.out.println("Phone : ");
        String phone = br.readLine();
        System.out.println("Email : ");
        String email = br.readLine();
        System.out.println("Department : ");
        String department = br.readLine();
        try(Connection con = DriverManager.getConnection(url, username, password)){
            PreparedStatement pstmt = con.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.setString(4, department);
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected > 0){
                System.out.println(" New Student Added Successfully");
            }else System.out.println(" Failed to insert student.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static void deleteStudent(String url, String username, String password, BufferedReader br) throws SQLException, IOException {
        String deleteSQL = "DELETE FROM students WHERE name = ? AND student_id = ?";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println(" Type student name : ");
            String studentName = br.readLine();
            System.out.println(" Type your student id : ");
            int studentId = Integer.parseInt(br.readLine());
            try(PreparedStatement pstmt = con.prepareStatement(deleteSQL)){
                pstmt.setString(1, studentName);
                pstmt.setInt(2, studentId);
                int rowsAffected = pstmt.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println(" Student " + studentName + " deleted successfully");
                }
                else System.out.println(" Failed to delete student.");
            }
        }
    }
    private static void getAllStudents(String url, String username, String password) throws SQLException, IOException {
        String searchSQL = "SELECT * FROM students";
        try(Connection con = DriverManager.getConnection(url, username, password);
        Statement pstmt = con.createStatement();
        ResultSet rs = pstmt.executeQuery(searchSQL)){
            while(rs.next()){
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Phone : " + rs.getString("phone"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println();
            }
        }
    }
    private static void updateStudent(String url, String username, String password, BufferedReader br) throws SQLException, IOException {
        String updateSQL = "UPDATE students SET name = ?, phone = ?, email = ?, department = ? WHERE student_id = ?";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println("Type student ID : ");
            int studentId = Integer.parseInt(br.readLine());
            System.out.println("Type student name : ");
            String studentName = br.readLine();
            System.out.println("Type student phone : ");
            String phone = br.readLine();
            System.out.println("Type student email : ");
            String email = br.readLine();
            System.out.println("Type student department : ");
            String department = br.readLine();
            try(PreparedStatement pstmt = con.prepareStatement(updateSQL)){
                pstmt.setString(1, studentName);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.setString(4, department);
                pstmt.setInt(5, studentId);
                int rowsAffected = pstmt.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println(" Student " + studentName + '(' + studentId + ')' + " updated successfully");
                }else System.out.println(" Failed to update student.");
            }
        }
    }
}
