import java.sql.*;

public class Main {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // SQL query to create Emp table
            String createTableQuery = "CREATE TABLE Emp (" +
                    "ENo INT NOT NULL AUTO_INCREMENT," +
                    "EName VARCHAR(50) NOT NULL," +
                    "Sal DECIMAL(10, 2) NOT NULL," +
                    "PRIMARY KEY (ENo)" +
                    ")";

            // SQL query to insert record into Emp table
            String insertQuery = "INSERT INTO Emp (EName, Sal) VALUES (?, ?)";

            // Create the Emp table
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
                System.out.println("Emp table created successfully.");
            }

            // Insert a record into the Emp table using PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "John");
                preparedStatement.setDouble(2, 50000.00);
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new record inserted into Emp table.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
