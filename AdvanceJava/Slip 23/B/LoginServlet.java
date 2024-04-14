import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Retrieve username and password from request parameters
            String usernameInput = request.getParameter("username");
            String passwordInput = request.getParameter("password");

            // Prepare SQL query to search for username and password
            String sql = "SELECT * FROM Users WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usernameInput);
            statement.setString(2, passwordInput);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            PrintWriter out = response.getWriter();
            if (resultSet.next()) {
                // Username and password found in the database
                out.println("<html><body>");
                out.println("<h2>Login Successful!</h2>");
                out.println("<p>Welcome, " + usernameInput + "!</p>");
                out.println("</body></html>");
            } else {
                // Username and password not found in the database
                out.println("<html><body>");
                out.println("<h2>Login Failed!</h2>");
                out.println("<p>Invalid username or password.</p>");
                out.println("</body></html>");
            }

            // Close resources
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServletException("Database access error", ex);
        }
    }
}
