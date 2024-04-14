import java.sql.*;

public class StudentDetails {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        // SQL query to insert student details
        String insertSql = "INSERT INTO Students (rno, sname, per) VALUES (?, ?, ?)";

        // SQL query to retrieve details of student with highest percentage
        String selectSql = "SELECT * FROM Students WHERE per = (SELECT MAX(per) FROM Students)";

        try (
            // Establish database connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create prepared statement for insertion
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            // Create statement for selection
            Statement selectStatement = connection.createStatement();
            // Execute selection query
            ResultSet resultSet = selectStatement.executeQuery(selectSql);
        ) {
            // Add student records to the database
            insertStudent(insertStatement, 101, "Alice", 85.5);
            insertStudent(insertStatement, 102, "Bob", 77.8);
            insertStudent(insertStatement, 103, "Charlie", 92.3);
            insertStudent(insertStatement, 104, "David", 81.0);
            insertStudent(insertStatement, 105, "Eve", 88.7);

            // Display details of student with highest percentage
            if (resultSet.next()) {
                System.out.println("Details of student with highest percentage:");
                System.out.println("Roll Number: " + resultSet.getInt("rno"));
                System.out.println("Name: " + resultSet.getString("sname"));
                System.out.println("Percentage: " + resultSet.getDouble("per"));
            } else {
                System.out.println("No records found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert student record into the database
    private static void insertStudent(PreparedStatement statement, int rno, String sname, double per) throws SQLException {
        statement.setInt(1, rno);
        statement.setString(2, sname);
        statement.setDouble(3, per);
        statement.executeUpdate();
    }
}
