<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Details</title>
</head>
<body>
    <h1>Enter Account Details</h1>
    <form action="InsertAccount.jsp" method="post">
        Account Number: <input type="text" name="ANo"><br>
        Type: <input type="text" name="Type"><br>
        Balance: <input type="text" name="Bal"><br>
        <input type="submit" value="Submit">
    </form>

    <h2>Account Details</h2>
    <table border="1">
        <tr>
            <th>Account Number</th>
            <th>Type</th>
            <th>Balance</th>
        </tr>
        <% 
        try {
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";

            // Establish database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Retrieve account details from database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Account");

            // Display account details in tabular form
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("ANo") + "</td>");
                out.println("<td>" + resultSet.getString("Type") + "</td>");
                out.println("<td>" + resultSet.getString("Bal") + "</td>");
                out.println("</tr>");
            }

            // Close database resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        %>
    </table>
</body>
</html>
