import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the existing cookies from the request
        Cookie[] cookies = request.getCookies();

        // Initialize visit count to 0
        int visitCount = 0;

        // Check if the cookies exist
        if (cookies != null) {
            // Loop through the cookies to find the visit count cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    // Parse the visit count value from the cookie
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        // Increment the visit count
        visitCount++;

        // Create a new cookie with the updated visit count
        Cookie visitCountCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set the cookie to expire in 24 hours (86400 seconds)
        visitCountCookie.setMaxAge(86400);

        // Add the cookie to the response
        response.addCookie(visitCountCookie);

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        // Check if the user is visiting the page for the first time
        if (visitCount == 1) {
            out.println("<h1>Welcome to our website!</h1>");
        } else {
            out.println("<h1>You have visited this page " + visitCount + " times.</h1>");
        }
    }
}
