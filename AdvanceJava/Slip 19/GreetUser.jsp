<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Greet User</title>
</head>
<body>
    <h2>Greetings, <%= request.getParameter("username") %>!</h2>
    
    <%-- Determine time of day --%>
    <% 
        int hour = java.time.LocalDateTime.now().getHour();
        String greeting = "Good ";
        if (hour < 12) {
            greeting += "Morning";
        } else if (hour < 18) {
            greeting += "Afternoon";
        } else {
            greeting += "Evening";
        }
    %>
    
    <p><%= greeting %>, <%= request.getParameter("username") %>!</p>
</body>
</html>
