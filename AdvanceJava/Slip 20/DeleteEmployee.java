import java.sql.*;

public class DeleteEmployee {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployee <employeeID>");
            return;
        }

        int employeeID = Integer.parseInt(args[0]);

        // JDBC URL, username, and password
        String URL = "jdbc:mysql://localhost:3306/your_database_name";
        String USER = "your_username";
        String PASSWORD = "your_password";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // SQL query to delete employee details based on employee ID
            String deleteQuery = "DELETE FROM Employee WHERE ENo = ?";

            // Create PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, employeeID);

                // Execute the delete query
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee details deleted successfully.");
                } else {
                    System.out.println("No employee found with ID: " + employeeID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
