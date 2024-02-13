package models;

import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlConnector {

    private static final int PORT = 3306;
    private static final String DATABASE = "gritacademy";
    private static final String USER = "gabe";
    private static final String PASSWORD = "";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:" + PORT + "/" + DATABASE;
    private static final DataSource dataSource = getDataSource();

    private static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(CONNECTION_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static ArrayList<String> students() {
        ArrayList<String> studentList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM students");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String studentInfo = rs.getString("fname") + "," + rs.getString("lname") + ","
                        + rs.getString("city") + "," + rs.getString("hobbies");
                studentList.add(studentInfo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Exception: " + ex.getMessage());
        }
        return studentList;
    }

    public static ArrayList<String> courses() {
        ArrayList<String> courseList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM courses");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String courseInfo = rs.getString("name") + "," + rs.getInt("yhp") + "," + rs.getString("info");
                courseList.add(courseInfo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Exception: " + ex.getMessage());
        }
        return courseList;
    }

    public static ArrayList<String> attendance() {
        ArrayList<String> attendanceList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();

             PreparedStatement statement = conn.prepareStatement(
                     "SELECT s.fname, s.lname, c.name FROM students s JOIN attendance a ON s.id = a.studentID " +
                             "JOIN courses c ON a.courseID = c.id ORDER BY a.id ASC;");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String attendanceInfo = rs.getString("fname") + "," + rs.getString("lname") + ","
                        + rs.getString("name");
                attendanceList.add(attendanceInfo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Exception: " + ex.getMessage());
        }
        return attendanceList;
    }
}
